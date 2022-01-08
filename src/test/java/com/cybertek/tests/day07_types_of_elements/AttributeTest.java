package com.cybertek.tests.day07_types_of_elements;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AttributeTest {

    @Test
    public void test1() {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("http://practice.cybertekschool.com/radio_buttons");

        WebElement blueRadioBtn = driver.findElement(By.id("blue"));
        blueRadioBtn.getAttribute("value");

        // Get the value of type attribute
        System.out.println("blueRadioBtn.getAttribute(\"type\") = " + blueRadioBtn.getAttribute("type"));
        // Get the name of type attribute
        System.out.println("blueRadioBtn.getAttribute(\"name\") = " + blueRadioBtn.getAttribute("name"));
        // Get the checked type attribute -- since checked attribute does not keep any value, it will return true/false
        System.out.println("blueRadioBtn.getAttribute(\"checked\") = " + blueRadioBtn.getAttribute("checked"));
        // Trying to get attribute that does not exist --> it will return "null"
        System.out.println("blueRadioBtn.getAttribute(\"href\") = " + blueRadioBtn.getAttribute("href"));

        System.out.println(blueRadioBtn.getAttribute("outerHTML"));

        driver.get("http://practice.cybertekschool.com/multiple_buttons");
        WebElement button2 = driver.findElement(By.name("button2"));
        System.out.println(button2.getAttribute("outerHTML"));
        String outerHTML = button2.getAttribute("outerHTML");
        Assert.assertTrue(outerHTML.contains("Button 2"));

        System.out.println(button2.getAttribute("innerHTML"));


        driver.quit();
    }
}