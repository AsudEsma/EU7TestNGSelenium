package com.cybertek.tests.HM;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CheckBoxHM {

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

        WebElement checkBox1 = driver.findElement(By.cssSelector("#ctl00_MainContent_orderGrid_ctl02_OrderSelector"));
        WebElement checkBox2 = driver.findElement(By.cssSelector("#ctl00_MainContent_orderGrid_ctl03_OrderSelector"));
        WebElement checkBox3 = driver.findElement(By.cssSelector("#ctl00_MainContent_orderGrid_ctl04_OrderSelector"));
        WebElement checkBox4 = driver.findElement(By.cssSelector("#ctl00_MainContent_orderGrid_ctl05_OrderSelector"));
        WebElement checkBox5 = driver.findElement(By.cssSelector("#ctl00_MainContent_orderGrid_ctl06_OrderSelector"));
        WebElement checkBox6 = driver.findElement(By.cssSelector("#ctl00_MainContent_orderGrid_ctl07_OrderSelector"));
        WebElement checkBox7 = driver.findElement(By.cssSelector("#ctl00_MainContent_orderGrid_ctl08_OrderSelector"));
        WebElement checkBox8 = driver.findElement(By.cssSelector("#ctl00_MainContent_orderGrid_ctl09_OrderSelector"));

        Assert.assertTrue(checkBox1.isSelected(), "checkBox1 is selected.");
        Assert.assertTrue(checkBox2.isSelected(), "checkBox2 is selected.");
        Assert.assertTrue(checkBox3.isSelected(), "checkBox3 is selected.");
        Assert.assertTrue(checkBox4.isSelected(), "checkBox4 is selected.");
        Assert.assertTrue(checkBox5.isSelected(), "checkBox5 is selected.");
        Assert.assertTrue(checkBox6.isSelected(), "checkBox6 is selected.");
        Assert.assertTrue(checkBox7.isSelected(), "checkBox7 is selected.");
        Assert.assertTrue(checkBox8.isSelected(), "checkBox8 is selected.");

        WebElement uncheckAllBtn = driver.findElement(By.cssSelector("#ctl00_MainContent_btnUncheckAll"));
        uncheckAllBtn.click();

        checkBox1 = driver.findElement(By.cssSelector("#ctl00_MainContent_orderGrid_ctl02_OrderSelector"));
        checkBox2 = driver.findElement(By.cssSelector("#ctl00_MainContent_orderGrid_ctl03_OrderSelector"));
        checkBox3 = driver.findElement(By.cssSelector("#ctl00_MainContent_orderGrid_ctl04_OrderSelector"));
        checkBox4 = driver.findElement(By.cssSelector("#ctl00_MainContent_orderGrid_ctl05_OrderSelector"));
        checkBox5 = driver.findElement(By.cssSelector("#ctl00_MainContent_orderGrid_ctl06_OrderSelector"));
        checkBox6 = driver.findElement(By.cssSelector("#ctl00_MainContent_orderGrid_ctl07_OrderSelector"));
        checkBox7 = driver.findElement(By.cssSelector("#ctl00_MainContent_orderGrid_ctl08_OrderSelector"));
        checkBox8 = driver.findElement(By.cssSelector("#ctl00_MainContent_orderGrid_ctl09_OrderSelector"));

        Assert.assertFalse(checkBox1.isSelected(), "checkBox1 is NOT selected.");
        Assert.assertFalse(checkBox2.isSelected(), "checkBox2 is NOT selected.");
        Assert.assertFalse(checkBox3.isSelected(), "checkBox3 is NOT selected.");
        Assert.assertFalse(checkBox4.isSelected(), "checkBox4 is NOT selected.");
        Assert.assertFalse(checkBox5.isSelected(), "checkBox5 is NOT selected.");
        Assert.assertFalse(checkBox6.isSelected(), "checkBox6 is NOT selected.");
        Assert.assertFalse(checkBox7.isSelected(), "checkBox7 is NOT selected.");
        Assert.assertFalse(checkBox8.isSelected(), "checkBox8 is NOT selected.");

        checkBox4.click();
        WebElement deleteBtn = driver.findElement(By.cssSelector("#ctl00_MainContent_btnDelete"));
        deleteBtn.click();

        checkBox4 = driver.findElement(By.cssSelector("#ctl00_MainContent_orderGrid_ctl05_OrderSelector"));
        Assert.assertFalse(checkBox4.isEnabled());

//        driver.quit();



    }
}
