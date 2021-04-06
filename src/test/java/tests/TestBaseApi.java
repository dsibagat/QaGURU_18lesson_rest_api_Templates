package tests;

import com.codeborne.selenide.Configuration;
import config.ConfigHelper;
import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;


public class TestBaseApi {
    @BeforeAll
    public static void beforeAll() {
        RestAssured.baseURI = ConfigHelper.getWebUri();
        Configuration.baseUrl = ConfigHelper.getWebUrl();
        Configuration.timeout = 10000;
    }
}