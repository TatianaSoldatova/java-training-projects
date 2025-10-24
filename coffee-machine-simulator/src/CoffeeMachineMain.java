import java.util.Scanner;

public class CoffeeMachineMain {
    static Scanner input = new Scanner(System.in);

    // Constants
    public static final int WATER_PER_CUP = 200;
    public static final int MILK_PER_CUP = 50;
    public static final int COFFEE_BEANS_PER_CUP = 15;

    public static void main(String[] args) {

        // Variables:
        int water = 0;
        int milk = 0;
        int coffeeBeans = 0;
        int cups = 0;

        System.out.print("Write how many cups of coffee you will need: ");

        cups = input.nextInt();

        water = WATER_PER_CUP * cups;
        milk = MILK_PER_CUP * cups;
        coffeeBeans = COFFEE_BEANS_PER_CUP * cups;

        System.out.println("For " + cups + " cups of coffee you will need: ");
        System.out.println(water + " ml of water");
        System.out.println(milk + " ml of milk");
        System.out.println(coffeeBeans + " g of coffee beans");
    }
}
