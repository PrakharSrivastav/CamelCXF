package com.ps.beans;

import com.ps.model.CountryInfo;
import org.apache.camel.Exchange;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CountryBean {


    public static void countryList(final Exchange ex) {
        List<String> list = new ArrayList<>();
        list.add("IN");
        list.add("NO");
        list.add("US");
        list.add("GB");
        list.add("FI");
        list.add("DE");
        list.add("NI");
        ex.getIn().setBody(list, ArrayList.class);
    }


    public static void stampHeader(final Exchange ex) {
        String isoCode = ex.getIn().getHeader("isoCode", String.class);
        String type = ex.getIn().getHeader("type", String.class);
        if (isoCode != null) {
            // clear the headers and set only the required ones
            Map<String, Object> m = new HashMap<>();
            ex.getIn().setHeaders(m);
            ex.getIn().setHeader("isoCode", isoCode);
            ex.getIn().setHeader("type", type);

            CountryInfo i = new CountryInfo();
            i.setCode(isoCode);
            if (type.equals("flag")) {
                i.setFlag(ex.getIn().getBody(String.class));
            }
            if (type.equals("name")) {
                i.setName(ex.getIn().getBody(String.class));
            }
            if (type.equals("capital")) {
                i.setCapitalCity(ex.getIn().getBody(String.class));
            }

            ex.getIn().setBody(i, CountryInfo.class);
        }
    }

}
