package spec;

import apiAuth.Auth;
import io.restassured.specification.RequestSpecification;

import java.util.Map;

import static io.restassured.RestAssured.given;
import static tameplate.ReportTemplate.filters;

public class Spec {

    public static RequestSpecification request(String body) {
        Map<String, String> cookies = new Auth().login();
        return given()
                .contentType("application/x-www-form-urlencoded; charset=UTF-8")
                .cookies(cookies)
                .body(body)
                .filter(filters().customTemplates());
    }
}
