import java.util.Scanner;

public class CompareStrings {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        String a = input.nextLine();
        String b = input.nextLine();

        boolean result = true;

        if (a.length() != b.length()) {
            result = false;
        } else {
            for (int i = 0; i < a.length(); i++) {
                if (a.charAt(i) != b.charAt(i)) {
                    result = false;
                    break;
                }
            }
        }

        if (result) {
            System.out.println("Equal using charAt()");
        } else {
            System.out.println("Not equal using charAt()");
        }

        if (a.equals(b)) {
            System.out.println("Equal using equals()");
        } else {
            System.out.println("Not equal using equals()");
        }
    }
}
