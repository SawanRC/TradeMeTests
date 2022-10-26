package com.nirari.acc.factory;

import com.nirari.acc.elements.TMElement;
import com.nirari.acc.elements.TMElementImpl;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WrapsDriver;
import org.openqa.selenium.support.pagefactory.ElementLocator;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Optional;

public class CustomElementHandler implements InvocationHandler {

    private final ElementLocator locator;
    private final Class<?> concreteImplementation;

    private final WebDriver driver;

    public CustomElementHandler(ElementLocator locator, Class<?> elementInterface, WebDriver driver) {
        this.locator = locator;

        //Get the concrete implementation from the given interface, or fallback to TMElementImpl
        this.concreteImplementation = Optional
                            .ofNullable(elementInterface.getAnnotation(ConcreteImplementation.class))
                            .map(ConcreteImplementation::ImplementedBy)
                            .orElse(TMElementImpl.class);

        this.driver = driver;
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
            Object item = concreteImplementation.getConstructor(WebElement.class).newInstance(wrappedElement);

            if (WrapsDriver.class.isAssignableFrom(concreteImplementation)) {
                ((TMElement)item).setDriver(driver);
            }

            return item;
        }
        catch (Exception e) {
            throw new RuntimeException("Concrete implementation : " + concreteImplementation.getName() +
                    " does not have a constructor accepting WebElement", e);
        }
    }
}