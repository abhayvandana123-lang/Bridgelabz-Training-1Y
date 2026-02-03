import java.util.Scanner;

public class FactorFinder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter an integer: ");
        int number = scanner.nextInt();

        if (number == 0) {
            System.out.println("0 has infinitely many factors.");
        } else {
            int n = Math.abs(number);
            int i = 1;
            while (i <= n) {
                if (n % i == 0) {
                    System.out.println(i);
                }
                i++;
            }
        }

        scanner.close();
    }
}
