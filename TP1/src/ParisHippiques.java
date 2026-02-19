/**
 * Cette classe contient... TODO
 *
 * @author : William Huet (HUEW75120205)
 * @version : 10 février 2026
 */

public class ParisHippiques {
    /*CONSTANTES*/
    //LONG MESSAGES ET INTERFACES DE MENU
    final static String ENTETE_MENU_PRINCIPAL =
            "\n" +
            "--------------\n" +
            "MENU PRINCIPAL\n" +
            "--------------\n";
    final static String ENTETE_MENU_PARI =
            "\n" +
            "--------------\n" +
            "PLACER UN PARI\n" +
            "--------------\n";
    final static String ENTETE_MENU_BANQUE =
            "\n" +
            "---------------\n" +
            "GÉRER LA BANQUE\n" +
            "---------------\n";
    final static String MSG_MENU_PRINCIPAL =
            "1. Placer un pari\n" +
            "2. Gérer la banque\n" +
            "3. Quitter\n" +
            "\n" +
            "Entrez votre choix : ";
    final static String MSG_MENU_PARI =
            "Type de pari\n" +
            "  1. Pari simple gagnant\n" +
            "  2. Pari simple placé\n" +
            "  3. Pari couplé gagnant ordonné\n" +
            "  4. Pari couplé gagnant non ordonné\n" +
            "  5. Revenir au menu principal\n" +
            "\n" +
            "Entrez le type de pari : ";
    final static String MSG_LISTE_CHEVAUX =
            "Chevaux\n" +
            "  1. Gaspard\n" +
            "  2. Bubulle\n" +
            "  3. Babette\n" +
            "  4. Socrate\n" +
            "  5. Romarin\n" +
            "  6. Canelle\n" +
            "\n";
    final static String MSG_DEBUT_GERER_BANQUE = "** Montant en banque : ";
    final static String MSG_FIN_GERER_BANQUE =
            "$ **\n" +
            "\n" +
            "(A)jouter, (V)ider, ou (R)evenir au menu principal : ";

    //PETITS MESSAGES
    final static String MSG_BIENVENUE = "Ce programme permet de placer des paris sur des courses hippiques virtuelles.\n";
    final static String MSG_METTRE_MONTANT_BANQUE = "Votre banque est vide.\n" + "Pour continuer, entrez un montant à mettre en banque (0 pour quitter) : ";
    final static String MSG_CHOIX_UNIQUE_CHEVAL = "Entrez le numero du cheval : ";
    final static String MSG_CHOIX_PREMIER_CHEVAL = "Entrez le numero du premier cheval : ";
    final static String MSG_CHOIX_DEUXIEME_CHEVAL = "Entrez le numero du deuxième cheval : ";
    final static String MSG_FIN_PROGRAMME = "\n"+"FIN DU PROGRAMME. Aurevoir!";
    final static String MSG_AJOUT_BANQUE = "Entrez le montant a ajouter (0 pour annuler) : ";

    //MESSAGES D'ERREURS
    final static String MSG_ERREUR_MONTANT_BANQUE = "Erreur, le montant doit être plus grand ou égal a 0! Recommencez...";
    final static String MSG_ERREUR_CHOIX_MENU = "Erreur, entrez un choix entre 1 et 3! Recommencez...";
    final static String MSG_ERREUR_CHOIX_PARI = "Erreur, entrez un choix entre 1 et 5! Recommencez...";
    final static String MSG_ERREUR_CHOIX_CHEVAL = "Erreur, entrez un choix entre 1 et 6! Recommencez...";
    final static String MSG_ERREUR_CHOIX_BANQUE = "Erreur, entrez A, V ou R! Recommencez...";

    //VALEURS BYTES POUR SELECTION DE MENU
    final static char SELECTION_1 = '1';
    final static char SELECTION_2 = '2';
    final static char SELECTION_3 = '3';
    final static char SELECTION_4 = '4';
    final static char SELECTION_5 = '5';
    final static char SELECTION_6 = '6';

    final static char AJOUTER_BANQUE = 'A';
    final static char VIDER_BANQUE = 'V';
    final static char REVENIR_BANQUE = 'R';


