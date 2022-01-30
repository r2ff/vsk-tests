package rest;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static helpers.LogFilter.filters;
import static io.restassured.RestAssured.given;

public class RestClient {

    public Response sendPostRequest(String uri, Object body) {
        return given()
                .contentType(ContentType.JSON)
                .filter(filters().withRestApiTemplates())
                .when()
                .body(body).log().body()
                .post(uri);
    }
}
