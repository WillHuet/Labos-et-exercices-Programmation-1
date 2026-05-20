/**
 * Cette classe contient tous les méthodes nécessaires pour faire fonctionner un jeu de démineur.
 * Comme il n'y a pas de méthode exécutable "main", cette en-tête sera courte.
 * Cependant, des commentaires expliquant le fonctionnement de chaque méthode seront présent ci-dessous.
 *
 * Cette classe comporte un nombre multiple de constantes et attributs d'instance.
 * Elle possède également un seul constructeur prenant 3 paramètres.
 *
 * On peut retrouver à la fin du code les méthodes qui ne sont pas requises dans l'énoncé du TP.
 * Je les ai écrite afin de raffiner le code et éviter les doublons.
 *
 * @author William Huet (HUEW75120205)
 * @version H26
 */
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
    //  +++++++++++++++++++++++
    //  + CONSTRUCTEUR PUBLIC +
    //  +++++++++++++++++++++++
    */

    /**
     * Seul et unique constructeur de la classe "JeuDemineur".
     * Celui-ci établi principalement la dimension de la grille ainsi que le nombre de mines.
     * On construit également les deux grilles nécéssaires pour le fonctionnement du jeu (grilleJeuCache et grilleJeuSolution).
     * À la fin, on initialise d'autres attributs, incluant les attributs de classes (nbrPartiesJouees & nbrPartiesPerdues)
     *
     * @param nbrLignesGrille représente le nombre de lignes de la grille (verticale).
     * @param nbrColGrille représente le nombre de colonnes de la grille (horizontale).
     * @param nbrMines représente le mine dispersée dans la grille.
     */
    public JeuDemineur(int nbrLignesGrille, int nbrColGrille, int nbrMines) {
        this.nbrLignesGrille = validationNbrDeLignes(nbrLignesGrille);
        this.nbrColGrille = validationNbrDeLignes(nbrColGrille);
        this.nbrMines = validationNbrDeMines(this.nbrLignesGrille, this.nbrColGrille, nbrMines);

        this.grilleJeuSolution = TP3Util.construireGrilleJeuSolution(this.nbrLignesGrille, this.nbrColGrille, this.nbrMines);

        this.grilleJeuCache = new char[this.nbrLignesGrille][this.nbrColGrille];
        viderGrilleCache();

        nbrCasesSansMineDecouvertes = 0;
        nbrPartiesJouees = 0;
        nbrPartiesPerdues = 0;
    }

    /*
    //  +++++++++++
    //  + GETTERS +
    //  +++++++++++
    */

    /**
     * Les 6 prochaines méthodes représentent nos observateurs (getters).
     * (méthode qui nous permettent de récupérer les informations sur notre partie de démineur)
     *
     * getNbrLignesGrille() retourne le nombre de lignes.
     * getNbrColGrille() retourne le nombre de colonnes.
     * getNbrMines() retourne le nombre de mines total.
     * getNbrCasesSansMineDecouvertes() retourne le nombre de case total excluant celles avec des mines.
     * isPartieGagnee() retourne vrai si la partie est remportée.
     * isPartiePerdue() retourne vrai si la partie est perdue.
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

    /**
     * Méthode qui permet de découvrir le résultat d'une case.
     *
     * En premier lieu, on souhaite déterminer l'emplacement de la case (sa position dans notre tableau char[][]).
     * Pour cela, on doit récupérer la ligne et la colonne de la dite case.
     *
     * Ensuite, on veut valider que la case est se situe bien dans notre grille (ligne et colonne respectant les dimensions).
     * On souhaite également valider que la case que l'on souhaite analyser n'a pas été découverte.
     * Si l'un des deux cas est vrai, la méthode s'arrête ici (d'ou l'utilisation du "return").
     *
     * Si la case est conforme et n'a pas déjà été validée, on prend la valeur de la case de la grilleJeuSolution et l'applique à notre grilleJeuCache.
     * Si cette case est une mine, on met fin au jeu en appliquant la valeur true à "partiePerdue" et en ajoutant un à "nbrPartiesJouees" et "nbrPartiesPerdues".
     *
     * Si cette case est un espace, on ajoute un à "nbrCasesSansMineDecouvertes".
     * On valide si jamais toutes les cases sans mines ont été trouvées.
     * Si c'est le cas, on met fin au jeu en appliquant la valeur true à "partieGagnee" et en ajoutant un à "nbrPartiesJouees".
     *
     * @param uneCase représente la case que l'on souhaite analyser.
     */
    public void decouvrirUneCase(Case uneCase){
        int ligne = uneCase.getNoLigne() -1;
        int col = uneCase.getNoColonne() -1;

        int nbrCasesTotalSansMine = (nbrColGrille * nbrLignesGrille) - nbrMines;

        if (ligne < 0 || ligne >= nbrLignesGrille || col < 0 || col >= nbrColGrille) {
            return;
        }

        if (grilleJeuCache[ligne][col] != ESPACE || partieGagnee || partiePerdue) {
            return;
        }

        grilleJeuCache[ligne][col] = grilleJeuSolution[ligne][col];

        if (grilleJeuSolution[ligne][col] == MINES) {
            partiePerdue = true;
            nbrPartiesPerdues++;
            nbrPartiesJouees++;
        } else {
            nbrCasesSansMineDecouvertes++;
            if (nbrCasesSansMineDecouvertes == nbrCasesTotalSansMine) {
                partieGagnee = true;
                nbrPartiesJouees++;
            }
        }
    }

    /**
     * Méthode qui permet de réinitialiser la partie sans changer l'état de la grilleJeuSolution.
     *
     * On appelle la méthode "viderGrilleCache()" pour remplacer la valeur de tous les caractères par ESPACE (' ').
     * On réinitialise le nombre de case découvertes.
     * On réinitialise la valeur de "partieGagnee" et "partiePerdue" à FALSE.
     */
    public void reinitialiserPartie(){
        viderGrilleCache();

        nbrCasesSansMineDecouvertes = 0;
        partieGagnee = false;
        partiePerdue = false;
    }

    /**
     * Méthode qui permet de convertir visuellement notre grilleJeuCache.
     * On initialise premièrement un String vide. On va ajouter des caractères au fur et à mesure.
     *
     * On retourne en premier l'en-tête. La grandeur de celle-ci varie selon le nombre de colonnes.
     * On ajoute ensuite une ligne séparatrice qui sépare l'en-tête du tableau.
     *
     * On retourne ensuite chaque ligne suivi d'une ligne séparatrice.
     * Chacune d'entres elles est composée du numéro de la ligne, suivi par les cases avec les valeurs de la grilleJeuCache à l'intérieur.
     * À la fin, on stipule que l'on souhaite faire un saut de ligne pour passer à la ligne suivante SAUF si c'est la dernière.
     */
    public String grilleToString(){
        String resultat = "";

        //-------
        //EN-TÊTE
        //-------

        //LIGNE EN-TÊTE
        resultat += "    ";
        for (int i = 1; i <= nbrColGrille; i++) {
            resultat += i+ "  ";
            if (i != nbrColGrille) {
                resultat += " ";
            }
        }
        resultat += "\n";

        //LIGNE SÉPARATRICE EN-TÊTE
        resultat += "  ";
        for (int i = 0; i < nbrColGrille; i++) {
            resultat += "----";
        }
        resultat += "-\n";

        //------
        //GRILLE
        //------

        //LIGNES (index = l pour "ligne")
        for (int l = 0; l < nbrLignesGrille; l++) {
            resultat += (l + 1) + " |";

            //COLONNES (index = c pour "colonne")
            for (int c = 0; c < nbrColGrille; c++) {
                resultat += " " + grilleJeuCache[l][c] + " |";
            }
            resultat += "\n";

            //LIGNES SÉPARATRICES (pour lignes)
            resultat += "  ";
            for (int c = 0; c < nbrColGrille; c++) {
                resultat += "----";
            }
            resultat += "-";

            //SAUT DE LIGNE APRÈS LIGNES SÉPARATRICES (POUR TOUTES SAUF LA DERNIÈRE, sinon erreur de nombre de caractères)
            if (l < nbrLignesGrille - 1) {
                resultat += "\n";
            }
        }

        return resultat;
    }

    /**
     * Méthode qui donne le pourcentage de cases découvertes.
     * Le résultat du pourcentage est arrondi avec "Math.round()" pour avoir un entier.
     */
    public int pourcentageAcheve(){
        double pourcentage = 0.00;
        int nbrCasesTotalSansMine = (nbrColGrille * nbrLignesGrille) - nbrMines;

        if(partieGagnee){
            pourcentage = 100;
        } else if (nbrCasesSansMineDecouvertes > 0){
            pourcentage = (double) nbrCasesSansMineDecouvertes / nbrCasesTotalSansMine * 100;
        }

        return (int) Math.round(pourcentage);
    }

    /**
     * Méthode qui retourne la dimension de notre grille, le nombre de mines total et le pourcentage accompli à date.
     * EX: "Grille 4 X 6 (10 mines) => 100 % acheve."
     */
    public String toString(){
        return "Grille " + nbrLignesGrille + " X " + nbrColGrille + " (" + nbrMines+ " mines) => " + pourcentageAcheve() + " % acheve.";
    }

    /*
    //  ++++++++++++++++++++++++++++++++
    //  + MÉTHODES DE CLASSE PUBLIQUES +
    //  ++++++++++++++++++++++++++++++++
    */

    /**
     * Les 2 prochaines méthodes représentent nos méthodes de classe publiques.
     *
     * getNbrPartiesJouees() retourne le nombre de parties jouées au total.
     * getNbrPartiesPerdues() retourne le nombre de parties perdues au total.
     */
    public static int getNbrPartiesJouees() {
        return nbrPartiesJouees;
    }

    public static int getNbrPartiesPerdues() {
        return nbrPartiesPerdues;
    }

    /*
    //  ++++++++++++++++++++++++++++
    //  + MÉTHODES SUPPLÉMENTAIRES +
    //  ++++++++++++++++++++++++++++
    */

    /**
     * Méthode qui valide le nombre de lignes lors de l'initialisation de notre grille.
     * Le minimum est 3 alors que le maximum est 8.
     *
     * Si la valeur rentrée est plus petite que le minimum, on met le minimum à sa place.
     * Si la valeur rentrée est plus grande que le maximum, on met le maximum à sa place.
     *
     * @param nbrLignes représente le nombre de lignes (ou colonnes) que l'on souhaite valider.
     */
    public int validationNbrDeLignes(int nbrLignes){
        int minDeLignes = 3;
        int maxDeLignes = 8;
        if (nbrLignes <= minDeLignes){
            return minDeLignes;
        } else return Math.min(nbrLignes, maxDeLignes);
    }

    /**
     * Méthode qui valide le nombre de mines lors de l'initialisation de notre grille.
     * Le minimum de mines est représenté par le plus grand nombre entre le nbrLignesGrille et nbrColGrille.
     * Le maximum de mines est représenté la grandeur totale de notre grille, moins la valeur minimum de mines.
     *
     * Si la valeur rentrée est plus petite que le minimum, on met le minimum à sa place.
     * Si la valeur rentrée est plus grande que le maximum, on met le maximum à sa place.
     *
     * @param nbrLignesGrille représente le nombre de lignes de notre grille.
     * @param nbrColGrille représente le nombre de colonnes de notre grille.
     * @param nbrMines représente le nombre de mines que l'on souhaite valider.
     */
    public int validationNbrDeMines(int nbrLignesGrille, int nbrColGrille, int nbrMines) {
        int minDeMines = Math.max(nbrLignesGrille, nbrColGrille);
        int maxDeMines = (nbrLignesGrille * nbrColGrille) - minDeMines;

        if (nbrMines <= minDeMines) {
            return minDeMines;
        } else return Math.min(nbrMines, maxDeMines);
    }

    /**
     * Méthode qui vide notre grilleJeuCache.
     * Pour faire cela, on doit tout simplement remplacer tous les caractères de notre tableau char[][] par des ESPACES (' ').
     */
    public void viderGrilleCache(){
        for (int i = 0; i < nbrLignesGrille; i++) {
            for (int j = 0; j < nbrColGrille; j++) {
                grilleJeuCache[i][j] = ESPACE;
            }
        }
    }
}
