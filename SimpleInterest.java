package com.gla;

public class SimpleInterest {

    public static double calculateSI(double principal, double rate, double time) {
        return (principal * rate * time) / 100;
    }

    public static void main(String[] args) {

        double principal = 10000;
        double rate = 5;
        double time = 2;

        double simpleInterest = calculateSI(principal, rate, time);

        System.out.println("The Simple Interest is " + simpleInterest
                + " for Principal " + principal
                + ", Rate of Interest " + rate
                + " and Time " + time);
    }
}
