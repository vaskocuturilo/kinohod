package ru.kinohod.browsers;

import com.codeborne.selenide.WebDriverProvider;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.logging.Logger;

/**
 * The class Chrome.
 */
@SuppressWarnings("deprecation")
public class Chrome implements WebDriverProvider {

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
     *
     */
    private ChromeOptions chromeOptions() {
        final ChromeOptions chromeOptions = new ChromeOptions();

        return chromeOptions;
    }


}
