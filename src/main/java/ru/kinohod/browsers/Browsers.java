package ru.kinohod.browsers;

import com.codeborne.selenide.Configuration;

/**
 * The class Browsers.
 */
public final class Browsers {

    /**
     * Method selectBrowser.
     *
     * @param browser the browser.
     */
    public static void selectBrowser(final String browser) {

        if ("chrome".equalsIgnoreCase(browser)) {
            Configuration.browser = Chrome.class.getName();
        } else if ("remote".equalsIgnoreCase(browser)) {
            Configuration.browser = Remote.class.getName();
        } else {
            throw new IllegalStateException("Browser " + browser + " not supported in this tests. ");
        }
    }
}
