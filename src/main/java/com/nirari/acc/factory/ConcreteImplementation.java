package com.nirari.acc.factory;

import com.nirari.acc.elements.TMElementImpl;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;


@Retention(RetentionPolicy.RUNTIME)
public @interface ConcreteImplementation {
    Class<?> ImplementedBy() default TMElementImpl.class;
}
