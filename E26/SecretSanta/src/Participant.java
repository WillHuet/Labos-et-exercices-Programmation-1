public class Participant {

    //VARIABLES
    private String name;
    private Participant spouse;
    private int consultationCounter;

    //CONSTRUCTEUR
    public Participant(String name, Participant spouse) {
        this.name = name;
        this.spouse = null;
        this.consultationCounter = 0;
    }

    //GETTERS - SETTERS
    public String getName() {
        return name;
    }

    public Participant getSpouse() {
        if (spouse == null) {
            throw new IllegalStateException("This participant doesn't have a spouse!");
        }
        return spouse;
    }

    public int getConsultationCount() {
        return consultationCounter;
    }

    public void incrementCounter() {
        consultationCounter++;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSpouse(Participant spouse) {
        this.spouse = spouse;
    }

    //ToString()
    @Override
    public String toString(){
        return this.name;
    }

}
