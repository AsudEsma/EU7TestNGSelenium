package com.cybertek.tests.HM02;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class allTheTasksInOnePlace {
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

    @Test(priority = 1)
    public void dateOfBirth() {
        driver.get("https://practice-cybertekschool.herokuapp.com");
        driver.findElement(By.linkText("Registration Form")).click();
        WebElement dateOfBirthBox = driver.findElement(By.xpath("//*[@id=\"registrationForm\"]/div[8]//input"));
        String date = "wrong_dob";
        dateOfBirthBox.sendKeys(date);
        WebElement notValidWarning = driver.findElement(By.xpath("//*[contains(text(),'is not valid')]"));
        Assert.assertTrue(notValidWarning.isDisplayed(), "Verify that the warning for invalid birthday is displayed");
    }

    @Test (priority = 2)
    public void programmingLanguages() {
        driver.get("https://practice-cybertekschool.herokuapp.com");
        driver.findElement(By.linkText("Registration Form")).click();
        List<WebElement> checkBoxes = driver.findElements(By.className("form-check-label"));
        for (int i = 0; i < checkBoxes.size(); i++) {
            Assert.assertTrue(checkBoxes.get(i).isDisplayed(), "Verify that the checkbox " + i + " is displayed");
        }
    }

    @Test (priority = 3)
    public void onlyOneLetterName() {
        driver.get("https://practice-cybertekschool.herokuapp.com");
        driver.findElement(By.linkText("Registration Form")).click();
        WebElement firstNameTextBox = driver.findElement(By.name("firstname"));
        firstNameTextBox.sendKeys("A");
        WebElement firstNameWarning = driver.findElement(By.xpath("//*[contains(text(),'first name must be more than 2')]"));
        Assert.assertTrue(firstNameWarning.isDisplayed(), "Verify that the firstName more than 2 letter warning is displayed");
    }

    @Test (priority = 4)
    public void onlyOneLetterSurname() {
        driver.get("https://practice-cybertekschool.herokuapp.com");
        driver.findElement(By.linkText("Registration Form")).click();
        WebElement lastNameTextBox = driver.findElement(By.name("lastname"));
        lastNameTextBox.sendKeys("o");
        WebElement lastNameWarning = driver.findElement(By.xpath("//*[contains(text(),'last name must be more than 2')]"));
        Assert.assertTrue(lastNameWarning.isDisplayed(), "Verify that the lastName more than 2 letter warning is displayed");
    }

    @Test (priority = 5)
    public void signUpSteps() {
        driver.get("https://practice-cybertekschool.herokuapp.com");
        driver.findElement(By.linkText("Registration Form")).click();
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

    @Test (priority = 6)
    public void test6() {
        driver.get("https://www.tempmailaddress.com/");
        String email = driver.findElement(By.id("email")).getText();

        driver.get("https://practice-cybertekschool.herokuapp.com");
        driver.findElement(By.linkText("Sign Up For Mailing List")).click();

        driver.findElement(By.xpath("//input")).sendKeys("Mike Smith");
        driver.findElement(By.xpath("(//input)[2]")).sendKeys(email);
        driver.findElement(By.xpath("//button")).click();

        String expectedText = "Thank you for signing up. Click the button below to return to the home page.";
        WebElement actualText = driver.findElement(By.xpath("//h3"));
        Assert.assertEquals(actualText.getText(),expectedText, "Verify that the messages are the same.");

        driver.navigate().back();
        driver.navigate().back();
        driver.navigate().back();

        WebElement emailCheck = driver.findElement(By.xpath("//*[@id=\"schranka\"]//td[1]"));
        Assert.assertTrue(emailCheck.getText().contains("do-not-reply"), "Verify that the email is sent from do-not-reply");

        emailCheck.click();
        WebElement emailSender = driver.findElement(By.id("odesilatel"));
        String expectedEmail = "do-not-reply@practice.cybertekschool.com";
        String actualEmail = emailSender.getText();
        Assert.assertEquals(expectedEmail,actualEmail,"Verify that email sent from do-not-reply@practice.cybertekschool.com");

        WebElement emailSubject = driver.findElement(By.id("predmet"));
        String expectedSubject = "Thanks for subscribing to practice.cybertekschool.com!";
        String actualSubject = emailSubject.getText();
        Assert.assertEquals(expectedSubject,actualSubject,"Verify that email subject is correct");

    }

    @Test (priority = 7)
    public void test7() {
        driver.get("https://practice-cybertekschool.herokuapp.com");
        driver.findElement(By.linkText("File Upload")).click();
        WebElement chooseFile = driver.findElement(By.name("file"));
        String dynamicLocation = System.getProperty("user.dir");
        String fileLocation = "\\src/test/resources/textfile.txt";
        String fullPath = dynamicLocation + fileLocation;

        chooseFile.sendKeys(fullPath);
        driver.findElement(By.id("file-submit")).click();
        String expectedText = "File Uploaded!";
        String actualText = driver.findElement(By.xpath("//h3")).getText();
        Assert.assertEquals(expectedText,actualText, "Verify the subject is \"File Uploaded!\"");

        WebElement fileName = driver.findElement(By.id("uploaded-files"));
        Assert.assertTrue(fileName.isDisplayed());

    }

    @Test
    public void test8() {
        driver.get("https://practice-cybertekschool.herokuapp.com");
        driver.findElement(By.linkText("Autocomplete")).click();
        String country = "United States of America";
        driver.findElement(By.id("myCountry")).sendKeys(country);
        driver.findElement(By.xpath("//input[@type='button']")).click();

        String expectedText = "You selected: " + country;
        String actualText = driver.findElement(By.id("result")).getText();

        Assert.assertEquals(expectedText,actualText, "Verify that submission was successful");
    }

    @Test
    public void statusCodesBasic() {

        driver.get("https://practice-cybertekschool.herokuapp.com");
        driver.findElement(By.linkText("Status Codes")).click();
        driver.findElement(By.linkText("200")).click();
        WebElement confirmMessage = driver.findElement(By.xpath("//*[contains(text(),'200')]"));
        Assert.assertTrue(confirmMessage.isDisplayed());

        driver.navigate().back();

        driver.findElement(By.linkText("301")).click();
        confirmMessage = driver.findElement(By.xpath("//*[contains(text(),'301')]"));
        Assert.assertTrue(confirmMessage.isDisplayed());

        driver.navigate().back();

        driver.findElement(By.linkText("404")).click();
        confirmMessage = driver.findElement(By.xpath("//*[contains(text(),'404')]"));
        Assert.assertTrue(confirmMessage.isDisplayed());

        driver.navigate().back();

        driver.findElement(By.linkText("500")).click();
        confirmMessage = driver.findElement(By.xpath("//*[contains(text(),'500')]"));
        Assert.assertTrue(confirmMessage.isDisplayed());
    }

    @Test
    public void statusCodesInLoop() {
        driver.get("https://practice-cybertekschool.herokuapp.com/");
        driver.findElement(By.linkText("Status Codes")).click();
        List<WebElement> elements = driver.findElements(By.xpath("//*[@id=\"content\"]/div/ul/li/a"));
        Assert.assertEquals(elements.size(), 4);

        for (int i = 0; i < elements.size(); i++) {
            WebElement each = driver.findElement(By.xpath("(//*[@id=\"content\"]/div/ul/li/a)[" + (i + 1) + "]"));
            String control = each.getText();
            each.click();
            String actual = driver.findElement(By.xpath("//p")).getText();
            Assert.assertTrue(actual.contains(control), "Verify that status code " + (i+1) + " contains the code");
            driver.navigate().back();
        }
    }
}
