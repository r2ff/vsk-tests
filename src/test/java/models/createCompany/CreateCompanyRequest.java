package models.createCompany;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import models.doRegister.DoRegisterRequest;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CreateCompanyRequest {

    @JsonProperty("company_name")
    String companyName;
    @JsonProperty("company_type")
    String companyType;
    @JsonProperty("company_users")
    String[] companyUsers;
    @JsonProperty("email_owner")
    String emailOwner;

    public static CreateCompanyRequest createCompanyRequest() {
        return new CreateCompanyRequest();
    }

    public CreateCompanyRequest setCompanyName(String companyName) {
        this.companyName = companyName;
        return this;
    }

    public CreateCompanyRequest setCompanyType(String companyType) {
        this.companyType = companyType;
        return this;
    }

    public CreateCompanyRequest setCompanyUsers(String[] companyUsers) {
        this.companyUsers = companyUsers;
        return this;
    }

    public CreateCompanyRequest setEmailOwner(String emailOwner) {
        this.emailOwner = emailOwner;
        return this;
    }
}
