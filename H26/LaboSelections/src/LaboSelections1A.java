public class LaboSelections1A {
    void main() {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        final char LETTRE_A = 'A';
        final char LETTRE_B = 'B';
        final char LETTRE_Q = 'Q';

        final String MSG_INPUT = "Veuillez entrer un caractère (A, B ou Q) : ";
        final String MSG_CONFIRM = "Vous avez choisi le menu ";
        final String MSG_ERROR_INPUT = "Votre choix est invalide.";

        char inputMenu;

        System.out.print(MSG_INPUT);
        inputMenu = Clavier.lireChar();
        if (inputMenu == LETTRE_A){
            System.out.println(MSG_CONFIRM + LETTRE_A);
        } else if (inputMenu == LETTRE_B){
            System.out.println(MSG_CONFIRM + LETTRE_B);
        } else if (inputMenu == LETTRE_Q){
            System.out.println(MSG_CONFIRM + LETTRE_Q);
        } else{
            System.out.println(MSG_ERROR_INPUT);
        }
    }
}
