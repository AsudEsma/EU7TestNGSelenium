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

public class SelectDropdownTest {

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
        WebElement dropdownElement = driver.findElement(By.id("state"));

        Select stateDropdown = new Select(dropdownElement);
        List<WebElement> dropList = stateDropdown.getOptions();
        System.out.println("dropList.size() = " + dropList.size());

        for (WebElement each : dropList) {
            System.out.println(each.getText());
        }
    }

    @Test
    public void test2() {
        driver.get("http://practice.cybertekschool.com/dropdown");
        WebElement dropdownElement = driver.findElement(By.id("state"));

        Select stateDropdown = new Select(dropdownElement);
        Assert.assertEquals(stateDropdown.getFirstSelectedOption().getText(), "Select a State", "Verify the first selected option is \"Select a state\"");

        String expectedOption = "Select a State";
        String actualOption = stateDropdown.getFirstSelectedOption().getText();
        Assert.assertEquals(expectedOption, actualOption, "Verify the first selected option is " + expectedOption);

        stateDropdown.selectByVisibleText("Virginia");
        expectedOption = "Virginia";
        actualOption = stateDropdown.getFirstSelectedOption().getText();
        Assert.assertEquals(expectedOption,actualOption, "Verify that " + expectedOption + " is selected");

        stateDropdown.selectByIndex(51);
        expectedOption = "Wyoming";
        actualOption = stateDropdown.getFirstSelectedOption().getText();
        Assert.assertEquals(expectedOption,actualOption, "Verify that " + expectedOption + " is selected");

        stateDropdown.selectByValue("TX");
        expectedOption = "Texas";
        actualOption = stateDropdown.getFirstSelectedOption().getText();
        Assert.assertEquals(expectedOption,actualOption, "Verify that " + expectedOption + " is selected");
    }
}
