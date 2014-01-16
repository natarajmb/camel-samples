package com.cognitivenode.processor;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.component.restlet.RestletEndpoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Processor to map restlet methods to service calls.
 *
 * @author nataraj.basappa
 * @version 1.0, 11/12/2012
 */
public class RestletProcessor implements Processor {

    private final Logger logger = LoggerFactory.getLogger(RestletProcessor.class);

    @Override
    public void process(Exchange exchange) throws Exception {
        logger.info("Processing...");
        exchange.getIn().getHeader("email", String.class);
        logger.info(exchange.getIn().getBody().toString());
    }
}
