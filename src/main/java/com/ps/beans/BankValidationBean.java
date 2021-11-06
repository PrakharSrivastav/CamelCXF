package com.ps.beans;

import org.apache.camel.Exchange;
import org.apache.camel.Handler;
import org.apache.camel.ValidationException;

public class BankValidationBean {
    @Handler
    public void validateInput(final Exchange ex) throws ValidationException {
        final String id = ex.getIn().getBody(String.class);
        if (id == null) {
            throw new ValidationException(ex, "missing.id");
        }

        if (id.isEmpty()) {
            throw new ValidationException(ex, "empty.id");
        }

        if (id.length() != 8) {
            throw new ValidationException(ex, "bad.id");
        }
    }
}

    /*
    private static final QName qname = new QName(
            "http://thomas-bayer.com/blz/",
            "BLZService");

    public GetBankType getBankType(final String type) {
        final GetBankType gbt = new GetBankType();
        gbt.setBlz(type);
        return gbt;
    }

    public String GetBankName(final String id) {
        final BLZService ss = new BLZService(BLZService.WSDL_LOCATION, qname);
        final BLZServicePortType port = ss.getBLZServiceSOAP12PortHttp();
        final com.thomas_bayer.blz.DetailsType _getBank__return = port.getBank(id);
        return _getBank__return.getBezeichnung();
    }

    public static String getServiceName() {
        return qname.toString();
    }

    public static BLZServicePortType getServicePort() {
        final BLZService ss = new BLZService(BLZService.WSDL_LOCATION, qname);
        return ss.getBLZServiceSOAP12PortHttp();
    }*/
