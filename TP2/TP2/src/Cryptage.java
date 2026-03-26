/**
 *  Cette classe sert à crypter et décrypter des messages.
 *
 *  Lorsque l'application se lance, on demande à l'utilisateur d'appuyer sur « ENTRÉE » pour lancer le programme.
 *  Par la suite, un menu comportant trois options apparait.
 *
 *  Si l'on sélectionne la PREMIÈRE option (1. Crypter un message), le programme ensuite demande à l'utilisateur de rentrer une clé de cryptage.
 *  Celle-ci doit respecter le format suivant:
 *      - La clé est composé uniquement de lettres et de chiffres.
 *      - Une clé doit être composée de un ou plusieurs « blocs ». Ceux-ci doivent contenir quatres caractères :
 *          - LES DEUX PREMIERS doivent être une des combinaisons suivante: RG, RD, PE, PI, IV (représente le type de cryptage).
 *          - LES DEUX DERNIERS doivent être des chiffres qui représentent un nombre entre 00 et 99 (représente le nombre itération).
 *  Après avoir rentrée une clé valide, le programme nous demande de rentrer le message que l'on souhaite crypter. Celui-ci peut contenir:
 *      - Des lettres, des chiffres, des espaces et les 9 caractères suivant: .!?,;:'-"
 *      - NE PEUT PAS contenir de saut de ligne (\n)
 *      - Si l'on laisse le message vide et que l'on appuie sur « ENTRÉE », on retourne au menu principal.
 *  Une fois le message validé, le programme nous renvoient le message crypté!
 *  On doit appuyer sur « ENTRÉE » pour retourner au menu principal.
 *
 *  Si l'on sélectionne la DEUXIÈME option (2. Decrypter un message), c'est pas mal les mêmes démarches que pour crypter.
 *  On demande premièrement une clé de décryptage valide (même validation que pour le cryptage).
 *  Par la suite, on demande le message que l'on souhaite décrypter (même validation que pour le cryptage).
 *  Le programme renvoient finalement le message décrypté et attend que l'utilisateur appuie sur « ENTRÉE » pour retourner au menu.
 *
 *  Si l'on sélectionne la TROISIÈME option (Quitter), cela met fin au programme.
 *
 *  -------------------------------------
 *  @author : William Huet (HUEW75120205)
 *  @version : 26 mars 2026
 *  -------------------------------------
 */

public class Cryptage {

    /*
    //  ++++++++++++++
    //  + CONSTANTES +
    //  ++++++++++++++
    */

    //CHAR
    public final static char exterieure = 'e';
    public final static char interieure = 'i';
    public final static char cryptage = 'c';
    public final static char decryptage = 'd';

    //MESSAGES TRADITIONNELS
    public final static String MSG_INPUT_CLE_CRYPTAGE = "CLÉ DE CRYPTAGE : ";
    public final static String MSG_INPUT_MSG_CRYPTAGE = "MESSAGE À CRYPTER (ENTRÉE pour annuler) : ";
    public final static String MSG_INPUT_CLE_DECRYPTAGE = "CLÉ DE DÉCRYPTAGE : ";
    public final static String MSG_INPUT_MSG_DECRYPTAGE = "MESSAGE À DÉCRYPTER (ENTRÉE pour annuler) : ";
    public static final String MSG_OPERATION_ANNULEE = "--> OPÉRATION ANNULÉE <--";
    public static final String MSG_SOLLICITATION_MENU = "----\n" +
            "MENU\n" +
            "----\n" +
            "1. Crypter un message\n" +
            "2. Décrypter un message\n" +
            "3. Quitter\n" +
            "\n" +
            "Entrez votre choix : ";

    //MESSAGES D'ERREURS
    public final static String MSG_ERREUR_CLE = "ERREUR, clé invalide ! Recommencez...";
    public final static String MSG_ERREUR_MSG = "ERREUR, message invalide :\n" +
            "\tLe message ne peut contenir que des lettres, des chiffres, des\n" +
            "\tespaces, et les caractères .!?,;:'-\"";
    public static final String MSG_ERREUR_MENU =
            "\n" +
            "ERREUR, choix de menu invalide ! Recommencez..." +
            "\n";

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

