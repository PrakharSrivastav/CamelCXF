package com.ps.routes;

import com.ps.aggregation.MyCompletionStrategy;
import com.ps.beans.CountryBean;
import org.apache.camel.builder.endpoint.EndpointRouteBuilder;
import org.apache.camel.builder.endpoint.dsl.CxfEndpointBuilderFactory;
import org.apache.camel.builder.endpoint.dsl.SedaEndpointBuilderFactory;
import org.apache.camel.builder.endpoint.dsl.TimerEndpointBuilderFactory;
import org.apache.camel.component.cxf.common.message.CxfConstants;

public class CountryRouteBuilder extends EndpointRouteBuilder {

    private TimerEndpointBuilderFactory.TimerEndpointBuilder myTimer() {
        return timer("myTimer").fixedRate(true).period(5000).delay(2);
    }

    private SedaEndpointBuilderFactory.SedaEndpointBuilder nameRoute() {
        return seda("nameRoute");
    }

    private SedaEndpointBuilderFactory.SedaEndpointBuilder flagRoute() {
        return seda("flagRoute");
    }

    private SedaEndpointBuilderFactory.SedaEndpointBuilder capitalRoute() {
        return seda("capitalRoute");
    }

    private SedaEndpointBuilderFactory.SedaEndpointBuilder finalRoute() {
        return seda("finalRoute");
    }

    private CxfEndpointBuilderFactory.CxfEndpointBuilder cxfEndpoint() {
        return cxf("{{country.service.path}}")
                .serviceClass("{{country.service.class}}")
                .dataFormat(CxfEndpointBuilderFactory.DataFormat.POJO);
    }


    @Override
    public void configure() throws Exception {

        // get a list of countries
        from(this.myTimer())
                .bean(CountryBean.class, "countryList")
                .split()
                .body()
                .multicast()
                .to(this.nameRoute())
                .to(this.capitalRoute())
                .to(this.flagRoute());

        // find name
        from(this.nameRoute()).routeId("NameRoute")
                .setHeader("isoCode", simple("${body}"))
                .setHeader("type", simple("name"))
                .setHeader(CxfConstants.OPERATION_NAME, simple("{{country.service.operation.CountryName}}"))
                .setHeader(CxfConstants.OPERATION_NAMESPACE, simple("{{country.service.operation.namespace}}"))
                .to(this.cxfEndpoint())
                .bean(CountryBean.class, "stampHeader")
                .to(this.finalRoute())
        ;
        // find currency
        from(this.flagRoute())
                .routeId("CountryFlag")
                .setHeader("isoCode", simple("${body}"))
                .setHeader("type", simple("flag"))
                .setHeader(CxfConstants.OPERATION_NAME, simple("{{country.service.operation.CountryFlag}}"))
                .setHeader(CxfConstants.OPERATION_NAMESPACE, simple("{{country.service.operation.namespace}}"))
                .to(this.cxfEndpoint())
                .bean(CountryBean.class, "stampHeader")
                .to(this.finalRoute())
        ;

        // find capital city
        from(this.capitalRoute()).routeId("CapitalRoute")
                .setHeader("isoCode", simple("${body}"))
                .setHeader("type", simple("capital"))
                .setHeader(CxfConstants.OPERATION_NAME, simple("{{country.service.operation.CapitalCity}}"))
                .setHeader(CxfConstants.OPERATION_NAMESPACE, simple("{{country.service.operation.namespace}}"))
                .to(this.cxfEndpoint())
                .bean(CountryBean.class, "stampHeader")
                .to(this.finalRoute())
        ;

        // combine info
        from(this.finalRoute())
                .aggregate(header("isoCode"), new MyCompletionStrategy())
                .completionTimeout(1000)
                .completionTimeoutCheckerInterval(100)
                .log("${headers}")
                .log("${body}")
        ;
        // send to logger

    }
}
