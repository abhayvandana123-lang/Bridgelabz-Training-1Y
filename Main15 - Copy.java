import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();

        String unique = "";

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            boolean exists = false;

            for (int j = 0; j < unique.length(); j++) {
                if (unique.charAt(j) == ch) {
                    exists = true;
                    break;
                }
            }

            if (!exists) {
                unique += ch;
            }
        }

        for (int i = 0; i < unique.length(); i++) {
            char ch = unique.charAt(i);
            int count = 0;

            for (int j = 0; j < str.length(); j++) {
                if (str.charAt(j) == ch) {
                    count++;
                }
            }

            System.out.println(ch + " " + count);
        }
    }
}
