public class Cryptage {
    /*
    //  ++++++++++++++
    //  + CONSTANTES +
    //  ++++++++++++++
    */

    //MESSAGE TRADITIONNEL
    public final static String MSG_INPUT_CLE = "CLE DE CRYPTAGE : ";
    public final static String MSG_INPUT_MSG = "MESSAGE A CRYPTER (ENTREE pour annuler) : ";
    public static final String MSG_OPERATION_ANNULEE = "--> OPERATION ANNULÉE <--";
    public static final String MSG_SOLLICITATION_MENU = "----\n" +
            "MENU\n" +
            "----\n" +
            "1. Crypter un message\n" +
            "2. Décrypter un message\n" +
            "3. Quitter\n" +
            "\n" +
            "Entrez votre choix : ";

    //MESSAGE D'ERREUR
    public final static String MSG_ERREUR_CLE = "ERREUR, clé invalide ! Recommencez...";
    public final static String MSG_ERREUR_MSG = "ERREUR, message invalide :\n" +
            "\tLe message ne peut contenir que des lettres, des chiffres, des\n" +
            "\tespaces, et les caractères .!?,;:'-\"";
    public static final String MSG_ERREUR_MENU =
            "\n" +
            "ERREUR, choix de menu invalide ! Recommencez..." +
            "\n";

    /*
    //  ++++++++++++++++++++++
    //  + MÉTHODES INTERFACE +
    //  ++++++++++++++++++++++
    */

    /**
     * Cette methode affiche la presentation de ce programme.
     */
    public static void presenterLogiciel() {
        System.out.println("Ce logiciel permet de crypter et de décrypter des messages secrets. \n");
    }

    /**
     * Cette methode affiche un message disant a l'utilisateur
     * d'appuyer sur ENTREE pour continuer.
     */
    public static void pause() {
        System.out.print("Tapez <ENTRÉE> pour continuer...");
        Clavier.lireFinLigne();
    }
    /**
     * Cette methode affiche un message de fin du programme.
     */
    public static void finProgramme() {
        System.out.println("AUREVOIR !");
    }

    /*
    //  +++++++++++++++++++++++
    //  + MÉTHODES VALIDATION +
    //  +++++++++++++++++++++++
    */

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
        return cle.toUpperCase();
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

    /*
    //  +++++++++++++++++
    //  + MÉTHODES MENU +
    //  +++++++++++++++++
    */

    /**
     * Cette methode saisit et valide le choix de l'utilisateur
     * entre borneInf et borneSup.
     * @param msgSoll le msg de sollicitation du choix de l'utilisateur.
     * @param msgErr le msg d'erreur lorsqu'un choix est invalide.
     * @param borneInf la borne inférieure pour un choix valide.
     * @param borneSup la borne supérieure pour un choix valide.
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

    public static void selectionMenu(){
        char selection;
        do {
            selection = validerChoixMenu(MSG_SOLLICITATION_MENU, MSG_ERREUR_MENU, '1', '3');

            if (selection == '1'){
                String messageCrypte = crypter(validerCle(MSG_INPUT_CLE, MSG_ERREUR_CLE), validerMessage(MSG_INPUT_MSG, MSG_ERREUR_MSG));
                if (messageCrypte.equals(MSG_OPERATION_ANNULEE)){
                    System.out.println(MSG_OPERATION_ANNULEE);
                } else {
                    System.out.println("MESSAGE CRYPTÉ : [" + messageCrypte +"]");
                    pause();
                }
            } else if (selection == '2'){
                String messageDecrypte = decrypter(validerCle(MSG_INPUT_CLE, MSG_ERREUR_CLE), validerMessage(MSG_INPUT_MSG, MSG_ERREUR_MSG));
                if (messageDecrypte.equals(MSG_OPERATION_ANNULEE)){
                    System.out.println(MSG_OPERATION_ANNULEE);
                } else {
                    System.out.println("MESSAGE DÉCRYPTÉ : [" + messageDecrypte +"]");
                    pause();
                }
            }
        } while (selection != '3');
    }

    /*
    //  ++++++++++++++++++++++++
    //  + MÉTHODES (DÉ)CRYPTER +
    //  ++++++++++++++++++++++++
    */

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

        char exterieure = 'e';
        char interieure = 'i';
        char cryptage = 'c';

