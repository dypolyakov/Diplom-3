package com.dimqa.generator;

import com.dimqa.model.User;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;

public class UserGenerator {

    public User random() {
        String name = getRandomName();
        String email = getRandomEmail();
        String password = getRandomPassword();
        return new User(name, email, password);
    }

    public String getRandomName() {
        return RandomStringUtils.randomAlphabetic(4, 10);
    }
    public String getRandomEmail() {
        String username = RandomStringUtils.randomAlphabetic(4, 8);
        String domain = RandomStringUtils.randomAlphabetic(4, 6);
        String tld = RandomStringUtils.randomAlphabetic(2, 3);
        return String.format("%s@%s.%s", username, domain, tld).toLowerCase();
    }
    public String getRandomPassword() {
        return RandomStringUtils.randomAlphanumeric(6, 12);
    }

    public String getInvalidPassword() {
        return RandomStringUtils.randomAlphabetic(1, 5);
    }

}
