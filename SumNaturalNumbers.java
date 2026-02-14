package com.gla;

public class SumNaturalNumbers {

    public static int recursiveSum(int n) {
        if (n == 1)
            return 1;
        return n + recursiveSum(n - 1);
    }

    public static int formulaSum(int n) {
        return (n * (n + 1)) / 2;
    }

    public static void main(String[] args) {

        int n = 10;

        if (n > 0) {

            int sumRecursive = recursiveSum(n);
            int sumFormula = formulaSum(n);

            System.out.println("Sum using recursion: " + sumRecursive);
            System.out.println("Sum using formula: " + sumFormula);

            if (sumRecursive == sumFormula)
                System.out.println("Both computations are correct and equal.");
            else
                System.out.println("Results are not equal.");

        } else {
            System.out.println("Not a Natural Number");
        }
    }
}
