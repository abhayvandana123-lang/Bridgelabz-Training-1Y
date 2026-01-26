import java.util.Scanner;

public class EmployeeBonus {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double salary = sc.nextDouble();
        int years = sc.nextInt();
        double bonus;

        if (years < 5) {
            bonus = salary * 0.05;
        } else if (years <= 10) {
            bonus = salary * 0.10;
        } else {
            bonus = salary * 0.15;
        }

        System.out.println(bonus);
    }
}
