import java.util.Scanner;

public class Age {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int amarAge = sc.nextInt();
        int akbarAge = sc.nextInt();
        int anthonyAge = sc.nextInt();

        double amarHeight = sc.nextDouble();
        double akbarHeight = sc.nextDouble();
        double anthonyHeight = sc.nextDouble();

        String youngest;
        if (amarAge <= akbarAge && amarAge <= anthonyAge)
            youngest = "Amar";
        else if (akbarAge <= amarAge && akbarAge <= anthonyAge)
            youngest = "Akbar";
        else
            youngest = "Anthony";

        String tallest;
        if (amarHeight >= akbarHeight && amarHeight >= anthonyHeight)
            tallest = "Amar";
        else if (akbarHeight >= amarHeight && akbarHeight >= anthonyHeight)
            tallest = "Akbar";
        else
            tallest = "Anthony";

        System.out.print
