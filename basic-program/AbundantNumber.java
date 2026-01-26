import java.util.Scanner;

public class AbundantNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int num = sc.nextInt();

        if (num < 1) {
            System.out.println("Enter a positive number.");
        } else {
            int sum = 0;
            int i = 1;
            while (i < num) {
                if (num % i == 0) {
                    sum += i;
                }
                i++;
            }
            if (sum > num)
                System.out.println("Abundant Number");
            else
                System.out.println("Not an Abundant Number");
        }

        sc.close();
    }
}
