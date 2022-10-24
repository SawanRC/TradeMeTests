package com.nirari.acc.pages;

import org.openqa.selenium.WebDriver;

public abstract class TMPage {

    public WebDriver driver;

    public TMPage(WebDriver driver) {
        this.driver = driver;
    }

    public abstract boolean exists();
}
