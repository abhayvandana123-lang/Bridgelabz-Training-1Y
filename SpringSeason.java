package com.gla;

public class SpringSeason {

    public static boolean isSpringSeason(int month, int day) {
        if ((month == 3 && day >= 20) ||
            (month == 4) ||
            (month == 5) ||
            (month == 6 && day <= 20)) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {

        int month = 4;
        int day = 15;

        boolean result = isSpringSeason(month, day);

        if (result)
            System.out.println("Its a Spring Season");
        else
            System.out.println("Not a Spring Season");
    }
}
