package ru.kinohod.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

/**
 * The type Search result.
 */
public class SearchResultPage {

    /**
     * The constant TEXT.
     */
    private static final String TEXT = "Test-drive TV";

    /**
     * The Selenide Element.
     */
    private final transient SelenideElement searchResult = $("main[class='tm-main'] h2 div");

    /**
     * The default constructor.
     */
    public SearchResultPage() {
        super();
        //empty
        return;
    }

    /**
     * Assert result search result.
     *
     * @return the search result.
     */
    public SearchResultPage assertResult() {

        searchResult.shouldHave(Condition.text(TEXT));

        return this;
    }
}
