
package com.learnwebservices.services.tempconverter;

/**
 * Please modify this class to meet your needs
 * This class is not complete
 */

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlSeeAlso;

/**
 * This class was generated by Apache CXF 3.4.5
 * 2021-11-08T13:24:02.755+01:00
 * Generated source version: 3.4.5
 *
 */
public final class TempConverterEndpoint_TempConverterEndpointPort_Client {

    private static final QName SERVICE_NAME = new QName("http://learnwebservices.com/services/tempconverter", "TempConverterEndpointService");

    private TempConverterEndpoint_TempConverterEndpointPort_Client() {
    }

    public static void main(String args[]) throws java.lang.Exception {
        URL wsdlURL = TempConverterEndpointService.WSDL_LOCATION;
        if (args.length > 0 && args[0] != null && !"".equals(args[0])) {
            File wsdlFile = new File(args[0]);
            try {
                if (wsdlFile.exists()) {
                    wsdlURL = wsdlFile.toURI().toURL();
                } else {
                    wsdlURL = new URL(args[0]);
                }
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        }

        TempConverterEndpointService ss = new TempConverterEndpointService(wsdlURL, SERVICE_NAME);
        TempConverterEndpoint port = ss.getTempConverterEndpointPort();

        {
        System.out.println("Invoking celsiusToFahrenheit...");
        com.learnwebservices.services.tempconverter.CelsiusToFahrenheitRequest _celsiusToFahrenheit_celsiusToFahrenheitRequest = null;
        com.learnwebservices.services.tempconverter.CelsiusToFahrenheitResponse _celsiusToFahrenheit__return = port.celsiusToFahrenheit(_celsiusToFahrenheit_celsiusToFahrenheitRequest);
        System.out.println("celsiusToFahrenheit.result=" + _celsiusToFahrenheit__return);


        }
        {
        System.out.println("Invoking fahrenheitToCelsius...");
        com.learnwebservices.services.tempconverter.FahrenheitToCelsiusRequest _fahrenheitToCelsius_fahrenheitToCelsiusRequest = null;
        com.learnwebservices.services.tempconverter.FahrenheitToCelsiusResponse _fahrenheitToCelsius__return = port.fahrenheitToCelsius(_fahrenheitToCelsius_fahrenheitToCelsiusRequest);
        System.out.println("fahrenheitToCelsius.result=" + _fahrenheitToCelsius__return);


        }

        System.exit(0);
    }

}