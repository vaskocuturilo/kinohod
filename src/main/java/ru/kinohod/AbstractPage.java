package ru.kinohod;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import ru.kinohod.base.BaseWeb;

import static org.testng.Assert.assertEquals;

/**
 * The type Abstract page.
 */
public abstract class AbstractPage extends BaseWeb {

    /**
     * The default constructor.
     */
    public AbstractPage() {
        super();
        //empty
        return;
    }

    /**
     * Open page.
     *
     * @param url       the url.
     * @param titlePage the title page.
     */
    public void openPage(final String url, final String titlePage) {
        Selenide.open(url);
        assertEquals(getTitlePage(), titlePage);
    }

    /**
     * Gets title page.
     *
     * @return the title page.
     */
    public String getTitlePage() {
        return WebDriverRunner.getWebDriver().getTitle();
    }
}
