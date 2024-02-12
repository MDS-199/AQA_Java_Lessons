package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BasketPage extends BasePage{
    public BasketPage(WebDriver driver) {
        super(driver);
    }
    public void productPurchaseClick (String numberOfProduct){
        String xpath = String.format("//div[@class='main-page__content']//article[%s]//a[@class='product-card__add-basket j-add-to-basket btn-main']", numberOfProduct);
        driver.findElement(By.xpath(xpath)).click();
    }
    public String productPrice (String numberOfProduct){
        String xpath = String.format("//div[@class='accordion__list']//div[@class='accordion__list-item list-item j-b-basket-item'][%s]//div[@class='list-item__price-new']", numberOfProduct);
        return driver.findElement(By.xpath(xpath)).getText();
    }
    public String productName (String numberOfProduct){
        String xpath = String.format("//div[@class='accordion__list']//div[@class='accordion__list-item list-item j-b-basket-item'][%s]//span[@class='good-info__good-name']", numberOfProduct);
        return driver.findElement(By.xpath(xpath)).getText();
    }
    public String productsQuantity(){
        Pattern pattern = Pattern.compile("\\d+");
        String quantityText = driver.findElement(By.xpath("//div[@class='b-top__count line']/span")).getText();
        Matcher matcher = pattern.matcher(quantityText);
        if (matcher.find()) {
            String numberString = matcher.group();
            return numberString;
        } else {
            System.out.println("Число не найдено.");
            return null;
        }
    }
    public String purchaseSum (){
        return driver.findElement(By.xpath("//p[@class='b-top__total line']/span/span")).getText();
    }

    public TreeMap<String, String> collectFirst3ItemsNameInBasket (BasketPage basketPage){
        TreeMap<String, String> namesInBasketCollection = new TreeMap<>();
        String nameInBasketOne = "Наименования продукта 1: ";
        String nameInBasketTwo = "Наименования продукта 2: ";
        String nameInBasketThree = "Наименования продукта 3: ";
        namesInBasketCollection.put(nameInBasketOne, productName("3"));
        namesInBasketCollection.put(nameInBasketTwo, productName("2"));
        namesInBasketCollection.put(nameInBasketThree, productName("1"));
        return namesInBasketCollection;
    };
    public TreeMap<String, String> collectFirst3ItemsPriceInBasket (BasketPage basketPage){
        TreeMap<String, String> pricesInBasketCollection = new TreeMap<>();
        String productNumberOne = "Цена продукта 1: ";
        String productNumberTwo = "Цена продукта 2: ";
        String productNumberThree = "Цена продукта 3: ";
        pricesInBasketCollection.put(productNumberOne, productPrice("3"));
        pricesInBasketCollection.put(productNumberTwo, productPrice("2"));
        pricesInBasketCollection.put(productNumberThree, productPrice("1"));
        return pricesInBasketCollection;
    };
}
