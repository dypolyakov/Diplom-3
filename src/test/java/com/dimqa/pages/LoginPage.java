package com.dimqa.pages;

import com.dimqa.constants.URLs;
import com.dimqa.model.Credentials;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {
    private final WebDriver driver;
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }
    private final By heading = By.xpath("//div[contains(@class, 'Auth_login')]/h2");
    private final By emailField = By.xpath("//input[@name='name']");
    private final By passwordField = By.xpath("//input[@name='Пароль']");
    private final By loginButton = By.xpath("//button[.='Войти']");
    private final By registerLink = By.linkText("Зарегистрироваться");
    private final By restorePasswordLink = By.linkText("Восстановить пароль");




    public void waitingForLoading() {
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.urlToBe(URLs.LOGIN_PAGE));
    }

    public String getHeadingText() {
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOfElementLocated(heading));
        return driver.findElement(heading).getText();
    }

    public void typeEmail(String email) {
        driver.findElement(emailField).sendKeys(email);
    }

    public void typePassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }

    public void clickLoginButton() {
        driver.findElement(loginButton).click();
    }

    public void clickRegistration() {
        driver.findElement(registerLink).click();
    }

    public void clickrestorePasswordLink() {
        driver.findElement(restorePasswordLink).click();
    }

    public void fillLoginForm(Credentials credentials) {
        typeEmail(credentials.getEmail());
        typePassword(credentials.getPassword());
        clickLoginButton();
    }
}
