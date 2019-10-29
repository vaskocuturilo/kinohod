package ru.kinohod.pages;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.ElementsCollection;

import static com.codeborne.selenide.Selenide.$$;

/**
 * The class Main page.
 */
public class MainPage {

    /**
     * The ElementsCollection.
     */
    private final transient ElementsCollection links = $$("ul[class='uk-navbar-nav'] li");

    /**
     * The default constructor.
     */
    public MainPage() {
        super();
        //empty
        return;
    }

    /**
     * Check links main page.
     *
     * @param sizeLinks the size links
     * @return the main page
     */
    public MainPage checkLinks(final int sizeLinks) {

        links.shouldHaveSize(sizeLinks);

        return this;
    }

    /**
     * Check title links main page.
     *
     * @return the main page
     */
    public MainPage checkTitleLinks() {
        links.shouldHave(CollectionCondition.texts("Кинотеатры", "Фильмы", "Дома", " "));
        return this;
    }
}
