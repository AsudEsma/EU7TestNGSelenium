package com.cybertek.tests.HM;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HM01_TestCase02 {
    public static void main(String[] args) {

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://www.ebay.com");

        WebElement searchBox = driver.findElement(By.xpath("//*[@id='gh-ac']"));
        searchBox.click();
        String item = "Selenium";
        searchBox.sendKeys(item);

        WebElement searchButton = driver.findElement(By.xpath("//*[@id='gh-btn']"));
        searchButton.click();

        System.out.println(driver.getTitle().contains("selenium"));

        driver.quit();

    }
}
