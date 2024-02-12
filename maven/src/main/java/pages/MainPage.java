package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.HashMap;
import java.util.List;
import java.util.TreeMap;

public class MainPage extends BasePage {
    public MainPage(WebDriver driver) {
        super(driver);
    }
    public WebElement productPurchaseButton (String numberOfProduct){
        String xpath = String.format("//div[@class='main-page__content']//article[%s]//a[@class='product-card__add-basket j-add-to-basket btn-main']", numberOfProduct);
        return driver.findElement(By.xpath(xpath));
    }
    public WebElement productSizeButton(){
        return driver.findElement(By.xpath("//ul[@class='sizes-list j-quick-order-sizes']/li"));
    }
    public String productPrice (String numberOfProduct){
        String xpath = String.format("//div[@class='main-page__content']//article[%s]//ins[@class='price__lower-price wallet-price']", numberOfProduct);
        return driver.findElement(By.xpath(xpath)).getText();
    }
    public String productName (String numberOfProduct){
        String xpath = String.format("//div[@class='main-page__content']//article[%s]//span[@class='product-card__name']", numberOfProduct);
        return driver.findElement(By.xpath(xpath)).getText();
    }
    public TreeMap<String, String> collectFirst3ItemsName (MainPage mainPage){
        TreeMap<String, String> namesInMainCollection = new TreeMap<>();
        String productNumberOne = "Наименования продукта 1: ";
        String productNumberTwo = "Наименования продукта 2: ";
        String productNumberThree = "Наименования продукта 3: ";
        String nameOne = mainPage.productName("1");
        nameOne = nameOne.replace("/ ", "");
        String nameTwo = mainPage.productName("2");
        nameTwo = nameTwo.replace("/ ", "");
        String nameThree = mainPage.productName("3");
        nameThree = nameThree.replace("/ ", "");
        namesInMainCollection.put(productNumberOne, nameOne);
        namesInMainCollection.put(productNumberTwo, nameTwo);
        namesInMainCollection.put(productNumberThree, nameThree);
        return namesInMainCollection;
    };
    public TreeMap<String, String> collectFirst3ItemsPrice (MainPage mainPage){
        TreeMap<String, String> pricesInMainCollection = new TreeMap<>();
        String productNumberOne = "Цена продукта 1: ";
        String productNumberTwo = "Цена продукта 2: ";
        String productNumberThree = "Цена продукта 3: ";
        pricesInMainCollection.put(productNumberOne, mainPage.productPrice("1"));;
        pricesInMainCollection.put(productNumberTwo, mainPage.productPrice("2"));
        pricesInMainCollection.put(productNumberThree, mainPage.productPrice("3"));
        return pricesInMainCollection;
    };
    public double sumFirst3Items (){
        
    }

    public void toBasketFirst3Items(MainPage mainPage){
        List<WebElement> menuElements = driver.findElements(By.className("sizes-list"));
        mainPage.productPurchaseButton("1").click();
        if (!menuElements.isEmpty()){
            mainPage.productSizeButton().click();
        }
        mainPage.productPurchaseButton("2").click();
        menuElements = driver.findElements(By.className("sizes-list"));
        if (!menuElements.isEmpty()){
            mainPage.productSizeButton().click();
        }
        mainPage.productPurchaseButton("3").click();
        menuElements = driver.findElements(By.className("sizes-list"));
        if (!menuElements.isEmpty()){
            mainPage.productSizeButton().click();
        }
    }

}
