package com.ps.beans;

import com.learnwebservices.services.tempconverter.CelsiusToFahrenheitRequest;
import org.apache.camel.Exchange;
import org.apache.camel.Handler;
import org.apache.camel.ValidationException;

public class C2FBean {
    @Handler
    public void validateInput(final Exchange ex) throws ValidationException {
        final String tempInCelsius = ex.getIn().getBody(String.class);
        if (tempInCelsius == null) {
            throw new ValidationException(ex, "missing.tempInCelsius");
        }

        if (tempInCelsius.isEmpty()) {
            throw new ValidationException(ex, "empty.tempInCelsius");
        }

        try {
            CelsiusToFahrenheitRequest ctf = new CelsiusToFahrenheitRequest();
            double temp = Double.parseDouble(tempInCelsius);
            ctf.setTemperatureInCelsius(temp);

            ex.getIn().setBody(ctf, CelsiusToFahrenheitRequest.class);
        } catch (NumberFormatException exp) {
            throw new ValidationException(ex, "bad.temp.value");
        }
    }
}
