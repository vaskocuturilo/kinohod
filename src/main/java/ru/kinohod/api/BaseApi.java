package ru.kinohod.api;

import io.restassured.RestAssured;
import org.testng.annotations.BeforeTest;

import static ru.kinohod.utils.PropertiesReader.loadProperty;


/**
 * The class Base api.
 */
public class BaseApi {

    /**
     * The default constructor.
     */
    public BaseApi() {
        super();
        //empty
        return;
    }

    /**
     * Before test.
     */
    @BeforeTest(alwaysRun = true)
    public void beforeTest() {
        RestAssured.baseURI = loadProperty("url");
    }
}
