package org.example;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class MtsByOnlineReplenishmentTest
{
    private static final WebDriver driver = new ChromeDriver();
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    @BeforeAll
    static void setupDriver() {
        driver.get("https://www.mts.by/");
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//button[text()='Принять']")).click();
    }
    @Test
    @Order(1)
    void checkBlockName(){
        WebElement element = driver.findElement(By.xpath("//div[@class='pay__wrapper']/h2"));
        assertEquals("Онлайн пополнение\nбез комиссии", element.getText());
    }
    @ParameterizedTest
    @Order(2)
    @CsvSource({
            "/local/templates/new_design/assets/html/images/pages/index/pay/visa.svg",
            "/local/templates/new_design/assets/html/images/pages/index/pay/visa-verified.svg",
            "/local/templates/new_design/assets/html/images/pages/index/pay/mastercard.svg",
            "/local/templates/new_design/assets/html/images/pages/index/pay/mastercard-secure.svg",
            "/local/templates/new_design/assets/html/images/pages/index/pay/belkart.svg",
            "/local/templates/new_design/assets/html/images/pages/index/pay/mir.svg"
    })
    void checkLogoPaySystems(String logoPickLink){
        String xpath = String.format("//img[@src='%s']", logoPickLink);
        assertNotNull(driver.findElement(By.xpath(xpath)));
    }

    @Test
    @Order(4)
    void checkButton(){
        driver.findElement(By.xpath("//a[text()='Подробнее о сервисе']")).click();
        assertNotNull(driver.findElement(By.xpath("//div[@id='bxdynamic_cookies-agreement-pt1_start']")));
        driver.findElement(By.xpath("//a[@class='page-header__logo']")).click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }
    @Test
    @Order(3)
    void fillInputReplenishment(){
        driver.findElement(By.xpath("//input[@placeholder='Номер телефона']")).sendKeys("297777777");
        driver.findElement(By.xpath("//input[@id='connection-sum']")).sendKeys("100");
        driver.findElement(By.xpath("//*[@id='pay-connection']/button")).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebElement replenishmentMenu = driver.findElement(By.xpath("//div[@class='bepaid-app']"));
        assertTrue(replenishmentMenu.isDisplayed(), "Всплывающее меню не открыто");
        driver.switchTo().frame(0);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement closeButton = driver.findElement(By.xpath("//div[@class='header__close-button']"));
        closeButton.click();
        driver.switchTo().defaultContent();
    }
    @AfterAll
    static void endSession() {
        driver.quit();
    }
}