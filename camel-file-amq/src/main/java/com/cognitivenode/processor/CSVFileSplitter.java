package com.cognitivenode.processor;

import org.apache.camel.Exchange;
import org.apache.camel.component.file.GenericFile;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Splits CSV file into multiple chunks to be processed
 * independently.
 *
 * @author nataraj.basappa
 * @version 1.0, 27/11/2012
 */
public class CSVFileSplitter {

    private static Logger logger = LoggerFactory.getLogger(CSVFileSplitter.class);
    private String splitFileDir;
    private int maxLines;

    public List<File> splitFile(Exchange exchange) {
        List<File> fileList = new ArrayList<File>();
        logger.info("Inside CSVFileSplitter");
        Object body = exchange.getIn().getBody();
        if (body != null) {
            if (body instanceof GenericFile) {
                GenericFile genericFile = (GenericFile) body;
                File file = (File) genericFile.getFile();
                try {
                    BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file), "UTF8"));
                    String line = reader.readLine();
                    String columnNames = line.trim();
                    int counter = 0;
                    while (line != null) {
                        File tempFile = new File(splitFileDir);
                        tempFile.mkdirs();
                        tempFile = new File(splitFileDir, counter + file.getName());
                        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(new FileOutputStream(tempFile),"UTF-8");
                        outputStreamWriter.write(columnNames);
                        for (int index = 0; index < maxLines; index++) {
                            line = reader.readLine();
                            if (line == null)
                                break;
                            outputStreamWriter.write("\r\n");
                            outputStreamWriter.write(line);
                        }
                        outputStreamWriter.flush();
                        outputStreamWriter.close();
                        fileList.add(tempFile);
                        counter++;
                    }
                } catch (FileNotFoundException e) {
                    logger.error("Unable to read file");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else {
                logger.error("Not a file");
            }
        }
        return fileList;
    }

    public void setSplitFileDir(String splitFileDir) {
        this.splitFileDir = splitFileDir;
    }

    public void setMaxLines(int maxLines) {
        this.maxLines = maxLines;
    }
}
