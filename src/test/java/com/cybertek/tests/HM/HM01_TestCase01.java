package com.cybertek.tests.HM;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HM01_TestCase01 {
    public static void main(String[] args) {

        WebDriver driver = WebDriverFactory.getDriver("Chrome");
        driver.get("https://www.ebay.com");

        // Wooden Spoon
        WebElement searchBox = driver.findElement(By.xpath("//*[@id='gh-ac']"));
        searchBox.click();
        String item = "wooden spoon";
        searchBox.sendKeys(item);

        WebElement searchButton = driver.findElement(By.xpath("//*[@id='gh-btn']"));
        searchButton.click();

        WebElement resultsFound = driver.findElement(By.xpath("//*h1[@class='srp-controls__count-heading'"));

        System.out.println(resultsFound.getText() + " results for " + item);

        // Selenium
        driver.get("https://www.ebay.com");

        searchBox = driver.findElement(By.xpath("//*[@id='gh-ac']"));
        searchBox.click();
        item = "Selenium";
        searchBox.sendKeys(item);
        searchButton = driver.findElement(By.xpath("//*[@id='gh-btn']"));
        searchButton.click();
        resultsFound = driver.findElement(By.xpath("//*[@id='mainContent']//h1/span[1]"));
        System.out.println(resultsFound.getText() + " results for " + item);

        // Computer
        driver.get("https://www.ebay.com");

        searchBox = driver.findElement(By.xpath("//*[@id='gh-ac']"));
        searchBox.click();
        item = "Computer";
        searchBox.sendKeys(item);
        searchButton = driver.findElement(By.xpath("//*[@id='gh-btn']"));
        searchButton.click();
        resultsFound = driver.findElement(By.xpath("//*[@id='mainContent']//h1/span[1]"));
        System.out.println(resultsFound.getText() + " results for " + item);
    }
}
