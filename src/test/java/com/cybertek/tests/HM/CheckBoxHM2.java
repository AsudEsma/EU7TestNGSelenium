package com.cybertek.tests.HM;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;

public class CheckBoxHM2 {

    public WebDriver driver;
    @BeforeClass
    public void setClass() {
        driver = WebDriverFactory.getDriver("chrome");
    }
    @BeforeMethod
    public void openPage() {
        driver.get("http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx");
        driver.manage().window().maximize();

        WebElement usernameBox = driver.findElement(By.id("ctl00_MainContent_username"));
        usernameBox.sendKeys("Tester");

        WebElement passwordBox = driver.findElement(By.id("ctl00_MainContent_password"));
        passwordBox.sendKeys("test");

        driver.findElement(By.cssSelector("input[type='submit']")).click();
    }
    @AfterClass
    public void closePage() {
        driver.quit();
    }

    @Test (priority = 1)
    public void checkBoxAll() {
        WebElement checkAllBtn = driver.findElement(By.linkText("Check All"));
        checkAllBtn.click();

        for (int i=1; i<=8; i++) {
            String checkBoxLocator = "(//input[@type='checkbox'])[" + i + "]";
            Assert.assertTrue(driver.findElement(By.xpath(checkBoxLocator)).isSelected(), "checkbox " + i + " is NOT selected");
        }

        WebElement uncheckAllBtn = driver.findElement(By.linkText("Uncheck All"));
        uncheckAllBtn.click();

        for (int i=1; i<=8; i++) {
            String checkBoxLocator = "(//input[@type='checkbox'])[" + i + "]";
            Assert.assertFalse(driver.findElement(By.xpath(checkBoxLocator)).isSelected(), "checkbox " + i + " is STILL selected");
        }
    }

    @Test (priority = 2)
    public void deletePersonTest() {
        String name = "Steve Johns";
        WebElement checkBox = driver.findElement(By.xpath("//*[contains(text(),'"+name+"')]/preceding-sibling::*/input")); // sibling method
        // You can also use: By.xpath("//*[contains(text(),'Steve Johns')]/..//td[1]/input")
        checkBox.click();
        WebElement deleteBtn = driver.findElement(By.id("ctl00_MainContent_btnDelete"));
        deleteBtn.click();

        ArrayList<String> names = new ArrayList<>();
        for (int i=1; i<=7; i++) {
            String nameText = driver.findElement(By.xpath("//tr["+(i+1)+"]/td[2]")).getText();
            names.add(nameText);
        }
        Assert.assertFalse(names.contains(name), "the name is STILL there, TRY AGAIN.");
    }

}
