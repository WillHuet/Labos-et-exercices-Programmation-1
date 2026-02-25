/**
 * Cette classe contient une méthode permettant de faire des paris hippiques.
 *
 * Lorsque l'application se lance, on demande déposer un montant dans la banque. Celui-ci doit être plus grand que zéro (0).
 * Par la suite, un menu principal avec trois options s'affiche: [ 1. Placer un pari, 2. Gérer la banque et 3. Quitter ]
 *
 * Si l'on sélectionne la PREMIÈRE option (Placer un pari), un nouveau menu s'affiche avec cinq nouvelles options :
 *   1. Pari simple gagnant (le cheval sélectionné arrive en première place / cote de 3)
 *   2. Pari simple placé (le cheval sélectionné arrive en première ou deuxième place / cote de 2)
 *   3. Pari couplé gagnant ordonné (les chevaux sélectionnés arrivent respectivement en première et deuxième place / cote de 3.5)
 *   4. Pari couplé gagnant non ordonné (les chevaux sélectionnés arrivent en première et deuxième place, peu importe l'ordre / cote de 2.5)
 *   5. Revenir au menu principal
 * Pour chaque type de pari, on nous demande de rentrer la valeur de un ou deux chevaux ainsi que la valeur de notre pari.
 * Par la suite, la course s'effectue et affiche les résultats après quelques secondes.
 * Une petite interface apparaît ensuite pour nous montrer nos gains ou pertes totaux et nous révèle notre nouveau montant en banque.
 * Une requête d'appuyer sur « ENTRÉE » apparaît et nous ramène au menu principal
 *
 * Si l'on sélectionne la DEUXIÈME option (Gérer la banque), un nouveau menu s'affiche avec trois nouvelles options :
 *   « (A)jouter, (V)ider, ou (R)evenir au menu principal : »
 * Ajouter nous permet de, bien évidemment, ajouter des fonds dans notre banque. La valeur doit être plus grande que zéro (0).
 * Vider permet de retirer tous les fonds de notre banque et met fin au programme.
 * Revenir au menu principal nous ramène au menu précédent.
 *
 * Si l'on sélectionne la TROISIÈME option (Quitter), cela met fin au programme.
 *
 * -------------------------------------
 * @author : William Huet (HUEW75120205)
 * @version : 24 février 2026
 * -------------------------------------
 */

public class ParisHippiques {
    /*CONSTANTES*/
    //LONG MESSAGES ET INTERFACES DE MENU (PLUS DE DEUX LIGNES)
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
            "\n" +
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

    //PETITS MESSAGES (UNE OU DEUX LIGNES MAX)
    public final static String MSG_BIENVENUE = "Ce programme permet de placer des paris sur des courses hippiques virtuelles.\n";
    public final static String MSG_METTRE_MONTANT_BANQUE = "Votre banque est vide.\n" + "Pour continuer, entrez un montant à mettre en banque (0 pour quitter) : ";
    public final static String MSG_CHOIX_UNIQUE_CHEVAL = "Entrez le numéro du cheval : ";
    public final static String MSG_CHOIX_PREMIER_CHEVAL = "Entrez le numéro du premier cheval : ";
    public final static String MSG_CHOIX_DEUXIEME_CHEVAL = "Entrez le numéro du deuxième cheval : ";
    public final static String MSG_FIN_PROGRAMME = "\n"+"FIN DU PROGRAMME. Au revoir!";
    public final static String MSG_AJOUT_BANQUE = "\n" + "Entrez le montant à ajouter (0 pour annuler) : ";
    public final static String MSG_MONTANT_MISE = "Entrez le montant de la mise (0 pour annuler) : ";
    public final static String MSG_DEBUT_GERER_BANQUE = "\n" + "** Montant en banque : ";
    public final static String MSG_RETOUR_MENU_PRINCIPAL = "Appuyez sur <ENTREE> pour revenir au menu principal...";
    public final static String MSG_BRAVO = "\n" + "BRAVO ! Vous avez gagné ";
    public final static String MSG_DESOLE = "\n" + "DÉSOLÉ ! Vous avez perdu votre pari.";
    public final static String MSG_GAIN_CUMULE= "\n" + "GAIN CUMULÉ       : ";
    public final static String MSG_PERTE_CUMULE= "\n" + "PERTE CUMULÉE     : ";
    public final static String MSG_BANQUE_APRES_GAIN = "BANQUE            : ";

