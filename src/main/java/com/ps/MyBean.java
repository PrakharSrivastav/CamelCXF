package com.ps;

import com.thomas_bayer.blz.BLZService;
import com.thomas_bayer.blz.BLZServicePortType;
import com.thomas_bayer.blz.GetBankType;

import javax.xml.namespace.QName;

public class MyBean {
    public GetBankType getBankType(String type) {
        GetBankType gbt = new GetBankType();
        gbt.setBlz(type);

        return gbt;
    }

    public String GetBankName(String id) {
        BLZService ss = new BLZService(BLZService.WSDL_LOCATION, new QName("http://thomas-bayer.com/blz/", "BLZService"));
        BLZServicePortType port = ss.getBLZServiceSOAP12PortHttp();


        System.out.println("Invoking getBank...");
        java.lang.String _getBank_blz = "37050198";
        com.thomas_bayer.blz.DetailsType _getBank__return = port.getBank(_getBank_blz);
        System.out.println("getBank.result=" + _getBank__return.getBezeichnung());


        return _getBank__return.getBezeichnung();
    }

}