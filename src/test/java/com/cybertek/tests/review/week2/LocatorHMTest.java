package com.cybertek.tests.review.week2;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LocatorHMTest {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://www.ebay.com");

        // For ID: it is always unique but the problem is: it can be dynamic.
        // To find out weither it is dynamic or not USE: #idName

        WebElement searchBox = driver.findElement(By.id("gh-ac"));
        String expectedSearchItem = "Selenium";
        searchBox.sendKeys(expectedSearchItem);

        WebElement searchButton = driver.findElement(By.id("gh-btn"));
        searchButton.click();

        WebElement searchResultElement = driver.findElement(By.xpath("//h1[@class='srp-controls__count-heading']"));
        String searchResultText = searchResultElement.getText().split(" ")[0];

        System.out.println("searchResultText = " + searchResultText);

        Thread.sleep(2000);

        driver.quit();


    }
}
