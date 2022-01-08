package com.cybertek.tests.day09_waits;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class ImplicitWaitExample {
    WebDriver driver;

    @BeforeMethod
    public void setup() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        // When ever you use a FindElement() method this implicitlyWait() method will be triggered.
        // So you can have it in your BeforeMethod all the time.
        // The limit of waiting secs needs to be up to 20-30. This is a DYNAMIC kind of wait.
        // If it is more than 20 there is smt wrong, you can ask them to fix it.
        // But if they dont fix it you can make it 30 secs. 30+ secs are TOTALLY problematic!

        // If it cannot find the element within the given time, it will throw a NSE (NoSuchElement) Exception
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void test1() {
        driver.get("http://practice.cybertekschool.com/dynamic_loading/4");
        WebElement element = driver.findElement(By.id("finish"));
        System.out.println(element.getText());
    }
}
