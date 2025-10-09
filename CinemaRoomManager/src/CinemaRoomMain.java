import java.util.Scanner;

public class CinemaRoomMain {
    static Scanner input = new Scanner(System.in);

    // Constants
    public static final int NORMAL_TICKET_PRICE = 10;
    public static final int REDUCED_TICKET_PRICE = 8;
    public static final int SMALL_ROOM_SIZE = 60; // seats

    public static void main(String[] args) {

        // Variables
        int nbRows = 0;
        int nbSeats = 0;
        int totalNbSeats = 0;

        int totalIncome = 0;

        System.out.print("Enter the number of rows: ");
        nbRows = input.nextInt();

        System.out.print("Enter the number of seats in each row: ");
        nbSeats = input.nextInt();

        totalNbSeats = nbRows * nbSeats;

        if(totalNbSeats <= SMALL_ROOM_SIZE) {
            totalIncome = totalNbSeats * NORMAL_TICKET_PRICE;
        } else{
            if(totalNbSeats % 2 == 0) {
                totalIncome = (totalNbSeats / 2) * NORMAL_TICKET_PRICE + (totalNbSeats / 2) * REDUCED_TICKET_PRICE;
            } else{
                int firstHalf = totalNbSeats / 2;
                int secondHalf = totalNbSeats - firstHalf;
                totalIncome =  firstHalf * NORMAL_TICKET_PRICE + secondHalf * REDUCED_TICKET_PRICE;
            }
        }
        System.out.println("Total income: $" + totalIncome);

        input.close();

        /*
        System.out.println("Cinema:");
        System.out.println("  1 2 3 4 5 6 7 8");
        System.out.println("1 S S S S S S S S");
        System.out.println("2 S S S S S S S S");
        System.out.println("3 S S S S S S S S");
        System.out.println("4 S S S S S S S S");
        System.out.println("5 S S S S S S S S");
        System.out.println("6 S S S S S S S S");
        System.out.println("7 S S S S S S S S");*/
    }
}
