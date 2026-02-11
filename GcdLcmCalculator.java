import java.util.Scanner;

public class GcdLcmCalculator {

    public static int getNumber() {
        Scanner sc = new Scanner(System.in);
        return sc.nextInt();
    }

    public static int gcd(int a, int b) {
        if (b == 0)
            return a;
        return gcd(b, a % b);
    }

    public static int lcm(int a, int b) {
        return (a * b) / gcd(a, b);
    }

    public static void display(int g, int l) {
        System.out.println(g);
        System.out.println(l);
    }

    public static void main(String[] args) {
        int n1 = getNumber();
        int n2 = getNumber();
        int g = gcd(n1, n2);
        int l = lcm(n1, n2);
        display(g, l);
    }
}
