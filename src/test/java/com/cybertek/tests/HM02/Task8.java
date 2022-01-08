package com.cybertek.tests.HM02;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Task8 {
    WebDriver driver;

    @BeforeMethod
    public void setup() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void test() {
        driver.get("https://practice-cybertekschool.herokuapp.com");
        driver.findElement(By.linkText("Autocomplete")).click();
        String country = "United States of America";
        driver.findElement(By.id("myCountry")).sendKeys(country);
        driver.findElement(By.xpath("//input[@type='button']")).click();

        String expectedText = "You selected: " + country;
        String actualText = driver.findElement(By.id("result")).getText();

        Assert.assertEquals(expectedText,actualText, "Verify that submission was successful");

    }
}