    //MESSAGES D'ERREURS
    public final static String MSG_ERREUR_MONTANT_BANQUE = "\n" + "ERREUR, le montant doit être plus grand ou égal a 0! Recommencez... ";
    public final static String MSG_ERREUR_CHOIX_MENU = "\n" + "ERREUR, entrez un choix entre 1 et 3! Recommencez... ";
    public final static String MSG_ERREUR_CHOIX_PARI = "\n" + "ERREUR, entrez un choix entre 1 et 5! Recommencez... ";
    public final static String MSG_ERREUR_CHOIX_CHEVAL = "\n" + "ERREUR, entrez un choix entre 1 et 6! Recommencez... ";
    public final static String MSG_ERREUR_CHOIX_BANQUE = "\n" + "ERREUR, entrez A, V ou R! Recommencez..." + "\n";
    public final static String MSG_ERREUR_MONTANT_MISE = "\n" + "ERREUR, la mise doit être entre 0.00$ et ";

    //VALEURS CHAR POUR SÉLECTION DANS LES MULTIPLES MENUS
    public final static char SELECTION_1 = '1';
    public final static char SELECTION_2 = '2';
    public final static char SELECTION_3 = '3';
    public final static char SELECTION_4 = '4';
    public final static char SELECTION_5 = '5';
    public final static char SELECTION_6 = '6';

    public final static char AJOUTER_BANQUE_MAJ = 'A';
    public final static char AJOUTER_BANQUE_MIN = 'a';
    public final static char VIDER_BANQUE_MAJ = 'V';
    public final static char VIDER_BANQUE_MIN = 'v';
    public final static char REVENIR_BANQUE_MAJ = 'R';
    public final static char REVENIR_BANQUE_MIN = 'r';

