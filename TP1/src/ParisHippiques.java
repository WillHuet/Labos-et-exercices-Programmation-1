/**
 * Cette classe contient... TODO
 *
 * @author : William Huet (HUEW75120205)
 * @version : 10 février 2026
 */

public class ParisHippiques {
    /*CONSTANTES*/
    //LONG MESSAGES ET INTERFACES DE MENU
    public final static String ENTETE_MENU_PRINCIPAL =
            "\n" +
            "--------------\n" +
            "MENU PRINCIPAL\n" +
            "--------------\n";
    public final static String ENTETE_MENU_PARI =
            "\n" +
            "--------------\n" +
            "PLACER UN PARI\n" +
            "--------------\n";
    public final static String ENTETE_MENU_BANQUE =
            "\n" +
            "---------------\n" +
            "GÉRER LA BANQUE\n" +
            "---------------\n";
    public final static String ENTETE_OPERATION_ANNULEE =
            "\n" +
            "----> OPERATION ANNULÉE <----\n" +
            "\n";
    public final static String MSG_MENU_PRINCIPAL =
            "1. Placer un pari\n" +
            "2. Gérer la banque\n" +
            "3. Quitter\n" +
            "\n" +
            "Entrez votre choix : ";
    public final static String MSG_MENU_PARI =
            "\n" +
            "Type de pari\n" +
            "  1. Pari simple gagnant\n" +
            "  2. Pari simple placé\n" +
            "  3. Pari couplé gagnant ordonné\n" +
            "  4. Pari couplé gagnant non ordonné\n" +
            "  5. Revenir au menu principal\n" +
            "\n" +
            "Entrez le type de pari : ";
    public final static String MSG_LISTE_CHEVAUX =
            "Chevaux\n" +
            "  1. Gaspard\n" +
            "  2. Bubulle\n" +
            "  3. Babette\n" +
            "  4. Socrate\n" +
            "  5. Romarin\n" +
            "  6. Canelle\n" +
            "\n";
    public final static String MSG_FIN_GERER_BANQUE =
            "$ **\n" +
            "\n" +
            "(A)jouter, (V)ider, ou (R)evenir au menu principal : ";

    //PETITS MESSAGES
    public final static String MSG_BIENVENUE = "Ce programme permet de placer des paris sur des courses hippiques virtuelles.\n";
    public final static String MSG_METTRE_MONTANT_BANQUE = "Votre banque est vide.\n" + "Pour continuer, entrez un montant à mettre en banque (0 pour quitter) : ";
    public final static String MSG_CHOIX_UNIQUE_CHEVAL = "Entrez le numéro du cheval : ";
    public final static String MSG_CHOIX_PREMIER_CHEVAL = "Entrez le numéro du premier cheval : ";
    public final static String MSG_CHOIX_DEUXIEME_CHEVAL = "Entrez le numéro du deuxième cheval : ";
    public final static String MSG_FIN_PROGRAMME = "\n"+"FIN DU PROGRAMME. Au revoir!";
    public final static String MSG_AJOUT_BANQUE = "Entrez le montant à ajouter (0 pour annuler) : ";
    public final static String MSG_MONTANT_MISE = "Entrez le montant de la mise (0 pour annuler) : ";
    public final static String MSG_DEBUT_GERER_BANQUE = "** Montant en banque : ";
    public final static String MSG_RETOUR_MENU_PRINCIPAL = "Appuyez sur <ENTREE> pour revenir au menu principal...";
    public final static String MSG_BRAVO = "\n" + "BRAVO ! Vous avez gagné ";
    public final static String MSG_DESOLE = "\n" + "DÉSOLÉ ! Vous avez perdu votre pari.";
    public final static String MSG_GAIN_CUMULE= "\n" + "GAIN CUMULÉ       : ";
    public final static String MSG_PERTE_CUMULE= "\n" + "PERTE CUMULÉE     : ";
    public final static String MSG_BANQUE_APRES_GAIN = "BANQUE            : ";


