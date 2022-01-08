package com.cybertek.tests.HM;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HM02_XpathPractice {
    public static void main(String[] args) {

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/forgot_password");

        WebElement homePageButton = driver.findElement(By.xpath("//a[contains(text(),'ome')]"));
        WebElement forgotPasswordHeader = driver.findElement(By.xpath("//h2[contains(text(),'Forgot')]"));
        WebElement emailText = driver.findElement(By.xpath("//label[contains(text(),'mail')]"));
        WebElement emailInputBox = driver.findElement(By.xpath("//input[@name='email']"));
        WebElement retrievePassword = driver.findElement(By.xpath("//i[@class]"));
        WebElement poweredBy = driver.findElement(By.xpath("//a[@target='_blank']"));

        System.out.print("The 6 elements are ");
        System.out.print(homePageButton.getText() + ", ");
        System.out.print(forgotPasswordHeader.getText() + ", ");
        System.out.print(emailText.getText() + ", ");
        System.out.print("Email Input Box, ");
        System.out.print(retrievePassword.getText() + ", ");
        System.out.print(homePageButton.getText() + ", ");
        System.out.print(poweredBy.getText());

        driver.quit();
    }
}
