import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String number;
        int base;
        System.out.print("Enter a number: ");
        number = scanner.nextLine();
        System.out.print("Enter the base system (2 for binary, 10 for decimal, 16 for hexadecimal): ");
        base = scanner.nextInt();
        scanner.nextLine();
        String convertedNumber;
        boolean isValidInput = true;
        switch (base) {
            case 2:
                isValidInput = isBinary(number);
                break;
            case 10:
                isValidInput = isDecimal(number);
                break;
            case 16:
                isValidInput = isHexadecimal(number);
                break;
            default:
                System.out.println("Invalid base system!");
                System.exit(0);
        }
        if (!isValidInput) {
            System.out.println("Invalid input for the specified base system!");
            System.exit(0);
        }
        switch (base) {
            case 2:
                convertedNumber = convertBinary(number);
                break;
            case 10:
                convertedNumber = convertDecimal(number);
                break;
            case 16:
                convertedNumber = convertHexadecimal(number);
                break;
            default:
                convertedNumber = "";
                break;
        }
        System.out.println("Converted number: " + convertedNumber);
    }

    // Check if the input is a valid binary number
    public static boolean isBinary(String number) {
        return number.matches("[01]+");
    }

    // Check if the input is a valid decimal number
    public static boolean isDecimal(String number) {
        return number.matches("[0-9]+");
    }

    // Check if the input is a valid hexadecimal number
    public static boolean isHexadecimal(String number) {
        return number.matches("[0-9A-Fa-f]+");
    }

    // Convert a binary number to decimal
    public static String convertBinary(String number) {
        return Integer.toString(Integer.parseInt(number, 2));
    }

    // Convert a decimal number to binary
    public static String convertDecimal(String number) {
        return Integer.toBinaryString(Integer.parseInt(number));
    }

    // Convert a hexadecimal number to decimal
    public static String convertHexadecimal(String number) {
        return Integer.toString(Integer.parseInt(number, 16));
    }
}