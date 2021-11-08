
package com.learnwebservices.services.tempconverter;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.learnwebservices.services.tempconverter package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _CelsiusToFahrenheitRequest_QNAME = new QName("http://learnwebservices.com/services/tempconverter", "CelsiusToFahrenheitRequest");
    private final static QName _CelsiusToFahrenheitResponse_QNAME = new QName("http://learnwebservices.com/services/tempconverter", "CelsiusToFahrenheitResponse");
    private final static QName _FahrenheitToCelsiusRequest_QNAME = new QName("http://learnwebservices.com/services/tempconverter", "FahrenheitToCelsiusRequest");
    private final static QName _FahrenheitToCelsiusResponse_QNAME = new QName("http://learnwebservices.com/services/tempconverter", "FahrenheitToCelsiusResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.learnwebservices.services.tempconverter
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link CelsiusToFahrenheitRequest }
     * 
     */
    public CelsiusToFahrenheitRequest createCelsiusToFahrenheitRequest() {
        return new CelsiusToFahrenheitRequest();
    }

    /**
     * Create an instance of {@link CelsiusToFahrenheitResponse }
     * 
     */
    public CelsiusToFahrenheitResponse createCelsiusToFahrenheitResponse() {
        return new CelsiusToFahrenheitResponse();
    }

    /**
     * Create an instance of {@link FahrenheitToCelsiusRequest }
     * 
     */
    public FahrenheitToCelsiusRequest createFahrenheitToCelsiusRequest() {
        return new FahrenheitToCelsiusRequest();
    }

    /**
     * Create an instance of {@link FahrenheitToCelsiusResponse }
     * 
     */
    public FahrenheitToCelsiusResponse createFahrenheitToCelsiusResponse() {
        return new FahrenheitToCelsiusResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CelsiusToFahrenheitRequest }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link CelsiusToFahrenheitRequest }{@code >}
     */
    @XmlElementDecl(namespace = "http://learnwebservices.com/services/tempconverter", name = "CelsiusToFahrenheitRequest")
    public JAXBElement<CelsiusToFahrenheitRequest> createCelsiusToFahrenheitRequest(CelsiusToFahrenheitRequest value) {
        return new JAXBElement<CelsiusToFahrenheitRequest>(_CelsiusToFahrenheitRequest_QNAME, CelsiusToFahrenheitRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CelsiusToFahrenheitResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link CelsiusToFahrenheitResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://learnwebservices.com/services/tempconverter", name = "CelsiusToFahrenheitResponse")
    public JAXBElement<CelsiusToFahrenheitResponse> createCelsiusToFahrenheitResponse(CelsiusToFahrenheitResponse value) {
        return new JAXBElement<CelsiusToFahrenheitResponse>(_CelsiusToFahrenheitResponse_QNAME, CelsiusToFahrenheitResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FahrenheitToCelsiusRequest }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link FahrenheitToCelsiusRequest }{@code >}
     */
    @XmlElementDecl(namespace = "http://learnwebservices.com/services/tempconverter", name = "FahrenheitToCelsiusRequest")
    public JAXBElement<FahrenheitToCelsiusRequest> createFahrenheitToCelsiusRequest(FahrenheitToCelsiusRequest value) {
        return new JAXBElement<FahrenheitToCelsiusRequest>(_FahrenheitToCelsiusRequest_QNAME, FahrenheitToCelsiusRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FahrenheitToCelsiusResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link FahrenheitToCelsiusResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://learnwebservices.com/services/tempconverter", name = "FahrenheitToCelsiusResponse")
    public JAXBElement<FahrenheitToCelsiusResponse> createFahrenheitToCelsiusResponse(FahrenheitToCelsiusResponse value) {
        return new JAXBElement<FahrenheitToCelsiusResponse>(_FahrenheitToCelsiusResponse_QNAME, FahrenheitToCelsiusResponse.class, null, value);
    }

}
