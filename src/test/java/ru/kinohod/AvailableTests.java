package ru.kinohod;

import io.qameta.allure.Story;
import org.testng.annotations.Test;
import ru.kinohod.pages.SearchPage;

public class AvailableTests extends AbstractPage {

    @Test
    @Story("Check main page.")
    public void testAssertMainPage() {
        openPage("", "Киноход - билеты в кино со скидкой 10%. Сервис по покупке и возврату билетов в кино");
    }

    @Test
    @Story("Check search.")
    public void testCheckSearch() {
        openPage("", "Киноход - билеты в кино со скидкой 10%. Сервис по покупке и возврату билетов в кино");
        new SearchPage()
                .addDataForSearch("test")
                .getResult()
                .assertResult();
    }
}
