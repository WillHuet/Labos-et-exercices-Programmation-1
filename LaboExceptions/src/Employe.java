public class Employe {
    //attribut de classe
    private static int dernierNumero = 0;

    //attributs d'instance
    private String nomDeFamille;
    private String prenom;
    private int numero;
    private int nbrAnnees;
    private double salaire;

    public Employe(String nomdeDeFamille, String prenom, int nbrAnnees, double salaire){
        this.nomDeFamille = nomdeDeFamille;
        this.prenom = prenom;
        this.nbrAnnees = nbrAnnees;
        this.salaire = salaire;
        dernierNumero = dernierNumero + 1;
        numero = dernierNumero;
    }

    public String getNomDeFamille(){
        return nomDeFamille;
    }

    public String getPrenom() {
        return prenom;
    }

    public int getNbrAnnees() {
        return nbrAnnees;
    }

    public int getNumero() {
        return numero;
    }

    public double getSalaire() {
        return salaire;
    }

    public void setNomDeFamille(String nomDeFamille) {
        this.nomDeFamille = nomDeFamille;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setNbrAnnees(int nbrAnnees) {
        this.nbrAnnees = nbrAnnees;
    }

    public void setSalaire(double salaire) {
        this.salaire = salaire;
    }
}
