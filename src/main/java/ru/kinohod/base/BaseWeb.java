package ru.kinohod.base;

import org.testng.annotations.*;
import ru.kinohod.environment.Environment;
import ru.kinohod.listener.AllureScreenShooter;

import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.WebDriverRunner.*;
import static ru.kinohod.browsers.Browsers.selectBrowser;
import static ru.kinohod.utils.PropertiesReader.loadProperty;

/**
 * The type Base web.
 */
@Listeners({AllureScreenShooter.class})
public class BaseWeb {

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
     *
     * @param browser this value for which browser use.
     */
    @Parameters({"browser"})
    @BeforeTest(alwaysRun = true)
    public void startProcess(@Optional("chrome") final String browser) {
        baseUrl = loadProperty("WEB_URL");
        if (Environment.isCheckOperatingSystem()) {
            selectBrowser("remote");
        } else {
            selectBrowser(browser);
            clearBrowserCache();
        }
    }

    /**
     * Stop process.
     */
    @AfterTest(alwaysRun = true)
    public void stopProcess() {
        closeWebDriver();
    }
}
