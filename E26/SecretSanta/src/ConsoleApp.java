import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

public class ConsoleApp {
    private static Scanner scanner = new Scanner(System.in);
    private static SecretSanta SS = new SecretSanta();
    private static Map<String, Participant> assignedParticipants = new HashMap<>();

    public static void main(String[] args) {
        boolean running = true;

        while (running) {
            showMenu();
            try{
                int choice = scanner.nextInt();

                switch (choice) {
                    case 1 -> addParticipant();
                    case 2 -> defineCouple();
                    case 3 -> generateDraw();
                    case 4 -> consultResult();
                    case 5 -> showAllResults();
                    case 6 -> showStats();
                    case 7 -> reset();
                    case 0 -> running = false;
                    default -> System.out.println("Invalid choice.");
                }
            } catch (NumberFormatException e){
                System.out.println("Invalid choice. Enter a value between 0 and 7");
            }

            System.out.println("Goodbye!");
        }
    }

    private static void showMenu() {

    }

    private static void addParticipant() {

    }

    private static void defineCouple() {

    }

    private static void generateDraw() {

    }

    private static void consultResult() {

    }

    private static void showAllResults() {

    }

    private static void showStats() {

    }
    private static void reset() {

    }
}
