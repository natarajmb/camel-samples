package com.cognitivenode.framework;

import com.cognitivenode.framework.annotation.HttpDelete;
import com.cognitivenode.framework.annotation.HttpGet;
import com.cognitivenode.framework.annotation.HttpPost;
import com.cognitivenode.framework.annotation.HttpPut;
import org.reflections.Reflections;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * This class maps annotations to implementation
 *
 * @author nataraj.basappa
 * @version 1.0, 21/12/2012
 */
public class AnnotationMapper {

    private Map<String, Class> lookup = null;
    private String packageToScan = null;

    public AnnotationMapper() {
        lookup = new HashMap<String, Class>();
        lookup.put("GET", HttpGet.class);
        lookup.put("POST", HttpPost.class);
        lookup.put("PUT", HttpPut.class);
        lookup.put("DELETE", HttpDelete.class);
    }

    public void setPackageToScan(String packageToScan) {
        this.packageToScan = packageToScan;
    }

    void execute(String method, String uri, Map<String, String> keyValue) {

        // get list of classes in the defined package
        Class aClass = (Class) lookup.get(method);
        Reflections reflections = new Reflections(packageToScan);
        Set<Class<?>> classes = reflections.getTypesAnnotatedWith(aClass);

        if(!classes.isEmpty()) {
            // scan each class for the required method and uri match
            // if match found execute the method and send back the result

        } else {
            // if no match found throw an exception no method found
            throw new NoSuchMethodError("No methods with "+aClass.getName()+ "annotations defined");
        }


    }
}
