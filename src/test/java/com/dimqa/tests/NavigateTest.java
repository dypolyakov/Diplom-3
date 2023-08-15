package com.dimqa.tests;

import com.dimqa.constants.Texts;
import com.dimqa.constants.Users;
import com.dimqa.model.Credentials;
import com.dimqa.tests.TestBase;
import org.junit.Assert;
import org.junit.Test;

public class NavigateTest extends TestBase {
    Credentials credentials = new Credentials(Users.REGISTERED);

    @Test
    public void goToAccountPage() {
        header().clickAccount();
        loginPage().fillLoginForm(credentials);
        header().clickAccount();
        Assert.assertEquals(accountPage().getInformationText(), Texts.ACCOUNT_PAGE_INFO_TEXT);
    }

    @Test
    public void goToConstructor() {
        header().clickAccount();
        loginPage().fillLoginForm(credentials);
        header().clickConstructor();
        Assert.assertEquals(homePage().getOrderButtonText(), Texts.HOME_PAGE_ORDER_BUTTON_TEXT);
    }

    @Test
    public void goToMainPage() {
        header().clickAccount();
        loginPage().fillLoginForm(credentials);
        header().clickLogo();
        Assert.assertEquals(homePage().getOrderButtonText(), Texts.HOME_PAGE_ORDER_BUTTON_TEXT);
    }
}
