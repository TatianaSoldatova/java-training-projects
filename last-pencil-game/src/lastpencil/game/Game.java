package lastpencil.game;

import lastpencil.utils.InputUtils;
import lastpencil.utils.Messages;
import java.util.Random;
import java.util.Scanner;

public class Game {
    static Scanner input = new Scanner(System.in);

    //FIELDS
    private Player player;
    private Player bot;
    private int nbrPencils;
    String firstPlayerName;

    // METHODS
    /**
     * Starts the game by executing all the steps in order
     */
    public void start() {
        presentTheGame();
        initializePencilCount();
        firstPlayerName = chooseTheFirstPlayer();
        playGame();
        input.close();
    }

    /**
     * Displays the title of the game on screen at the beginning of a new game
     */
    private void presentTheGame(){
        System.out.println(Messages.TITLE);
    }

    /**
     * Prompts the user to enter the initial number of pencils for the game
     * and validates the input according to the game rules.
     * Appropriate error messages from {@link Messages} are displayed for:
     * - Non-integer input
     * - Negative or zero values
     */
    private void initializePencilCount(){
        System.out.println(Messages.PROMPT_NUMBER_OF_PENCILS);
        nbrPencils = InputUtils.readInt(input, Messages.ERROR_INVALID_INPUT);

        while (nbrPencils <= 0) {
            System.out.println(Messages.ERROR_NON_POSITIVE_NUMBER);
            nbrPencils = InputUtils.readInt(input, Messages.ERROR_INVALID_INPUT);
        }
    }

    /**
     * Prompts the user to choose which player will start the game.
     * This method initializes both the human player and the bot, then repeatedly asks
     * the user to enter the name of the player who should begin. The input is validated
     * against the initialized player names ("John" and "Jack"), ignoring case differences.
     * If the input is invalid, an error message is displayed, and the user is prompted again.
     */
    private String chooseTheFirstPlayer() {
        player = initializePlayer("John");
        bot = initializePlayer("Jack");

        System.out.println(Messages.PROMPT_FIRST_PLAYER);
        String playerName = input.nextLine().trim();

        while (!playerName.equalsIgnoreCase(player.getName())
                    && !playerName.equalsIgnoreCase(bot.getName())) {
            System.out.println(Messages.ERROR_UNKNOWN_PLAYER_NAME);
            playerName = input.nextLine().trim();
        }
        return playerName.substring(0, 1).toUpperCase() + playerName.substring(1);
    }

    /**
     * Initializes the player object for the game
     * @param name the name to assign to the player or the bot
     */
    private Player initializePlayer(String name){
        Player player = new Player();
        player.setName(name);
        return player;
    }

    /**
     * Draws the current number of pencils in the game as a sequence of "|" characters.
     */
    private void drawPencils(){
        for (int i = 0; i < nbrPencils; i++) {
            System.out.print("|");
        }
    }

    /**
     * Displays the current state of the game before the next player's move.
     * This method visually represents the remaining pencils on the table and
     * indicates whose turn it is next.
     * @param nextPlayerName the name of the player who will make the next move
     */
    private void showStateOfTheGameBeforeNextMove(String nextPlayerName){
        drawPencils();
        displayTurn(nextPlayerName);
    }

    /**
     * Displays a message indicating whose turn it is in the game.
     */
    private void displayTurn(String playerName){
        System.out.println("\n" + playerName + "'s turn!");
    }

    /**
     * Runs the main game loop for the Last Pencil game.
     * This method alternates turns between the player and the bot until all pencils are taken.
     * On each turn:
     * The current player (bot or human) removes a certain number of pencils.
     * The number of remaining pencils is updated accordingly.
     * If pencils remain, the next player's turn begins and the game state is displayed.
     * When no pencils remain, the current player is declared the winner.
     */
    private void playGame(){
        String currentPlayerName = firstPlayerName;
        showStateOfTheGameBeforeNextMove(firstPlayerName);

        while(nbrPencils > 0){
            if(currentPlayerName.equalsIgnoreCase(bot.getName())){
                nbrPencils -= botTurn(nbrPencils);
                currentPlayerName = player.getName();
            }else{
                nbrPencils -= playerTurn();
                currentPlayerName = bot.getName();
            }

            if(nbrPencils > 0){
                showStateOfTheGameBeforeNextMove(currentPlayerName);
            }else{
                // display winner
                System.out.println(currentPlayerName + " won!");
            }
        }
    }

    /**
     * Determines the bot's move based on the current number of remaining pencils.
     * The bot uses a simple strategy based on modular arithmetic to place the opponent
     * in a losing position whenever possible. Specifically:
     * If the number of remaining pencils % (3 + 1) equals 0, the bot removes 3 pencils.
     * If it equals 3, the bot removes 2 pencils.
     * If it equals 2, the bot removes 1 pencil.
     * If it equals 1, the bot removes a random number of pencils between 1 and 3.
     * If only one pencil remains, the bot removes it.
     * @param nbrPencils the number of pencils currently remaining on the table
     * @return the number of pencils the bot decides to remove
     */
    private int botTurn(int nbrPencils){
        final int MAX_PENCILS_TO_REMOVE = 3;
        final int MODULO = MAX_PENCILS_TO_REMOVE + 1;
        int nbPencilsToRemove;

        if(nbrPencils <= 1){
            nbPencilsToRemove = 1;
        }else{
            int remainder = nbrPencils % MODULO;
            if(remainder == 0){
                nbPencilsToRemove = MAX_PENCILS_TO_REMOVE;
            }else if(remainder == 3){
                nbPencilsToRemove = (MAX_PENCILS_TO_REMOVE - 1);
            }else if(remainder == 2){
                nbPencilsToRemove = (MAX_PENCILS_TO_REMOVE - 2);
            }else{
                Random random  = new Random();
                nbPencilsToRemove =  random.nextInt(MAX_PENCILS_TO_REMOVE);
            }
        }
        System.out.println(nbPencilsToRemove);
        return nbPencilsToRemove;
    }

    /**
     * Handles the player's turn by reading and validating the number of pencils they choose to remove.
     * The player must remove between 1 and 3 pencils, and cannot remove more pencils
     * than are currently available. If the input is invalid, the player is prompted
     * repeatedly until a valid number is entered.
     * @return the valid number of pencils the player decided to remove
     */
    private int playerTurn(){
        int nbPencilsToRemove = InputUtils.readInt(input, Messages.ERROR_INVALID_PENCIL_VALUE);

        while (nbPencilsToRemove < 1 || nbPencilsToRemove > 3 || nbPencilsToRemove > nbrPencils) {
            if (nbPencilsToRemove > nbrPencils) {
                System.out.println(Messages.ERROR_TOO_MANY_PENCILS_TAKEN);
                nbPencilsToRemove = InputUtils.readInt(input, Messages.ERROR_INVALID_PENCIL_VALUE);
            } else {
                System.out.println(Messages.ERROR_INVALID_PENCIL_VALUE);
                nbPencilsToRemove = InputUtils.readInt(input, Messages.ERROR_INVALID_PENCIL_VALUE);
            }
        }
        return nbPencilsToRemove;
    }
}
