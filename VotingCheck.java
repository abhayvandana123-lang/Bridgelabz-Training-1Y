package com.gla.array;
import java.util.Scanner;

class VotingCheck {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int age;

        for (int i = 1; i <= 10; i++) {
            age = sc.nextInt();
            if (age >= 18) {
                System.out.println("Eligible to vote");
            } else {
                System.out.println("Not eligible to vote");
            }
        }
    }
}