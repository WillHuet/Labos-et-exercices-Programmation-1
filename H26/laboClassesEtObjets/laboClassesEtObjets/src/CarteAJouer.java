public class CarteAJouer {
    // VARIABLES
    private int valeur;
    private String couleur;

    public CarteAJouer(){
        this.valeur = 0;
        this.couleur = "";
    }

    public CarteAJouer(int valeur, String couleur){
        this.valeur = valeur;
        this.couleur = couleur;
    }

    // GETTERS
    public int getValeur(){
        return this.valeur;
    }
    public String getCouleur(){
        return this.couleur;
    }

    // SETTERS
    public void setValeur(int valeur){
        this.valeur = valeur;
    }
    public void setCouleur(String couleur){
        this.couleur = couleur;
    }

    //MÉTHODES
    private String valeurEcrite(int valeur){
        String nom = "";
        if (valeur >= 1 && valeur <= 13){
            switch (valeur){
                case 1:
                    nom = "As";
                    break;
                case 11:
                    nom = "Valet";
                    break;
                case 12:
                    nom = "Dame";
                    break;
                case 13:
                    nom = "Roi";
                    break;
                default:
                    nom = Integer.toString(valeur);
            }
        } else {
            nom = "Valeur inconnue";
        }
        return nom;
    }

    private String couleurEcrite(String couleur){
        String nomCouleur = "";
        switch (couleur.toLowerCase()){
            case "coeur":
                nomCouleur = "Coeur";
                break;
            case "carreau":
                nomCouleur = "Carreau";
                break;
            case "trèfle":
                nomCouleur = "Trèfle";
                break;
            case "pique":
                nomCouleur = "Pique";
                break;
            default:
                nomCouleur = "Couleur inconnue";
        }
        return nomCouleur;
    }

    public void afficher(){
        System.out.printf("%-8s: %s%n", "Valeur", valeurEcrite(valeur));
        System.out.printf("%-8s: %s%n", "Couleur", couleurEcrite(couleur));
    }
}
