package ru.kinohod.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;


/**
 * The class Movie page.
 */
public class MoviePage {

    /**
     * The constant TEXT.
     */
    private static final String TEXT = "Купить билеты";

    /**
     * The constant DELAY.
     */
    private static final long DELAY = 5000;

    /**
     * The private Elements Collection.
     */
    private final transient SelenideElement
            movies = $("div[id='app'] div:nth-child(1) > article button"),
            buyTicketForm = $("div[id='boxoffice'] div:nth-child(3) svg");

    /**
     * Method Buy ticket.
     *
     * @return the movie page.
     */
    public MoviePage buyTicket() {
        movies.shouldHave(Condition.text(TEXT)).click();
        buyTicketForm.waitUntil(Condition.visible, DELAY).click();
        return this;
    }

}
