package ru.kinohod.browsers;

import com.codeborne.selenide.WebDriverProvider;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

/**
 * The class Chrome.
 */
public class Chrome implements WebDriverProvider {
    @Override
    public WebDriver createDriver(DesiredCapabilities desiredCapabilities) {
        return null;
    }
}