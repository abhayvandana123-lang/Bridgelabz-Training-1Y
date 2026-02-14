package com.gla;

public class Handshakes {

    public static int calculateHandshakes(int numberOfStudents) {
        return (numberOfStudents * (numberOfStudents - 1)) / 2;
    }

    public static void main(String[] args) {

        int numberOfStudents = 10;

        int handshakes = calculateHandshakes(numberOfStudents);

        System.out.println("The maximum number of handshakes among "
                + numberOfStudents + " students is " + handshakes);
    }
}
