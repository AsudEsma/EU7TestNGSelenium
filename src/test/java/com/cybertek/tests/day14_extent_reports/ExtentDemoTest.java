package com.cybertek.tests.day14_extent_reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.cybertek.utilities.ConfigurationReader;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ExtentDemoTest {

    // This class is used for starting and building reports
    ExtentReports report;

    // This class is used to create HTML report file
    ExtentHtmlReporter htmlReporter;

    // This will define a test, enables adding logs, authors, and test steps
    ExtentTest extentLogger;

    @BeforeMethod
    public void setup() {
        // Initialize the class
        report = new ExtentReports();

        // Create a report path
        String projectPath = System.getProperty("user.dir");
        String path = projectPath + "/test-output/report.html";

        // Initialize the HTML reporter with the report path
        htmlReporter = new ExtentHtmlReporter(path);

        // Attach the HTML report to report object
        report.attachReporter(htmlReporter);

        // Title in report
        htmlReporter.config().setReportName("Vytrack Smoke Test");

        // Set environment information
        report.setSystemInfo("Environment", "QA");
        report.setSystemInfo("Browser", ConfigurationReader.get("browser"));
        report.setSystemInfo("OS", System.getProperty("os.name"));
    }

    @Test
    public void test1() {
        // Give name to current test
        extentLogger = report.createTest("TC123 Login as Driver");

        // Test steps
        extentLogger.info("Open Chrome Browser");
        extentLogger.info("Go to this URL");
        extentLogger.info("Enter driver username password");
        extentLogger.info("Click login");
        extentLogger.info("Verify logged in");

        // pass() -> marks the test case as passed
        extentLogger.pass("TC123 is passed");
    }

    @AfterMethod
    public void teardown() {
        // This is when the report is actually created
        report.flush();
    }

}
