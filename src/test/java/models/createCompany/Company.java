package models.createCompany;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Company {

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public String getInn() {
        return inn;
    }

    public String getOgrn() {
        return ogrn;
    }

    public String getKpp() {
        return kpp;
    }

    public String getPhone() {
        return phone;
    }

    public String getAdress() {
        return adress;
    }

    public List<String> getUsers() {
        return users;
    }

    public String name;
    public String type;
    public String inn;
    public String ogrn;
    public String kpp;
    public String phone;
    public String adress;
    public List<String> users;
}
