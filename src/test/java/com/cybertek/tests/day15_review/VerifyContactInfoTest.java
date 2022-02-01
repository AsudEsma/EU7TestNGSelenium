package com.cybertek.tests.day15_review;

import com.cybertek.pages.ContactsPage;
import com.cybertek.pages.DashboardPage;
import com.cybertek.pages.LoginPage;
import com.cybertek.tests.TestBase;
import com.cybertek.utilities.ConfigurationReader;
import org.testng.annotations.Test;

public class VerifyContactInfoTest extends TestBase {

    @Test
    public void contactDetailsTest() {
        LoginPage loginPage = new LoginPage();
        String username = ConfigurationReader.get("salesmanager_username");
        String password = ConfigurationReader.get("salesmanager_password");
        loginPage.login(username, password);

        new DashboardPage().navigateToModule("Customers", "Contacts");

        ContactsPage contactsPage = new ContactsPage();
        contactsPage.waitUntilLoaderScreenDisappear();
        contactsPage.getContactEmail("mbrackstone9@example.com").click();
    }


}
