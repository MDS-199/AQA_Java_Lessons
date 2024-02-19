package org.screens;

import org.example.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainScreen {
    public MainScreen(AndroidDriver driver){

    }
    private final static String CALCULATOR_ICON = "//android.widget.TextView[@content-desc=\"Predicted app: Calculator\"]";
    @FindBy(xpath = CALCULATOR_ICON)
    private WebElement calculatorIcon;
    public MainScreen clickCalculatorApp(){
        calculatorIcon.click();
        return this;
    }
}