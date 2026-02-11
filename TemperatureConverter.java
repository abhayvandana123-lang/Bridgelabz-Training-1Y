import java.util.Scanner;

public class TemperatureConverter {

    public static double getInput() {
        Scanner sc = new Scanner(System.in);
        return sc.nextDouble();
    }

    public static double cToF(double c) {
        return (c * 9 / 5) + 32;
    }

    public static double fToC(double f) {
        return (f - 32) * 5 / 9;
    }

    public static void display(double cToF, double fToC) {
        System.out.println(cToF);
        System.out.println(fToC);
    }

    public static void main(String[] args) {
        double c = getInput();
        double f = getInput();
        display(cToF(c), fToC(f));
    }
}
