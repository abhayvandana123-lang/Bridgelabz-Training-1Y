import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class DateArithmetic {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DateTimeFormatter f = DateTimeFormatter.ofPattern("dd-MM-yyyy");

        String input = sc.nextLine();
        LocalDate date = LocalDate.parse(input, f);

        LocalDate result = date.plusDays(7).plusMonths(1).plusYears(2);
        result = result.minusWeeks(3);

        System.out.println(result.format(f));
    }
}
