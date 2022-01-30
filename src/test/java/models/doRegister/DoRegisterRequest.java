package models.doRegister;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DoRegisterRequest {


    private String name;
    private String password;
    private String email;

    public static DoRegisterRequest doRegisterRequest() {
        return new DoRegisterRequest();
    }

    public String getName() {
        return name;
    }

    public DoRegisterRequest setName(String name) {
        this.name = name;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public DoRegisterRequest setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public DoRegisterRequest setEmail(String email) {
        this.email = email;
        return this;
    }
}
