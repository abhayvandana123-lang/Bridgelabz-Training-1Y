import java.util.Scanner;
import java.util.StringTokenizer;

public class Mains1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int count = 0;

        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            if (line.trim().isEmpty()) {
                continue;
            }

            StringTokenizer st = new StringTokenizer(line, ";");

            String name = st.hasMoreTokens() ? st.nextToken() : "";
            String phone = st.hasMoreTokens() ? st.nextToken() : "";
            String email = st.hasMoreTokens() ? st.nextToken() : "";
            String address = st.hasMoreTokens() ? st.nextToken() : "";

            System.out.println("----------- Contact -----------");
            System.out.println("Name    : " + name);
            System.out.println("Phone   : " + phone);
            System.out.println("Email   : " + email);
            System.out.println("Address : " + address);
            System.out.println("--------------------------------");

            count++;
        }

        System.out.println("Total Contacts: " + count);
    }
}
