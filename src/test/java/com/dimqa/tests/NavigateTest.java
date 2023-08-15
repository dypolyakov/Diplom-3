package com.dimqa.tests;

import com.dimqa.constants.Texts;
import com.dimqa.constants.Users;
import com.dimqa.model.Credentials;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Test;

public class NavigateTest extends TestBase {
    Credentials credentials = new Credentials(Users.REGISTERED);

    @Test
    @DisplayName("Go to the profile page")
    @Description("Verifying that the user can get to the account page")
    public void goToAccountPage() {
        header().clickAccount();
        loginPage().fillLoginForm(credentials);
        header().clickAccount();
        Assert.assertEquals(accountPage().getInformationText(), Texts.ACCOUNT_PAGE_INFO_TEXT);
    }

    @Test
    @DisplayName("Go to the constructor page")
    @Description("Checking that the user can get to the constructor page. When click on the \"constructor\" button in the header")
    public void goToConstructor() {
        header().clickAccount();
        loginPage().fillLoginForm(credentials);
        header().clickConstructor();
        Assert.assertEquals(homePage().getOrderButtonText(), Texts.HOME_PAGE_ORDER_BUTTON_TEXT);
    }

    @Test
    @DisplayName("Go to the constructor page (home page)")
    @Description("Checking that the user can get to the constructor (home page) page. When click on the logo in the header")
    public void goToMainPage() {
        header().clickAccount();
        loginPage().fillLoginForm(credentials);
        header().clickLogo();
        Assert.assertEquals(homePage().getOrderButtonText(), Texts.HOME_PAGE_ORDER_BUTTON_TEXT);
    }
}
