import java.util.Scanner;

public class MultiplesBelowHundred {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        System.out.print("Enter an integer: ");
        int num = reader.nextInt();

        if (num == 0) {
            System.out.println("Every number is a multiple of 0.");
        } else {
            int i = 1;
            int limit = Math.abs(num);
            while (i * limit < 100) {
                System.out.println(i * limit);
                i++;
            }
        }

        reader.close();
