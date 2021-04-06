package tests;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

@Tag("test_api")
public class RegistrationTest extends TestBase {
    @Test
    void successesRegistration() {
        Faker faker = new Faker();
        String firstName = faker.name().firstName(),
                lastName = faker.name().lastName(),
                email = faker.internet().emailAddress(),
                password = faker.internet().password();

        open("/register");
        $("#FirstName").val(firstName);
        $("#LastName").val(lastName);
        $("#Email").val(email);
        $("#Password").val(password);
        $("#ConfirmPassword").val(password);
        $("#register-button").click();
        $(".result").shouldHave(text("Your registration completed"));
    }
}
