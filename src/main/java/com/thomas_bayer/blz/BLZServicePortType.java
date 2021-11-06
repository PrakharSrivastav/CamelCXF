package com.thomas_bayer.blz;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

/**
 * This class was generated by Apache CXF 3.4.5
 * 2021-11-06T14:30:32.303+01:00
 * Generated source version: 3.4.5
 *
 */
@WebService(targetNamespace = "http://thomas-bayer.com/blz/", name = "BLZServicePortType")
@XmlSeeAlso({ObjectFactory.class})
public interface BLZServicePortType {

    @WebMethod
    @Action(output = "http://thomas-bayer.com/blz/BLZService/getBankResponse")
    @RequestWrapper(localName = "getBank", targetNamespace = "http://thomas-bayer.com/blz/", className = "com.thomas_bayer.blz.GetBankType")
    @ResponseWrapper(localName = "getBankResponse", targetNamespace = "http://thomas-bayer.com/blz/", className = "com.thomas_bayer.blz.GetBankResponseType")
    @WebResult(name = "details", targetNamespace = "http://thomas-bayer.com/blz/")
    public com.thomas_bayer.blz.DetailsType getBank(

        @WebParam(name = "blz", targetNamespace = "http://thomas-bayer.com/blz/")
        java.lang.String blz
    );
}
