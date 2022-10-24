package com.nirari.acc;

import com.nirari.acc.factory.CustomFieldDecorator;
import com.nirari.acc.pages.Navigable;
import com.nirari.acc.pages.TMPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.DefaultElementLocatorFactory;

public class TMVisitor {

    private final WebDriver webDriver = WebDriverManager.chromedriver().create();

    public <T> T gotoPage(Class<T> page) {
        try {
            if (Navigable.class.isAssignableFrom(page)) {
                ((Navigable) page.getConstructor(WebDriver.class).newInstance(webDriver)).navigate(webDriver);
            }

            T p = page.getConstructor(WebDriver.class).newInstance(webDriver);
            PageFactory.initElements(new CustomFieldDecorator(new DefaultElementLocatorFactory(webDriver)), p);

            for (int i = 0; i < 10; i++) {
                if (((TMPage)p).exists()) {
                    return p;
                }

                Thread.sleep(1000);
            }

            throw new RuntimeException("Page not loaded!");
        }
        catch(Exception e) {
            throw new RuntimeException("An error occurred while loading page!", e);
        }
    }
}