    public static void main(String[] args) {
        /*VARIABLES*/
        boolean boolMenu = true;
        boolean boolPari = false;
        boolean boolBanque = false;
        boolean boolAffichageGainPerte = false;

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
        int premierChevalInput;
        int deuxiemeChevalInput;
        int premierePlace;
        int deuxiemePlace;

        /* DÉBUT DU PROGRAMME */
        //DEMANDE À L'UTILISATEUR DE RENTRER UN MONTANT POUR LA BANQUE
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

                //SÉLECTION MENU PRINCIPAL (PARI, BANQUE OU QUITTER)
                switch (menuPrincipalInput){

                    //MENU PRINCIPAL -> PLACER UN PARI (1)
                    case SELECTION_1:
                        System.out.print(ENTETE_MENU_PARI + MSG_MENU_PARI);
                        menuPariInput = Clavier.lireCharLn();
                        boolPari = true;
                        montantGagne = 0;
                        do{

                            // SÉLECTION MENU « PLACER UN PARI » (4 DIFFÉRENTS TYPES DE PARI ET L'OPTION POUR REVENIR EN ARRIÈRE)
                            switch (menuPariInput){

                                //MENU MENU PLACER UN PARI -> PARI SIMPLE (1)
                                //CHOIX D'UN SEUL CHEVAL. LE PARI EST GAGNANT SI CELUI-CI TERMINE PREMIER.
                                case SELECTION_1:

                                    //CHOIX CHEVAL
                                    System.out.print(MSG_LISTE_CHEVAUX + MSG_CHOIX_UNIQUE_CHEVAL);
                                    menuSelection1erChevalInput = Clavier.lireCharLn();
                                    while((byte)menuSelection1erChevalInput < (byte)SELECTION_1 || (byte)menuSelection1erChevalInput > (byte)SELECTION_6){
                                        System.out.println(MSG_ERREUR_CHOIX_CHEVAL + MSG_LISTE_CHEVAUX + MSG_CHOIX_UNIQUE_CHEVAL);
                                        menuSelection1erChevalInput = Clavier.lireCharLn();
                                    }

                                    //MONTANT DE LA MISE
                                    System.out.print(MSG_MONTANT_MISE);
                                    montantMiseInput = Clavier.lireDoubleLn();
                                    while(montantMiseInput < 0 || montantMiseInput > montantBanque){
                                        System.out.printf(MSG_ERREUR_MONTANT_MISE + "%.2f" + "$! Recommencez...\n",  montantBanque);
                                        System.out.print(MSG_MONTANT_MISE);
                                        montantMiseInput = Clavier.lireDoubleLn();
                                    }

                                    //EXÉCUTION DE LA COURSE (SI LA MISE N'EST PAS DE 0)
                                    if (montantMiseInput > 0 && montantMiseInput <= montantBanque){
                                        montantBanque -= montantMiseInput;
                                        gain -= montantMiseInput;

                                        classement = TP1Utils.executerCourse();
                                        premierChevalInput = menuSelection1erChevalInput - '0';
                                        premierePlace = (classement / 100000);
                                        if(premierePlace == premierChevalInput){
                                            System.out.println(MSG_BRAVO);
                                            montantGagne += montantMiseInput * 3;
                                            gain += montantGagne;
                                            montantBanque += montantGagne;
                                        } else {
                                            System.out.println(MSG_DESOLE);
                                        }
                                        boolAffichageGainPerte = true;
                                    } else {
                                        System.out.println(ENTETE_OPERATION_ANNULEE + MSG_RETOUR_MENU_PRINCIPAL);
                                        Clavier.lireFinLigne();
                                        boolPari = false;
                                    }
                                    break;

                                //MENU PLACER UN PARI -> PARI PLACE (2)
                                //CHOIX D'UN SEUL CHEVAL. LE PARI EST GAGNANT SI CELUI-CI TERMINE PREMIER OU DEUXIÈME.
                                case SELECTION_2:

                                    //CHOIX CHEVAL
                                    System.out.print(MSG_LISTE_CHEVAUX + MSG_CHOIX_UNIQUE_CHEVAL);
                                    menuSelection1erChevalInput = Clavier.lireCharLn();
                                    while((byte)menuSelection1erChevalInput < (byte)SELECTION_1 || (byte)menuSelection1erChevalInput > (byte)SELECTION_6){
                                        System.out.println(MSG_ERREUR_CHOIX_CHEVAL + MSG_LISTE_CHEVAUX + MSG_CHOIX_UNIQUE_CHEVAL);
                                        menuSelection1erChevalInput = Clavier.lireCharLn();
                                    }

                                    //MONTANT DE LA MISE
                                    System.out.print(MSG_MONTANT_MISE);
                                    montantMiseInput = Clavier.lireDoubleLn();
                                    while(montantMiseInput < 0 || montantMiseInput > montantBanque){
                                        System.out.printf(MSG_ERREUR_MONTANT_MISE + "%.2f" + "$! Recommencez...\n",  montantBanque);
                                        System.out.print(MSG_MONTANT_MISE);
                                        montantMiseInput = Clavier.lireDoubleLn();
                                    }

                                    //EXÉCUTION DE LA COURSE (SI LA MISE N'EST PAS DE 0)
                                    if (montantMiseInput > 0 && montantMiseInput <= montantBanque){
                                        montantBanque -= montantMiseInput;
                                        gain -= montantMiseInput;

                                        classement = TP1Utils.executerCourse();
                                        premierChevalInput = menuSelection1erChevalInput - '0';
                                        premierePlace = (classement / 100000);
                                        deuxiemePlace = (classement / 10000 % 10);
                                        if(premierePlace == premierChevalInput || deuxiemePlace == premierChevalInput){
                                            System.out.println(MSG_BRAVO);
                                            montantGagne += montantMiseInput * 2;
                                            gain += montantGagne;
                                            montantBanque += montantGagne;
                                        } else {
                                            System.out.println(MSG_DESOLE);
                                        }
                                        boolAffichageGainPerte = true;
                                    } else {
                                        System.out.println(ENTETE_OPERATION_ANNULEE + MSG_RETOUR_MENU_PRINCIPAL);
                                        Clavier.lireFinLigne();
                                        boolPari = false;
                                    }
                                    break;

                                //MENU PLACER UN PARI -> PARI COUPLE GAGNANT ORDONNÉ (3)
                                //CHOIX DE DEUX CHEVAUX. LE PARI EST GAGNANT SI CEUX-CI TERMINE RESPECTIVEMENT PREMIER ET DEUXIÈME.
                                case SELECTION_3:

                                    //CHOIX CHEVAUX
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

                                    //MONTANT DE LA MISE
                                    System.out.print(MSG_MONTANT_MISE);
                                    montantMiseInput = Clavier.lireDoubleLn();
                                    while(montantMiseInput < 0 || montantMiseInput > montantBanque){
                                        System.out.printf(MSG_ERREUR_MONTANT_MISE + "%.2f" + "$! Recommencez...\n",  montantBanque);
                                        System.out.print(MSG_MONTANT_MISE);
                                        montantMiseInput = Clavier.lireDoubleLn();
                                    }

                                    //EXÉCUTION DE LA COURSE (SI LA MISE N'EST PAS DE 0)
                                    if (montantMiseInput > 0 && montantMiseInput <= montantBanque){
                                        montantBanque -= montantMiseInput;
                                        gain -= montantMiseInput;

                                        classement = TP1Utils.executerCourse();
                                        premierChevalInput = menuSelection1erChevalInput - '0';
                                        deuxiemeChevalInput = menuSelection2emeChevalInput - '0';
                                        premierePlace = (classement / 100000);
                                        deuxiemePlace = (classement / 10000 % 10);
                                        if(premierePlace == premierChevalInput && deuxiemePlace == deuxiemeChevalInput){
                                            System.out.println(MSG_BRAVO);
                                            montantGagne += montantMiseInput * 3.5;
                                            gain += montantGagne;
                                            montantBanque += montantGagne;
                                        } else {
                                            System.out.println(MSG_DESOLE);
                                        }
                                        boolAffichageGainPerte = true;
                                    } else {
                                        System.out.println(ENTETE_OPERATION_ANNULEE + MSG_RETOUR_MENU_PRINCIPAL);
                                        Clavier.lireFinLigne();
                                        boolPari = false;
                                    }
                                    break;

                                //MENU PLACER UN PARI -> PARI COUPLE GAGNANT NON ORDONNÉ (4)
                                //CHOIX DE DEUX CHEVAUX. LE PARI EST GAGNANT SI CEUX-CI TERMINE PREMIER ET DEUXIÈME (PEU IMPORTE L'ORDRE).
                                case SELECTION_4:

                                    //CHOIX CHEVAUX
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

                                    //MONTANT DE LA MISE
                                    System.out.print(MSG_MONTANT_MISE);
                                    montantMiseInput = Clavier.lireDoubleLn();
                                    while(montantMiseInput < 0 || montantMiseInput > montantBanque){
                                        System.out.printf(MSG_ERREUR_MONTANT_MISE + "%.2f" + "$! Recommencez...\n",  montantBanque);
                                        System.out.print(MSG_MONTANT_MISE);
                                        montantMiseInput = Clavier.lireDoubleLn();
                                    }

                                    //EXÉCUTION DE LA COURSE (SI LA MISE N'EST PAS DE 0)
                                    if (montantMiseInput > 0 && montantMiseInput <= montantBanque){
                                        montantBanque -= montantMiseInput;
                                        gain -= montantMiseInput;

                                        classement = TP1Utils.executerCourse();
                                        premierChevalInput = menuSelection1erChevalInput - '0';
                                        deuxiemeChevalInput = menuSelection2emeChevalInput - '0';
                                        premierePlace = (classement / 100000);
                                        deuxiemePlace = (classement / 10000 % 10);
                                        if((premierePlace == premierChevalInput && deuxiemePlace == deuxiemeChevalInput) ||
                                        (premierePlace == deuxiemeChevalInput && deuxiemePlace == premierChevalInput)){
                                            System.out.println(MSG_BRAVO);
                                            montantGagne += montantMiseInput * 2.5;
                                            gain += montantGagne;
                                            montantBanque += montantGagne;
                                        } else {
                                            System.out.println(MSG_DESOLE);
                                        }
                                        boolAffichageGainPerte = true;
                                    } else {
                                        System.out.println(ENTETE_OPERATION_ANNULEE + MSG_RETOUR_MENU_PRINCIPAL);
                                        Clavier.lireFinLigne();
                                        boolPari = false;
                                    }
                                    break;

                                //MENU PLACER UN PARI -> REVENIR AU MENU PRINCIPAL (5)
                                //CHANGE LE BOOLÉEN « boolPari » À FALSE AFIN DE SORTIR DE NOTRE BOUCLE « do/while »
                                case SELECTION_5:
                                    boolPari = false;
                                    break;

                                //ERREUR DE SÉLECTION POUR LE MENU « PLACER UN PARI »
                                default:
                                    System.out.println(MSG_ERREUR_CHOIX_PARI);
                                    System.out.print(MSG_MENU_PARI);
                                    menuPariInput = Clavier.lireCharLn();
                            }

                            //AFFICHER GAIN OU PERTE & AJOUT À LA BANQUE SI ELLE EST VIDE
                            //S'EXÉCUTE SEULEMENT SI UNE COURSE À LIEU (PAS SI L'UTILISATEUR A VOULU RETOURNER EN ARRIÈRE)
                            while(boolAffichageGainPerte){
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
                                boolAffichageGainPerte = false;
                                boolPari = false;
                            }

                            //INTERFACE POUR AJOUTER DES FONDS DANS LA BANQUE
                            //S'EXÉCUTE SEULEMENT SI LE DERNIER PARI EFFECTUÉ A VIDÉ LA BANQUE DE L'UTILISATEUR
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
                        } while (boolPari);
                        break;

                    //AFFICHAGE DU MENU « GÉRER LA BANQUE »
                    case SELECTION_2:
                        boolBanque = true;
                        System.out.print(ENTETE_MENU_BANQUE);

                        // SÉLECTION MENU « GÉRER LA BANQUE » (AJOUTER, VIDER OU REVENIR EN ARRIÈRE)
                        do{
                            System.out.printf(MSG_DEBUT_GERER_BANQUE + "%.2f" + MSG_FIN_GERER_BANQUE,  montantBanque);
                            menuBanqueInput = Clavier.lireCharLn();

                            //GÉRER LA BANQUE -> AJOUTER DES FONDS ('A' ou 'a').
                            //LE MONTANT DOIT ÊTRE PLUS GRAND QUE 0.
                            if (menuBanqueInput == AJOUTER_BANQUE_MAJ || menuBanqueInput == AJOUTER_BANQUE_MIN) {
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

                            //GÉRER LA BANQUE -> VIDER LE COMPTE ('V' ou 'v').
                            //VIDE LE COMPTE DE BANQUE ET MET FIN AU PROGRAMME.
                            } else if (menuBanqueInput == VIDER_BANQUE_MAJ || menuBanqueInput == VIDER_BANQUE_MIN){
                                montantBanque = 0.00;
                                boolBanque = false;
                                boolMenu = false;

                            //GÉRER LA BANQUE -> RETOUR AU MENU PRINCIPAL ('R' ou 'r').
                            //RETOURNE L'UTILISATEUR AU MENU PRINCIPAL.
                            } else if(menuBanqueInput == REVENIR_BANQUE_MAJ || menuBanqueInput == REVENIR_BANQUE_MIN){
                                boolBanque = false;

                            //ERREUR SI LA VALEUR RENTRÉE N'EST PAS PARMI LES OPTIONS.
                            } else {
                                System.out.print(MSG_ERREUR_CHOIX_BANQUE);
                            }
                        } while(boolBanque);
                        break;

                    //MENU PRINCIPAL -> QUITTER LE PROGRAMME (3)
                    case SELECTION_3:
                        boolMenu = false;
                        break;
                    default:
                        System.out.println(MSG_ERREUR_CHOIX_MENU);
                }

            //SI LE MONTANT RENTRÉ AU TOUT DÉBUT DU PROGRAMME EST '0', MET FIN AU PROGRAMME.
            } else if (montantBanqueInput == 0) {
                boolMenu = false;
            }
        } while(boolMenu);
        System.out.println(MSG_FIN_PROGRAMME);
    }
}