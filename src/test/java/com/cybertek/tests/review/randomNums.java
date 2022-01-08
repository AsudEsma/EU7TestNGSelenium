package com.cybertek.tests.review;

import java.util.Random;

public class randomNums {
    public static void main(String[] args) {
        Random nw = new Random();
        System.out.println("nw = " + (nw.nextInt(13)+1));
    }
}
