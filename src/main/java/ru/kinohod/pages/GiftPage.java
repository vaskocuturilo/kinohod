package ru.kinohod.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import com.sun.istack.NotNull;

import java.util.Date;

import static com.codeborne.selenide.Selenide.$;

/**
 * The class Gift page.
 */
public class GiftPage {

    /**
     * The constant DELAY.
     */
    private static final long DELAY = 5000;

    /**
     * The constant TEXT.
     */
    private static final String TEXT = "Спасибо, что подписались на нашу рассылку!";

    /**
     * The private Selenide element.
     */
    private final transient SelenideElement
            registration = $("button[class='profile_unautorized']"),
            email = $("div[id='register_modal'] div[class='input_block email'] input"),
            password = $("div[id='register_modal'] div[class='input_block password'] input"),
            repeatPassword = $("div[id='register_modal'] div[class='input_block repeat_password'] input"),
            signIn = $("div[id='register_modal'] div[class='sign_container'] button"),
            subscribeInput = $("div[class='subscribe'] input"),
            subscribeButton = $("div[class='subscribe'] button"),
            subscribeSuccess = $("div[class='subscribeSuccess']");

    /**
     * The default constructor.
     */
    public GiftPage() {
        super();
        //empty
        return;
    }

    /**
     * Enter data for registration gift page.
     *
     * @return the gift page
     */
    public GiftPage enterDataForRegistration() {
        selectLastTab();
        registration.click();
        email.setValue(createEmailForNewUser());
        password.setValue("Test");
        repeatPassword.setValue("Test");
        signIn.click();

        return this;
    }


    /**
     * Method check subscribe service.
     *
     * @return the gift page.
     */
    public GiftPage checkSubscribeService() {
        selectLastTab();
        subscribeInput.setValue(createEmailForNewUser());
        subscribeButton.click();
        subscribeSuccess.waitUntil(Condition.visible, DELAY).shouldHave(Condition.text(TEXT));

        return this;
    }


    /**
     * Method select Last Tab.
     */
    private void selectLastTab() {
        for (final String lastTab : WebDriverRunner.getWebDriver().getWindowHandles()) {

            WebDriverRunner.getWebDriver().switchTo().window(lastTab);
        }
    }

    /**
     * Generate random email for new user.
     *
     * @return email.
     */
    @NotNull
    private static String createEmailForNewUser() {

        final String todayData = String.valueOf(new Date().getTime());

        return "kinohod" + todayData + "@qa.team";
    }
}
