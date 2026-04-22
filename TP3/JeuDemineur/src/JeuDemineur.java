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
        this.grilleJeuSolution = TP3Util.construireGrilleJeuSolution(nbrLignesGrille, nbrColGrille, nbrMines);
        this.grilleJeuCache = new char[nbrLignesGrille][nbrColGrille];

        nbrCasesSansMineDecouvertes = 0;
        nbrPartiesJouees = 0;
        nbrPartiesPerdues = 0;
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

    public boolean isPartiePerdue(){
        return this.partiePerdue;
    }

    /*
    //  ++++++++++++++++++++++++++++++++++
    //  + MÉTHODES D'INSTANCE PUBLIQUES +
    //  ++++++++++++++++++++++++++++++++++
    */
    public void decouvrirUneCase(Case uneCase){

    }

    public void reinitialiserPartie(){
        for (char[] tab : grilleJeuCache){
            for (char c : tab){
                c = ESPACE;
            }
        }
        nbrCasesSansMineDecouvertes = 0;
        partieGagnee = false;
        partiePerdue = false;
    }

    public String grilleToString(){
        String resultat = "";

        //EN-TÊTE
        resultat += "    ";
        for (int c = 1; c <= this.nbrColGrille; c++) {
            resultat += c + "   ";
        }
        resultat += "\n  ";

        for (int c = 1; c <= this.nbrColGrille; c++) {
            resultat += "----";
        }
        resultat += "-\n";

        for (int c = 1; c <= nbrLignesGrille; c++) {
            resultat += c + " |";
            for (int d = 1; d <= this.nbrColGrille; d++) {
                resultat +=  "   |";
            }
            resultat += "\n  ";

            for (int r = 1; r <= this.nbrColGrille; r++) {
                resultat += "----";
            }
            resultat += "-\n";
        }

        return resultat;
    }

    public int pourcentageAcheve(){
        int nbrCasesTotalSansMine = (this.nbrColGrille * this.nbrLignesGrille) - this.nbrMines;

        double pourcentage = ((double) this.nbrCasesSansMineDecouvertes / nbrCasesTotalSansMine) * 100;
        return (int)pourcentage;
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
    static void main(String[] args){
        JeuDemineur jeuDemineur = new JeuDemineur(3,7,4);
        System.out.print(jeuDemineur.grilleToString());
    }
}
