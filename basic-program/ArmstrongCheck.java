import java.util.Scanner;

public class ArmstrongCheck {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int num = sc.nextInt();

        int original = num;
        int temp = num;
        int digits = 0;

        while (temp != 0) {
            digits++;
            temp /= 10;
        }

        temp = original;
        int sum = 0;

        while (temp != 0) {
            int digit = temp % 10;
            int power = 1;
            int i = 0;
            while (i < digits) {
                power *= digit;
                i++;
            }
            sum += power;
            temp /= 10;
        }

        if (sum == original)
            System.out.println("Armstrong number");
        else
            System.out.println("Not an Armstrong number");

        sc.close();
    }
