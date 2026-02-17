/**
 * Cette classe contient...
 *
 * @author : William Huet (HUEW75120205)
 * @version : 10 février 2026
 */

public class ParisHippiques {
    //LES CONSTANTES VONT ICI
    //CONSTANTES
    final static String MSG_BIENVENUE = "Ce programme permet de placer des paris sur des courses hippiques virtuelles.\n";
    final static String MSG_METTRE_MONTANT_BANQUE = "Votre banque est vide.\n" +
            "Pour continuer, entrez un montant à mettre en banque (0 pour quitter) : ";
    final static String MSG_FIN_PROGRAMME = "Fin du programme. Aurevoir!";
    final static String MSG_MENU_PRINCIPAL =
            "\n" +
            "----\n" +
            "MENU\n" +
            "----\n" +
            "1. Placer un pari\n" +
            "2. Gérer la banque\n" +
            "3. Quitter\n" +
            "\n" +
            "Entrez votre choix : ";
    final static String MSG_MENU_PARI =
            "\n" +
            "--------------\n" +
            "PLACER UN PARI\n" +
            "--------------\n" +
            "\n" +
            "Type de pari\n" +
            "  1. Pari simple gagnant\n" +
            "  2. Pari simple placé\n" +
            "  3. Pari couplé gagnant ordonné\n" +
            "  4. Pari couplé gagnant non ordonné\n" +
            "  5. Revenir au menu principal\n" +
            "\n" +
            "Entrez le type de pari : ";
    final static String MSG_GERER_BANQUE =
            "\n" +
            "---------------\n" +
            "GÉRER LA BANQUE\n" +
            "---------------\n" +
            "\n" +
            "** Montant en banque : 100.00$ **\n" +
            "\n" +
            "(A)jouter, (V)ider, ou (R)evenir au menu principal : ";

    final static int MENU_1 = 1;
    final static byte MENU_2 = 2;
    final static byte MENU_3 = 3;

    final static byte AJOUTER_BANQUE = 'A';
    final static byte VIDER_BANQUE = 'V';
    final static byte REVENIR_BANQUE = 'R';

    //**ERREURS**
    final static String MSG_ERREUR_MONTANT_BANQUE = "Erreur, le montant doit être plus grand ou égal a 0! Recommencez...";
    final static String MSG_ERREUR_CHOIX_MENU = "Erreur, entrez un choix entre 1 et 3! Recommencez...";

    public static void main(String[] args) {

        //VARIABLES
        boolean enMarche = true;
        double montantBanqueInput = 0.00;
        double montantBanque = 0.00;
        int menuPrincipalInput = 0;
        int valeurMenu = 0;


        //DÉBUT DU CODE
        System.out.println(MSG_BIENVENUE);

        System.out.println(MSG_METTRE_MONTANT_BANQUE);
        montantBanqueInput = Clavier.lireDoubleLn();

        do{
            if (montantBanqueInput > 0){
                montantBanque = montantBanqueInput;

                System.out.println(MSG_MENU_PRINCIPAL);
                menuPrincipalInput = Clavier.lireIntLn();

                do{
                    switch (menuPrincipalInput){
                        case MENU_1:
                            System.out.println(MSG_MENU_PARI);
                            break;
                        case MENU_2:
                            System.out.println(MSG_GERER_BANQUE);
                            break;
                        case MENU_3:
                            enMarche = false;
                            break;
                        default:
                            System.out.println(MSG_ERREUR_CHOIX_MENU);
                    }
                }
                while (menuPrincipalInput >= 1 && menuPrincipalInput <= 2);
            } else if (montantBanqueInput < 0) {
                System.out.println(MSG_ERREUR_MONTANT_BANQUE);
                montantBanqueInput = Clavier.lireDoubleLn();
            }
        }
        while(enMarche);
        System.out.println(MSG_FIN_PROGRAMME);
    }
}
