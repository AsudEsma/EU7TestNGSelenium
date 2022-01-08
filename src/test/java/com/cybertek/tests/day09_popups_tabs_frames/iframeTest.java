package com.cybertek.tests.day09_popups_tabs_frames;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class iframeTest {

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
        driver.get("http://practice.cybertekschool.com/iframe");

        // switching to iframe w/ ID
        driver.switchTo().frame("mce_0_ifr");
        driver.findElement(By.cssSelector("#tinymce")).clear();
        driver.findElement(By.cssSelector("#tinymce")).sendKeys("Mike Smith with ID");
        Thread.sleep(2000);

        // first way to switch to parent
        driver.switchTo().defaultContent();

        // switching to iframe w/ INDEX
        driver.switchTo().frame(0);
        driver.findElement(By.cssSelector("#tinymce")).clear();
        driver.findElement(By.cssSelector("#tinymce")).sendKeys("Mike Smith with INDEX");
        Thread.sleep(2000);

        // second way to switch to parent
        driver.switchTo().parentFrame();

        // switching to iframe w/ WEBELEMENT
        WebElement iframeElement = driver.findElement(By.tagName("iframe"));
        driver.switchTo().frame(iframeElement);
        driver.findElement(By.cssSelector("#tinymce")).clear();
        driver.findElement(By.cssSelector("#tinymce")).sendKeys("Mike Smith with WEBELEMENT");
        Thread.sleep(2000);
    }

    @Test
    public void test2() {
        driver.get("http://practice.cybertekschool.com/nested_frames");
        /*
        HTML
            frame-top                               Understanting this tree is IMPORTANT
               frame-left                           Because, you cannot jump to grandchildren directly.
               frame-middle                         You need to go parent to child, step by step.
               frame-right
            frame-bottom
        In total we have 6 HTMLs
         */

        driver.switchTo().frame("frame-top");
        driver.switchTo().frame("frame-middle");
        System.out.println(driver.findElement(By.id("content")).getText());

        // first switch to the parent: FRAME-TOP
        driver.switchTo().parentFrame();
        driver.switchTo().frame(2);
        System.out.println(driver.findElement(By.tagName("body")).getText());

        driver.switchTo().defaultContent();
        driver.switchTo().frame(1);
        System.out.println(driver.findElement(By.tagName("body")).getText());
    }

}
