package com.cybertek.tests.day13_pom;

import com.cybertek.pages.CalendarEventsPage;
import com.cybertek.pages.CreateCalendarEventsPage;
import com.cybertek.pages.DashboardPage;
import com.cybertek.pages.LoginPage;
import com.cybertek.tests.TestBase;
import com.cybertek.utilities.BrowserUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RepeatOptionsTests extends TestBase {

    /** VERIFY RADIO BUTTONS
    Open Chrome browser
    Login as driver
    Go to Activities -> Calendar Events
    Click on create calendar events
    Click on repeat
    Verify that repeat every day is checked
    verify that repeat weekday is not checked
    */

    @Test
    public void test1() {

        LoginPage loginPage = new LoginPage();
        loginPage.loginAsDriver();

        DashboardPage dashboardPage = new DashboardPage();
        dashboardPage.navigateToModule("Activities" , "Calendar Events");

        CalendarEventsPage calendarEventsPage = new CalendarEventsPage();
        /**
         *  Wait for the loader mask !!
         *  And wait for the clickability
         */
        calendarEventsPage.waitUntilLoaderScreenDisappear();
        BrowserUtils.waitForClickability(calendarEventsPage.createCalendarEvent, 20);
        calendarEventsPage.createCalendarEvent.click();

        CreateCalendarEventsPage createCalendarEventsPage = new CreateCalendarEventsPage();
        createCalendarEventsPage.repeat.click();

        Assert.assertTrue(createCalendarEventsPage.days.isSelected(), "Verify repeat is selected for everyday");
        Assert.assertFalse(createCalendarEventsPage.weekday.isSelected(), "Verify weekday is not selected");

    }
}
