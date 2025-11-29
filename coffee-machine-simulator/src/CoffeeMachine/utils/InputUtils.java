package CoffeeMachine.utils;
import java.util.Scanner;

public class InputUtils {
    /**
     * Private constructor to prevent instantiation
     */
    private InputUtils() {}

    /**
     * Reads and validates an integer value from the given input
     * @param input the Scanner instance used to read user input
     * @param messageError the error message to display when the input is not an integer
     * @return the integer value entered by the user
     */
    public static int readInt(Scanner input, String messageError) {
        while (!input.hasNextInt()) {
            System.out.println(messageError);
            input.next(); // discard invalid input
        }
        int integer = input.nextInt();
        input.nextLine();

        return integer;
    }

    /**
     * Prompts the user with a message and reads an entire line of input.
     * This method prints the provided message to the console and then reads
     * the full line entered by the user, including spaces, until the user
     * presses Enter. It is useful for capturing multi-word input such as names,
     * addresses, or sentences.
     * @param input the Scanner object used to read input from the user
     * @param message the message to display to prompt the user (with new line)
     * @return the full line entered by the user as a String
     */
    public static String readStringLineLn(Scanner input, String message) {
        System.out.println(message);
        return input.nextLine();
    }

    /**
     * Prompts the user with a message and reads an entire line of input.
     * This method prints the provided message to the console and then reads
     * the full line entered by the user, including spaces, until the user
     * presses Enter. It is useful for capturing multi-word input such as names,
     * addresses, or sentences.
     * @param input the Scanner object used to read input from the user
     * @param message the message to display to prompt the user (without new line)
     * @return the full line entered by the user as a String
     */
    public static String readStringLine(Scanner input, String message) {
        System.out.print(message);
        return input.nextLine();
    }
}
