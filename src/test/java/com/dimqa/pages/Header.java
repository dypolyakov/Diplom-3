package com.dimqa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Header {
    private final WebDriver driver;
    private final By account = By.linkText("Личный Кабинет");
    private final By constructor = By.linkText("Конструктор");
    private final By logo = By.xpath("//div[contains(@class, 'AppHeader_header__logo')]");

    public Header(WebDriver driver) {
        this.driver = driver;
    }

    public void clickAccount() {
        driver.findElement(account).click();
    }

    public void clickConstructor() {
        driver.findElement(constructor).click();
    }

    public void clickLogo() {
        driver.findElement(logo).click();
    }
}
