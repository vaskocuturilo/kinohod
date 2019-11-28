package ru.kinohod.browsers;

import com.codeborne.selenide.WebDriverProvider;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Logger;

import static ru.kinohod.utils.PropertiesReader.loadProperty;


/**
 * The class Remote.
 */
public class Remote implements WebDriverProvider {
    /**
     * The constant LOGGER.
     */
    private static final Logger LOGGER = Logger.getLogger(Remote.class.getName());

    @Override
    public WebDriver createDriver(final DesiredCapabilities capabilities) {
        capabilities.setBrowserName("chrome");
        capabilities.setCapability("enableVNC", true);
        capabilities.setCapability(ChromeOptions.CAPABILITY, Chrome.chromeOptions());
        capabilities.setCapability("screenResolution", "1920x1080x24");
        try {
            return new RemoteWebDriver(getSelenoidUrl(), capabilities);
        } catch (Exception ex) {
            LOGGER.info("" + ex);
        }
        return null;
    }
    /**
     * The private method for run Grid .
     */
    private static URL getSelenoidUrl() {
        URL hostURL = null;
        try {
            hostURL = new URL(System.getProperty("selenoid.url", loadProperty("LOCAL")));
        } catch (MalformedURLException ex) {
            LOGGER.info("" + ex);
        }
        return hostURL;
    }
}
