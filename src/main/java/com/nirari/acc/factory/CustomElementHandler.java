package com.nirari.acc.factory;

import com.nirari.acc.elements.TMElementImpl;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.pagefactory.ElementLocator;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Optional;

public class CustomElementHandler implements InvocationHandler {

    private final ElementLocator locator;
    private final Class<?> concreteImplementation;

    public CustomElementHandler(ElementLocator locator, Class<?> elementInterface) {
        this.locator = locator;

        //Get the concrete implementation from the given interface, or fallback to TMElementImpl
        this.concreteImplementation = Optional
                            .ofNullable(elementInterface.getAnnotation(ConcreteImplementation.class))
                            .map(ConcreteImplementation::ImplementedBy)
                            .orElse(TMElementImpl.class);
    }

    @Override
    public Object invoke(Object object, Method method, Object[] objects) throws Throwable {
        WebElement element = locator.findElement();

        if ("getWrappedElement".equals(method.getName())) {
            return element;
        }

        try {
            return method.invoke(getConcreteImplInstance(element), objects);
        }
        catch (InvocationTargetException e) {
            throw e.getCause();
        }
    }

    private Object getConcreteImplInstance(WebElement wrappedElement) {
        try {
            return concreteImplementation.getConstructor(WebElement.class).newInstance(wrappedElement);
        }
        catch (Exception e) {
            throw new RuntimeException("Concrete implementation : " + concreteImplementation.getName() +
                    " does not have a constructor accepting WebElement", e);
        }
    }
}