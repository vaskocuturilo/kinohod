package ru.kinohod.base;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.aspectj.lang.annotation.After;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.logging.Logger;

import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.WebDriverRunner.clearBrowserCache;
import static com.codeborne.selenide.WebDriverRunner.closeWebDriver;


public class BaseWeb {
    private static final Logger LOGGER = Logger.getLogger(BaseWeb.class.getName());


    @BeforeTest(alwaysRun = true)
    public void startProcess() {
        Configuration.browser = "Chrome";
        baseUrl = "https://kinohod.ru";
        clearBrowserCache();
    }

    @AfterTest(alwaysRun = true)
    public void stopProcess() {
        LOGGER.info("");
        closeWebDriver();
        LOGGER.info("");

    }
}
