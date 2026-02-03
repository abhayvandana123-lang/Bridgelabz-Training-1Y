package com.gla.array;
import java.util.Scanner;

 class NumberCheck {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[5];

        for (int i = 0; i < 5; i++) {
            arr[i] = sc.nextInt();
        }

        for (int i = 0; i < 5; i++) {
            if (arr[i] > 0) {
                System.out.print("Positive ");
                if (arr[i] % 2 == 0) {
                    System.out.println("Even");
                } else {
                    System.out.println("Odd");
                }
            } else if (arr[i] < 0) {
                System.out.println("Negative");
            } else {
                System.out.println("Zero");
            }
        }

        if (arr[0] == arr[4]) {
            System.out.println("First and last are equal");
        } else if (arr[0] > arr[4]) {
            System.out.println("First is greater than last");
        } else {
            System.out.println("First is less than last");
        }
    }
}
