package com.nirari.acc.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.stream.Collectors;

public class TMSelectImpl extends TMElementImpl implements TMSelect {

    public TMSelectImpl(WebElement element) {
        super(element);
    }

    public List<String> getAvailableItems() {
        return this.findElements(By.xpath(".//option"))
                .stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
    }

    @Override
    public void selectItem(String item) {
        this.click();
        ((JavascriptExecutor)getWrappedDriver()).executeScript("arguments[0].scrollIntoView();", getWrappedElement());
        this.findElement(By.xpath(".//option[normalize-space(text())='" + item + "']")).click();
    }

    @Override
    public boolean exists() {
        return false;
    }
}
