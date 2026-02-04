import java.util.Scanner;

public class MaxDigit {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();

        int maxDigit = 10;
        int[] arr = new int[maxDigit];
        int index = 0;

        while (num != 0) {
            if (index == maxDigit) {
                maxDigit += 10;
                int[] temp = new int[maxDigit];
                for (int i = 0; i < arr.length; i++)
                    temp[i] = arr[i];
                arr = temp;
            }
            arr[index++] = num % 10;
