package ru.kinohod.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

/**
 * The type Search page.
 */
public class SearchPage {

    /**
     * The constant DELAY.
     */
    private static final long DELAY = 5000;

    /**
     * The Selenide elements.
     */
    private transient SelenideElement
            search = $("input[id='search-navbar']"),
            searchResult = $("ul[class='uk-list uk-margin-remove-bottom'] a");

    /**
     * Add data for search search page.
     *
     * @param textForSearch the text for search.
     * @return the search page.
     */
    public SearchPage addDataForSearch(String textForSearch) {
        search.setValue(textForSearch).pressEnter();
        return this;
    }

    /**
     * Get result search result.
     *
     * @return the search result.
     */
    public SearchResult getResult() {
        searchResult.waitUntil(Condition.visible, DELAY).click();
        return new SearchResult();
    }

}
