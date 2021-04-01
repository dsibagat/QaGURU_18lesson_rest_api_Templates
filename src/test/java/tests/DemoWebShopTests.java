package tests;

import api.Auth;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;
import static utils.FileUtils.readStringFromFile;

public class DemoWebShopTests extends TestBase {
    @Test
    void addToWishListTest() {
        Map<String, String> cookies = new Auth().login();
        String body = readStringFromFile("./src/test/resources/body.txt");

        Response response =
                given()
                        .contentType("application/x-www-form-urlencoded; charset=UTF-8")
                        .cookies(cookies)
                        .body(body)
                        .when()
                        .post("/addproducttocart/details/53/2")
                        .then()
                        .log().body()
                        .statusCode(200)
                        .body("success", is(true))
                        .extract().response();
    }
 @Test
    void sendMailToFriendTest() {
        Map<String, String> cookies = new Auth().login();
        String body = readStringFromFile("./src/test/resources/bodyForMail.txt");

        Response response =
                given()
                        .contentType("application/x-www-form-urlencoded; charset=UTF-8")
                        .cookies(cookies)
                        .body(body)
                        .when()
                        .post("/productemailafriend/53")
                        .then()
                        .statusCode(200)
                        .extract().response();
    }
}
