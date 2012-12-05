package com.cognitivenode.processor;

import com.cognitivenode.bean.OrderBean;
import com.thoughtworks.xstream.XStream;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.component.file.GenericFile;
import org.apache.commons.lang.time.DateFormatUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.text.NumberFormat;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/**
 * Processor that picks up XML file and convert it into
 * Java bean.
 *
 * @author nataraj.basappa
 * @version 1.0, 29/11/2012
 */
public class XML2BeanProcessor implements Processor {

    private static Logger logger = LoggerFactory.getLogger(XML2BeanProcessor.class);

    @Override
    public void process(Exchange exchange) throws Exception {
        Object body = exchange.getIn().getBody();
        if (body != null) {
            if (body instanceof GenericFile) {
                File file = (File) ((GenericFile) body).getFile();
                XStream xStream = new XStream();
                xStream.autodetectAnnotations(true);
                xStream.processAnnotations(OrderBean.class);
                OrderBean orderBean = (OrderBean) xStream.fromXML(file);

                // Setup a map to be used in Velocity template
                Map<String, Object> objectMap = new HashMap<String, Object>();
                objectMap.put("orderBean", orderBean);
                objectMap.put("DateFormatUtils", new DateFormatUtils());
                objectMap.put("NumberFormat", NumberFormat.getCurrencyInstance(Locale.UK));
                objectMap.put("dateFormat", "dd-MM-yyyy HH:mm:ss");
                // Set the map into the body
                exchange.getIn().setBody(objectMap);

                logger.info(xStream.toXML(orderBean));
                logger.info(file.getName());
            }
        }
    }
}