package tests;

import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import spec.Spec;

import static org.hamcrest.Matchers.is;
import static utils.FileUtils.readStringFromFile;

public class DemoWebShopTests extends TestBase {
    @Test
    public Response addToWishListTest() {
        String body = readStringFromFile("./src/test/resources/body.txt");
        return Spec.request(body).when()
                .post("/addproducttocart/details/53/2")
                .then()
                .log().body()
                .statusCode(200)
                .body("success", is(true))
                .extract().response();
    }

    @Test
    public Response sendMailToFriendTest() {
        String body = readStringFromFile("./src/test/resources/bodyForMail.txt");
        return Spec.request(body).when()
                .post("/productemailafriend/53")
                .then()
                .statusCode(200)
                .extract().response();
    }
}
