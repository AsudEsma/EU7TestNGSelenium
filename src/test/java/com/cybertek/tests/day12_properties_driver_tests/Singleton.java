package com.cybertek.tests.day12_properties_driver_tests;

public class Singleton {
    // Singleton class will have a private constructor
    // It means other classes cannot create an obj from this class

    private Singleton(){}

    private static String str;

    public static String getInstance() {
        if(str==null) {
            System.out.println("str is null. assigning value it");
            str="somevalue";
        } else {
            System.out.println("it has value, just returning it");
        }

        return str;
    }
}
