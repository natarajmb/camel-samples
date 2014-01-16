package com.cognitivenode.framework.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Used to mark a Http Post method
 *
 * @author nataraj.basappa
 * @version 1.0, 17/12/2012
 */

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface HttpPost {
    String url() default "/";
}
