package models.createCompany;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CreateCompanyResponse {


    String type;
    @JsonProperty("id_company")
    Integer idCompany;
    Company company;
    String message;


    public String getType() {
        return type;
    }

    public int getIdCompany() {
        return idCompany;
    }

    public Company getCompany() {
        return company;
    }

    public String getMessage() {
        return message;
    }
}
