package tests;

import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import spec.Spec;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;
import static utils.FileUtils.readStringFromFile;

public class DemoWebShopTests extends TestBase {
    @Test
    void addToWishListTest() {
        String body = readStringFromFile("./src/test/resources/body.txt");

        Response response = given()
                .spec(Spec.request(body))
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
        String bodyForMail = readStringFromFile("./src/test/resources/bodyForMail.txt");

        Response response = given()
                .spec(Spec.request(bodyForMail))
                .when()
                .post("/productemailafriend/53")
                .then()
                .statusCode(200)
                .extract().response();
    }
}
