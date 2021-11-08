package com.ps.aggregation;

import com.ps.model.CountryInfo;
import org.apache.camel.AggregationStrategy;
import org.apache.camel.Exchange;

public final class MyCompletionStrategy implements AggregationStrategy {
    @Override
    public Exchange aggregate(Exchange oldExchange, Exchange newExchange) {
        if (oldExchange == null) {
            return newExchange;
        }

        CountryInfo info = oldExchange.getIn().getBody(CountryInfo.class);
        String type = newExchange.getIn().getHeader("type", String.class);
        CountryInfo newInfo = newExchange.getIn().getBody(CountryInfo.class);
        if (type.equals("flag")) {
            info.setFlag(newInfo.getFlag());
        }
        if (type.equals("name")) {
            info.setName(newInfo.getName());
        }
        if (type.equals("capital")) {
            info.setCapitalCity(newInfo.getCapitalCity());
        }

        oldExchange.getIn().setBody(info, CountryInfo.class);

        return oldExchange;
    }
}