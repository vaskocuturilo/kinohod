package ru.kinohod.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

/**
 * The class Search page.
 */
public class SearchPage {

    /**
     * The constant DELAY.
     */
    private static final long DELAY = 5000;

    /**
     * The Selenide elements.
     */
    private final transient SelenideElement
            search = $("input[id='search-navbar']"),
            searchResult = $("ul[class='uk-list uk-margin-remove-bottom'] a");

    /**
     * The default constructor.
     */
    public SearchPage() {
        super();
        //empty
        return;
    }

    /**
     * Add data for search search page.
     *
     * @param textForSearch the text for search.
     * @return the search page.
     */
    public SearchPage addDataForSearch(final String textForSearch) {
        search.setValue(textForSearch).pressEnter();
        return this;
    }

    /**
     * Get result search result.
     *
     * @return the search result.
     */
    public SearchResultPage getResult() {
        searchResult.waitUntil(Condition.visible, DELAY).click();
        return new SearchResultPage();
    }

}
