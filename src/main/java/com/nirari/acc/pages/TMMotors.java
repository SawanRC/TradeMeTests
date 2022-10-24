package com.nirari.acc.pages;

import com.nirari.acc.elements.TMSelect;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class TMMotors extends TMPage {

    @FindBy(xpath = "//tg-select-container[.//label[normalize-space(text())='Make']]//select")
    public TMSelect makeSelect;

    public TMMotors(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean exists() {
        return !driver.findElements(By.xpath("//tm-motors-search-form")).isEmpty();
    }
}
