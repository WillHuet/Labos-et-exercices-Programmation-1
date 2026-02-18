public class LaboBoucles2A {
    final static char C_OUI = 'O';
    final static char C_NON = 'N';
    final static String MSG_INPUT = "Voulez-vous continuer [(o)ui ou (n)on] : ";
    final static String MSG_ERREUR = "Erreur, vous devez répondre par (o)ui ou par (n)on) !";
    final static String MSG_CONTINUER = "Vous avez choisi de continuer...\n" + "Appuyez sur [ENTREE] pour recommencer...";
    final static String MSG_FIN = "FIN";
    void main() {
        char lettreInput;
        char lettreUpper;

        System.out.print(MSG_INPUT);
        lettreInput = Clavier.lireCharLn();
        lettreUpper = Character.toUpperCase(lettreInput);
        while (lettreUpper != C_NON) {
            if(lettreUpper == C_OUI) {
                System.out.println(MSG_CONTINUER);
                Clavier.lireFinLigne();

                System.out.print(MSG_INPUT);
                lettreInput = Clavier.lireCharLn();
                lettreUpper = Character.toUpperCase(lettreInput);
            } else {
                System.out.print(MSG_ERREUR);
                System.out.println(MSG_INPUT);
                lettreInput = Clavier.lireCharLn();
                lettreUpper = Character.toUpperCase(lettreInput);
            }
        }
        System.out.println(MSG_FIN);
    }
}
