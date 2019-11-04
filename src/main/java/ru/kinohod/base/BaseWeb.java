package ru.kinohod.base;

import com.codeborne.selenide.Configuration;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import ru.kinohod.listener.AllureScreenShooter;

import java.util.logging.Logger;

import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.WebDriverRunner.*;

/**
 * The type Base web.
 */
@Listeners({AllureScreenShooter.class})
public class BaseWeb {

    /**
     * The constant for LOGGING.
     */
    private static final Logger LOGGER = Logger.getLogger(BaseWeb.class.getName());

    /**
     * The default constructor.
     */
    public BaseWeb() {
        super();
        //empty
        return;
    }

    /**
     * Start process.
     */
    @BeforeTest(alwaysRun = true)
    public void startProcess() {
        Configuration.browser = "Chrome";
        baseUrl = "https://kinohod.ru";
        clearBrowserCache();
    }

    /**
     * Stop process.
     */
    @AfterTest(alwaysRun = true)
    public void stopProcess() {
        LOGGER.info("");
        closeWebDriver();
        LOGGER.info("");

    }
}
