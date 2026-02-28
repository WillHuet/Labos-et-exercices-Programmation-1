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
    //----------
    //CONSTANTES
    //----------

    //Long messages et interfaces de menu (plus de deux lignes).
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

    //Petits messages (une ou deux lignes max).
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

    //Messages d'erreurs.
    public final static String MSG_ERREUR_MONTANT_BANQUE = "\n" + "ERREUR, le montant doit être plus grand ou égal a 0! Recommencez... ";
    public final static String MSG_ERREUR_CHOIX_MENU = "\n" + "ERREUR, entrez un choix entre 1 et 3! Recommencez... ";
    public final static String MSG_ERREUR_CHOIX_PARI = "\n" + "ERREUR, entrez un choix entre 1 et 5! Recommencez... ";
    public final static String MSG_ERREUR_CHOIX_CHEVAL = "\n" + "ERREUR, entrez un choix entre 1 et 6! Recommencez... ";
    public final static String MSG_ERREUR_CHOIX_BANQUE = "\n" + "ERREUR, entrez A, V ou R! Recommencez..." + "\n";
    public final static String MSG_ERREUR_MONTANT_MISE = "\n" + "ERREUR, la mise doit être entre 0.00$ et ";

    //Valeurs pour sélection dans les multiples menus.
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
        //---------
        //VARIABLES
        //---------

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

        //DÉBUT DU PROGRAMME
        //Demande à l'utilisateur de rentrer un montant pour la banque.
        System.out.println(MSG_BIENVENUE);
        System.out.print(MSG_METTRE_MONTANT_BANQUE);
        montantBanqueInput = Clavier.lireDoubleLn();

        while (montantBanqueInput < 0) {
            System.out.print(MSG_ERREUR_MONTANT_BANQUE);
            System.out.print(MSG_METTRE_MONTANT_BANQUE);
            montantBanqueInput = Clavier.lireDoubleLn();
        }
        montantBanque = montantBanqueInput;

        //Affichage du premier menu (principal).
        do{
            if (montantBanqueInput > 0){
                System.out.print(ENTETE_MENU_PRINCIPAL + MSG_MENU_PRINCIPAL);
                menuPrincipalInput = Clavier.lireCharLn();

                //Sélection pour le menu principal (pari, banque ou quitter).
                switch (menuPrincipalInput){

                    //Menu principal --> Placer un pari (1)
                    case SELECTION_1:
                        System.out.print(ENTETE_MENU_PARI + MSG_MENU_PARI);
                        menuPariInput = Clavier.lireCharLn();
                        boolPari = true;
                        montantGagne = 0;
                        do{

                            //Sélection pour le menu « Placer un pari » (4 différents types de pari et l'option pour revenir en arrière).
                            switch (menuPariInput){

                                //Menu placer un pari --> Pari simple (1)
                                //On choisi un seul cheval. Le pari est gagnant si celui-ci termine premier.
                                case SELECTION_1:

                                    //Choix du cheval.
                                    System.out.print(MSG_LISTE_CHEVAUX + MSG_CHOIX_UNIQUE_CHEVAL);
                                    menuSelection1erChevalInput = Clavier.lireCharLn();
                                    while((byte)menuSelection1erChevalInput < (byte)SELECTION_1 || (byte)menuSelection1erChevalInput > (byte)SELECTION_6){
                                        System.out.println(MSG_ERREUR_CHOIX_CHEVAL + MSG_LISTE_CHEVAUX + MSG_CHOIX_UNIQUE_CHEVAL);
                                        menuSelection1erChevalInput = Clavier.lireCharLn();
                                    }

                                    //Montant de la mise.
                                    System.out.print(MSG_MONTANT_MISE);
                                    montantMiseInput = Clavier.lireDoubleLn();
                                    while(montantMiseInput < 0 || montantMiseInput > montantBanque){
                                        System.out.printf(MSG_ERREUR_MONTANT_MISE + "%.2f" + "$! Recommencez...\n",  montantBanque);
                                        System.out.print(MSG_MONTANT_MISE);
                                        montantMiseInput = Clavier.lireDoubleLn();
                                    }

                                    //Exécution de la course (si la mise n'est pas de 0).
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
                                        System.out.print(ENTETE_OPERATION_ANNULEE + MSG_RETOUR_MENU_PRINCIPAL);
                                        Clavier.lireFinLigne();
                                        boolPari = false;
                                    }
                                    break;

                                //Menu placer un pari --> Pari place (2)
                                //On choisit un seul cheval. Le pari est gagnant si celui-ci termine premier ou deuxième.
                                case SELECTION_2:

                                    //Choix du cheval.
                                    System.out.print(MSG_LISTE_CHEVAUX + MSG_CHOIX_UNIQUE_CHEVAL);
                                    menuSelection1erChevalInput = Clavier.lireCharLn();
                                    while((byte)menuSelection1erChevalInput < (byte)SELECTION_1 || (byte)menuSelection1erChevalInput > (byte)SELECTION_6){
                                        System.out.println(MSG_ERREUR_CHOIX_CHEVAL + MSG_LISTE_CHEVAUX + MSG_CHOIX_UNIQUE_CHEVAL);
                                        menuSelection1erChevalInput = Clavier.lireCharLn();
                                    }

                                    //Montant de la mise.
                                    System.out.print(MSG_MONTANT_MISE);
                                    montantMiseInput = Clavier.lireDoubleLn();
                                    while(montantMiseInput < 0 || montantMiseInput > montantBanque){
                                        System.out.printf(MSG_ERREUR_MONTANT_MISE + "%.2f" + "$! Recommencez...\n",  montantBanque);
                                        System.out.print(MSG_MONTANT_MISE);
                                        montantMiseInput = Clavier.lireDoubleLn();
                                    }

                                    //Exécution de la course (si la mise n'est pas de 0).
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
                                        System.out.print(ENTETE_OPERATION_ANNULEE + MSG_RETOUR_MENU_PRINCIPAL);
                                        Clavier.lireFinLigne();
                                        boolPari = false;
                                    }
                                    break;

                                //Menu placer un pari --> Pari couple gagnant ordonné (3)
                                //On choisi deux chevaux. Le pari est gagnant si ceux-ci termine respectivement premier et deuxième.
                                case SELECTION_3:

                                    //Choix des chevaux.
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

                                    //Montant de la mise.
                                    System.out.print(MSG_MONTANT_MISE);
                                    montantMiseInput = Clavier.lireDoubleLn();
                                    while(montantMiseInput < 0 || montantMiseInput > montantBanque){
                                        System.out.printf(MSG_ERREUR_MONTANT_MISE + "%.2f" + "$! Recommencez...\n",  montantBanque);
                                        System.out.print(MSG_MONTANT_MISE);
                                        montantMiseInput = Clavier.lireDoubleLn();
                                    }

                                    //Exécution de la course (si la mise n'est pas de 0).
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
                                        System.out.print(ENTETE_OPERATION_ANNULEE + MSG_RETOUR_MENU_PRINCIPAL);
                                        Clavier.lireFinLigne();
                                        boolPari = false;
                                    }
                                    break;

                                //Menu placer un pari --> Pari couple gagnant non ordonné (4)
                                //Choix de deux chevaux. Le pari est gagnant si ceux-ci termine premier et deuxième (peu importe l'ordre).
                                case SELECTION_4:

                                    //Choix des chevaux.
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

                                    //Montant de la mise.
                                    System.out.print(MSG_MONTANT_MISE);
                                    montantMiseInput = Clavier.lireDoubleLn();
                                    while(montantMiseInput < 0 || montantMiseInput > montantBanque){
                                        System.out.printf(MSG_ERREUR_MONTANT_MISE + "%.2f" + "$! Recommencez...\n",  montantBanque);
                                        System.out.print(MSG_MONTANT_MISE);
                                        montantMiseInput = Clavier.lireDoubleLn();
                                    }

                                    //Exécution de la course (si la mise n'est pas de 0).
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
                                        System.out.print(ENTETE_OPERATION_ANNULEE + MSG_RETOUR_MENU_PRINCIPAL);
                                        Clavier.lireFinLigne();
                                        boolPari = false;
                                    }
                                    break;

                                //Menu placer un pari --> Revenir au menu principal (5)
                                //Change la valeur du booléen « boolPari » pour false afin de sortir de notre boucle « do/while ».
                                case SELECTION_5:
                                    boolPari = false;
                                    break;

                                //Erreur de sélection pour le menu « Placer un pari ».
                                default:
                                    System.out.println(MSG_ERREUR_CHOIX_PARI);
                                    System.out.print(MSG_MENU_PARI);
                                    menuPariInput = Clavier.lireCharLn();
                            }

                            //Afficher « gain ou perte » & ajout à la banque si jamais celle-ci est maintenant vide.
                            //S'exécute seulement si une course à lieu (pas si l'utilisateur a voulu retourner en arrière).
                            while(boolAffichageGainPerte){
                                if (gain >= 0){
                                    System.out.printf(MSG_GAIN_CUMULE + "%.2f" + "$\n",  gain);
                                    System.out.printf(MSG_BANQUE_APRES_GAIN + "%.2f" + "$\n", montantBanque);
                                } else {
                                    gain *= -1;
                                    System.out.printf(MSG_PERTE_CUMULE + "%.2f" + "$\n", gain);
                                    System.out.printf(MSG_BANQUE_APRES_GAIN + "%.2f" + "$\n", montantBanque);
                                    gain *= -1;
                                    //J'aurais utilisé la méthode "Math.abs()" pour éviter d'avoir le signe de moins devant mais je n'ai pas le droit.
                                }
                                System.out.print(MSG_RETOUR_MENU_PRINCIPAL);
                                Clavier.lireFinLigne();
                                boolAffichageGainPerte = false;
                                boolPari = false;
                            }

                            //Interface pour ajouter des fonds dans la banque.
                            //S'exécute seulement si le dernier pari effectué a vidé la banque de l'utilisateur.
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

                    //Affichage du menu « Gérer la banque ».
                    case SELECTION_2:
                        boolBanque = true;
                        System.out.print(ENTETE_MENU_BANQUE);

                        //Sélection pour menu « Gérer la banque » (ajouter, vider ou revenir en arrière).
                        do{
                            System.out.printf(MSG_DEBUT_GERER_BANQUE + "%.2f" + MSG_FIN_GERER_BANQUE,  montantBanque);
                            menuBanqueInput = Clavier.lireCharLn();

                            //Gérer la banque --> Ajouter des fonds ('A' ou 'a').
                            //Le montant doit être plus grand que 0.
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

                            //Gérer la banque --> Vider le compte ('V' ou 'v').
                            //Vide le compte de banque et met fin au programme.
                            } else if (menuBanqueInput == VIDER_BANQUE_MAJ || menuBanqueInput == VIDER_BANQUE_MIN){
                                montantBanque = 0.00;
                                boolBanque = false;
                                boolMenu = false;

                            //Gérer la banque --> Retour au menu principal ('R' ou 'r').
                            //Retourne l'utilisateur au menu principal.
                            } else if(menuBanqueInput == REVENIR_BANQUE_MAJ || menuBanqueInput == REVENIR_BANQUE_MIN){
                                boolBanque = false;

                            //Erreur si la valeur rentrée n'est pas parmi les options.
                            } else {
                                System.out.print(MSG_ERREUR_CHOIX_BANQUE);
                            }
                        } while(boolBanque);
                        break;

                    //Menu principal --> Quitter le programme (3)
                    case SELECTION_3:
                        boolMenu = false;
                        break;
                    default:
                        System.out.println(MSG_ERREUR_CHOIX_MENU);
                }

            //Si le montant rentré au tout début du programme est '0', cela met fin au programme.
            } else if (montantBanqueInput == 0) {
                boolMenu = false;
            }
        } while(boolMenu);
        System.out.println(MSG_FIN_PROGRAMME);
    }
}