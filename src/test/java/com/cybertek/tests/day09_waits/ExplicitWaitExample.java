package com.cybertek.tests.day09_waits;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class ExplicitWaitExample {
    WebDriver driver;

    @BeforeMethod
    public void setup() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void test1() throws InterruptedException {
        driver.get("http://practice.cybertekschool.com/dynamic_loading/1");
        driver.findElement(By.cssSelector(".btn.btn-primary")).click();

        WebElement usernameInput = driver.findElement(By.id("username"));

        // This is special kind of dynamic wait. You need to provide the WebElement you want to wait for.
        // So it does not make sense to put it in the BeforeMethod.
        // Everytime you need to wait for a WebElement to be "clickable", "visible", "enabled", etc
        // You need to put the kind of wait it requires.
        // If it cannot find the element you will get: "TimeoutException"
        // HERE: We used "visibilityOf"
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(usernameInput));
        usernameInput.sendKeys("Mike Smith");
    }

    @Test
    public void test2() throws InterruptedException {
        driver.get("http://practice.cybertekschool.com/dynamic_controls");
        driver.findElement(By.xpath("//*[.='Enable']")).click();
        WebElement inputBox = driver.findElement(By.cssSelector("#input-example>input"));

        // If it cannot find the element you will get: TimeoutException
        // HERE: We used "elementToBeClickable"
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(inputBox));
        inputBox.sendKeys("Mike Smith");
    }
}
