import java.util.*;

public class SecretSanta {
    //VARIABLES
    private ArrayList<Participant> participants;
    private ArrayList<Pairing> pairings;
    private boolean drawLocked;
    private Scanner scanner = new Scanner(System.in);

    //CONSTRUCTEUR
    public SecretSanta() {
        participants = new ArrayList<>();
        pairings = new ArrayList<>();
        drawLocked = false;
    }

    //MÉTHODES
    /*
    public void addParticipant(Participant p) {
        if(drawLocked || participants.contains(p)) {
            throw new IllegalStateException("Cannot add participant after the draw is locked!");
        } else{
            participants.add(p);
        }
    }
    */

    public void addParticipant() {
        boolean valid = false;

        if(drawLocked) {
            System.out.println("The draw is now locked. You cannot add any other participants!");
        } else {
            while (!valid) {
                System.out.println("Please enter the name of the new Participant!");
                while (scanner.hasNextInt() || scanner.hasNextDouble()) {
                    System.out.println("Error: Numbers are not allowed!");
                    System.out.print("Please enter a valid name : ");
                    scanner.next();
                }

                String newName = scanner.next();
                Participant newParticipant = new Participant(newName, null);

                if(!validateNewParticipant(newParticipant)) {
                    System.out.println("Participant already exists!");
                } else {
                    participants.add(newParticipant);
                    valid = true;
                }
            }
        }
    }

    public boolean validateNewParticipant(Participant newParticipant) {
        boolean result = true;

        for (Participant p : participants) {
            if(p.getName().equalsIgnoreCase(newParticipant.getName())) {
                result = false;
            }
        }
        return result;
    }

    public void defineCouple() {
        int i = 0;
        boolean valid = false;
        Participant p1 = null;
        Participant p2 = null;

        if(participants.size() > 2){
            System.out.println("ERROR! There's less than 2 person in the pool!");
        } else {
            for (Participant participant : participants) {
                System.out.println(i++ + ") " + participant.getName());
            }
            System.out.println("Please enter the number of each person you want to match!");

            System.out.print("First person : ");
            while (!valid){
                try {
                    int number1 = scanner.nextInt();
                    p1 = participants.get(number1);
                    valid = true;
                } catch (IndexOutOfBoundsException e){
                    System.out.println("Error: Please enter a number between 0 and " + (participants.size()-1));
                }
            }

            valid = false;

            System.out.print("Second person : ");
            while (!valid){
                try {
                    int number2 = scanner.nextInt();
                    p2 = participants.get(number2);
                    valid = true;
                } catch (IndexOutOfBoundsException e){
                    System.out.println("Error: Please enter a number between 0 and " + (participants.size()-1));
                }
            }

            if (p1.getSpouse() != null || p2.getSpouse() != null) {
                System.out.println("ERROR! One of the two person already has a spouse!");
            } else if (p1.equals(p2)){
                System.out.println("ERROR! You selected the same person 2 times!");
            } else {
                p1.setSpouse(p2);
                p2.setSpouse(p1);
            }
        }
    }

    public void generateDraw(){
        if(participants.size() < 2) {
            System.out.println("ERROR! There's less than 2 person in the pool!");
        } else {
            pairings.clear();
            Random rand = new Random();
            boolean valid = false;
            while(!valid){
                pairings.clear();

                ArrayList<Participant> receivers = new ArrayList<>(participants);

                Collections.shuffle(receivers, rand);

                valid = true;

                for (int i = 0; i < participants.size(); i++) {
                    Participant giver = participants.get(i);
                    Participant receiver = receivers.get(i);

                    if (giver == receiver) {
                        valid = false;
                        break;
                    }

                    if (giver.getSpouse() == receiver) {
                        valid = false;
                        break;
                    }

                    pairings.add(new Pairing(giver, receiver));
                }
            }
            drawLocked = true;
        }
    }

    public void consultAllAssignments(){
        for (Pairing pair : pairings) {
            System.out.println(pair.getGiver() + " ==> " + pair.getReceiver());
            pair.getGiver().incrementCounter();
            pair.getReceiver().incrementCounter();
        }
    }

    public Participant consultAssignment(Participant p){
        p.incrementCounter();

        for (Pairing pair : pairings) {
            if(pair.getGiver().equals(p)) {
                return pair.getReceiver();
            }
        }

        return null;
    }

    public int displayConsultationCounter(Participant p){
        int result = 0;

        for (Participant part :  participants) {
            if(part.equals(p)) {
                result = part.getConsultationCount();
            }
        }

        return result;
    }

    public void resetDraw(){
        pairings.clear();
        drawLocked = false;
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
        System.out.println("");
        System.out.print("Choice: ");
    }

    //MAIN EXÉCUTABLE (POUR TESTER)
    public void main(String[] args) {
        SecretSanta ss = new SecretSanta();
        Participant will = new Participant("Will", null);
        participants.add(will);
        Participant caro = new Participant("Caro", null);
        participants.add(caro);
        will.setSpouse(caro);
        caro.setSpouse(will);

        Participant max = new Participant("Max", null);
        participants.add(max);
        Participant vero = new Participant("Vero", null);
        participants.add(vero);
        max.setSpouse(vero);
        vero.setSpouse(max);

        boolean running = true;

        while (running) {
            showMenu();
            try{
                int choice = scanner.nextInt();

                if(choice < 0 || choice > 7) {
                    System.out.println("Invalid choice! Must be between 0 and 7!");
                }

                switch (choice) {
                    case 1 -> addParticipant();
                    case 2 -> defineCouple();
                    case 3 -> generateDraw();
                }
            } catch (InputMismatchException e){
                System.out.println("Invalid choice. Enter a value between 0 and 7");
            }
        }

//        while (running) {
//            showMenu();
//            try{
//                int choice = scanner.nextInt();
//
//                switch (choice) {
//                    case 1 -> addParticipant();
//                    case 2 -> defineCouple();
//                    case 3 -> generateDraw();
//                    case 4 -> consultAssignment();
//                    case 5 -> consultAllAssignments();
//                    case 6 -> displayConsultationCounter();
//                    case 7 -> resetDraw();
//                    case 0 -> running = false;
//                    default -> System.out.println("Invalid choice.");
//                }
//            } catch (NumberFormatException e){
//                System.out.println("Invalid choice. Enter a value between 0 and 7");
//            }
//
//            System.out.println("Goodbye!");
//        }
    }
}
