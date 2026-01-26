import java.util.Scanner;

public class GreatestFactorWhile {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter an integer: ");
        int num = sc.nextInt();

        int n = Math.abs(num);

        if (n <= 1) {
            System.out.println("No factor other than itself.");
        } else {
            int factor = n / 2;
            while (factor >= 1) {
                if (n % factor == 0) {
                    System.out.println(factor);
                    break;
                }
                factor--;
            }
        }

        sc.close();
    }
