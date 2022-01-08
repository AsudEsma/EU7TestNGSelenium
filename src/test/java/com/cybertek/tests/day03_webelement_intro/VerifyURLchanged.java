package com.cybertek.tests.day03_webelement_intro;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class VerifyURLchanged {
    public static void main(String[] args) {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/forgot_password");

        WebElement emailInputBox = driver.findElement(By.name("email"));
        emailInputBox.sendKeys("asesozdemir@gmail.com");

        WebElement retrieveClickButton = driver.findElement(By.id("form_submit"));
        retrieveClickButton.click();

        String expectedURL = "http://practice.cybertekschool.com/email_sent";
        String actualURL = driver.getCurrentUrl();

        if(expectedURL.equals(actualURL)) {
            System.out.println("PASSED :)");
        } else {
            System.out.println("FAILED!");
            System.out.println("expectedURL = " + expectedURL);
            System.out.println("actualURL = " + actualURL);
        }
        driver.quit();
    }
}
