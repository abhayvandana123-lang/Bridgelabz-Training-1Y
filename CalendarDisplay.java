package com.gla;

public class CalendarDisplay {

    public static String getMonthName(int month) {
        String[] months = { "January", "February", "March", "April", "May", "June",
                            "July", "August", "September", "October", "November", "December" };
        return months[month - 1];
    }

    public static boolean isLeapYear(int year) {
        if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0))
            return true;
        return false;
    }

    public static int getDaysInMonth(int month, int year) {
        int[] days = { 31, 28, 31, 30, 31, 30,
                       31, 31, 30, 31, 30, 31 };

        if (month == 2 && isLeapYear(year))
            return 29;

        return days[month - 1];
    }

    public static int getFirstDay(int month, int year) {
        int m = month;
        int y = year;

        if (m < 3) {
            m += 12;
            y--;
        }

        int k = y % 100;
        int j = y / 100;

        int h = (1 + (13 * (m + 1)) / 5 + k + (k / 4) + (j / 4) + (5 * j)) % 7;

        return (h + 6) % 7;
    }

    public static void main(String[] args) {

        int month = 7;
        int year = 2005;

        System.out.println("   " + getMonthName(month) + " " + year);
        System.out.println("Sun Mon Tue Wed Thu Fri Sat");

        int firstDay = getFirstDay(month, year);
        int days = getDaysInMonth(month, year);

        for (int i = 0; i < firstDay; i++) {
            System.out.print("    ");
        }

        for (int day = 1; day <= days; day++) {
            System.out.printf("%3d ", day);

            if ((day + firstDay) % 7 == 0)
                System.out.println();
        }
    }
}
