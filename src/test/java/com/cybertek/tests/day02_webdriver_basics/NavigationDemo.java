package com.cybertek.tests.day02_webdriver_basics;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class NavigationDemo {

    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com");
        driver.navigate().to("http://www.teknikadamlar.com.tr");
        for(int i=0; i<100; i++) {
            Thread.sleep(1000);
            driver.navigate().back();
            driver.navigate().forward();
            driver.navigate().refresh();
        }

        driver.close();
    }
}
