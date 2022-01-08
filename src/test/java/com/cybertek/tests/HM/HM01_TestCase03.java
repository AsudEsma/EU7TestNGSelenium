package com.cybertek.tests.HM;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.WebDriver;

public class HM01_TestCase03 {
    public static void main(String[] args) {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://www.wikipedia.org");

/*        Test case 3
        Go to wikipedia.org (Links to an external site.)
        enter search term `selenium webdriver`
        click on search button
        click on search result `Selenium (software)`
        verify url ends with `Selenium_(software)'*/
    }
}
