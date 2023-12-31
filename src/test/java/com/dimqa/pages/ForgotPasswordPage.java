package com.dimqa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ForgotPasswordPage {
    private WebDriver driver;

    public ForgotPasswordPage(WebDriver driver) {
        this.driver = driver;
    }

    private final By loginLink = By.xpath("//a[.='Войти']");

    public void clickLoginLink() {
        driver.findElement(loginLink).click();
    }

}
