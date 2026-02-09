import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s1 = sc.nextLine();
        String s2 = sc.nextLine();

        boolean equal = true;

        if (s1.length() != s2.length()) {
            equal = false;
        } else {
            for (int i = 0; i < s1.length(); i++) {
                if (s1.charAt(i) != s2.charAt(i)) {
                    equal = false;
                    break;
                }
            }
        }

        System.out.println(equal ? "Equal using charAt()" : "Not equal using charAt()");
        System.out.println(s1.equals(s2) ? "Equal using equals()" : "Not equal using equals()");
    }
}