        if (message == ""){
            return MSG_OPERATION_ANNULEE;
        } else {
            for (int i = 0; i < nbrDeManipulation; i++) {
                String bloc = cle.substring(position , position + 4);
                String deuxLettres = bloc.substring(0,2);
                int deuxChiffres = Integer.parseInt(bloc.substring(2,4));

                if(deuxLettres.equals("RG")){
                    message = operationRotationGauche(message, deuxChiffres);
                } else if(deuxLettres.equals("RD")){
                    message = operationRotationDroite(message, deuxChiffres);
                } else if(deuxLettres.equals("PE")){
                    message = operationsPermutation(message, deuxChiffres, exterieure, cryptage);
                } else if(deuxLettres.equals("PI")){
                    message = operationsPermutation(message, deuxChiffres, interieure, cryptage);
                } else if(deuxLettres.equals("IV")){
                    message = operationInversion(message, deuxChiffres, cryptage);
                }
                position = position + 4;
            }
            return message;
        }
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
        String message = msg;

        int nbrDeManipulation = cle.length() / 4;
        int position = cle.length();

        char exterieure = 'e';
        char interieure = 'i';
        char decryptage = 'd';

        if (message == ""){
            return MSG_OPERATION_ANNULEE;
        } else {
            for (int i = 0; i < nbrDeManipulation; i++) {
                String bloc = cle.substring(position -4, position);
                String deuxLettres = bloc.substring(0,2);
                int deuxChiffres = Integer.parseInt(bloc.substring(2,4));

                if(deuxLettres.equals("RG")){
                    message = operationRotationDroite(message, deuxChiffres);
                } else if(deuxLettres.equals("RD")){
                    message = operationRotationGauche(message, deuxChiffres);
                } else if(deuxLettres.equals("PE")){
                    message = operationsPermutation(message, deuxChiffres, exterieure, decryptage);
                } else if(deuxLettres.equals("PI")){
                    message = operationsPermutation(message, deuxChiffres, interieure, decryptage);
                } else if(deuxLettres.equals("IV")){
                    message = operationInversion(message, deuxChiffres, decryptage);
                }
                position = position - 4;
            }
            return message;
        }
    }

    /*
    //  +++++++++++++++++++++++
    //  + MÉTHODES OPÉRATIONS +
    //  +++++++++++++++++++++++
    */

    public static String operationRotationGauche(String message, int iteration){
        String m = message;
        int nbrDeTransformation = iteration;

        if (nbrDeTransformation >= m.length()){
            nbrDeTransformation = nbrDeTransformation % m.length();
        }

        for(int i = 1; i <= nbrDeTransformation; i++){
            m = m.substring(1) + m.charAt(0);
        }
        return m;
    }

    public static String operationRotationDroite(String message, int iteration){
        String m = message;
        int nbrDeTransformation = iteration;

        if (nbrDeTransformation >= m.length()){
            nbrDeTransformation = nbrDeTransformation % m.length();
        }

        for(int i = 1; i <= nbrDeTransformation; i++){
            m = m.charAt(m.length() - 1) + m.substring(0, m.length() - 1);
        }
        return m;
    }

    public static String operationsPermutation(String message, int iteration, char typePermutation, char typeOperation){
        String m = message;

        char exterieure = 'e';
        char interieure = 'i';
        char cryptage = 'c';
        char decryptage = 'd';

        int indexDernierCarac = m.length() - 1;
        int nbrDeTransformation = iteration;
        int positionPermutation;

        //Optimise le nombre d'opération.
        //Détermine si le nombre de transformation est plus grand que la longueur du texte.
        //Si c'est le cas, on réduit le nombre de transformation par le nombre restant après une division (modulo).
        if (m.length() % 2 == 0 && nbrDeTransformation >= m.length()){
            nbrDeTransformation = nbrDeTransformation % m.length();
        } else if (m.length() % 2 != 0 && nbrDeTransformation >= m.length() -1){
            nbrDeTransformation = nbrDeTransformation % (m.length() - 1);
        }

        //Détermine si c'est une permutation intérieure ou extérieure et si c'est du cryptage ou décryptage (change la position de départ).
        if (typeOperation == cryptage) {
            //Pour le cryptage, on commence au début pour la permutation extérieure, et au milieu pour la permutation intérieure.
            if (typePermutation == exterieure){
                positionPermutation = 0;
            } else {
                positionPermutation = m.length()/2 -1;
            }
        } else {
            //Pour le décryptage, c'est pas mal plus complex.

            //Si permutation externe, la position de départ n'est pas la même si le nombre de transformation est plus grand que la moitié de la longueur du texte.
            //Si c'est le cas, on doit ..........................
            if (typePermutation == exterieure){
                positionPermutation = m.length() % nbrDeTransformation;
                if (positionPermutation > m.length()/2){
                    positionPermutation = nbrDeTransformation % m.length()/2;
                }
            } else {
                if (nbrDeTransformation > m.length()/2){
                    if (m.length() % 2 == 0){
                        positionPermutation = nbrDeTransformation - m.length()/2;
                    } else {
                        positionPermutation = (nbrDeTransformation - m.length()/2) -1;
                    }
                } else {
                    positionPermutation = m.length()/2 - nbrDeTransformation;
                }
            }
        }

        //Début du code pour qui effectue les modifications sur le texte.
        if (indexDernierCarac != 0){
            for(int i = 0; i < nbrDeTransformation; i++){
                //Si en première position, on doit inverser le premier et dernier caractère, et mettre les reste entre les deux.
                if (positionPermutation == 0){
                    m = m.charAt(indexDernierCarac) +
                    m.substring(1, indexDernierCarac) +
                    m.charAt(positionPermutation);
                } else {
                    //Dans toutes les autres situations, on doit mettre ce qui avant, entre et après les deux caractères que l'on souhaite interchanger.
                    m = m.substring(0, positionPermutation) +
                    m.charAt(indexDernierCarac - positionPermutation) +
                    m.substring(positionPermutation + 1, indexDernierCarac - positionPermutation) +
                    m.charAt(positionPermutation) +
                    m.substring(indexDernierCarac - positionPermutation + 1);
                }

                //La position de la manipulation varie selon l'opération souhaitée.
                //Le changement de position est le même pour crypter en permutation extérieure, ou décrypter en permutation intérieure.
                if ((typePermutation == exterieure && typeOperation == cryptage) || (typePermutation == interieure && typeOperation == decryptage)){
                    //Quand on arrive au milieu, on souhaite que la prochaine modification se fasse sur le premier caractère.
                    //Sinon, on augmente de un.
                    if (m.length() % 2 == 0) {
                        if (positionPermutation+1 == m.length()/2) {
                            positionPermutation = 0;
                        } else {
                            positionPermutation++;
                        }
                    }
                } else {
                    //Même chose pour la permutation intérieure, mais lorsqu'on arrive au début, on doit retourner au milieu.
                    //Également, on part du milieu et descends d'un caractère au lieu de monter de un.
                    if (positionPermutation == 0) {
                        positionPermutation = m.length() / 2 - 1;
                    } else {
                        positionPermutation--;
                    }
                }
            }
        }
        return m;
    }

    public static String operationInversion(String message, int iteration, char typeOperation){
        String m = message;
        String resultatPremiereInversion = "";
        String resultatDeuxiemeInversion = "";
        String resultatInversion = "";
        int nbrCaracteres = m.length();
        int nbrInversion = iteration-1;
        int indexDernierCarac = nbrCaracteres - 1;

        if (nbrCaracteres >= nbrInversion && nbrInversion != 0){
            if(typeOperation == 'c'){
                //Inversion avant
                for (int i = nbrInversion; i >= 0; i--){
                    resultatPremiereInversion += m.charAt(i);
                }
                resultatPremiereInversion += m.substring(iteration);

                //Inversion arrière
                for (int i = indexDernierCarac; i >= (indexDernierCarac-nbrInversion); i--){
                    resultatDeuxiemeInversion += resultatPremiereInversion.charAt(i);

                }
                resultatInversion = resultatPremiereInversion.substring(0, indexDernierCarac - nbrInversion) + resultatDeuxiemeInversion;

                return resultatInversion;
            } else {
                // ...
                return null;
            }
        } else {
            return m;
        }
    }

    /*
    //  ++++++++++++++++++++++++++
    //  + CLASSE EXÉCUTABLE MAIN +
    //  ++++++++++++++++++++++++++
    */

    public static void main(String [] args) {
        presenterLogiciel();
        pause();
        selectionMenu();

        finProgramme();
    }
}
