import java.util.Scanner;

public class Index {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();

        int[] arr = new int[20];
        int index = 0;

        while (num != 0) {
            arr[index++] = num % 10;
            num /= 10;
        }

        for (int i = index - 1; i >= 0; i--)
            System.out.print(arr
