package com.learnwebservices.services.tempconverter;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceFeature;
import javax.xml.ws.Service;

/**
 * This class was generated by Apache CXF 3.4.5
 * 2021-11-08T13:24:02.798+01:00
 * Generated source version: 3.4.5
 *
 */
@WebServiceClient(name = "TempConverterEndpointService",
                  wsdlLocation = "file:/Users/prakhar/workspace/prakhar/thomas-bayer/src/main/resources/service2.wsdl",
                  targetNamespace = "http://learnwebservices.com/services/tempconverter")
public class TempConverterEndpointService extends Service {

    public final static URL WSDL_LOCATION;

    public final static QName SERVICE = new QName("http://learnwebservices.com/services/tempconverter", "TempConverterEndpointService");
    public final static QName TempConverterEndpointPort = new QName("http://learnwebservices.com/services/tempconverter", "TempConverterEndpointPort");
    static {
        URL url = null;
        try {
            url = new URL("file:/Users/prakhar/workspace/prakhar/thomas-bayer/src/main/resources/service2.wsdl");
        } catch (MalformedURLException e) {
            java.util.logging.Logger.getLogger(TempConverterEndpointService.class.getName())
                .log(java.util.logging.Level.INFO,
                     "Can not initialize the default wsdl from {0}", "file:/Users/prakhar/workspace/prakhar/thomas-bayer/src/main/resources/service2.wsdl");
        }
        WSDL_LOCATION = url;
    }

    public TempConverterEndpointService(URL wsdlLocation) {
        super(wsdlLocation, SERVICE);
    }

    public TempConverterEndpointService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public TempConverterEndpointService() {
        super(WSDL_LOCATION, SERVICE);
    }

    public TempConverterEndpointService(WebServiceFeature ... features) {
        super(WSDL_LOCATION, SERVICE, features);
    }

    public TempConverterEndpointService(URL wsdlLocation, WebServiceFeature ... features) {
        super(wsdlLocation, SERVICE, features);
    }

    public TempConverterEndpointService(URL wsdlLocation, QName serviceName, WebServiceFeature ... features) {
        super(wsdlLocation, serviceName, features);
    }




    /**
     *
     * @return
     *     returns TempConverterEndpoint
     */
    @WebEndpoint(name = "TempConverterEndpointPort")
    public TempConverterEndpoint getTempConverterEndpointPort() {
        return super.getPort(TempConverterEndpointPort, TempConverterEndpoint.class);
    }

    /**
     *
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns TempConverterEndpoint
     */
    @WebEndpoint(name = "TempConverterEndpointPort")
    public TempConverterEndpoint getTempConverterEndpointPort(WebServiceFeature... features) {
        return super.getPort(TempConverterEndpointPort, TempConverterEndpoint.class, features);
    }

}