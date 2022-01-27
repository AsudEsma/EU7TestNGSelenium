package com.cybertek.tests.day13_pom;

import com.cybertek.pages.CalendarEventsPage;
import com.cybertek.pages.CreateCalendarEventsPage;
import com.cybertek.pages.DashboardPage;
import com.cybertek.pages.LoginPage;
import com.cybertek.tests.TestBase;
import com.cybertek.utilities.BrowserUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

    /**
     VERIFY REPEAT OPTIONS
     Open Chrome browser
     Login as driver
     Go to Activities->Calendar Events
     Click on create calendar events button
     Click on repeat checkbox
     Verify that repeat options are Daily, Weekly, Monthly,Yearly (in this order)
     */

    @Test
    public void test2() {

        LoginPage loginPage = new LoginPage();
        loginPage.loginAsDriver();

        DashboardPage dashboardPage = new DashboardPage();
        dashboardPage.navigateToModule("Activities", "Calendar Events");

        CalendarEventsPage calendarEventsPage = new CalendarEventsPage();
        /**
         *  Wait for the loader mask !!
         *  And wait for the clickability
         */
        calendarEventsPage.waitUntilLoaderScreenDisappear();
        BrowserUtils.waitForClickability(calendarEventsPage.createCalendarEvent, 20);
        calendarEventsPage.createCalendarEvent.click();

        CreateCalendarEventsPage createCalendarEventsPage = new CreateCalendarEventsPage();
        calendarEventsPage.waitUntilLoaderScreenDisappear();
        createCalendarEventsPage.repeat.click();

        Select repeatsDropdowns = createCalendarEventsPage.repeatOptionsList();
        List<String> expectedList = Arrays.asList("Daily", "Weekly", "Monthly", "Yearly");
        List<WebElement> actualOptions = repeatsDropdowns.getOptions();

        List<String> actualList = new ArrayList<>();
        for (WebElement we : actualOptions) {
            actualList.add(we.getText());
        }
        /**
         * This is exactly the same thing with what we did in the previous lines.
         * You can use ready methods.
         * It will become a habit when you try to find more options on some sort fo a daily basis.
         */
        List<String> actualList2 = BrowserUtils.getElementsText(actualOptions);
        Assert.assertEquals(actualList, expectedList, "Verify that the repeat options are an exact match with the order");
    }
}
