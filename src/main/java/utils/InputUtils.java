package utils;
import java.util.Scanner;

public class InputUtils {
    private static Scanner scanner = new Scanner(System.in);

    public static int getValidInt(String prompt) {
        while (true) {
            System.out.print(prompt);
            if (scanner.hasNextInt()) {
                return scanner.nextInt();
            } else {
                System.out.println("Неправильний формат. Введіть ціле число.");
                scanner.next();
            }
        }
    }

    public static double getValidDouble(String prompt) {
        Scanner scanner = new Scanner(System.in);
        double value;
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine();
            try {
                value = Double.parseDouble(input);
                return value;
            } catch (NumberFormatException e) {
                System.out.println("Некоректний ввід");
            }
        }
    }

    public static boolean getValidBoolean(String prompt) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("true")) {
                return true;
            } else if (input.equalsIgnoreCase("false")) {
                return false;
            } else {
                System.out.println("Некоректний ввід");
            }
        }
    }

    public static String getStringInput(String prompt) {
        Scanner scanner = new Scanner(System.in);
        System.out.print(prompt);
        return scanner.nextLine();
    }
}
