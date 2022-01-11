package com.cybertek.tests.HM02;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Tasks_1_2_3_4_5 {
    WebDriver driver;

    @BeforeMethod
    public void setup() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get("https://practice-cybertekschool.herokuapp.com");
        driver.findElement(By.linkText("Registration Form")).click();
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @Test (priority = 1)
    public void dateOfBirth() {
        WebElement dateOfBirthBox = driver.findElement(By.xpath("//*[@id=\"registrationForm\"]/div[8]//input"));
        String date = "wrong_dob";
        dateOfBirthBox.sendKeys(date);
        WebElement notValidWarning = driver.findElement(By.xpath("//*[contains(text(),'is not valid')]"));
        Assert.assertTrue(notValidWarning.isDisplayed(), "Verify that the warning for invalid birthday is displayed");
    }

    @Test (priority = 2)
    public void programmingLanguages() {
        List<WebElement> checkBoxes = driver.findElements(By.className("form-check-label"));
        for (int i = 0; i < checkBoxes.size(); i++) {
             Assert.assertTrue(checkBoxes.get(i).isDisplayed(), "Verify that the checkbox " + i + " is displayed");
        }
    }

    @Test (priority = 3)
    public void onlyOneLetterName() {
        WebElement firstNameTextBox = driver.findElement(By.name("firstname"));
        firstNameTextBox.sendKeys("A");
        WebElement firstNameWarning = driver.findElement(By.xpath("//*[contains(text(),'first name must be more than 2')]"));
        Assert.assertFalse(firstNameWarning.isDisplayed(), "Verify that the firstName more than 2 letter warning is displayed");
    }

    @Test (priority = 4)
    public void onlyOneLetterSurname() {
        WebElement lastNameTextBox = driver.findElement(By.name("lastname"));
        lastNameTextBox.sendKeys("o");
        WebElement lastNameWarning = driver.findElement(By.xpath("//*[contains(text(),'last name must be more than 2')]"));
        Assert.assertTrue(lastNameWarning.isDisplayed(), "Verify that the lastName more than 2 letter warning is displayed");
    }

    @Test (priority = 5)
    public void signUpSteps() {
        WebElement firstNameTextBox = driver.findElement(By.name("firstname"));
        firstNameTextBox.sendKeys("Asude");

        WebElement lastNameTextBox = driver.findElement(By.name("lastname"));
        lastNameTextBox.sendKeys("Ozdemir");

        WebElement usernameBox = driver.findElement(By.name("username"));
        usernameBox.sendKeys("MikeSmith");

        WebElement emailAddressBox = driver.findElement(By.name("email"));
        emailAddressBox.sendKeys("mike@smith.com");

        WebElement passwordBox = driver.findElement(By.name("password"));
        passwordBox.sendKeys("12345678");

        WebElement phoneNumberBox = driver.findElement(By.name("phone"));
        phoneNumberBox.sendKeys("571-000-0000");

        List<WebElement> genders = driver.findElements(By.name("gender"));
        genders.get(1).click();

        WebElement dateOfBirthBox = driver.findElement(By.xpath("//*[@id=\"registrationForm\"]/div[8]//input"));
        String date = "07/13/1993";
        dateOfBirthBox.sendKeys(date);

        WebElement dropdownDepartment = driver.findElement(By.xpath("//select[@name='department']"));
        Select departmentDropdown = new Select(dropdownDepartment);
        departmentDropdown.selectByValue("DE");
        Assert.assertEquals(departmentDropdown.getFirstSelectedOption().getText(), "Department of Engineering", "Verify the selected option is Department of Engineering");

        WebElement dropdownJobTitle = driver.findElement(By.xpath("//select[@name='job_title']"));
        Select jobTitleDropdown = new Select(dropdownJobTitle);
        jobTitleDropdown.selectByVisibleText("SDET");
        Assert.assertEquals(jobTitleDropdown.getFirstSelectedOption().getText(), "SDET", "Verify the selected option is SDET");

        List<WebElement> languageCheckBoxes = driver.findElements(By.className("form-check-label"));
        languageCheckBoxes.get(1).click();

        driver.findElement(By.id("wooden_spoon")).click();

        WebElement loggedIn = driver.findElement(By.xpath("//p[contains(text(),'successful')]"));
        Assert.assertTrue(loggedIn.isDisplayed());
    }
}
