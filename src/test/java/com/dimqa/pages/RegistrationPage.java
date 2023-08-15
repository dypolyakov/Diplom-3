package com.dimqa.pages;

import com.dimqa.model.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegistrationPage {
    private final WebDriver driver;

    private final By nameField = By.xpath("//label[.='Имя']/../input");
    private final By emailField = By.xpath("//label[.='Email']/../input");
    private final By passwordField = By.name("Пароль");
    private final By registrationButton = By.xpath("//form/button");
    private final By passwordDiv = By.cssSelector(".input_type_password");
    private final By passwordError = By.xpath("//p[@class='input__error text_type_main-default']");
    private final By loginLink = By.xpath("//a[.='Войти']");

    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
    }

    public void fillName(String name) {
        driver.findElement(nameField).sendKeys(name);
    }
    public void fillEmail(String email) {
        driver.findElement(emailField).sendKeys(email);
    }
    public void fillPassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }

    public void fillForm(User user) {
        fillName(user.getName());
        fillEmail(user.getEmail());
        fillPassword(user.getPassword());
    }

    public void clickRegistrationButton() {
        driver.findElement(registrationButton).click();
    }

    public String getPasswordAttribute() {
        return driver.findElement(passwordDiv).getAttribute("class");
    }

    public String getPasswordErrorMessage() {
        return driver.findElement(passwordError).getText();
    }

    public void clickLoginLink() {
        driver.findElement(loginLink).click();
    }


}
