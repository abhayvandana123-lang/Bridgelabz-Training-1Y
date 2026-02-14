package com.gla;

public class NumberChecker {

    public static int countDigits(int number) {
        int count = 0;
        int temp = number;
        while (temp != 0) {
            count++;
            temp /= 10;
        }
        return count;
    }

    public static int[] storeDigits(int number) {
        int count = countDigits(number);
        int[] digits = new int[count];
        int temp = number;

        for (int i = count - 1; i >= 0; i--) {
            digits[i] = temp % 10;
            temp /= 10;
        }
        return digits;
    }

    public static boolean isDuckNumber(int[] digits) {
        boolean hasNonZero = false;
        for (int i = 0; i < digits.length; i++) {
            if (digits[i] != 0)
                hasNonZero = true;
        }
        return hasNonZero;
    }

    public static boolean isArmstrong(int number, int[] digits) {
        int sum = 0;
        int power = digits.length;

        for (int i = 0; i < digits.length; i++) {
            sum += Math.pow(digits[i], power);
        }

        return sum == number;
    }

    public static int[] findLargestAndSecondLargest(int[] digits) {
        int largest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;

        for (int i = 0; i < digits.length; i++) {
            if (digits[i] > largest) {
                secondLargest = largest;
                largest = digits[i];
            } else if (digits[i] > secondLargest && digits[i] != largest) {
                secondLargest = digits[i];
            }
        }

        return new int[]{largest, secondLargest};
    }

    public static int[] findSmallestAndSecondSmallest(int[] digits) {
        int smallest = Integer.MAX_VALUE;
        int secondSmallest = Integer.MAX_VALUE;

        for (int i = 0; i < digits.length; i++) {
            if (digits[i] < smallest) {
                secondSmallest = smallest;
                smallest = digits[i];
            } else if (digits[i] < secondSmallest && digits[i] != smallest) {
                secondSmallest = digits[i];
            }
        }

        return new int[]{smallest, secondSmallest};
    }

    public static void main(String[] args) {

        int number = 153;

        int digitCount = countDigits(number);
        int[] digits = storeDigits(number);

        System.out.println("Digit Count: " + digitCount);
        System.out.println("Duck Number: " + isDuckNumber(digits));
        System.out.println("Armstrong Number: " + isArmstrong(number, digits));

        int[] large = findLargestAndSecondLargest(digits);
        System.out.println("Largest: " + large[0]);
        System.out.println("Second Largest: " + large[1]);

        int[] small = findSmallestAndSecondSmallest(digits);
        System.out.println("Smallest: " + small[0]);
        System.out.println("Second Smallest: " + small[1]);
    }
}
