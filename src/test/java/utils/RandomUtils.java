package utils;

import com.github.javafaker.Faker;

import java.util.Locale;
import java.util.Random;

public class RandomUtils {

    public static String getRandomEmail() {
        return new Faker().internet().emailAddress();
    }

    public static String getRandomUsername() {
        return new Faker().name().username();
    }

    public static String getRandomPassword() {
        return new Faker().internet().password();
    }

    public static String getRandomCompanyType() {
        String[] types = new String[]{"ООО", "ИП", "ОАО"};
        Random random = new Random();
        return types[random.nextInt(types.length)];
    }

    public static String getRandomCompanyName() {
        return new Faker(new Locale("RU")).company().name().split(" ")[1];
    }

    public static String getRandomName() {
        return new Faker(new Locale("RU")).name().firstName();
    }

    public static String getRandomSurname() {
        return new Faker(new Locale("RU")).name().lastName();
    }

    public static String getRandomFatherName() {
        return new Faker(new Locale("RU")).name().nameWithMiddle().split(" ")[1];
    }

    public static String getRandomAnimalName() {
        return new Faker().animal().name();
    }

    public static String getRandomPhoneNumber() {
        return new Faker().phoneNumber().subscriberNumber(7);
    }

    public static String getRandomINN() {
        return new Faker().number().digits(12);
    }

    public static String getRandomGender() {
        String[] types = new String[]{"f", "m"};
        Random random = new Random();
        return types[random.nextInt(types.length)];

    }

    public static String getRandomHobby() {
        return new Faker().programmingLanguage().name();
    }
}
