package com.dimqa.tests;

import com.dimqa.constants.Texts;
import com.dimqa.generator.UserGenerator;
import com.dimqa.model.User;
import com.dimqa.constants.URLs;
import com.dimqa.tests.TestBase;
import org.junit.Assert;
import org.junit.Test;

public class RegistrationTest extends TestBase {

    private final UserGenerator userGenerator = new UserGenerator();

    @Test
    public void testRegistration() {
        header().clickAccount();
        accountPage().clickRegistration();
        User user = userGenerator.random();
        registrationPage().fillForm(user);
        registrationPage().clickRegistrationButton();
        loginPage().waitingForLoading();
        Assert.assertEquals(loginPage().getHeadingText(), Texts.LOGIN_PAGE_HEADING);
        Assert.assertEquals(getCurrentUrl(), URLs.LOGIN_PAGE);
    }

    @Test
    public void invalidPasswordLength() {
        header().clickAccount();
        accountPage().clickRegistration();
        registrationPage().fillPassword(userGenerator.getInvalidPassword());
        registrationPage().clickRegistrationButton();
        Assert.assertTrue(registrationPage().getPasswordAttribute().contains("input_status_error"));
        String actualErrorText = registrationPage().getPasswordErrorMessage();
        String expectedErrorText = Texts.LOGIN_PAGE_PASSWORD_ERROR_MESSAGE;
        Assert.assertEquals(actualErrorText, expectedErrorText);
    }

}
