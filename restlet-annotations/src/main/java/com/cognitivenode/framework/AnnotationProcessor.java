package com.cognitivenode.framework;

import com.cognitivenode.framework.annotation.HttpGet;

import javax.annotation.processing.*;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.TypeElement;
import javax.tools.Diagnostic;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Class to process custom annotations
 *
 * @author nataraj.basappa
 * @version 1.0, 17/12/2012
 */

@SupportedAnnotationTypes("*")
@SupportedSourceVersion(SourceVersion.RELEASE_6)
public class AnnotationProcessor extends AbstractProcessor {

    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
        Messager messager = processingEnv.getMessager();

        // HttpGet check - rudimentary check to see if same URL is used across multiple
        // get calls if it is then its notified as failed compilation
        List<String> urls = new ArrayList<String>();
        for (Element elem : roundEnv.getElementsAnnotatedWith(HttpGet.class)) {
            HttpGet httpGet = elem.getAnnotation(HttpGet.class);
            String message = "Duplicate annotation found on " + elem.getEnclosingElement().getSimpleName() + "." + elem.getSimpleName()
                    + " with URL " + httpGet.url();
            for (String url : urls) {
                if (url.equalsIgnoreCase(httpGet.url())) {
                    processingEnv.getMessager().printMessage(Diagnostic.Kind.ERROR, message);
                    return false;
                }
            }
            urls.add(httpGet.url());
        }
        return true;
    }

}
