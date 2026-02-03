import java.util.Scanner;

public class OddEvenNumbers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        System.out.println("Even numbers:");
        for (int i = 1; i <= n; i++) {
            if (i % 2 == 0) {
                System.out.print(i + " ");
            }
        }

        System.out.println();
        System.out.println("Odd numbers:");
        for (int i = 1; i <= n; i++) {
            if (i % 2 != 0) {
                System.out.print(i + " ");
            }
        }
    }
}
