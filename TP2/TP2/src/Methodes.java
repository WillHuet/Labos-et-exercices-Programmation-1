public class Methodes {
    //  ++++++++++++++
    //  + CONSTANTES +
    //  ++++++++++++++

    //MESSAGE TRADITIONNEL
    public final static String MSG_INPUT_CLE = "CLE DE CRYPTAGE : ";
    public final static String MSG_INPUT_MSG = "MESSAGE A CRYPTER (ENTREE pour annuler) : ";

    //MESSAGE D'ERREUR
    public final static String MSG_ERREUR_CLE = "ERREUR, clé invalide ! Recommencez...";
    public final static String MSG_ERREUR_MSG = "ERREUR, message invalide :\n" +
            "\tLe message ne peut contenir que des lettres, des chiffres, des\n" +
            "\tespaces, et les caractères .!?,;:'-\"";


    //  ++++++++++++
    //  + MÉTHODES +
    //  ++++++++++++

    public static void validerTexte(String message) {
        boolean valide = false;
        int nbrErreur = 0;
        String texte = message;

        while (valide == false) {
            for (int i = 0; i < texte.length(); i++) {
                boolean caractereValide = validationChar(texte.charAt(i));
                if (!caractereValide) {
                    nbrErreur++;
                }
            }

            if(nbrErreur == 0) {
                valide = true;
            } else{
                texte = affichageErreurMessage();
            }
        }
    }

    /**
     * Cette méthode valide si la clé de cryptage est valide.
     * La validation s'effectue sur plusieurs étapes :
     *  1) Valider le nombre de caractères (doit être divisible par 4).
     *  2) Diviser notre clé en blocs de quatre caractères.
     *  3) Valider si les deux premiers caractères du bloc sont valides (RG, RD, PE, PI, ou IV).
     *  4) Valider si les deux derniers caractères du bloc sont des chiffres et s'ils sont valides (entre 00 et 99).
     *
     * Ces quatre étapes s'effectuent autant de fois qu'il y a de bloc de quatre caractères.
     * Si aucune erreur n'a été repéré au cours de l'exécution de la boucle, le programme continue.
     *
     * @param cle la clé de cryptage
     */

    public static void validerCle(String cle) {
        boolean valide = false;

        int position = 0;
        int nbrDeManipulation = 0;
        int nbrErreur = 0;

        String texte = cle;
        String texteEnMaj = "";
        String bloc = "";
        String deuxLettres = "";
        String deuxChiffres = "";

        while (valide == false) {
            position = 0;
            nbrErreur = 0;
            if(texte.length() % 4 == 0){
                texteEnMaj = texte.toUpperCase();
                nbrDeManipulation = texte.length() / 4;
                for (int i = 0; i < nbrDeManipulation; i++) {
                    bloc = texteEnMaj.substring(position , position + 4);
                    deuxLettres = bloc.substring(0,2);
                    deuxChiffres = bloc.substring(2,4);
                    if(deuxLettres.equals("RG") || deuxLettres.equals("RD") || deuxLettres.equals("PE") || deuxLettres.equals("PI") || deuxLettres.equals("IV")) {
                        if(Character.isDigit(deuxChiffres.charAt(0)) && Character.isDigit(deuxChiffres.charAt(1))) {
                            if(Integer.parseInt(deuxChiffres) >= 0 || Integer.parseInt(deuxChiffres) <= 99){

                            } else {
                                nbrErreur++;
                            }
                        } else{
                            nbrErreur++;
                        }
                    } else {
                        nbrErreur++;
                    }
                    position = position + 4;
                }
                if(nbrErreur == 0) {
                    valide = true;
                } else {
                    texte = affichageErreurCle();
                }
            } else{
                texte = affichageErreurCle();
            }
        }
    }

    public static boolean validationChar(char c) {
        if ((c >= 'a' && c <= 'z') ||
            (c >= 'A' && c <= 'Z') ||
            (c >= '0' && c <= '9') ||
            (c == ' ') ||
            (c == '.' || c == '!' || c == '?' || c == ',' || c == ';' || c == ':' || c == '\'' || c == '-' || c == '"')){
            return true;
        } else {
            return false;
        }
    }

    public static String affichageErreurCle() {
        System.out.println(MSG_ERREUR_CLE);
        System.out.print(MSG_INPUT_CLE);
        return Clavier.lireString();
    }

    public static String affichageErreurMessage() {
        System.out.println(MSG_ERREUR_MSG);
        System.out.print(MSG_INPUT_MSG);
        return Clavier.lireString();
    }

    /**
     * Cette methode saisit et valide le choix de l'utilisateur
     * entre borneInf et borneSup.
     * @param msgSoll le msg de sollicitation du choix de l'utilisateur.
     * @param msgErr le msg d'erreur lorsqu'un choix est invalide.
     * @param borneInf la borne inferieure pour un choix valide.
     * @param borneSup la borne superieure pour un choix valide.
     * @return le choix valide de l'utilisateur, entre borneInf et
     * borneSup.
     */
    public static char validerChoixMenu (String msgSoll, String
            msgErr, char borneInf, char borneSup) {
        char choixMenu;
        System.out.print ("\n" + msgSoll);
        choixMenu = Clavier.lireCharLn();
        while (choixMenu < borneInf || choixMenu > borneSup) {
            System.out.println(msgErr);
            System.out.print (msgSoll);
            choixMenu = Clavier.lireCharLn();
        }
        return choixMenu;
    }

    /**
     * Crypte le msg donne avec la cle de cryptage donnee, et retourne
     * le message crypte.
     *
     * ANTECEDENT : la cle et le msg doivent être valides.
     *
     * @param cle la cle de cryptage
     * @param msg le message a crypter avec la cle donnee
     * @return le message crypte
     */
    public static String crypter(String cle, String msg){
        validerCle(cle);
        validerTexte(msg);

        return null;
    }

    /**
     * Décrypte le msg donne avec la clé de cryptage donnée, et retourne
     * le message décrypté.
     *
     * ANTECEDENT : la clé et le msg doivent être valides.
     *
     * @param cle la cle de cryptage
     * @param msg le message à décrypter avec la clé donnée
     * @return le message décrypte
     */
    public static String decrypter(String cle, String msg){
        return null;
    }
}
