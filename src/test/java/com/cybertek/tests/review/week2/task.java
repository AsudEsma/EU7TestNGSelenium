package com.cybertek.tests.review.week2;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class task {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://www.demoblaze.com/index.html#");

        WebElement laptopsButton = driver.findElement(By.partialLinkText("Laptops"));
        laptopsButton.click();

        Thread.sleep(2000);
        WebElement sonyVaioi7 = driver.findElement(By.partialLinkText("i7"));
        sonyVaioi7.click();

        Thread.sleep(2000);
        int expectedPrice = 790;

        WebElement priceOfVaioi7 = driver.findElement(By.tagName("h3"));
        String price = priceOfVaioi7.getText().split(" ")[0].substring(1);
        // Splitting the text with (space) and getting the first element of the array
        // after that getting rid of the $ sign, and parseInt'ing the String

        if(expectedPrice==Integer.parseInt(price)) {
            System.out.println("Expected and actual prices are the same: " + (expectedPrice == Integer.parseInt(price)));
        } else {
            System.out.println("Expected Price = " + expectedPrice);
            System.out.println("Actual Price = " + price);
        }

        driver.quit();

    }
}