        if(cle.length() % 4 == 0 && !cle.isEmpty()){
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
    //  ++++++++++++++++++++++++++++++++++++++++++++
    //  + MÉTHODES OPÉRATIONS (RG, RD, PE, PI, IV) +
    //  ++++++++++++++++++++++++++++++++++++++++++++
    */

    /**
     * Cette méthode exécute l'opération de rotation vers la gauche.
     * En d'autres mots, on prend le caractère en première postion et on l'envoie en dernière.
     *
     * @param message le message que l'on veut modifier.
     * @param iteration le nombre de fois que l'on doit exécuter l'opération.
     * @return le message modifié.
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

    /**
     * Cette méthode exécute l'opération de rotation vers la droite.
     * En d'autres mots, on prend le caractère en dernière position et on l'envoie en première.
     *
     * @param message le message que l'on veut modifier.
     * @param iteration le nombre de fois que l'on doit exécuter l'opération.
     * @return le message modifié.
     */
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

    /**
     * Cette méthode exécute l'opération de permutation intérieure ET extérieure.
     * Pour la permutation extérieure, on souhaite permuter les caractères de l'extérieur vers l'intérieur.
     * À l'inverse, la permutation intérieure cherche à permuter les caractères de l'intérieur vers l'extérieur.
     *
     * On peut également effectuer le décryptage grâce à cette méthode.
     * (cette méthode contient beaucoup de commentaire puisqu'elle comporte plus d'une centaine de lignes).
     *
     * @param message le message que l'on veut modifier.
     * @param iteration le nombre de fois que l'on doit exécuter l'opération.
     * @param typePermutation le type de permutation à effectuer ('e' = extérieure / 'i' = intérieure).
     * @param typeOperation le type d'opération à effectuer ('c' = cryptage / 'd' = décryptage).
     * @return le message modifié.
     */
    public static String operationsPermutation(String message, int iteration, char typePermutation, char typeOperation){
        String m = message;

        int longueurMessage = m.length();
        int indexDernierCaractere = longueurMessage - 1;
        int indexMilieu = longueurMessage /2;
        int nbrDeTransformation = iteration;
        int positionPermutation;

        // !!! OPTIMISATION DU NOMBRE DE TRANSFORMATIONS !!!
        //Détermine si le nombre de transformations est plus grand que la longueur du texte.
        //Si c'est le cas, on réduit le nombre de transformations par le nombre restant après une division (modulo).
        if (longueurMessage % 2 == 0 && nbrDeTransformation >= longueurMessage){
            nbrDeTransformation = nbrDeTransformation % longueurMessage;
        } else if (longueurMessage % 2 != 0 && nbrDeTransformation >= indexDernierCaractere){
            nbrDeTransformation = nbrDeTransformation % (indexDernierCaractere);
        }

        // !!! DÉFINITION DE LA POSITION DE DÉPART !!!
        // Détermine si c'est une permutation intérieure ou extérieure et s'il s'agit de cryptage ou décryptage.
        // La position de départ dépend de plusieurs éléments (4 scénarios possibles).
        if (typeOperation == cryptage) {
            //Pour le CRYPTAGE, on commence au début pour la permutation extérieure, et au milieu pour la permutation intérieure.
            if (typePermutation == exterieure){
                positionPermutation = 0;
            } else {
                positionPermutation = indexMilieu -1;
            }
        } else {
            //Pour le DÉCRYPTAGE, c'est pas mal plus complex.
            //Pour la permutation extérieure, on détermine la position de départ par la longueur du texte modulo le nombre de transformations.
            if (typePermutation == exterieure){
                if (nbrDeTransformation > indexMilieu){
                    positionPermutation = nbrDeTransformation - indexMilieu -1;
                } else {
                    positionPermutation = nbrDeTransformation -1;
                }
            } else {
                //Pour la permutation intérieure, la position de départ varie selon plusieurs critères.
                if (nbrDeTransformation > indexMilieu){
                    //Si le nombre de transformations surpassent la longueur de la moitié du texte,
                    //On doit ensuite déterminer si le nombre de caractères est pair ou impair (on doit retirer un si impair).
                    if (longueurMessage % 2 == 0){
                        positionPermutation = nbrDeTransformation - indexMilieu;
                    } else {
                        positionPermutation = (nbrDeTransformation - indexMilieu) -1;
                    }
                } else {
                    //Si le nombre de transformations ne surpassent pas la longueur de la moitié du texte,
                    //On réduit le nombre de transformations à la longueur de la moitié du texte.
                    positionPermutation = indexMilieu - nbrDeTransformation;
                }
            }
        }

        // !!! DÉBUT DU CODE POUR QUI MODIFIE LE TEXTE !!!
        // Valide premièrement si le texte contient plus de deux caractères.
        if (longueurMessage >= 2){
            for(int i = 0; i < nbrDeTransformation; i++){
                // !!! PERMUTATION DES CARACTÈRES !!!
                //Si en première position, on doit inverser le premier et dernier caractère, et mettre le reste entre les deux.
                if (positionPermutation == 0){
                    m = m.charAt(indexDernierCaractere) +
                    m.substring(1, indexDernierCaractere) +
                    m.charAt(positionPermutation);
                } else {
                    //Dans toutes les autres situations, on doit mettre ce qui avant, entre et après les deux caractères que l'on souhaite permuter.
                    m = m.substring(0, positionPermutation) +
                    m.charAt(indexDernierCaractere - positionPermutation) +
                    m.substring(positionPermutation + 1, indexDernierCaractere - positionPermutation) +
                    m.charAt(positionPermutation) +
                    m.substring(indexDernierCaractere - positionPermutation + 1);
                }

                // !!! CHANGEMENT DE LA POSITION DE PERMUTATION !!!
                //Le changement de position est le même pour crypter en permutation extérieure, ou décrypter en permutation intérieure.
                if ((typePermutation == exterieure && typeOperation == cryptage) || (typePermutation == interieure && typeOperation == decryptage)){
                    //Quand on arrive au milieu, on souhaite que la prochaine modification se fasse sur le premier caractère.
                    //Sinon, on augmente d'un.
                    if (longueurMessage % 2 == 0){
                        if (positionPermutation+1 > indexMilieu) {
                            positionPermutation = 0;
                        } else {
                            positionPermutation++;
                        }
                    } else {
                        if (positionPermutation+1 >= (indexMilieu)) {
                            positionPermutation = 0;
                        } else {
                            positionPermutation++;
                        }
                    }

                } else {
                    //Même chose pour la permutation intérieure, mais lorsqu'on arrive au début, on doit retourner au milieu.
                    //Également, on part du milieu et descend d'un caractère au lieu de monter d'un.
                    if (positionPermutation == 0) {
                        positionPermutation = indexMilieu - 1;
                    } else {
                        positionPermutation--;
                    }
                }
            }
        }
        return m;
    }

    /**
     * Cette méthode exécute l'opération d'inversion de caractères.
     * On souhaite prendre les caractères de la première position à la position choisie (iteration), et inverser l'ordre.
     * On commence par faire l'inversion au début du message, et ensuite sur la fin du message.
     *
     * Cette méthode permet également de faire le décryptage (inversion à l'arrière en premier, à l'avant en deuxième).
     *
     * @param message le message que l'on veut modifier.
     * @param iteration le nombre de fois que l'on doit exécuter l'opération.
     * @param typeOperation le type d'opération à effectuer ('c' = cryptage / 'd' = décryptage).
     * @return le message modifié.
     */
    public static String operationInversion(String message, int iteration, char typeOperation){
        String m = message;
        String resultatPremiereInversion = "";
        String resultatDeuxiemeInversion = "";
        String resultatInversion = "";

        int longueurMessage = m.length();
        int nbrInversion = iteration-1;
        int indexDernierCaractere = longueurMessage - 1;

        if (longueurMessage >= nbrInversion && nbrInversion != 0){
            //MODIFICATION POUR LE CRYPTAGE  (inversion avant suivie d'une inversion arrière)
            if(typeOperation == cryptage){
                //Inversion avant
                for (int i = nbrInversion; i >= 0; i--){
                    resultatPremiereInversion += m.charAt(i);
                }
                resultatPremiereInversion += m.substring(iteration);

                //Inversion arrière
                for (int i = indexDernierCaractere; i >= (indexDernierCaractere - nbrInversion); i--){
                    resultatDeuxiemeInversion += resultatPremiereInversion.charAt(i);
                }
                resultatInversion = resultatPremiereInversion.substring(0, indexDernierCaractere - nbrInversion) + resultatDeuxiemeInversion;

                return resultatInversion;
            } else {
                //MODIFICATION POUR LE DÉCRYPTAGE (inversion arrière suivie d'une inversion avant)
                //Inversion arrière
                for (int i = indexDernierCaractere; i >= (indexDernierCaractere - nbrInversion); i--){
                    resultatPremiereInversion += m.charAt(i);
                }
                resultatPremiereInversion = m.substring(0, (indexDernierCaractere - nbrInversion)) + resultatPremiereInversion;

                //Inversion avant
                for (int i = nbrInversion; i >= 0; i--){
                    resultatDeuxiemeInversion += resultatPremiereInversion.charAt(i);
                }
                resultatInversion = resultatDeuxiemeInversion + resultatPremiereInversion.substring(iteration, m.length());

                return resultatInversion;
            }
        } else {
            return m;
        }
    }

    /*
    //  ++++++++++++++++++++++
    //  + MÉTHODES INTERFACE +
    //  ++++++++++++++++++++++
    */

    /**
     * Cette méthode affiche la présentation de ce programme.
     */
    public static void presenterLogiciel() {
        System.out.println("Ce logiciel permet de crypter et de décrypter des messages secrets. \n");
    }

    /**
     * Cette méthode affiche un message disant a l'utilisateur
     * d'appuyer sur ENTRÉE pour continuer.
     */
    public static void pause() {
        System.out.print("Tapez <ENTRÉE> pour continuer...");
        Clavier.lireFinLigne();
    }

    /**
     * Cette méthode affiche l'interface du menu et demande à l'utilisateur de faire une sélection entre 1 et 3.
     *
     * Si l'on choisi l'option 1: on appelle la méthode « crypter » et l'on renvoit son résultat.
     * Si l'on choisi l'option 2: on appelle la méthode « décrypter » et l'on renvoit son résultat.
     * Si l'on choisi l'option 3: on quitte le programme.
     */
    public static void selectionMenu(){
        char selection;
        do {
            selection = validerChoixMenu(MSG_SOLLICITATION_MENU, MSG_ERREUR_MENU, '1', '3');

            if (selection == '1'){
                String messageCrypte = crypter(validerCle(MSG_INPUT_CLE_CRYPTAGE, MSG_ERREUR_CLE), validerMessage(MSG_INPUT_MSG_CRYPTAGE, MSG_ERREUR_MSG));
                if (messageCrypte.equals(MSG_OPERATION_ANNULEE)){
                    System.out.println(MSG_OPERATION_ANNULEE);
                } else {
                    System.out.println("MESSAGE CRYPTÉ : [" + messageCrypte +"]");
                    pause();
                }
            } else if (selection == '2'){
                String messageDecrypte = decrypter(validerCle(MSG_INPUT_CLE_DECRYPTAGE, MSG_ERREUR_CLE), validerMessage(MSG_INPUT_MSG_DECRYPTAGE, MSG_ERREUR_MSG));
                if (messageDecrypte.equals(MSG_OPERATION_ANNULEE)){
                    System.out.println(MSG_OPERATION_ANNULEE);
                } else {
                    System.out.println("MESSAGE DÉCRYPTÉ : [" + messageDecrypte +"]");
                    pause();
                }
            }
        } while (selection != '3');
    }

    /**
     * Cette méthode affiche un message de fin du programme.
     */
    public static void finProgramme() {
        System.out.println("AUREVOIR !");
    }

    /*
    //  ++++++++++++++++++++++++++
    //  + CLASSE EXÉCUTABLE MAIN +
    //  ++++++++++++++++++++++++++
    */

    /**
     * Cette méthode est la classe exécutable qui rend le programme fonctionnel.
     * On appelle toutes les méthodes d'interfaces.
     */
    public static void main(String [] args) {
        presenterLogiciel();
        pause();
        selectionMenu();
        finProgramme();
    }
}
