package com.cybertek.tests.review.week5;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class ScrollingTest {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get("http://practice.cybertekschool.com");
    }

    @AfterMethod
    public void tearDwon() {
        driver.quit();
    }

    @Test
    public void moveToElement() {
        Actions actions = new Actions(driver);
        WebElement cybertekSchoolLink = driver.findElement(By.linkText("Cybertek School"));
        actions.moveToElement(cybertekSchoolLink).click();
    }

    @Test
    public void pageUp_pageDown() { // Advance Keyboard actions
        Actions actions = new Actions(driver);
        WebElement cybertekSchoolLink = driver.findElement(By.linkText("Cybertek School"));
        actions.sendKeys(Keys.PAGE_DOWN,Keys.PAGE_DOWN,Keys.PAGE_DOWN).perform();

    }

    @Test
    public void scrollTestWithJSE() throws InterruptedException {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        // first way with JSE
        Thread.sleep(2000);
        jse.executeScript("window.scroll(0,document.body.scrollHeight)");
        Thread.sleep(1000);
        jse.executeScript("window.scroll(0,- document.body.scrollHeight)");
        Thread.sleep(1000);

        // Second way with JSE
        WebElement cybertekschoolLink = driver.findElement(By.linkText("Cybertek School"));
        jse.executeScript("arguments[0].scrollIntoView(true)",cybertekschoolLink);
        Thread.sleep(1000);

    }
}
