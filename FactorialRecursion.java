import java.util.Scanner;

public class FactorialRecursion {

    public static int getInput() {
        Scanner sc = new Scanner(System.in);
        return sc.nextInt();
    }

    public static long factorial(int n) {
        if (n <= 1)
            return 1;
        return n * factorial(n - 1);
    }

    public static void displayResult(long result) {
        System.out.println(result);
    }

    public static void main(String[] args) {
        int num = getInput();
        long result = factorial(num);
        displayResult(result);
    }
}
