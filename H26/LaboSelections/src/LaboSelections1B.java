public class LaboSelections1B {
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

        switch (inputMenu){
            case LETTRE_A :
                System.out.println(MSG_CONFIRM + LETTRE_A);
                //break;
            case LETTRE_B :
                System.out.println(MSG_CONFIRM + LETTRE_B);
                //break;
            case LETTRE_Q :
                System.out.println(MSG_CONFIRM + LETTRE_Q);
                //break;
            default :
                System.out.println(MSG_ERROR_INPUT);
                break;
        }
    }
}
