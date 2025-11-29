package CoffeeMachine.core;
import CoffeeMachine.utils.Messages;
import CoffeeMachine.utils.UserInterface;

import java.util.Scanner;

public class Inventory {
    private int water       = 0;
    private int milk        = 0;
    private int coffeeBeans = 0;
    private int cups        = 0;
    private int money      = 0;

    //Constructor
    public Inventory(){
        water = 400;
        milk = 540;
        coffeeBeans = 120;
        cups = 9;
        money = 550;
    }

    /**
     * Displays the current coffee machine inventory using the provided user interface.
     * @param ui the user interface responsible for displaying the inventory
     */
    public void showInventory(UserInterface ui){
        ui.showCoffeeMachineInventory(cups, water, milk, coffeeBeans, money);
    }

    /**
     * Adds user-specified ingredient quantities to the coffee machine inventory.
     * @param input the {@link Scanner} used to read user input
     * @param ui the user interface that handles input prompts and validation
     */
    public void addToInventory(Scanner input, UserInterface ui){
        water += ui.readIngredientsQty(input, Messages.PROMPT_ADD_WATER, Messages.ERR_INGREDIENTS_INPUT);
        milk += ui.readIngredientsQty(input, Messages.PROMPT_ADD_MILK, Messages.ERR_INGREDIENTS_INPUT);
        coffeeBeans += ui.readIngredientsQty(input, Messages.PROMPT_ADD_COFFEE, Messages.ERR_INGREDIENTS_INPUT);
        cups += ui.readIngredientsQty(input, Messages.PROMPT_ADD_CUPS, Messages.ERR_INGREDIENTS_INPUT);
    }

    /**
     * Checks whether the coffee machine has enough resources to prepare the selected coffee type.
     * @param ui the user interface used to display messages
     * @param type the type of coffee to prepare
     * @return true if all required resources are available, false otherwise
     */
    public boolean haveEnoughResources(UserInterface ui, CoffeeType type){
        boolean isEnough = true;
        if(water < type.getWater()){
            ui.showMsgLn(Messages.MSG_NOT_ENOUGH_WATER);
            isEnough = false;
        }else if(milk < type.getMilk()){
            ui.showMsgLn(Messages.MSG_NOT_ENOUGH_MILK);
            isEnough = false;
        }else if(coffeeBeans < type.getBeans()){
            ui.showMsgLn(Messages.MSG_NOT_ENOUGH_COFFEE);
            isEnough = false;
        }else if(cups < 1){
            ui.showMsgLn(Messages.MSG_NOT_ENOUGH_CUPS);
            isEnough = false;
        }else{
            ui.showMsg(Messages.MSG_MAKING_COFFEE);
        }
        return isEnough;
    }

    /**
     * Returns the current amount of water in the coffee machine.
     * @return the amount of water in milliliters
     */
    public int getWater() { return water; }

    /**
     * Returns the current amount of milk in the coffee machine.
     * @return the amount of milk in milliliters
     */
    public int getMilk() { return milk; }

    /**
     * Returns the current amount of coffee beans in the coffee machine.
     * @return the amount of coffee beans in grams
     */
    public int getCoffeeBeans() { return coffeeBeans; }

    /**
     * Returns the number of disposable cups available in the coffee machine.
     * @return the number of cups
     */
    public int getCups() { return cups; }

    /**
     * Returns the amount of money currently stored in the coffee machine.
     * @return the amount of money in dollars
     */
    public int getMoney() { return money; }

    /**
     * Sets the amount of water in the coffee machine.
     * @param water the new amount of water in milliliters
     */
    public void setWater(int water){ this.water = water; }

    /**
     * Sets the amount of milk in the coffee machine.
     * @param milk the new amount of milk in milliliters
     */
    public void setMilk(int milk){ this.milk = milk; }

    /**
     * Sets the amount of coffee beans in the coffee machine.
     * @param coffeeBeans the new amount of coffee beans in grams
     */
    public void setCoffeeBeans(int coffeeBeans){ this.coffeeBeans = coffeeBeans; }

    /**
     * Sets the number of disposable cups in the coffee machine.
     * @param cups the new number of cups
     */
    public void setCups(int cups){ this.cups = cups; }

    /**
     * Sets the amount of money stored in the coffee machine.
     * @param money the new amount of money in dollars
     */
    public void setMoney(int money){
        this.money = money;
    }
}
