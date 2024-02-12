package org.example.base;

import common.CommonActions;
import org.openqa.selenium.WebDriver;
import pages.BasePage;
import pages.BasketPage;
import pages.HeaderComponent;
import pages.MainPage;

public class BaseTest {
    protected WebDriver driver = CommonActions.createDriver();
    protected BasePage basePage = new BasePage(driver);
    protected MainPage mainPage = new MainPage(driver);
    protected BasketPage basketPage = new BasketPage(driver);
    protected HeaderComponent headerComponent = new HeaderComponent(driver);
}
