import java.util.Scanner;

public class GreatestFactor {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter an integer: ");
        int n = in.nextInt();

        int value = Math.abs(n);

        if (value <= 1) {
            System.out.println("No factor other than itself.");
        } else {
            int i = value - 1;
            while (i > 0) {
                if (value % i == 0) {
                    System.out.println(i);
                    break;
                }
                i--;
            }
        }

        in.close();
    }
}
