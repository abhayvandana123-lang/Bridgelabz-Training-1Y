import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String text = sc.nextLine();

        String[] builtIn = text.split(" ");

        String[] manual = new String[text.length()];
        int index = 0;
        String word = "";

        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            if (ch != ' ') {
                word += ch;
            } else {
                manual[index++] = word;
                word = "";
            }
        }
        manual[index++] = word;

        System.out.println("Manual Split:");
        for (int i = 0; i < index; i++) {
            System.out.println(manual[i]);
        }

        System.out.println("Using split():");
        for (int i = 0; i < builtIn.length; i++) {
            System.out.println(builtIn[i]);
        }
    }
}
