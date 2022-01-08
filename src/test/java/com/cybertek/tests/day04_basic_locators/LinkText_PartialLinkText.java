package com.cybertek.tests.day04_basic_locators;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LinkText_PartialLinkText {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/dynamic_loading");

        WebElement link1 = driver.findElement(By.linkText("Example 1: Element on page that is hidden and become visible after trigger"));
        link1.click();
        driver.navigate().back();

        WebElement link2 = driver.findElement(By.partialLinkText("Example 2"));
        link2.click();
        driver.navigate().back();

        WebElement link4 = driver.findElement(By.partialLinkText("Example 4"));
        link4.click();
        Thread.sleep(3000);

        driver.quit();


    }
}
