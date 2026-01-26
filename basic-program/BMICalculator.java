import java.util.Scanner;

public class BMICalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter weight in kilograms: ");
        double weight = sc.nextDouble();
        System.out.print("Enter height in meters: ");
        double height = sc.nextDouble();

        if (height > 0) {
            double bmi = weight / (height * height);
            System.out.println("BMI: " + bmi);
        } else {
            System.out.println("Height must be greater than zero.");
