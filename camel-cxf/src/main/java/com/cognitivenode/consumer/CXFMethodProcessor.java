package com.cognitivenode.consumer;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.cxf.service.model.BindingOperationInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Camel Processor to map webservice call called to right method.
 *
 * @author nataraj.basappa
 * @version 1.0, 15/09/2012
 */
public class CXFMethodProcessor implements Processor {

    private final Logger logger = LoggerFactory.getLogger(CXFMethodProcessor.class);

    @Override
    public void process(Exchange exchange) throws Exception {
        logger.info("Processing incoming exchange");
        BindingOperationInfo boi = (BindingOperationInfo) exchange.getProperty(BindingOperationInfo.class.getName());
        String operationName = boi.getOperationInfo().getName().getLocalPart();
        Character firstChar = operationName.charAt(0);
        exchange.getIn().getHeaders().put(Exchange.BEAN_METHOD_NAME, firstChar.toString().toLowerCase() + operationName.substring(1, operationName.length()));
        logger.info("Completed processing incoming exchange");
    }
}
