package tests;

import models.createCompany.CreateCompanyResponse;
import org.junit.jupiter.api.DisplayName;
import org.testng.annotations.Test;

import static helpers.ObjectToJSON.objectToJSON;
import static io.qameta.allure.Allure.step;
import static models.createCompany.CreateCompanyRequest.createCompanyRequest;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.is;
import static utils.RandomUtils.getRandomCompanyName;
import static utils.RandomUtils.getRandomCompanyType;

public class CreateCompanyTests extends BaseTests {

    final static String resultTypeSuccess = "success";
    final static String resultTypeError = "error";
    final static String messageEmailError = "Параметр email_owner является обязательным!";
    final static String messageCompanyTypeError = "Параметр company_type является обязательным!";
    final static String messageError = "некорректный";


    @Test
    @DisplayName("Отправка запроса со всеми атрибутами (company_name, company_type, company_users, email_owner)")
    void createCompanyWithFullAttributesTest() {

        final String companyType = getRandomCompanyType();
        final String companyName = getRandomCompanyName();
        final String[] companyUsers = new String[]{user};
        final String emailOwner = user;

//        RequestFactory requestFactory = new RequestFactory();

        CreateCompanyResponse createCompanyResponse =
                step("Отправка POST запроса", () -> {
                    return requestFactory
                            .createCompany(objectToJSON(createCompanyRequest()
                                    .setCompanyType(companyType)
                                    .setCompanyName(companyName)
                                    .setCompanyUsers(companyUsers)
                                    .setEmailOwner(emailOwner)))
                            .statusCode(200)
                            .extract().as(CreateCompanyResponse.class);
                });

        step("Проверки", () -> {
            step("Проверка company_name", () -> assertThat(createCompanyResponse.getCompany().getName(), is(companyName)));
            step("Проверка type", () -> assertThat(createCompanyResponse.getType(), is(resultTypeSuccess)));
        });
    }

    @Test
    @DisplayName("Отправка запроса с пустым body")
    void createCompanyWithEmptyBoyTest() {

        CreateCompanyResponse createCompanyResponse =
                step("Отправка POST запроса", () -> {
                    return requestFactory
                            .createCompany(objectToJSON(""))
                            .statusCode(200)
                            .extract().as(CreateCompanyResponse.class);
                });

        step("Проверки", () -> {
            step("Проверка message", () -> assertThat(createCompanyResponse.getMessage(), is(messageEmailError)));
            step("Проверка type", () -> assertThat(createCompanyResponse.getType(), is(resultTypeError)));
        });
    }

    @Test
    @DisplayName("Отправка запроса без company_type")
    void createCompanyWithoutCompanyTypeTest() {

        final String companyName = getRandomCompanyName();
        final String[] companyUsers = new String[]{user};
        final String emailOwner = user;

//        RequestFactory requestFactory = new RequestFactory();

        CreateCompanyResponse createCompanyResponse =
                step("Отправка POST запроса", () -> {
                    return requestFactory
                            .createCompany(objectToJSON(createCompanyRequest()
                                    .setCompanyName(companyName)
                                    .setCompanyUsers(companyUsers)
                                    .setEmailOwner(emailOwner)))
                            .statusCode(200)
                            .extract().as(CreateCompanyResponse.class);
                });

        step("Проверки", () -> {
            step("Проверка message", () -> assertThat(createCompanyResponse.getMessage(), is(messageCompanyTypeError)));
            step("Проверка type", () -> assertThat(createCompanyResponse.getType(), is(resultTypeError)));
        });
    }

    @Test
    @DisplayName("Отправка запроса с company_type, которого нет в списке доступных")
    void createCompanyWithWrongCompanyTypeTest() {

        final String companyType = "ЗАО";
        final String companyName = getRandomCompanyName();
        final String[] companyUsers = new String[]{user};
        final String emailOwner = user;

//        RequestFactory requestFactory = new RequestFactory();

        CreateCompanyResponse createCompanyResponse =
                step("Отправка POST запроса", () -> {
                    return requestFactory
                            .createCompany(objectToJSON(createCompanyRequest()
                                    .setCompanyName(companyName)
                                    .setCompanyType(companyType)
                                    .setCompanyUsers(companyUsers)
                                    .setEmailOwner(emailOwner)))
                            .statusCode(200)
                            .extract().as(CreateCompanyResponse.class);
                });

        step("Проверки", () -> {
            step("Проверка message", () -> assertThat(createCompanyResponse.getMessage(), containsString(messageError)));
            step("Проверка type", () -> assertThat(createCompanyResponse.getType(), is(resultTypeError)));
        });
    }

    @Test
    @DisplayName("Отправка запроса с пустым атрибутом company_name")
    void createCompanyWithEmptyCompanyNameTest() {

        final String companyType = getRandomCompanyType();
        final String companyName = "";
        final String[] companyUsers = new String[]{user};
        final String emailOwner = user;

//        RequestFactory requestFactory = new RequestFactory();

        CreateCompanyResponse createCompanyResponse =
                step("Отправка POST запроса", () -> {
                    return requestFactory
                            .createCompany(objectToJSON(createCompanyRequest()
                                    .setCompanyName(companyName)
                                    .setCompanyType(companyType)
                                    .setCompanyUsers(companyUsers)
                                    .setEmailOwner(emailOwner)))
                            .statusCode(200)
                            .extract().as(CreateCompanyResponse.class);
                });

        step("Проверки", () -> {
            step("Проверка message", () -> assertThat(createCompanyResponse.getMessage(), containsString(messageError)));
            step("Проверка type", () -> assertThat(createCompanyResponse.getType(), is(resultTypeError)));
        });
    }
}

