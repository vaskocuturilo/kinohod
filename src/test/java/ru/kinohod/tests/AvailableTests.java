package ru.kinohod.tests;

import io.qameta.allure.Story;
import org.testng.annotations.Test;
import ru.kinohod.AbstractPage;
import ru.kinohod.pages.CinemaPage;
import ru.kinohod.pages.MainPage;
import ru.kinohod.pages.MoviePage;
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
    @Story("Check cinema page.")
    public void testCheckCinema() {
        openPage("/cinema", "Кинотеатры - билеты и расписание сеансов - Киноход");
        new CinemaPage()
                .checkCinemasTitle(10);
    }

    @Test
    @Story("Check registration on the gift page.")
    public void testCheckGift() {
        openPage("", "Киноход - билеты в кино со скидкой 10%. Сервис по покупке и возврату билетов в кино");
        new MainPage()
                .checkLinks(4)
                .clickToTheElement(3)
                .enterDataForRegistration();
    }

    @Test
    @Story("Check subscribe on the gift page.")
    public void testCheckSubscribe() {
        openPage("", "Киноход - билеты в кино со скидкой 10%. Сервис по покупке и возврату билетов в кино");
        new MainPage()
                .checkLinks(4)
                .clickToTheElement(3)
                .checkSubscribeService();
    }

    @Test
    @Story("Check movie page.")
    public void testCheckMovie() {
        openPage("/movie", "Киноафиша - новинки кино и расписание фильмов - Киноход");
        new MoviePage()
                .buyTicket();
    }
}
