package com.cybertek.tests.day13_pom;

import com.cybertek.pages.BasePage;
import com.cybertek.pages.LoginPage;
import org.testng.annotations.Test;

public class PageSubtitleTest extends BasePage {

    @Test
    public void test1() {
        LoginPage loginPage = new LoginPage();
        loginPage.loginAsDriver();

    }
}
