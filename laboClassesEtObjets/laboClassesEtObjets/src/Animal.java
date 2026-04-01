public class Animal {

    // VARIABLES
    private String nom;
    private int sorte;
    private String race;
    private String proprietaire;

    // CONSTANTES
    // ...

    //CONSTRUCTEUR PAR DÉFAUT
    public Animal(){
        this.nom = "";
        this.sorte = 0;
        this.race = "";
        this.proprietaire = "";
    }

    // CONSTRUCTEUR AVEC PARAMÈTRES
    public Animal(String nom, int sorte, String race, String proprietaire){
        this.nom = nom;
        this.sorte = sorte;
        this.race = race;
        this.proprietaire = proprietaire;
    }

    // GETTERS
    public String getNom(){
        return this.nom;
    }
    public int getSorte(){
        return this.sorte;
    }

    public String getRace(){
        return this.race;
    }
    public String getProprietaire(){
        return this.proprietaire;
    }

    // SETTERS
    public void setNom(String nom){
        this.nom = nom;
    }
    public void setSorte(int sorte){
        this.sorte = sorte;
    }

    public void setRace(String race){
        this.race = race;
    }
    public void setProprietaire(String proprietaire){
        this.proprietaire = proprietaire;
    }

    // MÉTHODES

    private String typeAnimal(int chiffre){
        String type = "";
        if(chiffre == 0){
            type = "Inconnu ou autre";
        } else if(sorte == 1){
            type = "Chat";
        } else if(sorte == 2){
            type = "Chien";
        }
        return type;
    }

    public void afficher(){
        System.out.printf("%-8s: %s%n", "Nom", nom);
        System.out.printf("%-8s: %s%n", "Sorte", typeAnimal(sorte));
        System.out.printf("%-8s: %s%n", "Race", race);
        System.out.printf("%-8s: %s%n", "Proprio", proprietaire);
    }

}
