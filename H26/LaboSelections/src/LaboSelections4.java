public class LaboSelections4 {
    void main() {
        final String MSG_INPUT = "Entrez un caractère : ";
        final String MSG_VALID = "Le caractère est valide!";
        final String MSG_INVALID = "Le caractère est valide!";
        final String MSG_QUI_SUIT = "Le caractère qui suit ";

        char inputCaractere = ' ';
        char premierCaractere = ' ';

        System.out.print(MSG_INPUT);
        inputCaractere = Clavier.lireChar();

        if(inputCaractere >= 'a' && inputCaractere <= 'z'){
            premierCaractere = inputCaractere;
            char prochainCaractere = (char)(premierCaractere +1);
            System.out.println(MSG_VALID);
            System.out.println(MSG_QUI_SUIT + inputCaractere + " est : " + prochainCaractere);
        } else {
            System.out.println(MSG_INVALID);
        }
    }
}