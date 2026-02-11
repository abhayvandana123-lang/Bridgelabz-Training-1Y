import java.util.Scanner;

public class BasicCalculator {

    public static double getNumber() {
        Scanner sc = new Scanner(System.in);
        return sc.nextDouble();
    }

    public static int getChoice() {
        Scanner sc = new Scanner(System.in);
        return sc.nextInt();
    }

    public static double add(double a, double b) {
        return a + b;
    }

    public static double subtract(double a, double b) {
        return a - b;
    }

    public static double multiply(double a, double b) {
        return a * b;
    }

    public static double divide(double a, double b) {
        return a / b;
    }

    public static void display(double result) {
        System.out.println(result);
    }

    public static void main(String[] args) {
        int choice = getChoice();
        double n1 = getNumber();
        double n2 = getNumber();
        double result = 0;

        if (choice == 1)
            result = add(n1, n2);
        else if (choice == 2)
            result = subtract(n1, n2);
        else if (choice == 3)
            result = multiply(n1, n2);
        else if (choice == 4)
            result = divide(n1, n2);

        display(result);
    }
}
