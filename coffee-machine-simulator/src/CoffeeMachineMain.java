import CoffeeMachine.core.CoffeeMachine;
import java.util.Scanner;


public class CoffeeMachineMain {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        CoffeeMachine coffeeMachine = new CoffeeMachine();
        coffeeMachine.startMachine(input);
        input.close();
    }
}
