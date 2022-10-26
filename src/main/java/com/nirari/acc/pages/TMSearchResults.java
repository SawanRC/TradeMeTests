package com.nirari.acc.pages;

import com.nirari.acc.elements.TMElement;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class TMSearchResults extends TMPage {

    @FindBy(xpath = "//h3[contains(@class, 'tm-search-header-result-count__heading')]")
    public TMElement resultCountLabel;

    public TMSearchResults(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean exists() {
        try {
            return resultCountLabel.exists();
        }
        catch (NoSuchElementException ignored) {
            return false;
        }
    }
}
