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
    //  +++++++++++++++++++++++++
    //  + CLASSES DE VALIDATION +
    //  +++++++++++++++++++++++++
    */
    public int validationNbrDeLignes(int nbrLignes){
        int minDeLignes = 3;
        int maxDeLignes = 8;
        if (nbrLignes <= minDeLignes){
            return minDeLignes;
        } else if (nbrLignes >= maxDeLignes) {
            return maxDeLignes;
        } else {
            return nbrLignes;
        }
    }

    public int validationNbrDeMines(int nbrLignesGrille, int nbrColGrille, int nbrMines) {
        int minDeMines = Math.max(nbrLignesGrille, nbrColGrille);
        int maxDeMines = (nbrLignesGrille * nbrColGrille) - minDeMines;

        if (nbrMines <= minDeMines) {
            return minDeMines;
        } else if (nbrMines >= maxDeMines) {
            return maxDeMines;
        } else {
            return nbrMines;
        }
    }
}
