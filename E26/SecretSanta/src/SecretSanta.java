import java.util.*;

public class SecretSanta {
    //CONSTANTES (STRINGS)
    //--------------------

    //INPUT
    private String INPUT_ENTER_TO_CONTINUE = Colors.GREEN + "Press ENTER to continue" + Colors.RESET;
    private String INPUT_ENTER_NAME = Colors.FOND_VERT + "Please enter the name of the new Participant!" +  Colors.RESET;
    private String INPUT_NUMBER_MATCH = Colors.FOND_VERT + "Please enter the number of each person you want to match!" +  Colors.RESET;
    private String INPUT_NUMBER_REVIEL = Colors.FOND_VERT + "Please enter the number of the person you want to reveil : " + Colors.RESET;
    private String INPUT_NUMBER_COUNTER = Colors.FOND_VERT + "Please enter the number of the person you want to see the counter : " + Colors.RESET;
    private String MENU_SECRET_SANTA = Colors.FOND_ROUGE + Colors.GREEN + "=== SECRET SANTA ===" + Colors.RESET;
    private String MSG_LOCKED_DRAW = "The draw is now locked!";
    private String MSG_DRAW_RESET = "Draw has been reset!";

    //ERRORS
    private String ERR_DRAW_LOCKED = Colors.FOND_ROUGE + "ERROR! The draw is now locked. You cannot add any other participants!" + Colors.RESET;
    private String ERR_NAME_NUMBER = Colors.FOND_ROUGE + "ERROR! Numbers are not allowed!" + Colors.RESET + "/n" + "Please enter a valid name : ";
    private String ERR_NAME_EXISTS = Colors.FOND_ROUGE + "ERROR! Participant already exists!" + Colors.RESET;
    private String ERR_LESS_THAN_TWO = Colors.FOND_ROUGE + "ERROR! There's less than 2 person in the pool!" + Colors.RESET;
    private String ERR_WRONG_NUMBER = Colors.FOND_ROUGE + "ERROR! Please enter a number between 1 and ";
    private String ERR_ALREADY_MATCHED = Colors.FOND_ROUGE + "ERROR! One of the two person already has a spouse!" + Colors.RESET;
    private String ERR_SAME_PERSON = Colors.FOND_ROUGE + "ERROR! You selected the same person 2 times!" + Colors.RESET;
    private String ERR_ZERO_TO_SEVEN = Colors.FOND_ROUGE + "Invalid choice! Must be between 0 and 7!" + Colors.RESET;
    private String ERR_DRAW_UNLOCKED = Colors.FOND_ROUGE + "ERROR! The draw hasn't been done!" + Colors.RESET;

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
    public void addParticipant() {
        boolean valid = false;

        if(drawLocked) {
            System.out.println(ERR_DRAW_LOCKED);
            pause();
        } else {
            while (!valid) {
                System.out.println(INPUT_ENTER_NAME);
                while (scanner.hasNextInt() || scanner.hasNextDouble()) {
                    System.out.println(ERR_NAME_NUMBER);
                    scanner.next();
                }

                String newName = scanner.next();
                Participant newParticipant = new Participant(newName, null);

                if(!validateNewParticipant(newParticipant)) {
                    System.out.println(ERR_NAME_EXISTS);
                } else {
                    participants.add(newParticipant);
                    valid = true;
                    System.out.println(newParticipant.getName() + " has been added to the pool!");
                    pause();
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
        boolean valid = false;
        Participant p1 = null;
        Participant p2 = null;

        if(participants.size() < 2){
            System.out.println(ERR_LESS_THAN_TWO);
            pause();
        } else {
            System.out.println(displayNameList(participants));
            System.out.println(INPUT_NUMBER_MATCH);
            while (!valid){
                System.out.print("First person : ");
                try {
                    int number1 = scanner.nextInt();
                    p1 = participants.get(number1 - 1);
                    valid = true;
                } catch (IndexOutOfBoundsException e){
                    System.out.println(ERR_WRONG_NUMBER + (participants.size()-1) + Colors.RESET);
                    pause();
                }
            }

            valid = false;

            while (!valid){
                System.out.print("Second person : ");
                try {
                    int number2 = scanner.nextInt();
                    p2 = participants.get(number2 -1);
                    valid = true;
                } catch (IndexOutOfBoundsException e){
                    System.out.println(ERR_WRONG_NUMBER + (participants.size()) + Colors.RESET);
                    pause();
                }
            }

            if (p1.getSpouse() != null || p2.getSpouse() != null) {
                System.out.println(ERR_ALREADY_MATCHED);
                pause();
            } else if (p1.equals(p2)){
                System.out.println(ERR_SAME_PERSON);
                pause();
            } else {
                p1.setSpouse(p2);
                p2.setSpouse(p1);

                System.out.println(p1.getName() + " and " + p2.getName() + " are now a couple!");
                pause();
            }
        }
    }

    public void generateDraw(){
        if(participants.size() < 2) {
            System.out.println(ERR_LESS_THAN_TWO);
            pause();
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
            System.out.println(MSG_LOCKED_DRAW);
            pause();
        }
    }

    public void consultAllAssignments(){
        for (Pairing pair : pairings) {
            System.out.println(displayNames(pair, true));
            pair.getGiver().incrementCounter();
        }

        pause();
    }

    public void consultAssignment(){
        int value;
        boolean valid = false;
        if(!drawLocked) {
            System.out.println(ERR_DRAW_UNLOCKED);
            pause();
        } else {
            System.out.println(displayNameList(participants));
            System.out.println(INPUT_NUMBER_REVIEL);
            while (!valid){
                try {
                    value = scanner.nextInt();
                    Participant selected = participants.get(value - 1);
                    for (Pairing p : pairings) {
                        if (p.getGiver().getName().equals(selected.getName())) {
                            System.out.println(displayNames(p, true));
                            p.getGiver().incrementCounter();
                        }
                    }
                    valid = true;
                    pause();
                } catch (IndexOutOfBoundsException e){
                    System.out.println(ERR_WRONG_NUMBER + (participants.size()) + Colors.RESET);
                    pause();
                }
            }
        }
    }

    public String displayNames(Pairing pairing, boolean reveiled) {
        String result = "";
        if(reveiled) {
            result += pairing.getGiver().getName() + " ==> " + pairing.getReceiver().getName();
        } else {
            System.out.println(pairing.getGiver().getName() + " ==> " + "***");
        }
        return result;
    }

    public String displayNameList(ArrayList<Participant> list) {
        String result = "";
        int i = 1;
        for (Participant participant : participants) {
            result += (i++) + ") " + participant.getName();
            if (participant.getSpouse() == null) {
                result += " (single)";
            } else {
                result += " (in couple)";
            }
            result += "\n";
        }
        return result;
    }

    public void displayConsultationCounter(){
        int value;
        boolean valid = false;
        if(!drawLocked) {
            System.out.println(ERR_DRAW_UNLOCKED);
            pause();
        } else {
            displayNameList(participants);
            System.out.println(INPUT_NUMBER_COUNTER);
            while (!valid){
                try {
                    value = scanner.nextInt();
                    Participant selected = participants.get(value - 1);
                    System.out.println(selected.getName() + " has consulted his/her secret santa " + selected.getConsultationCount() + " time(s)!");
                    valid = true;

                    pause();
                } catch (IndexOutOfBoundsException e){
                    System.out.println(ERR_WRONG_NUMBER + (participants.size()) + Colors.RESET);
                    pause();
                }
            }
        }
    }

    public void resetDraw(){
        pairings.clear();
        drawLocked = false;
        System.out.println(MSG_DRAW_RESET);
        pause();
    }

    public void pause(){
        scanner.nextLine();
        System.out.println(INPUT_ENTER_TO_CONTINUE);
        scanner.nextLine();
    }

    public void showMenu() {
        System.out.println("\n" + MENU_SECRET_SANTA);
        System.out.println("1. Add participant");
        System.out.println("2. Define couple");
        System.out.println("3. Generate draw");
        System.out.println("4. Consult result");
        System.out.println("5. Show all results");
        System.out.println("6. Show consultation stats");
        System.out.println("7. Reset");
        System.out.println("0. Exit");
        System.out.println("");
        System.out.print("Select an option : ");
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
                    System.out.println(ERR_ZERO_TO_SEVEN);
                }

                switch (choice) {
                    case 1 -> addParticipant();
                    case 2 -> defineCouple();
                    case 3 -> generateDraw();
                    case 4 -> consultAssignment();
                    case 5 -> consultAllAssignments();
                    case 6 -> displayConsultationCounter();
                    case 7 -> resetDraw();
                    case 0 -> running = false;
                    default -> System.out.println(ERR_ZERO_TO_SEVEN);
                }
            } catch (InputMismatchException e){
                System.out.println(ERR_ZERO_TO_SEVEN);
            }
        }
        System.out.println("Goodbye!!!");
    }
}
