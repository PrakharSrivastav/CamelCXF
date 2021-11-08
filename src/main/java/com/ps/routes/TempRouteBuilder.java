package com.ps.routes;

import com.ps.beans.C2FBean;
import org.apache.camel.ValidationException;
import org.apache.camel.builder.endpoint.EndpointRouteBuilder;
import org.apache.camel.builder.endpoint.dsl.CxfEndpointBuilderFactory;
import org.apache.camel.builder.endpoint.dsl.TimerEndpointBuilderFactory;
import org.apache.camel.component.cxf.common.message.CxfConstants;

import java.io.IOException;

public class TempRouteBuilder extends EndpointRouteBuilder {
    @Override
    public void configure() throws Exception {
        // Define all the exceptions. This section will handle how different
        // Errors should be handled
        onException(ValidationException.class)
                .routeId("{{component.error.validation.route.id}}")
                .to(direct("{{component.error.name}}"));

        onException(IOException.class)
                .routeId("{{component.error.io.route.id}}")
                .to(direct("{{component.error.name}}"));

        // use timer as the source. In real world this will be an external source
        final TimerEndpointBuilderFactory.TimerEndpointBuilder epTimer = timer("{{component.timer.name}}")
                .fixedRate(true)
                .period(10000);

        // define the cxf endpoint to consume soap service
        final CxfEndpointBuilderFactory.CxfEndpointBuilder epCXFService = cxf("{{temp.service.path}}")
                .serviceClass("{{temp.service.class}}")
                .dataFormat(CxfEndpointBuilderFactory.DataFormat.POJO);

        from(epTimer)
                .routeId("{{temp.service.route.id}}")
                .setBody(constant("100"))
                // perform a validation
                .bean(C2FBean.class)
                .log("${body}")
                // set soap service headers
                .setHeader(CxfConstants.OPERATION_NAME, constant("{{temp.service.operation.name}}"))
                .setHeader(CxfConstants.OPERATION_NAMESPACE, constant("{{temp.service.operation.namespace}}"))
                // call the cxf endpoint
                .to(epCXFService)
                // log or do something about the response
                .log("${body}");

        // error handlers
        from(direct("{{component.error.name}}"))
                .routeId("{{component.error.final.route.id}}")
                .log("Error : ${body} ");
    }
}
