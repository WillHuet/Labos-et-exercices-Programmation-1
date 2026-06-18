import java.util.*;

public class SecretSanta {
    //VARIABLES
    private List<Participant> participants;
    private Map<Participant, Participant> assignedParticipants;
    private boolean drawLocked;

    //CONSTRUCTEUR
    public SecretSanta() {
        participants = new ArrayList<>();
        assignedParticipants = new HashMap<>();
        drawLocked = false;
    }

    //MÉTHODES
    public void addParticipant (Participant p) {
        if(drawLocked || participants.contains(p)) {
            throw new IllegalStateException("Cannot add participant after the draw is locked!");
        } else{
            participants.add(p);
        }
    }

    public void generateDraw(){
        boolean valid = false;

        if(participants.size() <= 1){
            throw new IllegalStateException("Cannot generate a draw, not enough participants!");
        }

        List<Participant> receivers = new ArrayList<>(participants);
        Collections.shuffle(receivers);

        while (!valid){
            valid = true;
            Collections.shuffle(receivers);

            for (int i = 0; i < participants.size(); i++) {
                Participant giver = participants.get(i);
                Participant receiver = receivers.get(i);

                if (giver.equals(receiver) ||
                        (giver.getSpouse() != null && giver.getSpouse().equals(receiver))) {
                    valid = false;
                    break;
                }

                assignedParticipants.put(giver, receiver);
            }
        }

        drawLocked = true;
    }

    public void consultAllAssignments(){
        for (Map.Entry<Participant, Participant> entry : assignedParticipants.entrySet()) {
            System.out.printf("%s -> %s\n", entry.getKey().getName(), entry.getValue().getName());
        }
    }

    public String consultOneAssignment(Participant p){
        if (!assignedParticipants.containsKey(p)) {
            throw new IllegalStateException("Participant is not included in the draw!");
        }

        return assignedParticipants.get(p).getName();
    }

    public void resetDraw(){
        assignedParticipants.clear();
        drawLocked = false;
    }
}
