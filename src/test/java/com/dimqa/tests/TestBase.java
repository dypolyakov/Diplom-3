package com.dimqa.tests;

import com.dimqa.constants.URLs;
import com.dimqa.model.User;
import com.dimqa.pages.*;
import io.restassured.http.ContentType;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.Browser;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static io.restassured.RestAssured.given;
import static java.net.HttpURLConnection.HTTP_ACCEPTED;
import static org.hamcrest.Matchers.equalTo;

public class TestBase {

    private String browser = System.getProperty("browser", Browser.CHROME.browserName());
    private WebDriver driver;
    private Header header;
    private LoginPage loginPage;
    private AccountPage accountPage;
    private RegistrationPage registrationPage;
    private HomePage homePage;
    private ForgotPasswordPage forgotPasswordPage;

    @Before
    public void setUp() {
        if (browser.equals(Browser.FIREFOX.browserName())) {
            driver = new FirefoxDriver();
        } else if (browser.equals(Browser.CHROME.browserName())) {
            driver = new ChromeDriver();
        } else if (browser.equals(("yandex"))) {
            System.setProperty("driver.chrome.driver", "src/test/resources/yandexdriver");
            ChromeOptions options = new ChromeOptions();
            options.setBinary("/Applications/Yandex.app/Contents/MacOS/Yandex");
            driver = new ChromeDriver(options);
        }

        driver.get(URLs.MAIN_PAGE);
        header = new Header(driver);
        loginPage = new LoginPage(driver);
        accountPage = new AccountPage(driver);
        registrationPage = new RegistrationPage(driver);
        homePage = new HomePage(driver);
        forgotPasswordPage = new ForgotPasswordPage(driver);

    }

    @After
    public void tearDown() {
        driver.quit();
    }

    public void deleteUser(User user) {
        given()
                .header("Authorization", getAccessToken(user))
                .delete("https://stellarburgers.nomoreparties.site/api/auth/user")
                .then()
                .statusCode(HTTP_ACCEPTED)
                .and()
                .body("success", equalTo(true))
                .body("message", equalTo("User successfully removed"));
    }

    private String getAccessToken(User user) {
        return given()
                .contentType(ContentType.JSON)
                .body(String.format("{\"email\": \"%s\",\"password\": \"%s\"}", user.getEmail(), user.getPassword()))
                .post("https://stellarburgers.nomoreparties.site/api/auth/login")
                .then()
                .extract()
                .path("accessToken");
    }

    public Header header() {
        return header;
    }

    public LoginPage loginPage() {
        return loginPage;
    }

    public AccountPage accountPage() {
        return accountPage;
    }

    public RegistrationPage registrationPage() {
        return registrationPage;
    }

    public HomePage homePage() {
        return homePage;
    }

    public ForgotPasswordPage forgotPasswordPage() {
        return forgotPasswordPage;
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }
}
