import java.util.*;

public class SecretSanta {
    //VARIABLES
    private ArrayList<Participant> participants;
    private ArrayList<Pairing> pairings;
    private boolean drawLocked;

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

    public void addParticipant(Participant participant) {
        if(drawLocked) {
            throw new IllegalStateException("Cannot add participant after the draw is locked!");
        }

        for(Participant p : participants) {
            if(p.getName().equalsIgnoreCase(participant.getName())) {
                throw new IllegalArgumentException("Participant already exists!");
            }
        }

        participants.add(participant);
    }

    public static void marry(Participant p1, Participant p2) {
        p1.setSpouse(p2);
        p2.setSpouse(p1);
    }

    public void generateDraw(){
        if(participants.size() < 2) {
            throw new IllegalStateException("Not enough participants!");
        }

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
        System.out.print("Choice: ");
    }

    //MAIN EXÉCUTABLE (POUR TESTER)
    public static void main(String[] args) {
        SecretSanta s = new SecretSanta();
    }
}
