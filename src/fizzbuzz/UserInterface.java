package fizzbuzz;

import java.util.Collection;
import java.util.HashSet;
import java.util.Scanner;

public class UserInterface {
    private static UserInterface userInterface = new UserInterface();

    private Scanner scanner = new Scanner(System.in);

    public static UserInterface getUserInterface() {
        return userInterface;
    }

    public Collection<Integer> promptForRules() { // Make sure scanner doesn't continue forever
        System.out.println("Please enter a series of numbers which you would like to replace with corresponding rules.");
        System.out.println("The numbers should be separated by commas.");
        HashSet<Integer> rulesToImplement = new HashSet<>();
        String input = scanner.nextLine();
        String[] numbers = input.split(",");
        for (String number: numbers) {
            number = number.trim();
            if (number.matches("\\d+")) {
                rulesToImplement.add(Integer.valueOf(number));
            }
        }
        return rulesToImplement;
    }

    public int promptForStartPoint() {
        System.out.println("Please enter an integer to start at.");
        try {
            return getIntFromConsoleInput();
        } catch (RuntimeException e) {
            return 0;
        }
    }

    public int promptForEndPoint() {
        System.out.println("Please enter an integer to end at.");
        try {
            return getIntFromConsoleInput();
        } catch (RuntimeException e) {
            return 500;
        }
    }

    private int getIntFromConsoleInput() {
        for (int i = 0; i < 3; i++) {
            String input = scanner.nextLine().trim();
            if (input.matches("\\d+")) {
                return Integer.valueOf(input);
            }
            System.out.println("No suitable integer was entered.");
            System.out.println("You have " + (2 - i) + " tries remaining before the default value will be used.");
        }
        throw new RuntimeException();
    }
}
