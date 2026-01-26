import java.util.Scanner;

public class FactorsUsingWhile {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter an integer: ");
        int value = input.nextInt();

        if (value == 0) {
            System.out.println("0 has infinitely many factors.");
        } else {
            int num = Math.abs(value);
            int i = 1;
            while (i <= num) {
                if (num % i == 0) {
                    System.out.println(i);
                }
                i++;
            }
        }

        input.close();
    }
}
