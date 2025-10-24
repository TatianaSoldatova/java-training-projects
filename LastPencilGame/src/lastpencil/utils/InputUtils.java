package lastpencil.utils;

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
}
