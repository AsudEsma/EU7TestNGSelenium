package com.cybertek.tests.HM02;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Tasks_9_10_11_12 {
    WebDriver driver;

    @BeforeMethod
    public void setup() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get("https://practice-cybertekschool.herokuapp.com");
        driver.findElement(By.linkText("Status Codes")).click();
    }

    @AfterMethod
    public void tearDown() {
               driver.quit();
    }

    @Test
    public void statusCode200() {
        driver.findElement(By.linkText("200")).click();
        WebElement confirmMessage = driver.findElement(By.xpath("//*[contains(text(),'200')]"));
        Assert.assertTrue(confirmMessage.isDisplayed());

        driver.navigate().back();

        driver.findElement(By.linkText("301")).click();
        confirmMessage = driver.findElement(By.xpath("//*[contains(text(),'301')]"));
        Assert.assertTrue(confirmMessage.isDisplayed());

        driver.navigate().back();

        driver.findElement(By.linkText("404")).click();
        confirmMessage = driver.findElement(By.xpath("//*[contains(text(),'404')]"));
        Assert.assertTrue(confirmMessage.isDisplayed());

        driver.navigate().back();

        driver.findElement(By.linkText("500")).click();
        confirmMessage = driver.findElement(By.xpath("//*[contains(text(),'500')]"));
        Assert.assertTrue(confirmMessage.isDisplayed());
    }
}
