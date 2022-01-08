package com.cybertek.tests.HM;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Random;

public class CheckBoxHM_2 {

    @Test
    public void test1() throws InterruptedException {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx");

        WebElement username = driver.findElement(By.cssSelector("#ctl00_MainContent_username"));
        username.sendKeys("Tester");

        WebElement password = driver.findElement(By.cssSelector("#ctl00_MainContent_password"));
        password.sendKeys("test");

        driver.findElement(By.cssSelector("#ctl00_MainContent_login_button")).click();

        WebElement checkAllBtn = driver.findElement(By.cssSelector("#ctl00_MainContent_btnCheckAll"));
        checkAllBtn.click();

        List<WebElement> list = driver.findElements(By.cssSelector("[type='checkbox']"));
        for(int i=0; i<list.size(); i++) {
            Assert.assertTrue(list.get(i).isSelected(), "verify " + (i+1) + " is checked");
        }

        WebElement uncheckAllBtn = driver.findElement(By.cssSelector("#ctl00_MainContent_btnUncheckAll"));
        uncheckAllBtn.click();

        List<WebElement> list2 = driver.findElements(By.cssSelector("[type='checkbox']"));
        for(int i=0; i<list2.size(); i++) {
            Assert.assertFalse(list2.get(i).isSelected(), "verify " + (i+1) + " is NOT checked");
        }

        Random rand = new Random();
        int randomNum = rand.nextInt(list.size()) + 1; //  0 1 2 3 4 5 6 7  -->  1 2 3 4 5 6 7 8
        String checkBoxXPath =  "(//input[@type = 'checkbox'])[" + randomNum + "]";

        WebElement checkBox = driver.findElement(By.xpath(checkBoxXPath));
        checkBox.click();

        // The names or other info might be duplicate,
        // so we locate card number as a unique verification point for a customer
        String cardNumXPath = "//tr[" + (randomNum+1) + "]//td[11]";

        WebElement cardNumber = driver.findElement(By.xpath(cardNumXPath));
        String expectedOutcome = cardNumber.getText(); // "123456789012"

        WebElement deleteBtn = driver.findElement(By.cssSelector("[type = 'submit']"));
        deleteBtn.click();

        WebElement table = driver.findElement(By.cssSelector(".SampleTable"));
        String tableText = table.getText();

//        System.out.println(tableText);

        Assert.assertFalse(tableText.contains(expectedOutcome), "verify the card is deleted and not found.");

    }

}
