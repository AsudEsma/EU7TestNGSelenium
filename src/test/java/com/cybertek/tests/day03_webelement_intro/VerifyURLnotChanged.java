package com.cybertek.tests.day03_webelement_intro;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class VerifyURLnotChanged {

    public static void main(String[] args) {

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/forgot_password");

        String expectedUrl = driver.getCurrentUrl();

        WebElement retrivePasswordBotton = driver.findElement(By.id("form_submit"));
        retrivePasswordBotton.click();

        String actualUrl = driver.getCurrentUrl();

        if(actualUrl.equals(expectedUrl)) {
            System.out.println("PASSED :)");
            driver.quit();
        } else {
            System.out.println("FAILED!");
        }

    }
}