    //MESSAGES D'ERREURS
    public final static String MSG_ERREUR_MONTANT_BANQUE = "\n" + "Erreur, le montant doit être plus grand ou égal a 0! Recommencez... ";
    public final static String MSG_ERREUR_CHOIX_MENU = "\n" + "Erreur, entrez un choix entre 1 et 3! Recommencez... ";
    public final static String MSG_ERREUR_CHOIX_PARI = "\n" + "Erreur, entrez un choix entre 1 et 5! Recommencez... ";
    public final static String MSG_ERREUR_CHOIX_CHEVAL = "\n" + "Erreur, entrez un choix entre 1 et 6! Recommencez... ";
    public final static String MSG_ERREUR_CHOIX_BANQUE = "\n" + "Erreur, entrez A, V ou R! Recommencez... ";
    public final static String MSG_ERREUR_MONTANT_MISE = "\n" + "Erreur, la mise doit être entre 0.00$ et ";



    //VALEURS BYTES POUR SELECTION DE MENU
    public final static char SELECTION_1 = '1';
    public final static char SELECTION_2 = '2';
    public final static char SELECTION_3 = '3';
    public final static char SELECTION_4 = '4';
    public final static char SELECTION_5 = '5';
    public final static char SELECTION_6 = '6';

    public final static char AJOUTER_BANQUE = 'A';
    public final static char VIDER_BANQUE = 'V';
    public final static char REVENIR_BANQUE = 'R';


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
        double montantMiseInput = 0.00;
        double montantBanque = 0.00;
        double montantGagne = 0.00;
        double gain = 0.00;

        int classement;
        int premierePlace;
        int deuxiemePlace;

        /*DEBUT DU PROGRAMME*/
        System.out.println(MSG_BIENVENUE);
        System.out.print(MSG_METTRE_MONTANT_BANQUE);
        montantBanqueInput = Clavier.lireDoubleLn();
        while (montantBanqueInput < 0) {
            System.out.print(MSG_ERREUR_MONTANT_BANQUE);
            System.out.print(MSG_METTRE_MONTANT_BANQUE);
            montantBanqueInput = Clavier.lireDoubleLn();
        }
        montantBanque = montantBanqueInput;

