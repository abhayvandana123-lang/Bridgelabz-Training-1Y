import java.util.Scanner;

public class LeapYearSingleIf {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a year: ");
        int y = sc.nextInt();

        if (y % 400 == 0 || (y % 4 == 0 && y % 100 != 0))
            System.out.println("Year is a Leap Year");
        else
            System.out.println("Year is not a Leap Year");

        sc.close();
    }
}
