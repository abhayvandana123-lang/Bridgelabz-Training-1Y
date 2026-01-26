import java.util.Scanner;

public class SubjectMarks {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Physics marks: ");
        int physics = sc.nextInt();
        System.out.print("Enter Chemistry marks: ");
        int chemistry = sc.nextInt();
        System.out.print("Enter Maths marks: ");
        int maths = sc.nextInt();

        int total = physics + chemistry + maths;
        double average = total / 3.0;

        System.out.println("Total Marks: " + total);
        System.out.println("Average Marks: " + average);

        sc.close();
    }
}
