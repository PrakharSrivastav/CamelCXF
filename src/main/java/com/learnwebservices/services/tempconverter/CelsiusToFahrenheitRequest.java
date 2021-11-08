
package com.learnwebservices.services.tempconverter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for celsiusToFahrenheitRequest complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="celsiusToFahrenheitRequest"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="TemperatureInCelsius" type="{http://www.w3.org/2001/XMLSchema}double"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "celsiusToFahrenheitRequest", propOrder = {
    "temperatureInCelsius"
})
public class CelsiusToFahrenheitRequest {

    @XmlElement(name = "TemperatureInCelsius")
    protected double temperatureInCelsius;

    /**
     * Gets the value of the temperatureInCelsius property.
     * 
     */
    public double getTemperatureInCelsius() {
        return temperatureInCelsius;
    }

    /**
     * Sets the value of the temperatureInCelsius property.
     * 
     */
    public void setTemperatureInCelsius(double value) {
        this.temperatureInCelsius = value;
    }

}
