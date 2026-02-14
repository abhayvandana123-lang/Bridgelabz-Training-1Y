package com.gla;

public class AthleteRun {

    public static double calculateRounds(double side1, double side2, double side3) {
        double perimeter = side1 + side2 + side3;
        double rounds = 5000 / perimeter;
        return rounds;
    }

    public static void main(String[] args) {

        double side1 = 100;
        double side2 = 150;
        double side3 = 200;

        double rounds = calculateRounds(side1, side2, side3);

        System.out.println("The athlete needs to complete " + rounds + " rounds to finish 5 km run");
    }
}
