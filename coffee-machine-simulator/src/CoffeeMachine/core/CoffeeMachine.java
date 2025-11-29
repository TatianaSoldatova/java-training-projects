package CoffeeMachine.core;
import CoffeeMachine.utils.Messages;
import CoffeeMachine.utils.UserInterface;

import java.util.Scanner;

public class CoffeeMachine {
    // Variables
    private int nbrCoffeeCupsMade = 0;
    UserInterface userInterface   = new UserInterface();
    Inventory inventory           = new Inventory();
    CoffeeType type;

    /**
     * Starts the coffee machine and handles user interactions in a loop.
     * @param input the {@link Scanner} used to read user input
     */
    public void startMachine(Scanner input) {
        userInterface.showMsgLn(Messages.TITLE);
        String action = "";
        do{
            action = userInterface.readActionChoice(input);
            switch (action) {
                case "buy":
                    if(nbrCoffeeCupsMade >= 10){
                        userInterface.showMsgLn(Messages.MSG_NEED_CLEANING);
                    }else{
                        type = validateCoffeeChoice(input);
                        if(!type.equals(CoffeeType.BACK) && inventory.haveEnoughResources(userInterface, type)){
                            makeCoffee(type);
                            nbrCoffeeCupsMade++;
                            //userInterface.showMsgLn("Number of cups made: " + nbrCoffeeCupsMade);
                        }
                    }
                    userInterface.addNewLine();
                    break;
                case "fill":
                    fillCoffeeMachine(input);
                    break;
                case "take":
                    giveMoney();
                    break;
                case "clean":
                    userInterface.showMsgLn(Messages.MSG_CLEANED);
                    nbrCoffeeCupsMade = 0;
                    break;
                case "remaining":
                    inventory.showInventory(userInterface);
                    break;
                case "exit":
                    userInterface.showMsgLn(Messages.END_OF_PROGRAM);
                    break;
                default:
                    userInterface.showMsg(Messages.ERR_ACTION_INPUT);
            }
        }while(!action.equals("exit"));
    }

    /**
     * Prompts the user to select a coffee type and validates the input.
     * @param input the {@link Scanner} used to read user input
     * @return the selected CoffeeType, or BACK if the user chooses to go back
     */
    private CoffeeType validateCoffeeChoice(Scanner input){
        String coffeeType = " ";
        CoffeeType type = null;
        do{
            coffeeType = userInterface.readCoffeeChoice(input);
            switch (coffeeType) {
                case "1":
                    type = CoffeeType.ESPRESSO;
                break;
                case "2":
                    type = CoffeeType.LATTE;
                break;
                case "3":
                    type = CoffeeType.CAPPUCCINO;
                break;
                case "back":
                    type = CoffeeType.BACK;
                    break;
                default:
                    userInterface.showMsg("Invalid input!\n");
            }
        }while(!coffeeType.equals("1") && !coffeeType.equals("2") && !coffeeType.equals("3") && !coffeeType.equals("back"));
        return type;
    }

    /**
     * Prepares a coffee of the specified type by updating the inventory.
     * This method decreases the inventory quantities according to the
     * requirements of the given CoffeeType.
     * @param coffeeType the type of coffee to prepare
     */
    private void makeCoffee(CoffeeType coffeeType){
        inventory.setWater(inventory.getWater() - coffeeType.getWater());
        inventory.setMilk(inventory.getMilk() - coffeeType.getMilk());
        inventory.setCoffeeBeans(inventory.getCoffeeBeans() -  coffeeType.getBeans());
        inventory.setCups(inventory.getCups() - 1);
        inventory.setMoney(inventory.getMoney() + coffeeType.getPrice());
    }

    /**
     * Gives all the money stored in the coffee machine to the user.
     */
    private void giveMoney(){
        userInterface.showMsgLn("I gave you $" + inventory.getMoney());
        inventory.setMoney(0);
    }

    /**
     * Adds ingredients to the coffee machine by prompting the user.
     * @param input the {@link Scanner} used to read user input
     */
    private void fillCoffeeMachine(Scanner input){
        inventory.addToInventory(input, userInterface);
    }
}
