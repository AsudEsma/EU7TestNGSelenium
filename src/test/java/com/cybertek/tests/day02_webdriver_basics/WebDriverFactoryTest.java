package com.cybertek.tests.day02_webdriver_basics;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.WebDriver;

public class WebDriverFactoryTest {

    public static void main(String[] args) {

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://google.com");
        String title = driver.getTitle();
        System.out.println("title = " + title);

    }
}
