package com.cybertek.tests.day07_testNG;

import org.testng.annotations.*;

public class BeforeAfterMethod {

    @BeforeClass
    public void setUpClass() {
        System.out.println("--Before Class--");
        System.out.println("Executed ONE time before the class");
    }


    @Test
    public void test1() {
        System.out.println("First Test Case");
    }

    @Test
    public void test2() {
        System.out.println("Second Test Case");
    }

    @BeforeMethod
    public void setUp() {
        System.out.println("WebDriver, Opening Browser");
    }

    @AfterMethod
    public void tearDown() {
        System.out.println("Closing Browser, Quit");
    }

    @AfterClass
    public void tearDownClass() {
        System.out.println("--After Class--");
        System.out.println("Executed ONE time after class");
    }





}
