package com.cybertek.tests.day07_types_of_elements;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckBoxDemo {

    @Test
    public void test1() {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("http://practice.cybertekschool.com/checkboxes");

        WebElement checkbox1 = driver.findElement(By.xpath("//input[1]"));
        WebElement checkbox2 = driver.findElement(By.xpath("//input[2]"));

        // How to verify checkbox is selected or not
        System.out.println("checkbox1.isSelected() = " + checkbox1.isSelected());
        System.out.println("checkbox2.isSelected() = " + checkbox2.isSelected());

        // Verify checkbox 1 is NOT selected, and checkbox2 is selected
        Assert.assertFalse(checkbox1.isSelected(), "Verify the first one is NOT selected");
        Assert.assertTrue(checkbox2.isSelected(), "Verify the second one is selected");

        checkbox1.click();
        Assert.assertTrue(checkbox1.isSelected(), "Verify the first one is selected");
        Assert.assertTrue(checkbox2.isSelected(), "Verify the second one is selected");

        driver.quit();
    }
}
