package com.cybertek.tests.HM;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;
import java.util.ListResourceBundle;

public class CheckBoxHM3 {

    @Test
    public void test1() throws InterruptedException {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx");

        WebElement username = driver.findElement(By.cssSelector("#ctl00_MainContent_username"));
        username.sendKeys("Tester");

        WebElement password = driver.findElement(By.cssSelector("#ctl00_MainContent_password"));
        password.sendKeys("test");

        driver.findElement(By.cssSelector("#ctl00_MainContent_login_button")).click();

        WebElement checkAllBtn = driver.findElement(By.cssSelector("#ctl00_MainContent_btnCheckAll"));
        checkAllBtn.click();

        List<WebElement> list = driver.findElements(By.cssSelector("[type='checkbox']"));
        for (WebElement each : list) {
            Assert.assertTrue(each.isSelected());
        }

        WebElement uncheckAllBtn = driver.findElement(By.cssSelector("#ctl00_MainContent_btnUncheckAll"));
        uncheckAllBtn.click();

        List<WebElement> list2 = driver.findElements(By.cssSelector("[type='checkbox']"));
        for (WebElement each : list2) {
            Assert.assertFalse(each.isSelected());
        }




    }
}
