package com.cybertek.tests.day16_ddf;

import com.cybertek.pages.DashboardPage;
import com.cybertek.pages.LoginPage;
import com.cybertek.tests.TestBase;
import com.cybertek.utilities.ExcelUtil;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DDF_LoginTest extends TestBase {

    // The environment was qa3
    // But apparently it down for some reason and that is why these cases don't pass the test !!
    // So we change the environment and the excel sheet

    /**
     * You may use (url=https://qa2.vytrack.com/) for the configuration.properties
     * than change the code
     * ExcelUtil qa3short = new ExcelUtil("src/test/resources/Vytracktestdata.xlsx","QA3-short"); as QA-2-short
     * for the excel sheet: delete the "result" column.
     * Save it, and copy paste it to resources package again.
     * It should work.
     * There will be only one test case that fails.
     * You may change it in the excel (line 8) or you may keep it to see whether screenshots working or not.
     */

    @DataProvider
    public Object [][] userData(){

        ExcelUtil qa3short = new ExcelUtil("src/test/resources/Vytracktestdata.xlsx","QA2-short");

        String [][] dataArray =qa3short.getDataArrayWithoutFirstRow();

        return dataArray;
    }

    @Test(dataProvider = "userData")
    public void test1(String username,String password,String firstName,String lastName){
        extentLogger=report.createTest("Test "+firstName+" "+lastName);
        LoginPage loginPage = new LoginPage();

        loginPage.login(username,password);

        DashboardPage dashboardPage = new DashboardPage();
        dashboardPage.waitUntilLoaderScreenDisappear();

        String actualFullName = dashboardPage.getUserName();
        String expectedFullName = firstName+" "+lastName;

        Assert.assertEquals(actualFullName,expectedFullName,"verify fullname");
        extentLogger.pass("PASSED");
    }
}
