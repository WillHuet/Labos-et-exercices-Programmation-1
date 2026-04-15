public class JeuDemineur {

    /*
    //  ++++++++++++++
    //  + CONSTANTES +
    //  ++++++++++++++
    */
    public final char ESPACE = ' ';
    public final char MINES = '*';

    /*
    //  ++++++++++++++++++++++++
    //  + ATTRIBUTS D'INSTANCE +
    //  ++++++++++++++++++++++++
    */
    public int nbrLignesGrille;
    public int nbrColGrille;
    public int nbrMines;
    public char[][] grilleJeuCache;
    public char[][] grilleJeuSolution;
    public int nbrCasesSansMineDecouvertes;
    public boolean partieGagnee = false;
    public boolean partiePerdue = false;

    /*
    //  +++++++++++++++++++++++
    //  + ATTRIBUTS DE CLASSE +
    //  +++++++++++++++++++++++
    */
    public static int nbrPartiesJouees;
    public static int nbrPartiesPerdues;

    /*
    //  +++++++++++++++++++++++++
    //  + CONSTRUCTEURS PUBLICS +
    //  +++++++++++++++++++++++++
    */
    public JeuDemineur(int nbrLignesGrille, int nbrColGrille, int nbrMines) {
        this.nbrLignesGrille = validationNbrDeLignes(nbrLignesGrille);
        this.nbrColGrille = validationNbrDeLignes(nbrColGrille);
        this.nbrMines = validationNbrDeMines(this.nbrLignesGrille, this.nbrColGrille, nbrMines);


    }

    /*
    //  ++++++++++++++++++++++++++
    //  + MÉTHODES DE VALIDATION +
    //  ++++++++++++++++++++++++++
    */
    public int validationNbrDeLignes(int nbrLignes){
        int minDeLignes = 3;
        int maxDeLignes = 8;
        if (nbrLignes <= minDeLignes){
            return minDeLignes;
        } else return Math.min(nbrLignes, maxDeLignes);
    }

    public int validationNbrDeMines(int nbrLignesGrille, int nbrColGrille, int nbrMines) {
        int minDeMines = Math.max(nbrLignesGrille, nbrColGrille);
        int maxDeMines = (nbrLignesGrille * nbrColGrille) - minDeMines;

        if (nbrMines <= minDeMines) {
            return minDeMines;
        } else return Math.min(nbrMines, maxDeMines);
    }

    /*
    //  +++++++++++
    //  + GETTERS +
    //  +++++++++++
    */
    public int getNbrLignesGrille(){
        return this.nbrLignesGrille;
    }

    public int getNbrColGrille(){
        return this.nbrColGrille;
    }

    public int getNbrMines(){
        return this.nbrMines;
    }

    public int getNbrCasesSansMineDecouvertes(){
        return this.nbrCasesSansMineDecouvertes;
    }

    public boolean isPartieGagnee(){
        return this.partieGagnee;
    }

    public  boolean isPartiePerdue(){
        return this.partiePerdue;
    }

    /*
    //  ++++++++++++++++++++++++++++++++++
    //  + MÉTHODES D'INSTANCE PUBLIQUES +
    //  ++++++++++++++++++++++++++++++++++
    */
    public static void decouvrirUneCase(Case uneCase){

    }

    public static void reinitialiserPartie(){

    }

    public static String grilleToString(){
        String resultat = "";

        //EN-TÊTE
        resultat += "    ";
        for (int c = 1; c <= 8; c++) {
            resultat += c + "   ";
        }
        resultat += "\n";

        for (int c = 1; c <= 8; c++) {
            resultat += "----";
        }
        resultat += "---\n";

        for (int c = 1; c <= 8; c++) {
            resultat += c + " |";
            for (int d = 1; d <= 8; d++) {
                resultat += "   |";
            }
            resultat += "\n";

            for (int r = 1; r <= 8; r++) {
                resultat += "----";
            }
            resultat += "---\n";
        }

        return resultat;
    }

    public static int pourcentageAcheve(){
        return 0;
    }

    public String toString(){
        return null;
    }

    /*
    //  ++++++++++++++++++++++++++++++++
    //  + MÉTHODES DE CLASSE PUBLIQUES +
    //  ++++++++++++++++++++++++++++++++
    */
    public static int getNbrPartiesJouees() {
        return nbrPartiesJouees;
    }

    public  static int getNbrPartiesPerdues() {
        return nbrPartiesPerdues;
    }

    /*
    //  +++++++++++++++++++
    //  + MAIN EXÉCUTABLE +
    //  +++++++++++++++++++
    */
    public static void main(String[] args){
        JeuDemineur jeuDemineur = new JeuDemineur(3,3,4);
        System.out.print(grilleToString());
    }
}
