package CoffeeMachine.utils;

import java.util.Scanner;

public class UserInterface {
    /**
     * Displays the current inventory and resources of the coffee machine.
     * @param cups the number of disposable cups available
     * @param water the amount of water in milliliters
     * @param milk the amount of milk in milliliters
     * @param coffeeBeans the amount of coffee beans in grams
     * @param money the amount of money stored in the machine
     */
    public void showCoffeeMachineInventory(int cups, int water, int milk, int coffeeBeans, int money){
        System.out.println();
        System.out.println("The coffee machine has: ");
        System.out.println(water + " ml of water");
        System.out.println(milk + " ml of milk");
        System.out.println(coffeeBeans + " g of coffee beans");
        System.out.println(cups + " disposable cups");
        System.out.println("$" + money + " of money");
    }

    /**
     * Displays the given message followed by a newline.
     * @param msg the message to display
     */
    public void showMsgLn(String msg){
        System.out.println(msg);
    }

    /**
     * Displays the given message without adding a newline.
     * @param msg the message to display
     */
    public void showMsg(String msg){
        System.out.print(msg);
    }

    /**
     * Outputs a single newline.
     */
    public void addNewLine(){
        System.out.println();
    }

    /**
     * Displays a message prompting for an ingredient quantity and reads an integer from input.
     * @param msg the prompt message shown to the user
     * @param err the error message displayed when invalid input is entered
     * @return the integer quantity read from input
     */
    public int readIngredientsQty(Scanner input, String msg, String err){
        showMsgLn(msg);
        return InputUtils.readInt(input, err);
    }

    /**
     * Reads and validates the user's action choice for the coffee machine.
     * Allowed actions are: buy, fill, take, remaining, exit, clean
     * @return the validated action entered by the user, always in lowercase
     */
    public String readActionChoice(Scanner input){
        String action = "";
        do{
            action = InputUtils.readStringLineLn(input,Messages.PROMPT_ACTION);
            action = action.toLowerCase();
            if(!action.equals("buy") && !action.equals("fill")
                    && !action.equals("take") && !action.equals("remaining")
                    && !action.equals("exit") && !action.equals("clean")){
                showMsg(Messages.ERR_ACTION_INPUT);
            }
        }while(!action.equals("buy") && !action.equals("fill")
                && !action.equals("take") && !action.equals("remaining")
                && !action.equals("exit") && !action.equals("clean"));

        return action;
    }

    /**
     * Reads the user's coffee choice from the input stream.
     * @return the coffee type chosen by the user as a String
     */
    public String readCoffeeChoice(Scanner input){
        return InputUtils.readStringLineLn(input, Messages.PROMPT_COFFEE_TYPE);
    }
}
