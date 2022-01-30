package tests;

import factory.RequestFactory;
import models.doRegister.DoRegisterResponse;
import org.junit.jupiter.api.DisplayName;
import org.testng.annotations.Test;

import static helpers.ObjectToJSON.objectToJSON;
import static io.qameta.allure.Allure.step;
import static models.doRegister.DoRegisterRequest.doRegisterRequest;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static utils.RandomUtils.*;

//import org.junit.jupiter.api.Test;

public class DoRegisterTests {

    final static String typeError = "error";
    final static String messageEmailError = "Параметр email является обязательным!";
    final static String messageEmailIncorrectError = " Некоректный  email ";
    final static String messageNameError = "Параметр name является обязательным!";
    final static String messagePasswordError = "Параметр password является обязательным!";


    @Test
    @DisplayName("Отправка запроса со всеми атрибутами (name, email, password)")
    void doRegistrationWithFullCredsTest() {

        final String email = getRandomEmail();
        final String name = getRandomUsername();
        final String password = getRandomPassword();

        RequestFactory requestFactory = new RequestFactory();

        DoRegisterResponse doRegisterResponse =
                step("Отправка POST запроса", () -> {
                    return requestFactory
                            .doRegister(objectToJSON(doRegisterRequest()
                                    .setName(name)
                                    .setPassword(password)
                                    .setEmail(email)))
                            .statusCode(200)
                            .extract().as(DoRegisterResponse.class);
                });

        step("Проверки", () -> {
            step("Проверка name", () -> assertThat(doRegisterResponse.getName(), is(name)));
            step("Проверка email", () -> assertThat(doRegisterResponse.getEmail(), is(email)));
        });
    }

    @Test
    @DisplayName("Отправка запроса с пустым body")
    void doRegistrationWithEmptyBodyTest() {

        RequestFactory requestFactory = new RequestFactory();

        DoRegisterResponse doRegisterResponse =
                step("Отправка POST запроса", () -> {
                    return requestFactory
                            .doRegister("")
                            .statusCode(200)
                            .extract().as(DoRegisterResponse.class);
                });

        step("Проверки", () -> {
            step("Проверка type", () -> assertThat(doRegisterResponse.getType(), is(typeError)));
            step("Проверка message", () -> assertThat(doRegisterResponse.getMessage(), is(messageEmailError)));
        });
    }

    @Test
    @DisplayName("Отправка запроса только с email")
    void doRegistrationWithEmailOnlyTest() {

        final String email = getRandomEmail();

        RequestFactory requestFactory = new RequestFactory();

        DoRegisterResponse doRegisterResponse =
                step("Отправка POST запроса", () -> {
                    return requestFactory
                            .doRegister(objectToJSON(doRegisterRequest()
                                    .setEmail(email)))
                            .statusCode(200)
                            .extract().as(DoRegisterResponse.class);
                });
        step("Проверки", () -> {
            step("Проверка type", () -> assertThat(doRegisterResponse.getType(), is(typeError)));
            step("Проверка message", () -> assertThat(doRegisterResponse.getMessage(), is(messageNameError)));
        });
    }

    @Test
    @DisplayName("Отправка запроса только с email и name")
    void doRegistrationWithEmailAndNameTest() {

        final String email = getRandomEmail();
        final String name = getRandomUsername();

        RequestFactory requestFactory = new RequestFactory();

        DoRegisterResponse doRegisterResponse =
                step("Отправка POST запроса", () -> {
                    return requestFactory
                            .doRegister(objectToJSON(doRegisterRequest()
                                    .setName(name)
                                    .setEmail(email)))
                            .statusCode(200)
                            .extract().as(DoRegisterResponse.class);
                });

        step("Проверки", () -> {
            step("Проверка type", () -> assertThat(doRegisterResponse.getType(), is(typeError)));
            step("Проверка message", () -> assertThat(doRegisterResponse.getMessage(), is(messagePasswordError)));
        });
    }

    @Test
    @DisplayName("Отправка запроса только с name и password")
    void doRegistrationWithNameAndPasswordTest() {

        final String password = getRandomPassword();
        final String name = getRandomUsername();

        RequestFactory requestFactory = new RequestFactory();

        DoRegisterResponse doRegisterResponse =
                step("Отправка POST запроса", () -> {
                    return requestFactory
                            .doRegister(objectToJSON(doRegisterRequest()
                                    .setName(name)
                                    .setPassword(password)))
                            .statusCode(200)
                            .extract().as(DoRegisterResponse.class);
                });

        step("Проверки", () -> {
            step("Проверка type", () -> assertThat(doRegisterResponse.getType(), is(typeError)));
            step("Проверка message", () -> assertThat(doRegisterResponse.getMessage(), is(messageEmailError)));
        });
    }

    @Test
    @DisplayName("Отправка запроса c пустыми атрбутами name, password, email")
    void doRegistrationWithEmptyAttributesTest() {

        final String password = "";
        final String name = "";
        final String email = "";

        RequestFactory requestFactory = new RequestFactory();

        DoRegisterResponse doRegisterResponse =
                step("Отправка POST запроса", () -> {
                    return requestFactory
                            .doRegister(objectToJSON(doRegisterRequest()
                                    .setName(name)
                                    .setEmail(email)
                                    .setPassword(password)))
                            .statusCode(200)
                            .extract().as(DoRegisterResponse.class);
                });

        step("Проверки", () -> {
            step("Проверка type", () -> assertThat(doRegisterResponse.getType(), is(typeError)));
            step("Проверка message", () -> assertThat(doRegisterResponse.getMessage(), is(messageEmailIncorrectError)));
        });
    }
}
