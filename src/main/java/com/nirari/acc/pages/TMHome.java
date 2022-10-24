package com.nirari.acc.pages;

import com.nirari.acc.elements.TMLink;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class TMHome extends TMPage implements Navigable {

    @FindBy(xpath = "//a[@routerlink='/motors']")
    public TMLink motorLink;

    public TMHome(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean exists() {
        return !driver.findElements(By.xpath("//tm-dynamic-homepage")).isEmpty();
    }

    @Override
    public void navigate(WebDriver driver) {
        driver.navigate().to("https://www.trademe.co.nz/a/");
    }
}
