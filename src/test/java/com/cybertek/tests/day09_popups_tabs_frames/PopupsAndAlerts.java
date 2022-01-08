package com.cybertek.tests.day09_popups_tabs_frames;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PopupsAndAlerts {

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
        driver.get("https://www.primefaces.org/showcase/ui/overlay/confirmDialog.xhtml");

        driver.findElement(By.xpath("//button[.='Confirm']")).click();

        driver.findElement(By.xpath("//button[.='No']")).click();

    }

    @Test
    public void test2() {

        driver.get("http://practice.cybertekschool.com/javascript_alerts");
        driver.findElement(By.xpath("//button[1]")).click();

        Alert alert = driver.switchTo().alert();
        alert.accept();

        driver.findElement(By.xpath("//button[2]")).click();
        alert.dismiss();

        driver.findElement(By.xpath("//button[3]")).click();
        alert.sendKeys("Mike Smith");
        alert.accept();
    }
}
