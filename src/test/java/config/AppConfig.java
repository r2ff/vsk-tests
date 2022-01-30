package config;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "classpath:config/app.properties",
})
public interface AppConfig extends Config {

    @Key("app.doRegister.url")
    String doRegisterUrl();

    @Key("app.CreateCompany.url")
    String createCompanyUrl();

    @Key("app.CreateUser.url")
    String createUserUrl();
}
