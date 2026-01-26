import java.util.Scanner;

public class PrimeCheck {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter an integer: ");
        int num = sc.nextInt();

        if (num <= 1) {
            System.out.println("Not a prime number");
        } else {
            boolean prime = true;
            int i = 2;
            while (i * i <= num) {
                if (num % i == 0) {
                    prime = false;
                    break;
                }
                i++;
            }
            if (prime)
                System.out.println("Prime number");
            else
                System.out.println("Not a prime number");
        }

        sc.close();
    }
