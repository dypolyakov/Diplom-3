package com.dimqa.tests;

import com.dimqa.constants.Texts;
import com.dimqa.constants.Users;
import com.dimqa.model.Credentials;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Test;

public class LogoutTest extends TestBase {
    Credentials credentials = new Credentials(Users.REGISTERED);
    @Test
    @DisplayName("Logging out of the account")
    @Description("Log out of your account from your account page. Using the logout button")
    public void logout() {
        header().clickAccount();
        loginPage().fillLoginForm(credentials);
        header().clickAccount();
        accountPage().clickExitButton();
        Assert.assertEquals(loginPage().getHeadingText(), Texts.LOGIN_PAGE_HEADING);

    }
}
