import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int age;

        for (int i = 1; i <= 10; i++) {
            age = sc.nextInt();
            if (age >= 18)
                System.out.println("Student " + i + " can vote");
            else
                System.out.println("Student " + i + " cannot vote");
        }
    }
}
