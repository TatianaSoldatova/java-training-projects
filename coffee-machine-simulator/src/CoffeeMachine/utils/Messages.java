package CoffeeMachine.utils;

public class Messages {

    private Messages() {}

    //------
    //TITLE
    //------
    public static final String TITLE = """
                                         
                                         *******   C O F F E E  M A C H I N E   *******
                                         """;
    //---------
    // PROMPTS
    //---------
    public static final String PROMPT_ADD_WATER             = "\nWrite how many ml of water you want to add: ";
    public static final String PROMPT_ADD_MILK              = "Write how many ml of milk you want to add: ";
    public static final String PROMPT_ADD_COFFEE            = "Write how many grams of coffee beans you want to add: ";
    public static final String PROMPT_ADD_CUPS              = "Write how many disposable cups you want to add: ";

    public static final String PROMPT_ACTION                = "\nWrite action (buy, fill, take, clean, remaining, exit): ";
    public static final String PROMPT_COFFEE_TYPE           = "\nWhat do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu: ";


    //----------
    // MESSAGES
    //----------
    public static final String MSG_MAKING_COFFEE            = "I have enough resources, making you a coffee!\n";
    public static final String MSG_NOT_ENOUGH_WATER         = "Sorry, not enough water!";
    public static final String MSG_NOT_ENOUGH_MILK          = "Sorry, not enough milk!";
    public static final String MSG_NOT_ENOUGH_COFFEE        = "Sorry, not enough coffee!";
    public static final String MSG_NOT_ENOUGH_CUPS          = "Sorry, not enough cups!";

    public static final String MSG_NEED_CLEANING            = "I need cleaning!";
    public static final String MSG_CLEANED                  = "I have been cleaned!";
    public static final String END_OF_PROGRAM               = "Coffee machine is off.";

    //-------
    //ERRORS
    //-------
    public static final String ERR_INGREDIENTS_INPUT        = "Invalid input! Try again...";
    public static final String ERR_ACTION_INPUT             = "Invalid action! Try again...\n";
}
