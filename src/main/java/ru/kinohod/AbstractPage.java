package ru.kinohod;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import ru.kinohod.base.BaseWeb;

import static org.testng.Assert.assertEquals;

public class AbstractPage extends BaseWeb {

    public void openPage(String url, String titlePage) {
        Selenide.open(url);
        assertEquals(getTitlePage(), titlePage);
    }

    public String getTitlePage() {
        return WebDriverRunner.getWebDriver().getTitle();
    }
}
