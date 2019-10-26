package ru.kinohod;

import io.qameta.allure.Story;
import org.testng.annotations.Test;

public class AvailableTests extends AbstractPage {

    @Test
    @Story("Check main page.")
    public void testAssertMainPage() {
        openPage("","Киноход - билеты в кино со скидкой 10%. Сервис по покупке и возврату билетов в кино");

    }
}
