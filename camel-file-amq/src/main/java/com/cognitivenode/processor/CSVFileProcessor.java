package com.cognitivenode.processor;

import au.com.bytecode.opencsv.CSVReader;
import au.com.bytecode.opencsv.bean.CsvToBean;
import au.com.bytecode.opencsv.bean.HeaderColumnNameTranslateMappingStrategy;
import com.cognitivenode.bean.ProductBean;
import org.apache.camel.Exchange;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * This class reads the file that's passed in by Camel File endpoint
 * and converts into a standard Java bean to be sent across to the
 * next endpoint
 *
 * @author nataraj.basappa
 * @version 1.0, 26/11/2012
 */
public class CSVFileProcessor {
    private static Logger logger = LoggerFactory.getLogger(CSVFileProcessor.class);

    public List<ProductBean> convertToProductBean(Exchange exchange) throws Exception {
        Object body = exchange.getIn().getBody();
        List<ProductBean> productBeanList = null;
        if (body != null) {
            if (body instanceof File) {
                File file = (File) body;
                logger.info("Processing file : " + file.getName());

                CSVReader csvReader = new CSVReader(new FileReader(file), '|', '\"');

                // Assuming first line of the CSV to always contain column headers
                String[] columnNames = csvReader.readNext();
                csvReader.close();
                Map<String, String> columnNameToBean = new HashMap<String, String>();

                if (columnNames != null && columnNames.length > 1) {
                    for (String currentColumn : columnNames) {
                        // Strip out additional quotes
                        currentColumn = currentColumn.replaceAll("\"", "");
                        // Replace spaces between column name
                        String beanPropertyName = currentColumn.replaceAll(" ", "");
                        // Replace (mm) characters in column name
                        beanPropertyName = beanPropertyName.replace("(mm)", "");
                        // Replace (kg) characters in column name
                        beanPropertyName = beanPropertyName.replace("(kg)", "");
                        // Convert column name to proper case so as to match java bean convention
                        beanPropertyName = Character.toLowerCase(beanPropertyName.charAt(0)) + (beanPropertyName.length() > 1 ? beanPropertyName.substring(1) : "");
                        columnNameToBean.put(currentColumn, beanPropertyName);
                    }
                } else {
                    logger.error("Incorrect file format");
                }

                csvReader = new CSVReader(new FileReader(file), '|', '\"');
                HeaderColumnNameTranslateMappingStrategy<ProductBean> strategy = new HeaderColumnNameTranslateMappingStrategy<ProductBean>();
                strategy.setType(ProductBean.class);
                strategy.setColumnMapping(columnNameToBean);
                CsvToBean<ProductBean> csvToBean = new CsvToBean<ProductBean>();
                productBeanList = csvToBean.parse(strategy, csvReader);

                //for (ProductBean productBean : productBeanList)
                //    logger.info(productBean.toString());
            }
        }
        return productBeanList;
    }
}