        //AFFICHAGE DU PREMIER MENU (PRINCIPAL)
        do{
            if (montantBanqueInput > 0){
                System.out.print(ENTETE_MENU_PRINCIPAL + MSG_MENU_PRINCIPAL);
                menuPrincipalInput = Clavier.lireCharLn();

                //SELECTION MENU PRINCIPAL (PARI, BANQUE OU QUITTER)
                switch (menuPrincipalInput){
                    //PARI
                    case SELECTION_1:
                        System.out.print(ENTETE_MENU_PARI + MSG_MENU_PARI);
                        menuPariInput = Clavier.lireCharLn();
                        boolPari = true;
                        montantGagne = 0;
                        do{
                            switch (menuPariInput){
                                //PARI SIMPLE
                                case SELECTION_1:
                                    System.out.print(MSG_LISTE_CHEVAUX + MSG_CHOIX_UNIQUE_CHEVAL);
                                    menuSelection1erChevalInput = Clavier.lireCharLn();
                                    while((byte)menuSelection1erChevalInput < (byte)SELECTION_1 || (byte)menuSelection1erChevalInput > (byte)SELECTION_6){
                                        System.out.println(MSG_ERREUR_CHOIX_CHEVAL + MSG_LISTE_CHEVAUX + MSG_CHOIX_UNIQUE_CHEVAL);
                                        menuSelection1erChevalInput = Clavier.lireCharLn();
                                    }

                                    System.out.print(MSG_MONTANT_MISE);
                                    montantMiseInput = Clavier.lireDoubleLn();
                                    while(montantMiseInput < 0 || montantMiseInput > montantBanque){
                                        System.out.println(MSG_ERREUR_MONTANT_MISE + String.format("%.2f", montantBanque) + "$! Recommencez...");
                                        System.out.print(MSG_MONTANT_MISE);
                                        montantMiseInput = Clavier.lireDoubleLn();
                                    }

                                    if (montantMiseInput > 0 && montantMiseInput <= montantBanque){
                                        montantBanque -= montantMiseInput;
                                        gain -= montantMiseInput;

                                        classement = TP1Utils.executerCourse();
                                        premierePlace = classement / 100000;
                                        if((char)premierePlace == menuSelection1erChevalInput){
                                            System.out.println(MSG_BRAVO);
                                            montantGagne += montantMiseInput * 3;
                                            gain += montantGagne;
                                            montantBanque += montantGagne;
                                        } else {
                                            System.out.println(MSG_DESOLE);
                                        }
                                    } else {
                                        System.out.println(ENTETE_OPERATION_ANNULEE + MSG_RETOUR_MENU_PRINCIPAL);
                                        Clavier.lireFinLigne();
                                        boolPari = false;
                                    }
                                    break;

                                //PARI PLACE
                                case SELECTION_2:
                                    System.out.print(MSG_LISTE_CHEVAUX + MSG_CHOIX_UNIQUE_CHEVAL);
                                    menuSelection1erChevalInput = Clavier.lireCharLn();
                                    while((byte)menuSelection1erChevalInput < (byte)SELECTION_1 || (byte)menuSelection1erChevalInput > (byte)SELECTION_6){
                                        System.out.println(MSG_ERREUR_CHOIX_CHEVAL + MSG_LISTE_CHEVAUX + MSG_CHOIX_UNIQUE_CHEVAL);
                                        menuSelection1erChevalInput = Clavier.lireCharLn();
                                    }

                                    System.out.print(MSG_MONTANT_MISE);
                                    montantMiseInput = Clavier.lireDoubleLn();
                                    while(montantMiseInput < 0 || montantMiseInput > montantBanque){
                                        System.out.println(MSG_ERREUR_MONTANT_MISE + String.format("%.2f", montantBanque) + "$! Recommencez...");
                                        System.out.print(MSG_MONTANT_MISE);
                                        montantMiseInput = Clavier.lireDoubleLn();
                                    }

                                    if (montantMiseInput > 0 && montantMiseInput <= montantBanque){
                                        montantBanque -= montantMiseInput;
                                        gain -= montantMiseInput;

                                        classement = TP1Utils.executerCourse();
                                        premierePlace = classement / 100000;
                                        deuxiemePlace = classement / 10000 % 10;
                                        if((char)premierePlace == menuSelection1erChevalInput || (char)deuxiemePlace == menuSelection1erChevalInput){
                                            System.out.println(MSG_BRAVO);
                                            montantGagne += montantMiseInput * 2;
                                            gain += montantGagne;
                                            montantBanque += montantGagne;
                                        } else {
                                            System.out.println(MSG_DESOLE);
                                        }
                                    } else {
                                        System.out.println(ENTETE_OPERATION_ANNULEE + MSG_RETOUR_MENU_PRINCIPAL);
                                        Clavier.lireFinLigne();
                                        boolPari = false;
                                    }
                                    break;

                                //PARI COUPLE GAGNANT ORDONNE
                                case SELECTION_3:
                                    System.out.print(MSG_LISTE_CHEVAUX + MSG_CHOIX_UNIQUE_CHEVAL);
                                    menuSelection1erChevalInput = Clavier.lireCharLn();
                                    while((byte)menuSelection1erChevalInput < (byte)SELECTION_1 || (byte)menuSelection1erChevalInput > (byte)SELECTION_6){
                                        System.out.println(MSG_ERREUR_CHOIX_CHEVAL + MSG_LISTE_CHEVAUX + MSG_CHOIX_UNIQUE_CHEVAL);
                                        menuSelection1erChevalInput = Clavier.lireCharLn();
                                    }

                                    System.out.print(MSG_LISTE_CHEVAUX + MSG_CHOIX_UNIQUE_CHEVAL);
                                    menuSelection2emeChevalInput = Clavier.lireCharLn();
                                    while((byte)menuSelection1erChevalInput < (byte)SELECTION_1 || (byte)menuSelection1erChevalInput > (byte)SELECTION_6){
                                        System.out.println(MSG_ERREUR_CHOIX_CHEVAL + MSG_LISTE_CHEVAUX + MSG_CHOIX_UNIQUE_CHEVAL);
                                        menuSelection1erChevalInput = Clavier.lireCharLn();
                                    }

                                    System.out.print(MSG_MONTANT_MISE);
                                    montantMiseInput = Clavier.lireDoubleLn();
                                    while(montantMiseInput < 0 || montantMiseInput > montantBanque){
                                        System.out.println(MSG_ERREUR_MONTANT_MISE + String.format("%.2f", montantBanque) + "$! Recommencez...");
                                        System.out.print(MSG_MONTANT_MISE);
                                        montantMiseInput = Clavier.lireDoubleLn();
                                    }

                                    if (montantMiseInput > 0 && montantMiseInput <= montantBanque){
                                        montantBanque -= montantMiseInput;
                                        gain -= montantMiseInput;

                                        classement = TP1Utils.executerCourse();
                                        premierePlace = classement / 100000;
                                        deuxiemePlace = classement / 10000 % 10;
                                        if((char)premierePlace == menuSelection1erChevalInput && (char)deuxiemePlace == menuSelection2emeChevalInput){
                                            System.out.println(MSG_BRAVO);
                                            montantGagne += montantMiseInput * 3.5;
                                            gain += montantGagne;
                                            montantBanque += montantGagne;
                                        } else {
                                            System.out.println(MSG_DESOLE);
                                        }
                                    } else {
                                        System.out.println(ENTETE_OPERATION_ANNULEE + MSG_RETOUR_MENU_PRINCIPAL);
                                        Clavier.lireFinLigne();
                                        boolPari = false;
                                    }
                                    break;

                                //PARI COUPLE GAGNANT NON ORDONNE
                                case SELECTION_4:
                                    System.out.print(MSG_LISTE_CHEVAUX + MSG_CHOIX_UNIQUE_CHEVAL);
                                    menuSelection1erChevalInput = Clavier.lireCharLn();
                                    while((byte)menuSelection1erChevalInput < (byte)SELECTION_1 || (byte)menuSelection1erChevalInput > (byte)SELECTION_6){
                                        System.out.println(MSG_ERREUR_CHOIX_CHEVAL + MSG_LISTE_CHEVAUX + MSG_CHOIX_UNIQUE_CHEVAL);
                                        menuSelection1erChevalInput = Clavier.lireCharLn();
                                    }

                                    System.out.print(MSG_LISTE_CHEVAUX + MSG_CHOIX_UNIQUE_CHEVAL);
                                    menuSelection2emeChevalInput = Clavier.lireCharLn();
                                    while((byte)menuSelection1erChevalInput < (byte)SELECTION_1 || (byte)menuSelection1erChevalInput > (byte)SELECTION_6){
                                        System.out.println(MSG_ERREUR_CHOIX_CHEVAL + MSG_LISTE_CHEVAUX + MSG_CHOIX_UNIQUE_CHEVAL);
                                        menuSelection1erChevalInput = Clavier.lireCharLn();
                                    }

                                    System.out.print(MSG_MONTANT_MISE);
                                    montantMiseInput = Clavier.lireDoubleLn();
                                    while(montantMiseInput < 0 || montantMiseInput > montantBanque){
                                        System.out.println(MSG_ERREUR_MONTANT_MISE + String.format("%.2f", montantBanque) + "$! Recommencez...");
                                        System.out.print(MSG_MONTANT_MISE);
                                        montantMiseInput = Clavier.lireDoubleLn();
                                    }

                                    if (montantMiseInput > 0 && montantMiseInput <= montantBanque){
                                        montantBanque -= montantMiseInput;
                                        gain -= montantMiseInput;

                                        classement = TP1Utils.executerCourse();
                                        premierePlace = classement / 100000;
                                        deuxiemePlace = classement / 10000 % 10;
                                        if(((char)premierePlace == menuSelection1erChevalInput && (char)deuxiemePlace == menuSelection2emeChevalInput) ||
                                        ((char)premierePlace == menuSelection2emeChevalInput && (char)deuxiemePlace == menuSelection1erChevalInput)){
                                            System.out.println(MSG_BRAVO);
                                            montantGagne += montantMiseInput * 2.5;
                                            gain += montantGagne;
                                            montantBanque += montantGagne;

                                        } else {
                                            System.out.println(MSG_DESOLE);
                                        }
                                    } else {
                                        System.out.println(ENTETE_OPERATION_ANNULEE + MSG_RETOUR_MENU_PRINCIPAL);
                                        Clavier.lireFinLigne();
                                        boolPari = false;
                                    }
                                    break;

                                //QUITTER MENU PARI
                                case SELECTION_5:
                                    boolPari = false;
                                    break;

                                //ERREUR
                                default:
                                    System.out.println(MSG_ERREUR_CHOIX_PARI);
                                    System.out.print(MSG_MENU_PARI);
                                    menuPariInput = Clavier.lireCharLn();
                            }
                            //AFFICHER GAIN OU PERTE & AJOUT À LA BANQUE SI ELLE EST VIDE
                            if (gain >= 0){
                                System.out.printf(MSG_GAIN_CUMULE + "%.2f" + "$\n",  gain);
                                System.out.printf(MSG_BANQUE_APRES_GAIN + "%.2f" + "$\n", montantBanque);
                            } else {
                                gain *= -1;
                                System.out.printf(MSG_PERTE_CUMULE + "%.2f" + "$\n", gain);
                                System.out.printf(MSG_BANQUE_APRES_GAIN + "%.2f" + "$\n", montantBanque);
                                gain *= -1;
                                //J'aurais utilisé la méthode "Math.abs() pour éviter d'avoir le signe de moins devant mais je n'ai pas le droit"
                            }
                            System.out.println(MSG_RETOUR_MENU_PRINCIPAL);
                            Clavier.lireFinLigne();
                            boolPari = false;

                            if(montantBanque == 0){
                                System.out.print(MSG_METTRE_MONTANT_BANQUE);
                                montantBanqueInput = Clavier.lireDoubleLn();
                                while (montantBanqueInput < 0) {
                                    System.out.print(MSG_ERREUR_MONTANT_BANQUE);
                                    montantBanqueInput = Clavier.lireDoubleLn();
                                }
                                if(montantBanqueInput == 0){
                                    boolMenu = false;
                                }
                                montantBanque = montantBanqueInput;
                            }
                        }
                        while (boolPari);
                        break;

                    //GERER BANQUE
                    case SELECTION_2:
                        boolBanque = true;
                        while (boolBanque){
                            System.out.print(ENTETE_MENU_BANQUE + MSG_DEBUT_GERER_BANQUE + String.format("%.2f", montantBanque) + MSG_FIN_GERER_BANQUE);
                            menuBanqueInput = Clavier.lireCharLn();
                            menuBanqueInput = Character.toUpperCase(menuBanqueInput);
                            switch (menuBanqueInput){
                                case AJOUTER_BANQUE:
                                    System.out.print(MSG_AJOUT_BANQUE);
                                    montantAjoutInput = Clavier.lireDoubleLn();
                                    while (montantAjoutInput < 0){
                                        System.out.println(MSG_ERREUR_MONTANT_BANQUE);
                                        System.out.print(MSG_AJOUT_BANQUE);
                                        montantAjoutInput = Clavier.lireDoubleLn();
                                    }
                                    if (montantAjoutInput >= 0){
                                        montantBanque += montantAjoutInput;
                                    }
                                    break;
                                case VIDER_BANQUE:
                                    montantBanque = 0.00;
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
            } else if (montantBanqueInput == 0) {
                boolMenu = false;
            }
        }
        while(boolMenu);
        System.out.println(MSG_FIN_PROGRAMME);
    }
}
