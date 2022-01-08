package com.cybertek.tests.HM02;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Task6 {
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
    public void test() throws InterruptedException {
        driver.get("https://www.tempmailaddress.com/");
        String email = driver.findElement(By.id("email")).getText();

        driver.get("https://practice-cybertekschool.herokuapp.com");
        driver.findElement(By.linkText("Sign Up For Mailing List")).click();

        driver.findElement(By.xpath("//input")).sendKeys("Mike Smith");
        driver.findElement(By.xpath("(//input)[2]")).sendKeys(email);
        driver.findElement(By.xpath("//button")).click();

        String expectedText = "Thank you for signing up. Click the button below to return to the home page.";
        WebElement actualText = driver.findElement(By.xpath("//h3"));
        Assert.assertEquals(actualText.getText(),expectedText, "Verify that the messages are the same.");

        driver.navigate().back();
        driver.navigate().back();
        driver.navigate().back();

        WebElement emailCheck = driver.findElement(By.xpath("//*[@id=\"schranka\"]//td[1]"));
        Assert.assertTrue(emailCheck.getText().contains("do-not-reply"), "Verify that the email is sent from do-not-reply");

        emailCheck.click();
        WebElement emailSender = driver.findElement(By.id("odesilatel"));
        String expectedEmail = "do-not-reply@practice.cybertekschool.com";
        String actualEmail = emailSender.getText();
        Assert.assertEquals(expectedEmail,actualEmail,"Verify that email sent from do-not-reply@practice.cybertekschool.com");

        WebElement emailSubject = driver.findElement(By.id("predmet"));
        String expectedSubject = "Thanks for subscribing to practice.cybertekschool.com!";
        String actualSubject = emailSubject.getText();
        Assert.assertEquals(expectedSubject,actualSubject,"Verify that email subject is correct");

    }
}
