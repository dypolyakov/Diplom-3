package com.dimqa.tests;

import org.junit.Assert;
import org.junit.Test;

public class IngredientsTabsTest extends TestBase {

    @Test
    public void switchingBetweenTabs() {
        homePage().clickSaucesTab();
        Assert.assertTrue(homePage().getSaucesTabAttributes().contains("tab_tab_type_current"));

        homePage().clickFillingsTab();
        Assert.assertTrue(homePage().getFillingsTabAttributes().contains("tab_tab_type_current"));

        homePage().clickBunsTab();
        Assert.assertTrue(homePage().getBunsTabAttributes().contains("tab_tab_type_current"));
    }
}
