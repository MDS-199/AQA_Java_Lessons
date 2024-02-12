package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HeaderComponent extends BasePage{
    public HeaderComponent(WebDriver driver) {
        super(driver);
    }
    public WebElement purchaseButton(){
        return driver.findElement(By.xpath("//div[@class='navbar-pc__item j-item-basket']/a"));
    }
/*    public HeaderComponent purchaseClick (){
        driver.findElement(By.xpath("//div[@class='navbar-pc__item j-item-basket']/a")).click();
        return this;
    }*/
    public String checkQuantityAllProducts (){
        return driver.findElement(By.xpath("//span[@class='navbar-pc__notify']")).getText();
    }
    public WebElement toMainButton(){
        return driver.findElement(By.xpath("//a[@class='nav-element__logo j-wba-header-item']"));
    }
}
