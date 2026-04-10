package com.gla;

import java.util.Scanner;

public class IntegerConversion {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int primitiveValue = scanner.nextInt();
        Integer objectValue = Integer.valueOf(primitiveValue);

        System.out.println(primitiveValue);
        System.out.println(objectValue);

        scanner.close();
    }
}