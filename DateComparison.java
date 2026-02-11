import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class DateComparison {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DateTimeFormatter f = DateTimeFormatter.ofPattern("dd-MM-yyyy");

        LocalDate d1 = LocalDate.parse(sc.nextLine(), f);
        LocalDate d2 = LocalDate.parse(sc.nextLine(), f);

        if (d1.isBefore(d2)) {
            System.out.println("First date is before second date");
        } else if (d1.isAfter(d2)) {
            System.out.println("First date is after second date");
        } else {
            System.out.println("Both dates are the same");
        }
    }
}
