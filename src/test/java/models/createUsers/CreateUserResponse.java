package models.createUsers;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CreateUserResponse {

    String email;
    String name;
    String hobby;
    String adres;
    String name1;
    String surname1;
    String fathername1;
    String cat;
    String dog;
    String parrot;
    String cavy;
    String hamster;
    String squirrel;
    String phone;
    String inn;
    String gender;
    String type;
    String message;

    public String getType() {
        return type;
    }

    public String getMessage() {
        return message;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public String getHobby() {
        return hobby;
    }

    public String getAdres() {
        return adres;
    }

    public String getName1() {
        return name1;
    }

    public String getSurname1() {
        return surname1;
    }

    public String getFathername1() {
        return fathername1;
    }

    public String getCat() {
        return cat;
    }

    public String getDog() {
        return dog;
    }

    public String getParrot() {
        return parrot;
    }

    public String getCavy() {
        return cavy;
    }

    public String getHamster() {
        return hamster;
    }

    public String getSquirrel() {
        return squirrel;
    }

    public String getPhone() {
        return phone;
    }

    public String getInn() {
        return inn;
    }

    public String getGender() {
        return gender;
    }
}
