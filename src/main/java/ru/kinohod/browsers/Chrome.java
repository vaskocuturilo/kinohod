package ru.kinohod.browsers;

import com.codeborne.selenide.WebDriverProvider;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.Collections;
import java.util.HashMap;
import java.util.logging.Logger;

/**
 * The class Chrome.
 */
@SuppressWarnings("deprecation")
public class Chrome implements WebDriverProvider {

    /**
     * The constant LOGGER.
     */
    private static final Logger LOGGER = Logger.getLogger(Chrome.class.getName());

    @Override
    public WebDriver createDriver(DesiredCapabilities capabilities) {
        WebDriverManager.chromedriver().setup();

        capabilities.setCapability(ChromeOptions.CAPABILITY, chromeOptions());

        try {
            return new ChromeDriver(capabilities);
        } catch (Exception ex) {

            LOGGER.info(String.valueOf(ex));
        }
        return null;
    }

    /**
     * Method chromeOptions.
     */
    private ChromeOptions chromeOptions() {
        final ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("disable-infobars");

        chromeOptions.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
        chromeOptions.setExperimentalOption("useAutomationExtension", false);

        chromeOptions.addArguments("--disable-gpu");
        chromeOptions.addArguments("--disable-extensions");
        chromeOptions.addArguments("--no-sandbox");
        chromeOptions.addArguments("--disable-dev-shm-usage");

        final HashMap<String, Object> preference = new HashMap<String, Object>();
        preference.put("credentials_enable_service", false);
        preference.put("profile.password_manager_enabled", false);
        chromeOptions.setExperimentalOption("prefs", preference);

        return chromeOptions;
    }
}
