package com.cybertek.tests.day03_webelement_intro;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class VerifyConfirmationMessage {
    public static void main(String[] args) {

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/forgot_password");

        String expectedEmail = "asesozdemir@gmail.com";
        WebElement emailInputBox = driver.findElement(By.name("email"));
        emailInputBox.sendKeys(expectedEmail);

        String actualEmail = emailInputBox.getAttribute("value");

        if(expectedEmail.equals(actualEmail)) {
            System.out.println("PASSED :)");
        } else {
            System.out.println("FAILED!");
        }

        WebElement retrievePasswordButton = driver.findElement(By.id("form_submit"));
        retrievePasswordButton.click();

        WebElement actualConfirmationMessage = driver.findElement(By.name("confirmation_message"));
        String actualMessage = actualConfirmationMessage.getText();
        String expectedMessage = "Your e-mail's been sent!";

        if(expectedMessage.equals(actualMessage)) {
            System.out.println("PASSED :)");
        } else {
            System.out.println("FAILED!");
            System.out.println("expectedMessage = " + expectedMessage);
            System.out.println("actualMessage = " + actualMessage);
        }

        driver.quit();
    }
}
