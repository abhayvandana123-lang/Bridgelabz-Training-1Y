package com.gla;

public class LeapYear {

    public static boolean isLeapYear(int year) {

        if (year >= 1582) {
            if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0))
                return true;
            else
                return false;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {

        int year = 2024;

        boolean result = isLeapYear(year);

        if (result)
            System.out.println("Year is a Leap Year");
        else
            System.out.println("Year is not a Leap Year");
    }
}
