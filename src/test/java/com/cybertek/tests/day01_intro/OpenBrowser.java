package com.cybertek.tests.day01_intro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.opera.OperaDriver;

public class OpenBrowser {

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://cydeo.com");

        WebDriverManager.operadriver().setup();
        WebDriver driver1 = new OperaDriver();
        driver1.get("http://www.teknikadamlar.com.tr");


    }
}
