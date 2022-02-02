package com.cybertek.tests.day15_review;

import com.cybertek.pages.ContactInfoPage;
import com.cybertek.pages.ContactsPage;
import com.cybertek.pages.DashboardPage;
import com.cybertek.pages.LoginPage;
import com.cybertek.tests.TestBase;
import com.cybertek.utilities.ConfigurationReader;
import org.testng.Assert;
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

        contactsPage.waitUntilLoaderScreenDisappear();
        contactsPage.getContactEmail("mbrackstone9@example.com").click();

        ContactInfoPage contactInfoPage = new ContactInfoPage();
        contactInfoPage.waitUntilLoaderScreenDisappear();

        String expectedFullName = "Mariam Brackstone";
        String actualFullName = contactInfoPage.fullName.getText();

        Assert.assertEquals(actualFullName,expectedFullName,"verify fullname");

        Assert.assertEquals(contactInfoPage.email.getText(),"mbrackstone9@example.com","Verify email");

        Assert.assertEquals(contactInfoPage.phoneNumber.getText(),"+18982323434","verify phone number");
    }
}
