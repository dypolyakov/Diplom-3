package com.dimqa.tests;

import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Test;

public class IngredientsTabsTest extends TestBase {

    @Test
    @DisplayName("Switching to the sauces tab")
    @Description("Test checks that the selected tab has become active")
    public void checkSaucesTab() {
        homePage().clickSaucesTab();
        Assert.assertTrue(homePage().getSaucesTabAttributes().contains("tab_tab_type_current"));
    }

    @Test
    @DisplayName("Switching to the fillings tab")
    @Description("Test checks that the selected tab has become active")
    public void checkFillingsTab() {
        homePage().clickFillingsTab();
        Assert.assertTrue(homePage().getFillingsTabAttributes().contains("tab_tab_type_current"));
    }

    @Test
    @DisplayName("Switching to the buns tab")
    @Description("Test checks that the selected tab has become active")
    public void checkBunsTab() {
        homePage().clickSaucesTab();
        homePage().clickBunsTab();
        Assert.assertTrue(homePage().getBunsTabAttributes().contains("tab_tab_type_current"));
    }
}
