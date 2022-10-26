package com.nirari.acc.elements;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.rmi.Remote;
import java.time.Duration;

public class TMButtonImpl extends TMElementImpl implements TMButton {

    private final String text;

    public TMButtonImpl(WebElement element) {
        super(element);
        this.text = element.getText();
    }

    @Override
    public void click() {
        super.click();

        if (this.text.trim().equals("Search")) {
            WebDriver driver = this.getWrappedDriver();
            new WebDriverWait(driver, Duration.ofSeconds(5))
                    .until(ExpectedConditions.presenceOfElementLocated(
                            By.xpath("//*[contains(@class, 'tm-search-header-result-count__heading')]")
                    )); //Wait for results to load
        }
    }

    @Override
    public boolean exists() {
        return false;
    }
}
