package com.ps;

import org.apache.camel.builder.endpoint.EndpointRouteBuilder;
import org.apache.camel.component.cxf.common.message.CxfConstants;

public class MyRouteBuilder extends EndpointRouteBuilder {
    @Override
    public void configure() throws Exception {
        from(timer("MyTimer").fixedRate(true).period(5000))
                .setBody(constant("37050198"))
                .bean(MyBean.class, "GetBankName(${body})")
                .log("${body}")
                //.bean(MyBean.class)
                //.setHeader(CxfConstants.OPERATION_NAME, constant("getBank"))
                //.setHeader(CxfConstants.OPERATION_NAMESPACE, constant("http://thomas-bayer.com/blz/"))
                //.to(cxf("http://www.thomas-bayer.com/axis2/services/BLZService").serviceClass("com.thomas_bayer.blz.BLZServicePortType_BLZServiceSOAP12PortHttp_Client"))
        //        .log("${body}")
        ;
    }


}
