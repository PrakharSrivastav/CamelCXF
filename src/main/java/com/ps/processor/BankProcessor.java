package com.ps.processor;

import com.thomas_bayer.blz.DetailsType;
import org.apache.camel.Exchange;
import org.apache.camel.Message;
import org.apache.camel.Processor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BankProcessor implements Processor {
    final static Logger logger = LoggerFactory.getLogger(BankProcessor.class);

    @Override
    public void process(Exchange exchange) throws Exception {
        Message in = exchange.getIn();
        DetailsType body = in.getBody(DetailsType.class);
        logger.info(body.toString());

        exchange.getIn().setBody(body);
    }
}
