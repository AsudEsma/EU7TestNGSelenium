package com.cybertek.tests.day08_types_of_elements_2;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class NoSelectDropdown {
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
        driver.get("http://practice.cybertekschool.com/dropdown");
        WebElement dropdownElement = driver.findElement(By.id("dropdownMenuLink"));
        dropdownElement.click();    // click to see the options

        List<WebElement> dropdownOptions = driver.findElements(By.className("dropdown-item"));

        Assert.assertEquals(dropdownOptions.size(), 5, "Verify the size of the options is correct");

        for (WebElement each : dropdownOptions) {
            System.out.println(each.getText());
        }

        dropdownOptions.get(2).click();

    }
}
