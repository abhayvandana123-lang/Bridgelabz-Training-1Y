import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();

        boolean[] visited = new boolean[str.length()];

        for (int i = 0; i < str.length(); i++) {
            if (visited[i]) {
                continue;
            }

            char ch = str.charAt(i);
            int count = 1;

            for (int j = i + 1; j < str.length(); j++) {
                if (str.charAt(j) == ch) {
                    count++;
                    visited[j] = true;
                }
            }

            System.out.println(ch + " " + count);
        }
    }
}
