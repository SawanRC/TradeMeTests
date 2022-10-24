package com.nirari.acc.elements;

import com.nirari.acc.factory.ConcreteImplementation;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WrapsElement;
import org.openqa.selenium.interactions.Locatable;

@ConcreteImplementation
public interface TMElement extends WebElement, WrapsElement, Locatable {
    boolean exists();
}
