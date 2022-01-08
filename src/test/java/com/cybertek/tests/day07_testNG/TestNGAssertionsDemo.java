package com.cybertek.tests.day07_testNG;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestNGAssertionsDemo {

    @BeforeClass
    public void setUpClass() {
        System.out.println("--Before Class--");
    }
    @AfterClass
    public void tearDownClass() {
        System.out.println("--After Class--");
    }

    @Test
    public void test1() {
        System.out.println("First assertion - test1");
        Assert.assertEquals("title", "title");
        System.out.println("Second assertion - test1");
        Assert.assertEquals("urL", "url");
        System.out.println("Third assertion - test1");
        Assert.assertEquals("url", "url");
    }

    @Test
    public void test2() {
        System.out.println("First assertion - test2");
        Assert.assertEquals("asude", "asudde", "Verify test2");
    }
    @Test
    public void test3() {
        System.out.println("First assertion - test3");
        String expectedTitle = "Cyb";
        String actualTitle = "Cybertek";
        Assert.assertTrue(actualTitle.startsWith(expectedTitle), "Verify title starts with Cyb");
    }
    @Test
    public void test4() {
        System.out.println("First assertion - test4");
        String email = "mike@smith.com";
        Assert.assertTrue(email.contains("@"), "Verify temail contains @");
    }
    @Test
    public void test5() {
        System.out.println("First assertion - test5");
        Assert.assertFalse(0>1, "verify 0 is not greater than 1");
    }
    @Test
    public void test6() {
        System.out.println("First assertion - test6");
        Assert.assertNotEquals("one", "on1e");
    }

}
