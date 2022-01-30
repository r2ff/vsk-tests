package models.createUsers;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CreateUserRequest {

    @JsonProperty("email")
    String email;
    @JsonProperty("name")
    String name;
    @JsonProperty("tasks")
    Integer[] tasks;
    @JsonProperty("companies")
    Integer[] companies;
    @JsonProperty("hobby")
    String hobby;
    @JsonProperty("adres")
    String adres;
    @JsonProperty("name1")
    String name1;
    @JsonProperty("surname1")
    String surname1;
    @JsonProperty("fathername1")
    String fathername1;
    @JsonProperty("cat")
    String cat;
    @JsonProperty("dog")
    String dog;
    @JsonProperty("parrot")
    String parrot;
    @JsonProperty("cavy")
    String cavy;
    @JsonProperty("hamster")
    String hamster;
    @JsonProperty("squirrel")
    String squirrel;
    @JsonProperty("phone")
    String phone;
    @JsonProperty("inn")
    String inn;
    @JsonProperty("gender")
    String gender;
    @JsonProperty("birthday")
    String birthday;
    @JsonProperty("date_start")
    String dateStart;

    public static CreateUserRequest createUserRequest() {
        return new CreateUserRequest();
    }

    public CreateUserRequest setEmail(String email) {
        this.email = email;
        return this;
    }

    public CreateUserRequest setName(String name) {
        this.name = name;
        return this;
    }

    public CreateUserRequest setTasks(Integer[] tasks) {
        this.tasks = tasks;
        return this;
    }

    public CreateUserRequest setCompanies(Integer[] companies) {
        this.companies = companies;
        return this;
    }

    public CreateUserRequest setHobby(String hobby) {
        this.hobby = hobby;
        return this;
    }

    public CreateUserRequest setAdres(String adres) {
        this.adres = adres;
        return this;
    }

    public CreateUserRequest setName1(String name1) {
        this.name1 = name1;
        return this;
    }

    public CreateUserRequest setSurname1(String surname1) {
        this.surname1 = surname1;
        return this;
    }

    public CreateUserRequest setFathername1(String fathername1) {
        this.fathername1 = fathername1;
        return this;
    }

    public CreateUserRequest setCat(String cat) {
        this.cat = cat;
        return this;
    }

    public CreateUserRequest setDog(String dog) {
        this.dog = dog;
        return this;
    }

    public CreateUserRequest setParrot(String parrot) {
        this.parrot = parrot;
        return this;
    }

    public CreateUserRequest setCavy(String cavy) {
        this.cavy = cavy;
        return this;
    }

    public CreateUserRequest setHamster(String hamster) {
        this.hamster = hamster;
        return this;
    }

    public CreateUserRequest setSquirrel(String squirrel) {
        this.squirrel = squirrel;
        return this;
    }

    public CreateUserRequest setPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public CreateUserRequest setInn(String inn) {
        this.inn = inn;
        return this;
    }

    public CreateUserRequest setGender(String gender) {
        this.gender = gender;
        return this;
    }

    public CreateUserRequest setBirthday(String birthday) {
        this.birthday = birthday;
        return this;
    }

    public CreateUserRequest setDateStart(String dateStart) {
        this.dateStart = dateStart;
        return this;
    }
}
