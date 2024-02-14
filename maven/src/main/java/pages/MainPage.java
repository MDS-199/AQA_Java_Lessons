package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.HashMap;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
    public double sumFirst3Items (MainPage mainPage){
        double sum = 0;
        Pattern pattern = Pattern.compile("\\d*");
        String priceFirstItem =  mainPage.productPrice("1");
        Matcher matcher = pattern.matcher(priceFirstItem);
        if (matcher.find()) {
            double numberString = Double.parseDouble(matcher.group());
            sum += numberString;
        } else {
            System.out.println("Число не найдено.");
            return 0;
        }
        String priceSecondItem =  mainPage.productPrice("2");
        matcher = pattern.matcher(priceSecondItem);
        if (matcher.find()) {
            double numberString = Double.parseDouble(matcher.group());
            sum += numberString;
        } else {
            System.out.println("Число не найдено.");
            return 0;
        }
        String priceThirdItem =  mainPage.productPrice("3");
        matcher = pattern.matcher(priceThirdItem);
        if (matcher.find()) {
            double numberString = Double.parseDouble(matcher.group());
            sum += numberString;
        } else {
            System.out.println("Число не найдено.");
            return 0;
        }
        return sum;
    }

    public void toBasketFirst3Items(MainPage mainPage){
        mainPage.productPurchaseButton("1").click();
        try {
            mainPage.productSizeButton().click();
        }
        catch (org.openqa.selenium.NoSuchElementException e){}

        mainPage.productPurchaseButton("2").click();
        try {
            mainPage.productSizeButton().click();
        }
        catch (org.openqa.selenium.NoSuchElementException e){}
        mainPage.productPurchaseButton("3").click();
        try {
            mainPage.productSizeButton().click();
        }
        catch (org.openqa.selenium.NoSuchElementException e){}
    }

}
