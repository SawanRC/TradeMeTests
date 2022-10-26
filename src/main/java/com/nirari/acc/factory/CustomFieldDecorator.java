package com.nirari.acc.factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WrapsElement;
import org.openqa.selenium.interactions.Locatable;
import org.openqa.selenium.support.pagefactory.DefaultFieldDecorator;
import org.openqa.selenium.support.pagefactory.ElementLocator;
import org.openqa.selenium.support.pagefactory.ElementLocatorFactory;

import java.lang.reflect.*;
import java.util.Optional;

public class CustomFieldDecorator extends DefaultFieldDecorator {
    protected ElementLocatorFactory factory;
    private WebDriver webDriver;

    public CustomFieldDecorator(ElementLocatorFactory factory, WebDriver webDriver) {
        super(factory);
        this.factory = factory;
        this.webDriver = webDriver;
    }

    @Override
    public Object decorate(ClassLoader loader, Field field) {
        if (!WebElement.class.isAssignableFrom(field.getType())) {
            return null;
        }

        Optional<ElementLocator> locator = Optional.ofNullable(factory.createLocator(field));

        return locator
                .map(loc -> proxyForLocator(loader, loc, field.getType()))
                .orElse(null);
    }

    private <T> T proxyForLocator(ClassLoader loader, ElementLocator locator, Class<T> fieldType) {
        InvocationHandler handler = new CustomElementHandler(locator, fieldType, webDriver);

        return fieldType
                .cast(Proxy.newProxyInstance(loader, new Class[] { fieldType, WrapsElement.class, Locatable.class }, handler));
    }
}
