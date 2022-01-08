package com.cybertek.tests.day10_file_upload;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FileUploadTest {
    WebDriver driver;

    @BeforeMethod
    public void setup() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void test1() {
        driver.get("http://practice.cybertekschool.com/upload");

        WebElement chooseFile = driver.findElement(By.name("file"));
        chooseFile.sendKeys("C:\\Users\\asude\\OneDrive\\Masaüstü\\text.txt");
        // click on the file you want to upload while press+holding SHIFT and choose "COPY AS PATH"
        // option. Then come here and copy the path in sendKeys method.

        driver.findElement(By.id("file-submit")).click();

        String actualFileName = driver.findElement(By.id("uploaded-files")).getText();
        String expectedFileName = "text.txt";

        Assert.assertEquals(actualFileName, expectedFileName, "Verify that file names match");
    }

    @Test
    public void test2() {
        driver.get("http://practice.cybertekschool.com/upload");

        WebElement chooseFile = driver.findElement(By.name("file"));
        // My absolute path for the resources textfile.txt is:
        // C:\Users\asude\IdeaProjects\EU7TestNGSelenium\src\test\resources\textfile.txt

        String dynamicLocation = System.getProperty("user.dir");
        // This will give me my projects location dynamicly. Which is:
        // C:\Users\asude\IdeaProjects\EU7TestNGSelenium

        String fileLocation = "\\src/test/resources/textfile.txt";
        // This is the location of the file.

        String fullPath = dynamicLocation + fileLocation;

        chooseFile.sendKeys(fullPath);
        // click on the file you want to upload while press+holding SHIFT and choose "COPY AS PATH"
        // option. Then come here and copy the path in sendKeys method.

        driver.findElement(By.id("file-submit")).click();

        String actualFileName = driver.findElement(By.id("uploaded-files")).getText();
        String expectedFileName = "textfile.txt";

        Assert.assertEquals(actualFileName, expectedFileName, "Verify that file names match");
    }
}
