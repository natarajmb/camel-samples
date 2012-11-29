package com.cognitivenode.processor;

import com.cognitivenode.bean.ProductBean;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.ObjectMessage;
import javax.jms.Session;

/**
 * This processor converts the Product bean into a JMS message
 *
 * @author nataraj.basappa
 * @version 1.0, 28/11/2012
 */
public class ProductBeanProcessor implements Processor {

    private static Logger logger = LoggerFactory.getLogger(ProductBeanProcessor.class);
    private ConnectionFactory connectionFactory;

    @Override
    public void process(final Exchange exchange) throws Exception {
        Object body = exchange.getIn().getBody();
        if (body != null) {
            if (body instanceof ProductBean) {
                final ProductBean productBean = (ProductBean) body;
                Connection connection = connectionFactory.createConnection();
                Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
                ObjectMessage objectMessage = session.createObjectMessage();
                objectMessage.setObject(productBean);
                exchange.getIn().setBody(objectMessage);
                logger.info("Sending Bean: " + productBean.toString());
            }
        }
    }

    public void setConnectionFactory(ConnectionFactory connectionFactory) {
        this.connectionFactory = connectionFactory;
    }
}
