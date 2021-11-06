package com.ps.routes;

import com.ps.beans.BankValidationBean;
import com.ps.processor.BankProcessor;
import com.thomas_bayer.blz.BLZService;
import org.apache.camel.ValidationException;
import org.apache.camel.builder.endpoint.EndpointRouteBuilder;
import org.apache.camel.builder.endpoint.dsl.CxfEndpointBuilderFactory;
import org.apache.camel.builder.endpoint.dsl.CxfEndpointBuilderFactory.CxfEndpointBuilder;
import org.apache.camel.builder.endpoint.dsl.TimerEndpointBuilderFactory.TimerEndpointBuilder;
import org.apache.camel.component.cxf.common.message.CxfConstants;

import java.io.IOException;

public class BankRouteBuilder extends EndpointRouteBuilder {

    @Override
    public void configure() {
        // Define all the exceptions. This section will handle how different
        // Errors should be handled
        onException(ValidationException.class)
                .routeId("{{component.error.validation.route.id}}")
                .to(direct("{{component.error.name}}"));

        onException(IOException.class)
                .routeId("{{component.error.io.route.id}}")
                .to(direct("{{component.error.name}}"));

        // use timer as the source. In real world this will be an external source
        final TimerEndpointBuilder tt = timer("{{component.timer.name}}")
                .fixedRate(true)
                .period(10000);

        // define the cxf endpoint to consume soap service
        final CxfEndpointBuilder cc = cxf("{{bank.service.path}}")
                .serviceClass("{{bank.service.class}}")
                .dataFormat(CxfEndpointBuilderFactory.DataFormat.POJO)
                .serviceName(BLZService.SERVICE.toString())
                .wrappedStyle(true)
                .wsdlURL(BLZService.WSDL_LOCATION.toString());

        // route definition
        from(tt)
                // setup route id for better logging
                .routeId("{{bank.service.route.id}}")
                // hardcoded, this parameter should come from some external-source
                .setBody(constant("37050198"))
                // perform a validation
                .bean(BankValidationBean.class)
                // set soap service headers
                .setHeader(CxfConstants.OPERATION_NAME, constant("{{bank.service.operation.name}}"))
                .setHeader(CxfConstants.OPERATION_NAMESPACE, constant("{{bank.service.operation.namespace}}"))
                // call the cxf endpoint
                .to(cc)
                // perform post-processing on the response
                .process(new BankProcessor())
                // log or do something about the response
                .log("${body}");


        // error handlers
        from(direct("{{component.error.name}}"))
                .routeId("{{component.error.final.route.id}}")
                .log("Error : ${body} ");
    }


}
