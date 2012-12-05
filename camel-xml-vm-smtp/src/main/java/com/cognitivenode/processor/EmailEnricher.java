package com.cognitivenode.processor;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

import java.util.HashMap;
import java.util.Map;

/**
 * Enriches the exchange by setting properties required to send emails
 *
 * @author nataraj.basappa
 * @version 1.0, 05/12/2012
 */
public class EmailEnricher implements Processor {

    private static final String TO_EMAIL = "To";
    private static final String FROM_EMAIL = "From";
    private static final String SUBJECT = "Subject";

    private final String toEmail = "natarajmb@aol.com";
    private final String fromEmail = "root@krishna.om.loc";
    private final String subject = "Camel Sample Order";

    @Override
    public void process(Exchange exchange) throws Exception {
        Map<String, Object> headers = exchange.getIn().getHeaders();
        if (headers == null) {
            headers = new HashMap<String, Object>();
        }
        headers.put(TO_EMAIL, toEmail);
        headers.put(FROM_EMAIL, fromEmail);
        headers.put(SUBJECT, subject);
    }
}
