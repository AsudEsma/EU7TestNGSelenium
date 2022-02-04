package com.cybertek.tests.day16_ddf;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DDF_with_DataProvider {
    @DataProvider
    public Object[][] testData() {
        String [][] data = {
                {"Fringe","10"},
                {"2 Broke Girls","10"},
                {"Orphan Black","10"},
                {"sense8","8"},
                {"Sherlock","10"},
                {"F.R.I.E.N.D.S.","7"},
                {"Breaking Bad","5"},
                {"Prison Break","9"},
                {"Vikings","8"},
                {"Victoria","9"},
                {"The Good Place","10"},
                {"Witcher","8"},
                {"Dark","2"},
                {"Emily in Paris","5"}
        };
        return data;
    }

    @Test (dataProvider = "testData")
    public void test1(String tvshow, String rating) {
        System.out.println("TV Show: " + tvshow + " has rating " + rating);
    }
}
