package org.example;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;



class MtsByOnlineReplenishmentPlaceholderTest {
    private static WebDriver driver;

    @BeforeAll
    static void setupDriver() {
        driver = WebDriverManager.getDriver();
        driver.get("https://www.mts.by/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//button[text()='Принять']")).click();
        WebElement payOnlineBlock = driver.findElement(By.xpath("//div[@class='pay__wrapper']"));
        new Actions(driver)
                .scrollToElement(payOnlineBlock)
                .perform();
    }

    @ParameterizedTest
    @Order(1)
    @CsvSource({
            "Номер телефона, connection-phone",
            "Сумма, connection-sum",
            "E-mail для отправки чека, connection-email"
    })
    void checkPlaceholderConnectionService(String placeholderExpected, String idPlaceholder) {
        String xpathtypePlaceholder = String.format("//form[@class='pay-form opened']/div/input[@id='%s']", idPlaceholder);
        WebElement placeholder = driver.findElement(By.xpath(xpathtypePlaceholder));
        assertEquals(placeholderExpected, placeholder.getAttribute("placeholder"));
    }
}
class MtsByOnlineReplenishmentPlaceholder2Test {
    private static WebDriver driver;

    @BeforeAll
    static void setupDriver() {
        driver = WebDriverManager.getDriver();
        driver.findElement(By.xpath("//button[@class='select__header']")).click();
        driver.findElement(By.xpath("//p[text()='Домашний интернет']")).click();
    }

    @ParameterizedTest
    @Order(1)
    @CsvSource({
            "Номер абонента, internet-phone",
            "Сумма, internet-sum",
            "E-mail для отправки чека, internet-email"
    })
    void checkPlaceholderConnectionService(String placeholderExpected, String idPlaceholder) {
        String xpathtypePlaceholder = String.format("//form[@class='pay-form opened']/div/input[@id='%s']", idPlaceholder);
        WebElement placeholder = driver.findElement(By.xpath(xpathtypePlaceholder));
        assertEquals(placeholderExpected, placeholder.getAttribute("placeholder"));
    }
}
class MtsByOnlineReplenishmentPlaceholder3Test {
    private static WebDriver driver;
    @BeforeAll
    static void setupDriver() {
        driver = WebDriverManager.getDriver();
        driver.findElement(By.xpath("//button[@class='select__header']")).click();
        driver.findElement(By.xpath("//p[text()='Рассрочка']")).click();
    }

    @ParameterizedTest
    @Order(1)
    @CsvSource({
            "Номер счета на 44, score-instalment",
            "Сумма, instalment-sum",
            "E-mail для отправки чека, instalment-email"
    })
    void checkPlaceholderConnectionService(String placeholderExpected, String idPlaceholder) {
        String xpathtypePlaceholder = String.format("//form[@class='pay-form opened']/div/input[@id='%s']", idPlaceholder);
        WebElement placeholder = driver.findElement(By.xpath(xpathtypePlaceholder));
        assertEquals(placeholderExpected, placeholder.getAttribute("placeholder"));
    }
}
class MtsByOnlineReplenishmentPlaceholder4Test {
    private static WebDriver driver;
    @BeforeAll
    static void setupDriver() {
        driver = WebDriverManager.getDriver();
        driver.findElement(By.xpath("//button[@class='select__header']")).click();
        driver.findElement(By.xpath("//p[text()='Задолженность']")).click();
    }

    @ParameterizedTest
    @Order(1)
    @CsvSource({
            "Номер счета на 2073, score-arrears",
            "Сумма, arrears-sum",
            "E-mail для отправки чека, arrears-email"
    })
    void checkPlaceholderConnectionService(String placeholderExpected, String idPlaceholder) {
        String xpathtypePlaceholder = String.format("//form[@class='pay-form opened']/div/input[@id='%s']", idPlaceholder);
        WebElement placeholder = driver.findElement(By.xpath(xpathtypePlaceholder));
        assertEquals(placeholderExpected, placeholder.getAttribute("placeholder"));
    }
    @AfterAll
    static void qoutDriver()
        {
            WebDriverManager.quitDriver();
        }
}