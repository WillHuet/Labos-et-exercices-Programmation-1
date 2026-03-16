public class Methodes {
    //CONSTANTES
    public final static String MSG_INPUT_CLE = "CLE DE CRYPTAGE : ";
    public final static String MSG_ERREUR_CLE = "ERREUR, cle invalide ! Recommencez...";

    public static void validerTexte(String texte) {
        boolean valide = false;

//        while (valide == false) {
//            if(){
//
//            }else{
//
//            }
//
//        }
    }

    public static void validerCle(String texte) {
        boolean valide = false;
        boolean validationLettres = false;
        boolean validationChiffres = false;

        int nbrDeManipulation = 0;
        int position = 0;

        String deuxLettres = "";
        String deuxChiffres = "";

//      RG, RD, PE, PI, ou IV.
        while (valide == false) {
            if(texte.length() % 4 == 0){
                nbrDeManipulation = texte.length() / 4;
                for (int i = 0; i < nbrDeManipulation; i++) {
                    deuxLettres = texte.substring(position , position + 1);
                    deuxChiffres = texte.substring(position + 2 , position + 3);

                    if(deuxLettres.equals("RG")) {}
                    position = position + 3;
                }
                if(validationLettres == true || validationChiffres == true) {
                    valide = true;
                }
            }else{
                System.out.print(MSG_ERREUR_CLE);
                System.out.print(MSG_INPUT_CLE);
                texte = Clavier.lireString();
            }
        }
    }

    public static void validerChoixMenu(String texte) {
        IO.println(String.format("Hello World!"));
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
