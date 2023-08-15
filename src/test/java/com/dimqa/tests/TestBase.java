package com.dimqa.tests;

import com.dimqa.constants.URLs;
import com.dimqa.pages.*;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestBase {

    public WebDriver driver = new ChromeDriver();
    public Header header = new Header(driver);
    public LoginPage loginPage = new LoginPage(driver);
    public AccountPage accountPage = new AccountPage(driver);
    public RegistrationPage registrationPage = new RegistrationPage(driver);
    public HomePage homePage = new HomePage(driver);
    public ForgotPasswordPage forgotPasswordPage = new ForgotPasswordPage(driver);

    @Before
    public void setUp() {
        driver.get(URLs.MAIN_PAGE);
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
