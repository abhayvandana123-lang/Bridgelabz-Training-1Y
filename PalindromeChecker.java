import java.util.Scanner;

public class PalindromeChecker {

    public static String getInput() {
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }

    public static boolean isPalindrome(String str) {
        String cleaned = str.replaceAll("\\s+", "").toLowerCase();
        int left = 0, right = cleaned.length() - 1;

        while (left < right) {
            if (cleaned.charAt(left) != cleaned.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static void displayResult(String str, boolean result) {
        if (result) {
            System.out.println("Palindrome");
        } else {
            System.out.println("Not a Palindrome");
        }
    }

    public static void main(String[] args) {
        String text = getInput();
        boolean check = isPalindrome(text);
        displayResult(text, check);
    }
}
