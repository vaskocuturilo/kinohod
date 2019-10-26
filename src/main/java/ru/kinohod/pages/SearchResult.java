package ru.kinohod.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

/**
 * The type Search result.
 */
public class SearchResult {
    private static final String TEXT = "Test-drive TV";

    /**
     * The constant.
     */
    private transient SelenideElement searchResult = $("main[class='tm-main'] h2 div");

    /**
     * Assert result search result.
     *
     * @return the search result.
     */
    public SearchResult assertResult() {

        searchResult.shouldHave(Condition.text(TEXT));

        return this;
    }
}
