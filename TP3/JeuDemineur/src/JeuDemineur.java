public class JeuDemineur {

    /*
    //  ++++++++++++++
    //  + CONSTANTES +
    //  ++++++++++++++
    */
    public static final char ESPACE = ' ';
    public static final char MINES = '*';

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
    public static int nbrPartiesJouees = 0;
    public static int nbrPartiesPerdues = 0;

    /*
    //  +++++++++++++++++++++++++
    //  + CONSTRUCTEURS PUBLICS +
    //  +++++++++++++++++++++++++
    */
    public JeuDemineur(int nbrLignesGrille, int nbrColGrille, int nbrMines) {
        this.nbrLignesGrille = validationNbrDeLignes(nbrLignesGrille);
        this.nbrColGrille = validationNbrDeLignes(nbrColGrille);
        this.nbrMines = validationNbrDeMines(this.nbrLignesGrille, this.nbrColGrille, nbrMines);

        this.grilleJeuSolution = TP3Util.construireGrilleJeuSolution(this.nbrLignesGrille, this.nbrColGrille, this.nbrMines);

        this.grilleJeuCache = new char[this.nbrLignesGrille][this.nbrColGrille];
        for (int i = 0; i < this.nbrLignesGrille; i++) {
            for (int j = 0; j < this.nbrColGrille; j++) {
                grilleJeuCache[i][j] = ESPACE;
            }
        }

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

    public boolean validationEmplacementCase(int ligne, int col){
        boolean resultat;

        if (ligne < 0 || ligne >= nbrLignesGrille || col < 0 || col >= nbrColGrille) {
            resultat = false;
        } else {
            resultat = true;
        }

        return resultat;
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
        int ligne = uneCase.getNoLigne() -1;
        int col = uneCase.getNoColonne() -1;

        grilleJeuCache[ligne][col] = grilleJeuSolution[ligne][col];
    }

    public void reinitialiserPartie(){
        for (int i = 0; i < nbrLignesGrille; i++) {
            for (int j = 0; j < nbrColGrille; j++) {
                grilleJeuCache[i][j] = ESPACE;
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
        double pourcentage = 0;
        int nbrCasesTotalSansMine = (nbrColGrille * nbrLignesGrille) - nbrMines;

        if(partieGagnee){
            pourcentage = 100;
        } else{
            pourcentage = nbrCasesSansMineDecouvertes / nbrCasesTotalSansMine * 100;
        }

        return (int) Math.round(pourcentage);
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

    public static int getNbrPartiesPerdues() {
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
