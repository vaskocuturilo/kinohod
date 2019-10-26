package ru.kinohod.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;

import static com.codeborne.selenide.Selenide.$$;

/**
 * The type Cinema page.
 */
public class CinemaPage {

    /**
     * The ElementsCollection.
     */
    private transient ElementsCollection collections = $$("article[class='wk-item-cinema uk-article']");


    /**
     * Check cinemas title cinema page.
     *
     * @param collectionsCinemas the collections cinemas
     * @return the cinema page
     */
    public CinemaPage checkCinemasTitle(int collectionsCinemas) {
        collections.shouldHaveSize(collectionsCinemas);
        return this;
    }

}
