public class WrapperUtilityMethods {
    public static void main(String[] args) {
        int intValue = Integer.parseInt("123");
        double doubleValue = Double.parseDouble("3.14");
        boolean boolValue = Boolean.parseBoolean("true");
        String binaryValue = Integer.toBinaryString(10);
        boolean isDigit = Character.isDigit('5');

        System.out.println("Integer value: " + intValue);
        System.out.println("Double value: " + doubleValue);
        System.out.println("Boolean value: " + boolValue);
        System.out.println("Binary of 10: " + binaryValue);
        System.out.println("Is '5' a digit: " + isDigit);
    }
}
