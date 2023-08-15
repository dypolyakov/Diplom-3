package com.dimqa.tests;

import com.dimqa.constants.Texts;
import com.dimqa.constants.Users;
import com.dimqa.model.Credentials;
import com.dimqa.tests.TestBase;
import org.junit.Assert;
import org.junit.Test;

public class LoginTest extends TestBase {
    Credentials credentials = new Credentials(Users.REGISTERED);
    @Test
    public void mainPageLogin() {
        homePage().clickLoginButton();
        loginPage().fillLoginForm(credentials);
        Assert.assertEquals(homePage().getOrderButtonText(), Texts.HOME_PAGE_ORDER_BUTTON_TEXT);
    }

    @Test
    public void accountPageLogin() {
        header().clickAccount();
        loginPage().fillLoginForm(credentials);
        Assert.assertEquals(homePage().getOrderButtonText(), Texts.HOME_PAGE_ORDER_BUTTON_TEXT);
    }

    @Test
    public void registrationPageLogin() {
        header().clickAccount();
        loginPage().clickRegistration();
        registrationPage().clickLoginLink();
        loginPage().fillLoginForm(credentials);
        Assert.assertEquals(homePage().getOrderButtonText(), Texts.HOME_PAGE_ORDER_BUTTON_TEXT);
    }

    @Test
    public void restorePasswordPageLogin() {
        header().clickAccount();
        loginPage().clickrestorePasswordLink();
        forgotPasswordPage().clickLoginLink();
        loginPage().fillLoginForm(credentials);
        Assert.assertEquals(homePage().getOrderButtonText(), Texts.HOME_PAGE_ORDER_BUTTON_TEXT);
    }


}
