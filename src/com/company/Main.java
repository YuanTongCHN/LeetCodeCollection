package com.company;

public class Main {

    public static void main(String[] args) {
        // write your code here

        String str = "1.0.01";
        String[] strs = str.split("\\.");
        for (String s : strs) {
            System.out.println(s);
        }
        //System.out.println(Integer.MAX_VALUE);
    }
}
