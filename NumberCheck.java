package com.gla;

public class NumberCheck {

    public static int checkNumber(int number) {
        if (number > 0)
            return 1;
        else if (number < 0)
            return -1;
        else
            return 0;
    }

    public static void main(String[] args) {

        int number = -5;

        int result = checkNumber(number);

        System.out.println("Result: " + result);
    }
}
