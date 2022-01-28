package com.cybertek.tests.day14_extent_reports;

import com.cybertek.pages.LoginPage;
import com.cybertek.tests.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NegativeLoginTestWithReport extends TestBase {

    @Test
    public void wrongPasswordTest() {
        // Name of the test
        extentLogger = report.createTest("Wrong Password Test");

        LoginPage loginPage = new LoginPage();

        loginPage.usernameInput.sendKeys("user1");
        extentLogger.info("Enter Username: user1");

        loginPage.passwordInput.sendKeys("somepassword");
        extentLogger.info("Enter password: somepassword");

        loginPage.loginBtn.click();
        extentLogger.info("Click on login button");

        extentLogger.info("Verify page URL");
        Assert.assertEquals(driver.getCurrentUrl(), "https://qa1.vytrack.com/user/login");

        extentLogger.pass("Wrong Password Test is PASSED");
    }

    @Test
    public void wrongUsernameTest() {

        LoginPage loginPage = new LoginPage();

        loginPage.usernameInput.sendKeys("someusername");
        extentLogger.info("Enter Username: someusername");

        loginPage.passwordInput.sendKeys("UserUser123");
        extentLogger.info("Enter Password: UserUser123");

        loginPage.loginBtn.click();
        extentLogger.info("Click on login button");

        extentLogger.info("Verify page URL");
        Assert.assertEquals(driver.getCurrentUrl(), "https://qa1.vytrack.com/user/login");
        extentLogger.pass("Wrong Username Test is PASSED");
    }
}
