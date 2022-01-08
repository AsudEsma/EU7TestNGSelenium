package com.cybertek.tests.day07_types_of_elements;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DesplayedDemo {

    @Test
    public void test1() throws InterruptedException {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("http://practice.cybertekschool.com/dynamic_loading/1");

        WebElement userNameInput = driver.findElement(By.cssSelector("#username"));

        System.out.println("userNameInput.isDisplayed() = " + userNameInput.isDisplayed());

        // Verify username inputbox is not displayed on the screen
        // Click start button
        // Verify username displayed on screen

        Assert.assertFalse(userNameInput.isDisplayed(), "Verify inputbox is NOT displayed.");
        WebElement startButton = driver.findElement(By.cssSelector("#start>button"));
        startButton.click();

        Thread.sleep(6000);
        Assert.assertTrue(userNameInput.isDisplayed(), "Verify inputbox is displayed.");

        driver.quit();

    }
}
