package com.cybertek.tests.day16_ddf;

import com.cybertek.utilities.ExcelUtil;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class ExcelUtilDemo {

    @Test
    public void readExcelFile() {

        // Create an object from ExcelUtil
        // It accepts two arguments:
        // Argument1: Location of the file (path)
        // Argument2: Sheet that we want to open (sheetName)

        ExcelUtil qa3short = new ExcelUtil("src/test/resources/Vytracktestdata.xlsx", "QA3-short");
        System.out.println("qa3short.rowCount() = " + qa3short.rowCount());
        System.out.println("qa3short.columnCount() = " + qa3short.columnCount());

        // While sending nums, it accepts the numbers starting from 0
        System.out.println("qa3short.getCellData(11,3) = " + qa3short.getCellData(11, 0));
        System.out.println("qa3short.getCellData(11,2) = " + qa3short.getCellData(11, 1));
        System.out.println("qa3short.getCellData(11,3) = " + qa3short.getCellData(11, 2));
        System.out.println("qa3short.getCellData(11,4) = " + qa3short.getCellData(11, 3));

        System.out.println("qa3short.getColumnsNames() = " + qa3short.getColumnsNames());

        // Get all data in List of Maps
        List<Map<String, String>> dataList = qa3short.getDataList();
        for (Map<String, String> oneRow : dataList) {
            System.out.println("oneRow = " + oneRow);
        }

        // For the map, we need to provide the index as index-2, because the first line is our KEYS
        System.out.println("dataList.get(2) = " + dataList.get(2));
        System.out.println("dataList.get(2).get(\"firstname\") = " + dataList.get(2).get("firstname"));
        System.out.println("dataList.get(8).get(\"lastname\") = " + dataList.get(8).get("lastname"));
        System.out.println("qa3short.getCellData(9,3) = " + qa3short.getCellData(9, 3));

        // Get all data in 2D array
        String[][] dataArray = qa3short.getDataArray();
        System.out.println(Arrays.deepToString(dataArray));


    }
}
