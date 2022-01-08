package com.cybertek.tests.day09_popups_tabs_frames;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Set;

public class MultipleWindows {
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
    public void SwitchWindowsTest() {
        driver.get("http://practice.cybertekschool.com/windows");
        System.out.println("Title before new window: " + driver.getTitle());

        driver.findElement(By.linkText("Click Here")).click();
        System.out.println("Title after new window: " + driver.getTitle());

        System.out.println("driver.getWindowHandle() = " + driver.getWindowHandle());
        String currentWindowHandle = driver.getWindowHandle();
        Set<String> windowHandles = driver.getWindowHandles();

        for (String handle : windowHandles) {
            if(!handle.equals(currentWindowHandle)) {
                driver.switchTo().window(handle);
            }
        }

        System.out.println("Title after new window: " + driver.getTitle());
    }

    @Test
    public void MoreThanTwoWindows() {
        driver.get("http://practice.cybertekschool.com/windows");
        driver.findElement(By.linkText("Click Here")).click();
        System.out.println("Title before switch: " + driver.getTitle());

        String expectedTitle = "New Window";

        Set<String> windowHandles = driver.getWindowHandles();
        for (String handle : windowHandles) {
            driver.switchTo().window(handle);
            if(driver.getTitle().equals(expectedTitle)) {
                break;
            }
        }

        System.out.println("Title after new window: " + driver.getTitle());
    }
}
