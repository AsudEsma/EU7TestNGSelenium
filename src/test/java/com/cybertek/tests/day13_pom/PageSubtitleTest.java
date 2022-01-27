package com.cybertek.tests.day13_pom;

import com.cybertek.pages.BasePage;
import com.cybertek.pages.CalendarEventsPage;
import com.cybertek.pages.DashboardPage;
import com.cybertek.pages.LoginPage;
import com.cybertek.tests.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PageSubtitleTest extends TestBase {

    /**
     * Test case
     * Open Chrome browser
     * Login as a Driver
     * Verify that page subtitle is Quick Launchpad
     * Go to Activities -> Calendar Events
     * verify that page subtitle is Calendar Events
     */

    @Test
    public void test1() {
        LoginPage loginPage = new LoginPage();
        loginPage.loginAsDriver();

        String expectedSubtitle = "Quick Launchpad";
        DashboardPage dashboardPage = new DashboardPage();
        String actualSubtitle = dashboardPage.getPageSubTitle();

        Assert.assertEquals(expectedSubtitle, actualSubtitle, "Verify subtitles are a match");

        dashboardPage.navigateToModule("Activities", "Calendar Events");

        CalendarEventsPage calendarEventsPage = new CalendarEventsPage();
        Assert.assertEquals(calendarEventsPage.getPageSubTitle(), "Calendar Events", "Verify subtitle is Calendar Events");

    }
}
