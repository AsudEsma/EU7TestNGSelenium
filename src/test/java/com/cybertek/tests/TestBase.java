package com.cybertek.tests;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.cybertek.utilities.BrowserUtils;
import com.cybertek.utilities.ConfigurationReader;
import com.cybertek.utilities.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class TestBase {
    protected WebDriver driver;
    protected Actions actions;
    protected WebDriverWait wait;
    // This class is used for starting and building reports
    protected static ExtentReports report;
    // This class is used to create HTML report file
    protected static ExtentHtmlReporter htmlReporter;
    // This will define a test, enables adding logs, authors, and test steps
    protected static ExtentTest extentLogger;

    // Environment set up
    protected  String url;

    @BeforeTest
    public void setUpTest(){
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

    @BeforeMethod
    @Parameters("env")
    public void setUp(@Optional String env){

        System.out.println("env== " + env);
        if (env==null){
            url =ConfigurationReader.get("url");
        }else{

            url = ConfigurationReader.get(env+"_url");
        }
        driver = Driver.get();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        actions = new Actions(driver);
        wait = new WebDriverWait(driver,10);
        driver.get(url);

    }
    // ITestResult class describes the result of a test in TestNG
    @AfterMethod
    public void tearDown(ITestResult result) throws InterruptedException, IOException {
        // If test fails
        if(result.getStatus()==ITestResult.FAILURE){
            // Record the name of the failed test case
            extentLogger.fail(result.getName());

            // Take the screenshot and return location of screenshot
            String screenShotPath = BrowserUtils.getScreenshot(result.getName());

            // Add your screenshot to your report
            extentLogger.addScreenCaptureFromPath(screenShotPath);

            // Capture the exception and put inside the report
            extentLogger.fail(result.getThrowable());

        }
        Thread.sleep(2000);
        Driver.closeDriver();
    }

    @AfterTest
    public void tearDownTest() {
        // This is when the report is actually created
        report.flush();
    }
}
