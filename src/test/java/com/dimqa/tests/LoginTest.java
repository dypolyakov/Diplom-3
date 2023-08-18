package com.dimqa.tests;

import com.dimqa.constants.Texts;
import com.dimqa.constants.Users;
import com.dimqa.model.Credentials;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Test;

public class LoginTest extends TestBase {
    Credentials credentials = new Credentials(Users.REGISTERED);
    @Test
    @DisplayName("Accessing the authorization page via the home page")
    @Description("Authorization from the home page via the \"login to account\" button")
    public void mainPageLogin() {
        homePage().clickLoginButton();
        loginPage().fillLoginForm(credentials);
        Assert.assertEquals(homePage().getOrderButtonText(), Texts.HOME_PAGE_ORDER_BUTTON_TEXT);
    }

    @Test
    @DisplayName("Accessing the authorization page via the header")
    @Description("Authorization from the home page via the \"My Account\" button in the header of the site")
    public void accountPageLogin() {
        header().clickAccount();
        loginPage().fillLoginForm(credentials);
        Assert.assertEquals(homePage().getOrderButtonText(), Texts.HOME_PAGE_ORDER_BUTTON_TEXT);
    }

    @Test
    @DisplayName("Accessing the authorization page via the registration page")
    @Description("Authorization from the registration page via the \"Login\" button in the registration form")
    public void registrationPageLogin() {
        header().clickAccount();
        loginPage().clickRegistration();
        registrationPage().clickLoginLink();
        loginPage().fillLoginForm(credentials);
        Assert.assertEquals(homePage().getOrderButtonText(), Texts.HOME_PAGE_ORDER_BUTTON_TEXT);
    }

    @Test
    @DisplayName("Accessing the authorization page via the forgot password page")
    @Description("Authorization from the restore password page via the \"Login\" button in the restore password page form")
    public void restorePasswordPageLogin() {
        header().clickAccount();
        loginPage().clickrestorePasswordLink();
        forgotPasswordPage().clickLoginLink();
        loginPage().fillLoginForm(credentials);
        Assert.assertEquals(homePage().getOrderButtonText(), Texts.HOME_PAGE_ORDER_BUTTON_TEXT);
    }


}
