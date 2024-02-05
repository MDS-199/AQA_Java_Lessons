package org.example;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

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
}
class MtsByOnlineReplenishmentFillingTest {
    private static WebDriver driver;
    @BeforeAll
    static void setupDriver() {
        driver = WebDriverManager.getDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }
    @BeforeAll
    static void fillInputReplenishment(){
        driver.findElement(By.xpath("//button[@class='select__header']")).click();
        driver.findElement(By.xpath("//p[text()='Услуги связи']")).click();
        driver.findElement(By.xpath("//input[@placeholder='Номер телефона']")).sendKeys("297777777");
        driver.findElement(By.xpath("//input[@id='connection-sum']")).sendKeys("100");
        driver.findElement(By.xpath("//*[@id='pay-connection']/button")).click();
        driver.switchTo().frame(driver.findElement(By.xpath("//div[@class='bepaid-app__container']//iframe")));
    }
    @Test
    void checkUpperSum(){
        WebElement upperSum = driver.findElement(By.xpath("//p[@class='header__payment-amount']"));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(upperSum));
        assertEquals("100.00 BYN" , upperSum.getText());
    }
    @Test
    void checkBottomSum(){
        WebElement bottomSum = driver.findElement(By.xpath("//button[@class='colored disabled ng-star-inserted']"));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(bottomSum));
        assertEquals("Оплатить 100.00 BYN" , bottomSum.getText());
    }
    @Test
    void checkNumber(){
        WebElement number = driver.findElement(By.xpath("//p[@class='header__payment-info']"));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(number));
        assertEquals("Оплата: Услуги связи Номер:375297777777" , number.getText());
    }
    @AfterAll
    static void qoutDriver()
    {
        WebDriverManager.quitDriver();
    }
}