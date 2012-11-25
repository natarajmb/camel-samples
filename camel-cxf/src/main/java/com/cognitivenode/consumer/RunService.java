package com.cognitivenode.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Class that invokes the camel context and spring context and
 * start the camel consumer to serve customer records
 *
 * @author nataraj.basappa
 * @version 1.0, 12/09/2012
 */
public class RunService {
    static Logger logger = LoggerFactory.getLogger(RunService.class);

    public static void main(String[] args) {
        // Below line of code, reads the spring context file and along with starts the
        // Camel context and its endpoints.
        logger.info("Starting Spring-Camel Integration...");
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-consumer-context.xml");
    }
}
