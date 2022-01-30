package models.doRegister;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DoRegisterResponse {

    String name;
    String avatar;
    String password;
    Integer birthday;
    String email;
    String gender;
    @JsonProperty("date_start")
    Integer dateStart;
    String hobby;
    String type;
    String message;

    public String getName() {
        return name;
    }

    public String getAvatar() {
        return avatar;
    }

    public String getPassword() {
        return password;
    }

    public Integer getBirthday() {
        return birthday;
    }

    public String getEmail() {
        return email;
    }

    public String getGender() {
        return gender;
    }

    public Integer getDateStart() {
        return dateStart;
    }

    public String getType() {
        return type;
    }

    public String getMessage() {
        return message;
    }

    public String getHobby() {
        return hobby;
    }
}
