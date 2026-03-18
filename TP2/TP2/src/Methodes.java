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
        boolean valide = false;

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
                } else if(!Character.isDigit(deuxChiffres.charAt(0)) || !Character.isDigit(deuxChiffres.charAt(1))){
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
        String message = msg;
        int nbrDeManipulation = cle.length() / 4;
        int position = 0;

        validerCle(cle, msg);
        validerMessage(msg, msg);

        for (int i = 0; i < nbrDeManipulation; i++) {
            String bloc = message.substring(position , position + 4);
            String deuxLettres = bloc.substring(0,2);
            int deuxChiffres = Integer.parseInt(bloc.substring(2,4));

            if(deuxLettres.equals("RG")){
                message = crypterRotationGauche(message, deuxChiffres);
            } else if(deuxLettres.equals("RD")){
                message = crypterRotationDroite(message, deuxChiffres);
            } else if(deuxLettres.equals("PE")){
                message = crypterPermutationExterieure(message, deuxChiffres);
            } else if(deuxLettres.equals("PI")){
                message = crypterPermutationInterieure(message, deuxChiffres);
            } else if(deuxLettres.equals("IV")){
                message = crypterInversion(message, deuxChiffres);
            }
            position = position + 4;
        }

        return message;
    }

    public static String crypterRotationGauche(String message, int iteration){
        String m = message;
        for(int i = 0; i < iteration; i++){
            m = m.substring(1) + m.charAt(0);
        }
        return m;
    }

    public static String crypterRotationDroite(String message, int iteration){
        String m = message;
        for(int i = 0; i < iteration; i++){
            m = m.charAt(m.length() - 1) + m.substring(0, m.length() - 2);
        }
        return m;
    }

    public static String crypterPermutationExterieure(String message, int iteration){
        String m = message;
        int indexDernierCarac = m.length() - 1;
        int positionPermutation = 0;

        if (indexDernierCarac != 0){
            for(int i = 0; i < iteration; i++){
                if (positionPermutation == 0){
                    m = m.charAt(indexDernierCarac) +
                        m.substring(1, indexDernierCarac) +
                        m.charAt(positionPermutation);
                } else {
                    m = m.substring(0, positionPermutation) +
                        m.charAt(indexDernierCarac - positionPermutation) +
                        m.substring(positionPermutation + 1, indexDernierCarac - positionPermutation) +
                        m.charAt(positionPermutation) +
                        m.substring(indexDernierCarac - positionPermutation + 1);
                }

                if (m.length() % 2 == 0) {
                    if (positionPermutation+1 == m.length()/2) {
                        positionPermutation = 0;
                    } else {
                        positionPermutation++;
                    }
                } else {
                    if (positionPermutation+1 >= m.length()/2) {
                        positionPermutation = 0;
                    } else {
                        positionPermutation++;
                    }
                }

            }
        }

        return m;
    }

    public static String crypterPermutationInterieure(String message, int iteration){
        String m = message;
        int indexDernierCarac = m.length() - 1;
        int positionPermutation = m.length()/2 -1;

        if (indexDernierCarac != 0){
            for(int i = 0; i < iteration; i++){
                if (positionPermutation == 0){
                    m = m.charAt(indexDernierCarac) +
                        m.substring(1, indexDernierCarac) +
                        m.charAt(positionPermutation);
                } else {
                    m = m.substring(0, positionPermutation) +
                        m.charAt(indexDernierCarac - positionPermutation) +
                        m.substring(positionPermutation + 1, indexDernierCarac - positionPermutation) +
                        m.charAt(positionPermutation) +
                        m.substring(indexDernierCarac - positionPermutation + 1);
                }

                if (positionPermutation == 0) {
                    positionPermutation = m.length()/2 -1;
                } else {
                    positionPermutation--;
                }
            }
        }

        return m;
    }

    public static String crypterInversion(String message, int iteration){
        String m = message;
        String resultat = "";
        int nbrCaracteres = m.length();
        int indexDernierCarac = nbrCaracteres - 1;

        if (nbrCaracteres >= iteration){
            
        } else {
            return m;
        }

        return m;
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
