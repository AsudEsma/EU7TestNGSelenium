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

public class Task7 {
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
        driver.findElement(By.linkText("File Upload")).click();
        WebElement chooseFile = driver.findElement(By.name("file"));
        String dynamicLocation = System.getProperty("user.dir");
        String fileLocation = "\\src/test/resources/textfile.txt";
        String fullPath = dynamicLocation + fileLocation;

        chooseFile.sendKeys(fullPath);
        driver.findElement(By.id("file-submit")).click();
        String expectedText = "File Uploaded!";
        String actualText = driver.findElement(By.xpath("//h3")).getText();
        Assert.assertEquals(expectedText,actualText, "Verify the subject is \"File Uploaded!\"");

        WebElement fileName = driver.findElement(By.id("uploaded-files"));
        Assert.assertTrue(fileName.isDisplayed());

    }
}
