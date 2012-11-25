package com.cognitivenode.producer;

import com.cognitivenode.customer.types.*;
import org.apache.camel.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.HashMap;
import java.util.Map;

/**
 * Makes a call to Customer Service through a proxy object
 *
 * @author nataraj.basappa
 * @version 1.0, 12/09/2012
 */
public class ConsumeService {

    private static Logger logger = LoggerFactory.getLogger(ConsumeService.class);
    private static final String SOAP_ACTION_HEADER = "operationName";
    private static final String ENDPOINT_NAME = "direct://callCSProxy";
    private final ApplicationContext context;

    public ConsumeService() {
        logger.info("Initialising Spring and Camel context");
        context = new ClassPathXmlApplicationContext("spring-producer-context.xml");
    }

    public static void main(String[] args) {
        ConsumeService consumeService = new ConsumeService();
        ObjectFactory factory = new ObjectFactory();
        GetCustomers getCustomers = factory.createGetCustomers();
        getCustomers.setIgnoreMe("");
        consumeService.sendMessageToWebService(getCustomers);
    }

    void sendMessageToWebService(Object object) {
        String soapAction = object.getClass().getSimpleName();
        Map<String, Object> headers = new HashMap<String, Object>();
        headers.put(SOAP_ACTION_HEADER, soapAction);

        logger.info("Setting up endpoint and payload");
        CamelContext camelContext = (CamelContext) context.getBean("camel");
        Endpoint endpoint = camelContext.getEndpoint(ENDPOINT_NAME);
        Exchange inExchange = endpoint.createExchange();
        Message inMessage = inExchange.getIn();
        if (inMessage.getHeaders() != null)
            inMessage.setHeaders(headers);
        inMessage.setBody(object);
        logger.info("Payload ready to be sent");
        ProducerTemplate template = camelContext.createProducerTemplate();
        template.setDefaultEndpoint(endpoint);
        Exchange outExchange = template.send(inExchange);
        if (outExchange.getException() != null) {
            outExchange.getException().printStackTrace();
            System.exit(1);
        }
        Message outMessage = outExchange.getOut();
        if (outMessage != null) {
            logger.info("Message ID: " + outMessage.getMessageId());
            Map<String, Object> outHeaders = outMessage.getHeaders();
            if (outHeaders != null) {
                logger.info("Headers from out message:");
                for (String headerKey : outHeaders.keySet()) {
                    logger.info("\t" + outHeaders.get(headerKey));
                }
            }
            ArrayOfCustomerRecord responseType;
            responseType = outMessage.getBody(ArrayOfCustomerRecord.class);
            if (responseType != null) {
                for (CustomerRecord record : responseType.getCustomers()) {
                    logger.info("");
                    logger.info("First Name: " + record.getFirstName());
                    logger.info("Last Name: " + record.getLastName());
                    logger.info("Gender: " + record.getGender());
                    logger.info("Username: " + record.getUsername());
                    logger.info("Password: " + record.getPassword());
                    logger.info("DOB: " + record.getDOB());
                    logger.info("");
                }
            }
        }
    }
}
