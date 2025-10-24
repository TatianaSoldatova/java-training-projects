package lastpencil.utils;

public class Messages {

    /**
     * Private constructor to prevent instantiation
     */
    private Messages() {}

    //------
    //TITLE
    //------
    public static final String TITLE = """
                                         
                                         *******   L A S T  P E N C I L   *******
                                               Taking the last pencil loses...
                                         """;
    //---------
    // PROMPTS
    //---------
    public static final String PROMPT_NUMBER_OF_PENCILS     = "How many pencils would you like to use? ";
    public static final String PROMPT_FIRST_PLAYER          = "Who will be the first (John (you), Jack (bot)): ";

    //-------
    //ERRORS
    //-------
    public static final String ERROR_INVALID_INPUT          = "The number of pencils should be numeric";
    public static final String ERROR_NON_POSITIVE_NUMBER    = "The number of pencils should be positive";
    public static final String ERROR_UNKNOWN_PLAYER_NAME    = "Choose between 'John' and 'Jack'";
    public static final String ERROR_TOO_MANY_PENCILS_TAKEN = "Too many pencils. Try again.";
    public static final String ERROR_INVALID_PENCIL_VALUE   = "Possible values: '1', '2' or '3'";
}
