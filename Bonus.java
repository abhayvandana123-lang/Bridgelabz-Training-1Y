import java.util.Scanner;

public class Bonus {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double totalBonus = 0;

        for (int i = 1; i <= 10; i++) {
            double salary = sc.nextDouble();
            int years = sc.nextInt();
            double bonus;

            if (years >= 10)
                bonus = salary * 0.10;
            else if (years >= 5)
                bonus = salary * 0.05;
            else
                bonus = salary * 0.02;

            double newSalary = salary + bonus;
            totalBonus += bonus;

            System.out.println("Employee " + i);
            System.out.println("Old Salary: " + salary);
            System.out.println("Bonus: " + bonus);
            System.out.println("New Salary: " + newSalary);
        }

        System.out.println("Total Bonus to be Paid: " + totalBonus);
    }
}
