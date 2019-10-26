package ru.kinohod;

import io.qameta.allure.Story;
import org.testng.annotations.Test;
import ru.kinohod.pages.CinemaPage;
import ru.kinohod.pages.MainPage;
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

    @Test
    @Story("Check size of links.")
    public void testCheckSizeOfLinks() {
        openPage("", "Киноход - билеты в кино со скидкой 10%. Сервис по покупке и возврату билетов в кино");
        new MainPage()
                .checkLinks(4)
                .checkTitleLinks();
    }

    @Test
    @Story("Check cinema page")
    public void testCheckCinema() {
        openPage("/cinema", "Кинотеатры - билеты и расписание сеансов - Киноход");
        new CinemaPage()
                .checkCinemasTitle(10);

    }

}
