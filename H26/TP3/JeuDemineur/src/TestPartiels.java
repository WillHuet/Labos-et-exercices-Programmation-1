import javax.swing.JOptionPane;

/**
 * Classe de tests PARTIELS pour la classe JeuDemineur - TP3 INF1120.
 *
 * Attention, cette classe de tests ne teste pas tous les cas. 
 * VOUS DEVEZ faire aussi vos propres tests, plus complets.
 *
 * Importez cette classe dans votre projet et executez sa methode main. 
 * Verifier, dans l'affichage a la console, que les valeurs attendues entre 
 * parentheses sont egales aux valeurs obtenues devant les parentheses. 
 * Si ce n'est pas le cas, le test a echoue. Par exemple : 
 *
 *   false (false)  -> Succès
 *   false (true)   -> Échec
 *   6 (6)          -> Succès
 *   6 (7)          -> Échec
 *
 * Aussi, parfois, on écrira OK (test réussi) ou ERREUR (test non réussi)
 *
 * Si les tests plantent, il y a une erreur dans votre code.
 *
 * @author Melanie Lord
 * @version H26
 */
public class TestPartiels {

    public static final String AVERTISSEMENT =
            "\n1) Ces tests ne sont pas complets (faites aussi vos propres tests).\n"
                    + "\n2) Ces tests partiels ne verifient pas le type des grilles du jeu solution et du jeu "
                    + "cache.\n   Assurez-vous de bien utiliser le type char[ ][ ] pour les deux grilles, sinon"
                    + " les tests qu'on\n   va effectuer pour la correction ne compileront pas, et puisqu'on"
                    + " ne pourra pas tester\n   votre programme, vous obtiendrez la note 0.";

    /**
     * Afficher message avertissement
     */
    public static void avertissement (String msg) {
        JOptionPane.showMessageDialog(null, msg, "ATTENTION",
                JOptionPane.WARNING_MESSAGE);
    }

    /**
     * Construit une chaine compose de s en majuscules, encadree avec une ligne
     * au-dessus et une ligne en-dessous.
     * @param s la chaine a mettre en majuscule et a encadrer.
     * @return une chaine compose de s en majuscules, encadree avec une ligne
     * au-dessus et une ligne en-dessous.
     */
    private static String maj (String s) {
        String tmp = "";
        for (int i = 1 ; i <= s.length() ; i++) {
            tmp = tmp + "-";
        }
        return "\n" + tmp + "\n" + s.toUpperCase() + "\n" + tmp + "\n";
    }

    /**
     * Verifie si attendu est egale a obtenu.
     * @param attendu chaine qu'on devrait obtenir, celle attendue
     * @param obtenu  chaine obtenue
     */
    private static void comparer(String attendu, String obtenu) {
        char cAttendu;
        char cObtenu;
        int longAttendue;
        int longObtenue;
        String msgErr = "";

        if (obtenu == null) {
            System.out.println("\njeu.grilleToString() => ERREUR : la chaine obtenue est null et ne devrait pas.");
        } else {
            longAttendue = attendu.length();
            longObtenue = obtenu.length();

            if (longAttendue != longObtenue) {
                System.out.println("\njeu.grilleToString() => ERREUR : la longueur de la chaine attendue (" + longAttendue +
                        ")\nest différente de la longueur de la chaine obtenue (" + longObtenue + ")");
                System.out.println("\nCHAINE ATTENDUE :\n\n" + attendu + "\n");
                System.out.println("CHAINE OBTENUE  :\n\n" + obtenu + "\n");

            } else {
                for (int i = 0 ; i < attendu.length() ; i++) {
                    cAttendu = attendu.charAt(i);
                    cObtenu = obtenu.charAt(i);

                    if (cAttendu != cObtenu) {
                        msgErr = msgErr + "   - Caracteres a l'indice " + i + " differents : "
                                + "'" + cAttendu + "' (attendu) different de '"
                                + cObtenu + "' (obtenu).\n";
                    }
                }

                if (!msgErr.isEmpty()) {
                    System.out.println("\njeu.grilleToString() => ERREUR :\n" + msgErr);
                    System.out.println("\nCHAINE ATTENDUE :\n\n" + attendu + "\n");
                    System.out.println("CHAINE OBTENUE  :\n\n" + obtenu + "\n");

                } else {
                    System.out.println("jeu.grilleToString() => OK");
                }
            }
        }

    }

