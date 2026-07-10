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
        return spouse;
    }

    public int getConsultationCount() {
        return consultationCounter;
    }

    public void incrementCounter() {
        consultationCounter++;
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
