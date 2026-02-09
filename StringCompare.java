import java.util.Scanner;

public class StringCompare {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s1 = sc.nextLine();
        String s2 = sc.nextLine();

        boolean same = true;

        if (s1.length() != s2.length()) {
            same = false;
        } else {
            for (int i = 0; i < s1.length(); i++) {
                if (s1.charAt(i) != s2.charAt(i)) {
                    same = false;
                    break;
                }
            }
        }

        if (same) {
            System.out.println("Strings are equal using charAt()");
        } else {
            System.out.println("Strings are not equal using charAt()");
        }

        if (s1.equals(s2)) {
            System.out.println("Strings are equal using equals()");
        } else {
            System.out.println("Strings are not equal using equals()");
        }
    }
}
