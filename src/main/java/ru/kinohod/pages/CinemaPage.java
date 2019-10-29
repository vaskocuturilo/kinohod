package ru.kinohod.pages;

import com.codeborne.selenide.ElementsCollection;

import static com.codeborne.selenide.Selenide.$$;

/**
 * The type Cinema page.
 */
public class CinemaPage {

    /**
     * The ElementsCollection.
     */
    private final transient ElementsCollection collections = $$("article[class='wk-item-cinema uk-article']");

    /**
     * The default constructor.
     */
    public CinemaPage() {
        super();
        //empty
        return;
    }

    /**
     * Check cinemas title cinema page.
     *
     * @param cinemasList the collections cinemas
     * @return the cinema page
     */
    public CinemaPage checkCinemasTitle(final int cinemasList) {
        collections.shouldHaveSize(cinemasList);
        return this;
    }

}