    /**
     * Application pour tester la classe JeuDemineur.
     * @param args (non utilisé)
     */
    public static void main (String[] args) {
        String sAttendue;
        String sObtenue;

        //Commentez cette ligne pour arreter de voir le message pop up
        //d'avertissement au debut du programme.
        avertissement(AVERTISSEMENT);

        System.out.println(maj("1. Creation d'un demineur 4x5 avec 9 mines"));

        JeuDemineur jeu = new JeuDemineur(4, 5, 9);
        System.out.println(jeu.getNbrLignesGrille() + " (4)");
        System.out.println(jeu.getNbrColGrille() + " (5)");
        System.out.println(jeu.getNbrMines() + " (9)");
        System.out.println(jeu.getNbrCasesSansMineDecouvertes() + " (0)");
        System.out.println(jeu.isPartieGagnee() + " (false)");
        System.out.println(jeu.isPartiePerdue() + " (false)");
        System.out.println(jeu.pourcentageAcheve() + " (0)");
        System.out.println(JeuDemineur.getNbrPartiesJouees() + " (0)");
        System.out.println(JeuDemineur.getNbrPartiesPerdues() + " (0)");

        sAttendue =    "    1   2   3   4   5  \n" +
                "  ---------------------\n" +
                "1 |   |   |   |   |   |\n" +
                "  ---------------------\n" +
                "2 |   |   |   |   |   |\n" +
                "  ---------------------\n" +
                "3 |   |   |   |   |   |\n" +
                "  ---------------------\n" +
                "4 |   |   |   |   |   |\n" +
                "  ---------------------";

        sObtenue = jeu.grilleToString();
        comparer(sAttendue, sObtenue);

        if (jeu.toString().trim().equals("Grille 4 X 5 (9 mines) => 0 % acheve.")) {
            System.out.println("jeu.toString() => OK");
        } else {
            System.out.println("jeu.toString() => ERREUR :");
            System.out.println("\tATTENDU  : Grille 4 X 5 (9 mines) => 0 % acheve.");
            System.out.println("\tTROUVE   : " + jeu.toString().trim());
        }

        System.out.println(maj("2. Decouvrir 1 case non minee"));
        jeu.decouvrirUneCase(new Case(1, 1));

        System.out.println(jeu.getNbrCasesSansMineDecouvertes() + " (1)");
        System.out.println(jeu.isPartieGagnee() + " (false)");
        System.out.println(jeu.isPartiePerdue() + " (false)");
        System.out.println(jeu.pourcentageAcheve() + " (9)");
        System.out.println(JeuDemineur.getNbrPartiesJouees() + " (0)");
        System.out.println(JeuDemineur.getNbrPartiesPerdues() + " (0)");

        sAttendue = "    1   2   3   4   5  \n" +
                "  ---------------------\n" +
                "1 | 2 |   |   |   |   |\n" +
                "  ---------------------\n" +
                "2 |   |   |   |   |   |\n" +
                "  ---------------------\n" +
                "3 |   |   |   |   |   |\n" +
                "  ---------------------\n" +
                "4 |   |   |   |   |   |\n" +
                "  ---------------------";

        sObtenue = jeu.grilleToString();
        comparer(sAttendue, sObtenue);

        if (jeu.toString().trim().equals("Grille 4 X 5 (9 mines) => 9 % acheve.")) {
            System.out.println("jeu.toString() => OK");
        } else {
            System.out.println("jeu.toString() => ERREUR :");
            System.out.println("\tATTENDU  : Grille 4 X 5 (9 mines) => 9 % acheve.");
            System.out.println("\tTROUVE   : " + jeu.toString().trim());
        }

        System.out.println(maj("3. Decouvrir 6 cases non minees"));

        jeu.decouvrirUneCase(new Case(4, 3));
        jeu.decouvrirUneCase(new Case(1, 5));
        jeu.decouvrirUneCase(new Case(3, 1));
        jeu.decouvrirUneCase(new Case(2, 3));
        jeu.decouvrirUneCase(new Case(3, 5));

        System.out.println(jeu.getNbrCasesSansMineDecouvertes() + " (6)");
        System.out.println(jeu.isPartieGagnee() + " (false)");
        System.out.println(jeu.isPartiePerdue() + " (false)");
        System.out.println(jeu.pourcentageAcheve() + " (55)");
        System.out.println(JeuDemineur.getNbrPartiesJouees() + " (0)");
        System.out.println(JeuDemineur.getNbrPartiesPerdues() + " (0)");

        System.out.println(maj("4. Decouvrir 1 case deja decouverte"));
        jeu.decouvrirUneCase(new Case(2, 3));

        System.out.println(jeu.getNbrCasesSansMineDecouvertes() + " (6)");
        System.out.println(jeu.isPartieGagnee() + " (false)");
        System.out.println(jeu.isPartiePerdue() + " (false)");
        System.out.println(jeu.pourcentageAcheve() + " (55)");
        System.out.println(JeuDemineur.getNbrPartiesJouees() + " (0)");
        System.out.println(JeuDemineur.getNbrPartiesPerdues() + " (0)");

        System.out.println(maj("5. Tenter de decouvrir 1 case invalide (55)"));

        jeu.decouvrirUneCase(new Case(5, 5));

        System.out.println(jeu.getNbrCasesSansMineDecouvertes() + " (6)");
        System.out.println(jeu.isPartieGagnee() + " (false)");
        System.out.println(jeu.isPartiePerdue() + " (false)");
        System.out.println(jeu.pourcentageAcheve() + " (55)");
        System.out.println(JeuDemineur.getNbrPartiesJouees() + " (0)");
        System.out.println(JeuDemineur.getNbrPartiesPerdues() + " (0)");

        System.out.println(maj("6. Decouvrir 2 cases non minees"));

        jeu.decouvrirUneCase(new Case(1, 4));
        jeu.decouvrirUneCase(new Case(2, 2));

        System.out.println(jeu.getNbrCasesSansMineDecouvertes() + " (8)");
        System.out.println(jeu.isPartieGagnee() + " (false)");
        System.out.println(jeu.isPartiePerdue() + " (false)");
        System.out.println(jeu.pourcentageAcheve() + " (73)");
        System.out.println(JeuDemineur.getNbrPartiesJouees() + " (0)");
        System.out.println(JeuDemineur.getNbrPartiesPerdues() + " (0)");

        System.out.println(maj("7. Decouvrir le reste des cases non minees"));

        jeu.decouvrirUneCase(new Case(3, 3));
        jeu.decouvrirUneCase(new Case(4, 2));
        jeu.decouvrirUneCase(new Case(4, 5));

        System.out.println(jeu.getNbrCasesSansMineDecouvertes() + " (11)");
        System.out.println(jeu.isPartieGagnee() + " (true)");
        System.out.println(jeu.isPartiePerdue() + " (false)");
        System.out.println(jeu.pourcentageAcheve() + " (100)");
        System.out.println(JeuDemineur.getNbrPartiesJouees() + " (1)");
        System.out.println(JeuDemineur.getNbrPartiesPerdues() + " (0)");

        System.out.println(maj("8. Reinitialiser la partie"));
        jeu.reinitialiserPartie();

        System.out.println(jeu.getNbrLignesGrille() + " (4)");
        System.out.println(jeu.getNbrColGrille() + " (5)");
        System.out.println(jeu.getNbrMines() + " (9)");
        System.out.println(jeu.getNbrCasesSansMineDecouvertes() + " (0)");
        System.out.println(jeu.isPartieGagnee() + " (false)");
        System.out.println(jeu.isPartiePerdue() + " (false)");
        System.out.println(jeu.pourcentageAcheve() + " (0)");
        System.out.println(JeuDemineur.getNbrPartiesJouees() + " (1)");
        System.out.println(JeuDemineur.getNbrPartiesPerdues() + " (0)");

        System.out.println(maj("9. Decouvrir 3 cases non minees"));

        jeu.decouvrirUneCase(new Case(1, 4));
        jeu.decouvrirUneCase(new Case(2, 2));
        jeu.decouvrirUneCase(new Case(1, 5));

        System.out.println(jeu.getNbrCasesSansMineDecouvertes() + " (3)");
        System.out.println(jeu.isPartieGagnee() + " (false)");
        System.out.println(jeu.isPartiePerdue() + " (false)");
        System.out.println(jeu.pourcentageAcheve() + " (27)");
        System.out.println(JeuDemineur.getNbrPartiesJouees() + " (1)");
        System.out.println(JeuDemineur.getNbrPartiesPerdues() + " (0)");

        sAttendue = "    1   2   3   4   5  \n" +
                "  ---------------------\n" +
                "1 |   |   |   | 3 | 2 |\n" +
                "  ---------------------\n" +
                "2 |   | 4 |   |   |   |\n" +
                "  ---------------------\n" +
                "3 |   |   |   |   |   |\n" +
                "  ---------------------\n" +
                "4 |   |   |   |   |   |\n" +
                "  ---------------------";

        sObtenue = jeu.grilleToString();
        comparer(sAttendue, sObtenue);

        if (jeu.toString().trim().equals("Grille 4 X 5 (9 mines) => 27 % acheve.")) {
            System.out.println("jeu.toString() => OK");
        } else {
            System.out.println("jeu.toString() => ERREUR :");
            System.out.println("\tATTENDU  : Grille 4 X 5 (9 mines) => 27 % acheve.");
            System.out.println("\tTROUVE   : " + jeu.toString().trim());
        }

        System.out.println(maj("10. Decouvrir 1 case minee"));

        jeu.decouvrirUneCase(new Case(2, 1)); //mine

        System.out.println(jeu.getNbrCasesSansMineDecouvertes() + " (3)");
        System.out.println(jeu.isPartieGagnee() + " (false)");
        System.out.println(jeu.isPartiePerdue() + " (true)");
        System.out.println(jeu.pourcentageAcheve() + " (27)");
        System.out.println(JeuDemineur.getNbrPartiesJouees() + " (2)");
        System.out.println(JeuDemineur.getNbrPartiesPerdues() + " (1)");

        if (jeu.toString().trim().equals("Grille 4 X 5 (9 mines) => 27 % acheve.")) {
            System.out.println("jeu.toString() => OK");
        } else {
            System.out.println("jeu.toString() => ERREUR :");
            System.out.println("\tATTENDU  : Grille 4 X 5 (9 mines) => 27 % acheve.");
            System.out.println("\tTROUVE   : " + jeu.toString().trim());
        }

        System.out.println(maj("11. Creation d'un demineur 7x8 avec 16 mines"));

        jeu = new JeuDemineur(7, 8, 16);

        System.out.println("Découvrir quelques cases...");
        jeu.decouvrirUneCase(new Case(1,1));
        jeu.decouvrirUneCase(new Case(2,2));
        jeu.decouvrirUneCase(new Case(3,3));
        jeu.decouvrirUneCase(new Case(7,7));
        jeu.decouvrirUneCase(new Case(5,1));
        jeu.decouvrirUneCase(new Case(4,8));
        jeu.decouvrirUneCase(new Case(2,1)); //-> boum (partie perdue)
        jeu.decouvrirUneCase(new Case(7,1)); //-> ignorée car partie déjà terminée

        sAttendue = "    1   2   3   4   5   6   7   8  \n" +
                "  ---------------------------------\n" +
                "1 | 1 |   |   |   |   |   |   |   |\n" +
                "  ---------------------------------\n" +
                "2 | * | 2 |   |   |   |   |   |   |\n" +
                "  ---------------------------------\n" +
                "3 |   |   | 4 |   |   |   |   |   |\n" +
                "  ---------------------------------\n" +
                "4 |   |   |   |   |   |   |   | 1 |\n" +
                "  ---------------------------------\n" +
                "5 | 3 |   |   |   |   |   |   |   |\n" +
                "  ---------------------------------\n" +
                "6 |   |   |   |   |   |   |   |   |\n" +
                "  ---------------------------------\n" +
                "7 |   |   |   |   |   |   | 1 |   |\n" +
                "  ---------------------------------";

        sObtenue = jeu.grilleToString();
        comparer(sAttendue, sObtenue);
        System.out.println("\nFIN DES TESTS\n");



    }


}