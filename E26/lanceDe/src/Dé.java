import java.util.Random;

public class Dé {
    public int valeur;


    public Dé(int valeur) {
        this.valeur = valeur;
    }

    public int getValeur() {
        return valeur;
    }

    public void setValeur(int valeur) {
        this.valeur = valeur;
    }

    public static int lancerDe(){
        Random rand = new Random();
        return rand.nextInt(6) + 1;
    }
}