    public static void main(String[] args) {
        /*VARIABLES*/
        boolean boolMenu = true;
        boolean boolPari = false;
        boolean boolBanque = false;

        char menuPrincipalInput;
        char menuPariInput;
        char menuChevauxInput;
        char menuBanqueInput;
        char menuSelection1erChevalInput;
        char menuSelection2emeChevalInput;

        double montantAjoutInput = 0.00;
        double montantBanqueInput = 0.00;
        double montantBanque = 0.00;

        /*DEBUT DU PROGRAMME*/
        System.out.println(MSG_BIENVENUE);

        System.out.print(MSG_METTRE_MONTANT_BANQUE);
        montantBanqueInput = Clavier.lireDoubleLn();
        montantBanque = montantBanqueInput;
        //AFFICHAGE DU PREMIER MENU (PRINCIPAL)
        do{
            if (montantBanqueInput > 0){
                System.out.print(ENTETE_MENU_PRINCIPAL + MSG_MENU_PRINCIPAL);
                menuPrincipalInput = Clavier.lireCharLn();

                //SELECTION MENU PRINCIPAL (PARI, BANQUE OU QUITTER)
                //do{
                    switch (menuPrincipalInput){
                        //PARI
                        case SELECTION_1:
                            System.out.print(ENTETE_MENU_PARI + MSG_MENU_PARI);
                            menuPariInput = Clavier.lireCharLn();
                            boolPari = true;
                            while (boolPari){
                                switch (menuPariInput){
                                    //PARI SIMPLE
                                    case SELECTION_1:
                                        System.out.print(MSG_LISTE_CHEVAUX + MSG_CHOIX_UNIQUE_CHEVAL);
                                        menuSelection1erChevalInput = Clavier.lireCharLn();
                                        //TODO
                                        break;

                                    //PARI PLACE
                                    case SELECTION_2:
                                        System.out.print(MSG_LISTE_CHEVAUX + MSG_CHOIX_UNIQUE_CHEVAL);
                                        menuSelection1erChevalInput = Clavier.lireCharLn();
                                        //TODO
                                        break;

                                    //PARI COUPLE GAGNANT ORDONNE
                                    case SELECTION_3:
                                        System.out.print(MSG_LISTE_CHEVAUX + MSG_CHOIX_PREMIER_CHEVAL);
                                        menuSelection1erChevalInput = Clavier.lireCharLn();
                                        System.out.print(MSG_LISTE_CHEVAUX + MSG_CHOIX_PREMIER_CHEVAL);
                                        menuSelection2emeChevalInput = Clavier.lireCharLn();
                                        //TODO
                                        break;

                                    //PARI COUPLE GAGNANT NON ORDONNE
                                    case SELECTION_4:
                                        System.out.print(MSG_LISTE_CHEVAUX + MSG_CHOIX_PREMIER_CHEVAL);
                                        menuSelection1erChevalInput = Clavier.lireCharLn();
                                        System.out.print(MSG_LISTE_CHEVAUX + MSG_CHOIX_PREMIER_CHEVAL);
                                        menuSelection2emeChevalInput = Clavier.lireCharLn();
                                        //TODO
                                        break;

                                    //QUITTER MENU PARI
                                    case SELECTION_5:
                                        boolPari = false;
                                        break;

                                    //ERREUR
                                    default:
                                        System.out.println(MSG_ERREUR_CHOIX_PARI);
                                        System.out.println(MSG_MENU_PARI);
                                        //menuPariInput = Clavier.lireString();
                                        //menuPari = menuPariInput.charAt(0);
                                }
                            }
                            break;

                        //GERER BANQUE
                        case SELECTION_2:
                            boolBanque = true;
                            while (boolBanque){
                                System.out.print(ENTETE_MENU_BANQUE + MSG_DEBUT_GERER_BANQUE + montantBanque + MSG_FIN_GERER_BANQUE);
                                menuBanqueInput = Clavier.lireCharLn();
                                menuBanqueInput = Character.toUpperCase(menuBanqueInput);
                                switch (menuBanqueInput){
                                    case AJOUTER_BANQUE:
                                        System.out.print(MSG_AJOUT_BANQUE);
                                        montantAjoutInput = Clavier.lireDoubleLn();
                                        if (montantAjoutInput >= 0){
                                            montantBanque += montantAjoutInput;
                                        } else {
                                           while (montantAjoutInput < 0){
                                               System.out.println(MSG_ERREUR_MONTANT_BANQUE);
                                               System.out.print(MSG_AJOUT_BANQUE);
                                               montantAjoutInput = Clavier.lireDoubleLn();
                                           }
                                        }
                                        break;
                                    case VIDER_BANQUE:
                                        montantBanque = 0.00;
                                        menuPrincipalInput = 3;
                                        boolBanque = false;
                                        boolMenu = false;
                                        break;
                                    case REVENIR_BANQUE:
                                        boolBanque = false;
                                        break;
                                    default:
                                        System.out.print(MSG_ERREUR_CHOIX_BANQUE);
                                }
                            }
                            break;

                        //QUITTER PROGRAMME
                        case SELECTION_3:
                            boolMenu = false;
                            break;
                        default:
                            System.out.println(MSG_ERREUR_CHOIX_MENU);
                    }
                //}
                //while (menuPrincipalInput >= 1 && menuPrincipalInput <= 2);
            } else if (montantBanqueInput < 0) {
                System.out.println(MSG_ERREUR_MONTANT_BANQUE);
                montantBanqueInput = Clavier.lireDoubleLn();
            } else if (montantBanqueInput == 0) {
                boolMenu = false;
            }
        }
        while(boolMenu);
        System.out.println(MSG_FIN_PROGRAMME);
    }
}
