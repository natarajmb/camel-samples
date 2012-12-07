package com.cognitivenode;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Method;

/**
 * Don't leave me here :(
 *
 * @author nataraj.basappa
 * @version 1.0, 06/12/2012
 */
public class SpringWebServiceProcessor implements Processor {

    private final Logger logger = LoggerFactory.getLogger(SpringWebServiceProcessor.class);
    private IBookService bookService = null;

    @Override
    public void process(Exchange exchange) throws Exception {
        String methodName = (String) exchange.getIn().getHeader("method");
        logger.info("Request for method " + methodName + " with Param " + exchange.getIn().getBody().getClass());
        logger.info(exchange.getIn().getBody().toString());
        Method method = bookService.getClass().getMethod(methodName, exchange.getIn().getBody().getClass());
        exchange.getOut().setHeaders(exchange.getIn().getHeaders());
        logger.info("Response : " + method.invoke(bookService, exchange.getIn().getBody()));
        exchange.getOut().setBody(method.invoke(bookService, exchange.getIn().getBody()));
    }

    public void setBookService(IBookService bookService) {
        this.bookService = bookService;
    }
}
