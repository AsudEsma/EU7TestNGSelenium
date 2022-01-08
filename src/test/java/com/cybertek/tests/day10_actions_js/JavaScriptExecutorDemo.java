package com.cybertek.tests.day10_actions_js;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class JavaScriptExecutorDemo {
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
    public void test1() {
        driver.get("http://practice.cybertekschool.com");
        WebElement dropdownLink = driver.findElement(By.linkText("Dropdown"));
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].click();", dropdownLink);
    }

    @Test
    public void typeWithJS() {
        driver.get("http://practice.cybertekschool.com/dynamic_controls");
        WebElement inputBox = driver.findElement(By.cssSelector("#input-example>input"));
        JavascriptExecutor jse = (JavascriptExecutor) driver;

        String text = "Hello disabled Input Box ^.^";
        jse.executeScript("arguments[0].setAttribute('value','" + text + "')", inputBox);
    }

    @Test
    public void ScrollDownAndUp() throws InterruptedException {
        driver.get("http://practice.cybertekschool.com/infinite_scroll");
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        for (int i = 0; i < 10; i++) {
            jse.executeScript("window.scrollBy(0,250)");
            Thread.sleep(500);
        }

        for (int i = 0; i < 10; i++) {
            jse.executeScript("window.scrollBy(0,-250)");
            Thread.sleep(500);
        }
    }

    // For the element you directly want to find without giving any numbers of scrolls.
    @Test
    public void ScrollToElement() throws InterruptedException {
        driver.get("http://www.amazon.com/");
        Thread.sleep(2000);
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        WebElement languageDropdown = driver.findElement(By.id("icp-touch-link-language"));
        jse.executeScript("arguments[0].scrollIntoView(true);", languageDropdown);

    }
}
