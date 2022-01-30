package tests;

import factory.RequestFactory;
import models.createUsers.CreateUserResponse;
import org.junit.jupiter.api.DisplayName;
import org.testng.annotations.Test;

import static helpers.ObjectToJSON.objectToJSON;
import static io.qameta.allure.Allure.step;
import static models.createUsers.CreateUserRequest.createUserRequest;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static utils.RandomUtils.getRandomEmail;
import static utils.RandomUtils.getRandomUsername;

public class CreateUserTests {

    final static String resultTypeSuccess = "success";
    final static String resultTypeError = "error";
    final static String messageEmailInvalidError = "email неправильный!";
    final static String messageCompanyError = "Параметр companies является обязательным!";
    final static String messageNameError = " имя  не может быть пустым!";
//    final static String messageNameError = " имя  уже есть в БД";


    RequestFactory requestFactory = new RequestFactory();

    @Test
    @DisplayName("Отправка запроса с минимальным количеством атрибутов")
    void createCompanyWithMinAttributesTest() {

        final String email = getRandomEmail();
        final String name = getRandomUsername();
        final Integer[] tasks = new Integer[]{5};
        final Integer[] companies = new Integer[]{10};

        CreateUserResponse createUserResponse =
                step("Отправка POST запроса", () -> {
                    return requestFactory
                            .createUser(objectToJSON(createUserRequest()
                                    .setEmail(email)
                                    .setName(name)
                                    .setTasks(tasks)
                                    .setCompanies(companies)
                            ))
                            .statusCode(200)
                            .extract().as(CreateUserResponse.class);
                });

        step("Проверки", () -> {
            step("Проверка name", () -> assertThat(createUserResponse.getName(), is(name)));
            step("Проверка email", () -> assertThat(createUserResponse.getEmail(), is(email)));
        });
    }

    @Test
    @DisplayName("Отправка запроса с пустым body")
    void createCompanyWithEmptyBodyTest() {

        CreateUserResponse createUserResponse =
                step("Отправка POST запроса", () -> {
                    return requestFactory
                            .createUser(objectToJSON("")
                            )
                            .statusCode(200)
                            .extract().as(CreateUserResponse.class);
                });

        step("Проверки", () -> {
            step("Проверка type", () -> assertThat(createUserResponse.getType(), is(resultTypeError)));
            step("Проверка message", () -> assertThat(createUserResponse.getMessage(), is(messageCompanyError)));
        });
    }

    @Test
    @DisplayName("Отправка запроса с минимальным количеством атрибутов и атрибуты пустые")
    void createCompanyWithEmptyAttributesTest() {

        final String email = "";
        final String name = "";
        final Integer[] tasks = null;
        final Integer[] companies = null;

        CreateUserResponse createUserResponse =
                step("Отправка POST запроса", () -> {
                    return requestFactory
                            .createUser(objectToJSON(createUserRequest()
                                    .setEmail(email)
                                    .setName(name)
                                    .setTasks(tasks)
                                    .setCompanies(companies)
                            ))
                            .statusCode(200)
                            .extract().as(CreateUserResponse.class);
                });

        step("Проверки", () -> {
            step("Проверка type", () -> assertThat(createUserResponse.getType(), is(resultTypeError)));
            step("Проверка message", () -> assertThat(createUserResponse.getMessage(), is(messageCompanyError)));
        });
    }

    @Test
    @DisplayName("Отправка запроса с некорректным email")
    void createCompanyWithInvalidEmailTest() {

        final String email = getRandomEmail().replace("@", "");
        final String name = getRandomUsername();
        final Integer[] tasks = new Integer[]{5};
        final Integer[] companies = new Integer[]{10};

        CreateUserResponse createUserResponse =
                step("Отправка POST запроса", () -> {
                    return requestFactory
                            .createUser(objectToJSON(createUserRequest()
                                    .setEmail(email)
                                    .setName(name)
                                    .setTasks(tasks)
                                    .setCompanies(companies)
                            ))
                            .statusCode(200)
                            .extract().as(CreateUserResponse.class);
                });

        step("Проверки", () -> {
            step("Проверка type", () -> assertThat(createUserResponse.getType(), is(resultTypeError)));
            step("Проверка message", () -> assertThat(createUserResponse.getMessage(), is(messageEmailInvalidError)));
        });
    }

    @Test
    @DisplayName("Отправка запроса с пустым name")
    void createCompanyWithEmptyNameTest() {

        final String email = getRandomEmail();
        final String name = "";
        final Integer[] tasks = new Integer[]{5};
        final Integer[] companies = new Integer[]{10};

        CreateUserResponse createUserResponse =
                step("Отправка POST запроса", () -> {
                    return requestFactory
                            .createUser(objectToJSON(createUserRequest()
                                    .setEmail(email)
                                    .setName(name)
                                    .setTasks(tasks)
                                    .setCompanies(companies)
                            ))
                            .statusCode(200)
                            .extract().as(CreateUserResponse.class);
                });

        step("Проверки", () -> {
            step("Проверка type", () -> assertThat(createUserResponse.getType(), is(resultTypeError)));
            step("Проверка message", () -> assertThat(createUserResponse.getMessage(), is(messageNameError)));
        });
    }
}
