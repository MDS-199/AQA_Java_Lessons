package org.example;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Pixel3aMobileTest extends AndroidDriver
{
    @Test
    public void checkCalculateSum1and3Test() {
        initialize();
        driver.findElement(By.xpath("//android.widget.TextView[@content-desc=\"Calculator\"]")).click();
        driver.findElement(By.id("com.google.android.calculator:id/digit_1")).click();
        driver.findElement(By.id("com.google.android.calculator:id/op_add")).click();
        driver.findElement(By.id("com.google.android.calculator:id/digit_3")).click();
        driver.findElement(By.id("com.google.android.calculator:id/eq")).click();
        assertEquals("4", driver.findElement(By.id("com.google.android.calculator:id/result_final")).getText());
    }
    @Test
    public void checkCalculateSubtraction3and1Test() {
        initialize();
        driver.findElement(By.id("com.google.android.calculator:id/digit_3")).click();
        driver.findElement(By.id("com.google.android.calculator:id/op_sub")).click();
        driver.findElement(By.id("com.google.android.calculator:id/digit_1")).click();
        driver.findElement(By.id("com.google.android.calculator:id/eq")).click();
        assertEquals("2", driver.findElement(By.id("com.google.android.calculator:id/result_final")).getText());
    }
    @Test
    public void checkCalculateMultiplication6and2Test() {
        initialize();
        driver.findElement(By.id("com.google.android.calculator:id/digit_3")).click();
        driver.findElement(By.id("com.google.android.calculator:id/op_mul")).click();
        driver.findElement(By.id("com.google.android.calculator:id/digit_2")).click();
        driver.findElement(By.id("com.google.android.calculator:id/eq")).click();
        assertEquals("6", driver.findElement(By.id("com.google.android.calculator:id/result_final")).getText());
    }
    @Test
    public void checkCalculateDivide6and2Test() {
        initialize();
        driver.findElement(By.id("com.google.android.calculator:id/digit_6")).click();
        driver.findElement(By.id("com.google.android.calculator:id/op_div")).click();
        driver.findElement(By.id("com.google.android.calculator:id/digit_2")).click();
        driver.findElement(By.id("com.google.android.calculator:id/eq")).click();
        assertEquals("3", driver.findElement(By.id("com.google.android.calculator:id/result_final")).getText());
    }
}