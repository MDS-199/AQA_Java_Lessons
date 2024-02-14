package org.example.wildberrriespurchasetest;

import common.CommonActions;
import org.example.base.BaseTest;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.BasePage;
import pages.HeaderComponent;

import java.util.HashMap;
import java.util.List;
import java.util.TreeMap;

import static org.junit.jupiter.api.Assertions.*;


public class WBPurchaseTest extends BaseTest {
    @AfterEach
    public void toMain() throws InterruptedException {
        headerComponent.toMainButton().click();
    }
    @Test
    @Order(1)
    public void checkFirst3ProductsNames () throws InterruptedException {
        basePage.open("https://www.wildberries.ru/");
        TreeMap<String, String> first3ProductsInMain = mainPage.collectFirst3ItemsName(mainPage);
        mainPage.toBasketFirst3Items(mainPage);
        headerComponent.purchaseButton().click();
        Thread.sleep(Long.parseLong("2000"));
        TreeMap<String, String> first3ProductsInBasket = basketPage.collectFirst3ItemsNameInBasket(basketPage);
        assertEquals(first3ProductsInMain, first3ProductsInBasket);
    }
    @Test
    @Order(2)
    public void checkFirst3ProductsPrices () throws InterruptedException {
        TreeMap<String, String> first3PricesProductsInMain = mainPage.collectFirst3ItemsPrice(mainPage);
        mainPage.toBasketFirst3Items(mainPage);
        headerComponent.purchaseButton().click();
        Thread.sleep(Long.parseLong("2000"));
        TreeMap<String, String> firstPricesProductsInBasket = basketPage.collectFirst3ItemsPriceInBasket(basketPage);
        assertEquals(first3PricesProductsInMain, firstPricesProductsInBasket);
    }
    @Test
    public void checkQuantityProductsInMainAndBasket () throws InterruptedException {
        mainPage.toBasketFirst3Items(mainPage);
        String quantityInMain = headerComponent.checkQuantityAllProducts();
        headerComponent.purchaseButton().click();
        Thread.sleep(Long.parseLong("2000"));
        String quantityInBasket = basketPage.productsQuantity();
        assertEquals(quantityInMain, quantityInBasket);
    }
    @Test
    public void checkSumInMainAndBasket () throws InterruptedException {
        mainPage.toBasketFirst3Items(mainPage);
        double sumInMain = mainPage.sumFirst3Items(mainPage);
        headerComponent.purchaseButton().click();
        Thread.sleep(Long.parseLong("2000"));
        double sumInBasket = basketPage.sumFirst3ItemsInBasket(basketPage);;
        assertEquals(sumInMain, sumInBasket);
    }
    @AfterAll
    public static void endWork(){
        CommonActions.quitDriver();
    }
}
