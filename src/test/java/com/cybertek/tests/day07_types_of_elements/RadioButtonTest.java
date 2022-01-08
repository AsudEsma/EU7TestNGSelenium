package com.cybertek.tests.day07_types_of_elements;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RadioButtonTest {
    @Test
    public void test1() throws InterruptedException {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("http://practice.cybertekschool.com/radio_buttons");

        WebElement blueRadioButton = driver.findElement(By.cssSelector("#blue"));
        WebElement redRadioButton = driver.findElement(By.id("red"));
        WebElement greenRadioButton = driver.findElement(By.id("green"));

        // How to check radio button is selected
        System.out.println(blueRadioButton.isSelected());
        System.out.println(redRadioButton.isSelected());

        redRadioButton.click();

        Assert.assertFalse(blueRadioButton.isSelected(), "Verify blue radio button IS NOT selected");
        Assert.assertTrue(redRadioButton.isSelected(), "Verify red radio button IS selected");
        Assert.assertTrue(!greenRadioButton.isSelected(), "Verify green radio button is NOT selected");

        Thread.sleep(3000);
        driver.quit();
    }
}
