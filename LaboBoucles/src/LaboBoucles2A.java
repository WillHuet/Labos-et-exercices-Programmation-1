public class LaboBoucles2A {
    final static char C_OUI = 'O';
    final static char C_NON = 'N';
    final static String MSG_INPUT = "Voulez-vous continuer [(o)ui ou (n)on] : ";
    final static String MSG_ERREUR = "Erreur, vous devez répondre par (o)ui ou par (n)on) !";
    final static String MSG_CONTINUER = "Vous avez choisi de continuer...\n" + "Appuyez sur [ENTREE] pour recommencer...";
    final static String MSG_FIN = "FIN";
    void main() {
        char lettreInput;

        System.out.print(MSG_INPUT);
        lettreInput = Clavier.lireCharLn();
        while (lettreInput != C_NON) {
            System.out.println(MSG_CONTINUER);
            Clavier.lireFinLigne();

            if(lettreInput != C_OUI) {
                System.out.print(MSG_ERREUR);
                System.out.print(MSG_INPUT);
                lettreInput = Clavier.lireCharLn();
            }
        }
        System.out.println(MSG_FIN);
    }
}
