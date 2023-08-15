package com.dimqa.tests;

import com.dimqa.constants.Texts;
import com.dimqa.constants.Users;
import com.dimqa.model.Credentials;
import com.dimqa.tests.TestBase;
import org.junit.Assert;
import org.junit.Test;

public class LogoutTest extends TestBase {
    Credentials credentials = new Credentials(Users.REGISTERED);
    @Test
    public void logout() {
        header().clickAccount();
        loginPage().fillLoginForm(credentials);
        header().clickAccount();
        accountPage().clickExitButton();
        Assert.assertEquals(loginPage().getHeadingText(), Texts.LOGIN_PAGE_HEADING);

    }
}
