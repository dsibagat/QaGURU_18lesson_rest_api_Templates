package tests;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import spec.Spec;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;
import static utils.FileUtils.readStringFromFile;

@Tag("test_api")
public class DemoWebShopTests extends TestBaseApi {
    @Test
    void addToWishListTest() {
        String body = readStringFromFile("./src/test/resources/body.txt");

        given()
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

        given()
                .spec(Spec.request(bodyForMail))
                .when()
                .post("/productemailafriend/53")
                .then()
                .statusCode(200)
                .extract().response();
    }
}
