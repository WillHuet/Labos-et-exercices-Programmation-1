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
        System.out.println("\n=== SECRET SANTA ===");
        System.out.println("1. Add participant");
        System.out.println("2. Define couple");
        System.out.println("3. Generate draw");
        System.out.println("4. Consult result");
        System.out.println("5. Show all results");
        System.out.println("6. Show consultation stats");
        System.out.println("7. Reset");
        System.out.println("0. Exit");
        System.out.print("Choice: ");
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

    /*

private static void addParticipant() {
        System.out.print("Enter name: ");
        String name = scanner.next();

        if (participantsMap.containsKey(name)) {
            System.out.println("Participant already exists.");
            return;
        }

        Participant p = new Participant(name);
        participantsMap.put(name, p);
        santa.addParticipant(p);

        System.out.println("Participant added.");
    }

    private static void defineCouple() {
        System.out.print("First person: ");
        String name1 = scanner.next();

        System.out.print("Second person: ");
        String name2 = scanner.next();

        Participant p1 = participantsMap.get(name1);
        Participant p2 = participantsMap.get(name2);


if (p1 == null || p2 == null) {
            System.out.println("Participant not found.");
            return;
        }

        p1.setSpouse(p2);
        p2.setSpouse(p1);

        System.out.println("Couple defined.");
    }

    private static void generateDraw() {
        try {
            santa.generateDraw();
            System.out.println("Draw generated!");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }


private static void consultResult() {
        System.out.print("Enter your name: ");
        String name = scanner.next();

        Participant p = participantsMap.get(name);

        if (p == null) {
            System.out.println("Participant not found.");
            return;
        }

        try {
            Participant result = santa.consult(p);
            System.out.println("You give a gift to: " + result.getName());
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void showAllResults() {
        santa.showAllResults();
    }

    private static void showStats() {
        santa.showConsultationCounts();
    }


 private static void reset() {
        santa.reset();
        participantsMap.clear();
        System.out.println("Reset done.");
    }

     */
}
