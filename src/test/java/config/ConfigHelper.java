package config;

import org.aeonbits.owner.ConfigFactory;

public class ConfigHelper {

    private static AppConfig getConfig() {
        return ConfigFactory.newInstance().create(AppConfig.class, System.getProperties());
    }

    public static String getDoRegisterUrl() {
        return getConfig().doRegisterUrl();
    }

    public static String getCreateCompanyUrl() {
        return getConfig().createCompanyUrl();
    }

    public static String getCreateUserUrl() {
        return getConfig().createUserUrl();
    }
}
