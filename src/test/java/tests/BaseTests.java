package tests;

import factory.RequestFactory;
import models.doRegister.DoRegisterResponse;
import org.testng.annotations.BeforeClass;

import java.io.IOException;

import static helpers.ObjectToJSON.objectToJSON;
import static models.doRegister.DoRegisterRequest.doRegisterRequest;
import static utils.RandomUtils.getRandomEmail;
import static utils.RandomUtils.getRandomPassword;

public class BaseTests {

    RequestFactory requestFactory;
    String user;

    @BeforeClass
    void init() throws IOException {
        this.requestFactory = new RequestFactory();

        this.user = requestFactory.doRegister(objectToJSON(doRegisterRequest()
                .setName(getRandomEmail())
                .setPassword(getRandomPassword())
                .setEmail(getRandomEmail())))
                .statusCode(200)
                .extract().as(DoRegisterResponse.class).getEmail();

        System.out.println(user);
    }
}
