package factory;

import config.ConfigHelper;
import io.restassured.response.ValidatableResponse;
import rest.RestClient;

public class RequestFactory {

    RestClient restClient;

    public RequestFactory() {
        restClient = new RestClient();
    }

    public ValidatableResponse doRegister(Object body) {
        return restClient.sendPostRequest(ConfigHelper.getDoRegisterUrl(), body)
                .then().log().body();
    }

    public ValidatableResponse createCompany(Object body) {
        return restClient.sendPostRequest(ConfigHelper.getCreateCompanyUrl(), body)
                .then().log().body();
    }
    public ValidatableResponse createUser(Object body) {
        return restClient.sendPostRequest(ConfigHelper.getCreateUserUrl(), body)
                .then().log().body();
    }
}
