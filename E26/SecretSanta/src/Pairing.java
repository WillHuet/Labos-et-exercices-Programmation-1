public class Pairing {
    private Participant giver;
    private Participant receiver;

    public Pairing(Participant giver, Participant receiver) {
        this.giver = giver;
        this.receiver = receiver;
    }

    public Participant getGiver() {
        return giver;
    }

    public Participant getReceiver() {
        return receiver;
    }
}
