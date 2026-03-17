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

    /**
     * Cette méthode saisit et valide le message entré par l'utilisateur.
     * (utilise la méthode « validationCaracteres() » pour s'assurer que le message est conforme)
     *
     * @param msgSoll le msg de sollicitation du choix de l'utilisateur.
     * @param msgErr le msg d'erreur lorsqu'un choix est invalide.
     * @return le message validé.
     */
    public static String validerMessage(String msgSoll, String msgErr) {
        String texte;

        System.out.print ("\n" + msgSoll);
        texte = Clavier.lireString();

        while (!validationCaracteres(texte)) {
            System.out.println(msgErr);
            System.out.print (msgSoll);
            texte = Clavier.lireString();
        }
        return texte;
    }

    /**
     * Cette méthode saisit et valide la clé entré par l'utilisateur.
     * (utilise la méthode « validationBlocsCle() » pour s'assurer que la clé est conforme)
     *
     * @param msgSoll le msg de sollicitation du choix de l'utilisateur.
     * @param msgErr le msg d'erreur lorsqu'un choix est invalide.
     * @return la clé validée.
     */
    public static String validerCle(String msgSoll, String msgErr) {
        String cle;

        System.out.print ("\n" + msgSoll);
        cle = Clavier.lireString();

        while (!validationBlocsCle(cle)) {
            System.out.println(msgErr);
            System.out.print (msgSoll);
            cle = Clavier.lireString();
        }
        return cle;
    }

    /**
     * Cette méthode permet de valider si tous les caractères d'un message sont valides.
     * @param message le message que l'on souhaite analyser.
     * @return TRUE si tous les caractères sont valides, FALSE si l'un ou plusieurs sont interdits.
     */
    public static boolean validationCaracteres(String message) {
        boolean resulat = true;
        for(int i = 0; i < message.length(); i++) {
            char c = message.charAt(i);
            if ((c >= 'a' && c <= 'z') ||
               (c >= 'A' && c <= 'Z') ||
               (c >= '0' && c <= '9') ||
               (c == ' ') ||
               (c == '.' || c == '!' || c == '?' || c == ',' || c == ';' || c == ':' || c == '\'' || c == '-' || c == '"')){
            } else {
                resulat = false;
            }
        }
        return resulat;
    }

    /**
     * Cette méthode valide si la clé de cryptage est valide.
     * La validation s'effectue sur plusieurs étapes :
     *  1) Valider le nombre de caractères (doit être divisible par 4).
     *  2) Diviser notre clé en blocs de quatre caractères.
     *  3) Valider si les deux premiers caractères du bloc sont valides (RG, RD, PE, PI, ou IV).
     *  4) Valider si les deux derniers caractères du bloc sont des chiffres et s'ils sont valides (entre 00 et 99).
     * Ces quatre étapes s'effectuent autant de fois qu'il y a de bloc de quatre caractères.
     *
     * @param cle la clé que l'on souhaite valider bloc par bloc.
     * @return TRUE tous les blocs sont acceptables, FALSE si au minimum l'un d'entre eux possède une erreur.
     */
    public static boolean validationBlocsCle(String cle) {
        boolean resulat = true;

        String texteEnMaj = "";
        String deuxLettres = "";
        String deuxChiffres = "";

        int nbrDeManipulation = 0;
        int position = 0;

        if(cle.length() % 4 == 0){
            texteEnMaj = cle.toUpperCase();
            nbrDeManipulation = texteEnMaj.length() / 4;
            for (int i = 0; i < nbrDeManipulation; i++) {
                String bloc = texteEnMaj.substring(position , position + 4);
                deuxLettres = bloc.substring(0,2);
                deuxChiffres = bloc.substring(2,4);
                if(!deuxLettres.equals("RG") && !deuxLettres.equals("RD") && !deuxLettres.equals("PE") && !deuxLettres.equals("PI") && !deuxLettres.equals("IV")) {
                    resulat = false;
                } else if(Character.isDigit(deuxChiffres.charAt(0)) && Character.isDigit(deuxChiffres.charAt(1))) {
                    if(Integer.parseInt(deuxChiffres) < 0 || Integer.parseInt(deuxChiffres) > 100){
                        resulat = false;
                    }
                }
                position = position + 4;
            }
        } else {
            resulat = false;
        }
        return resulat;
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
        //validerCle(cle);
        //validerTexte(msg);

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
