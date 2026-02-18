public class LaboBoucles3 {
    final static int VALEUR_MIN = 2;
    final static int VALEUR_MAX = 12;
    final static String COL = "  |  ";
    final static String MSG_INPUT = "Entrez un nombre : ";
    final static String MSG_ERREUR = "Erreur, le nombre doit être entre 2 et 12 inclus.";
    void main() {
        int valeurInput=0;

        System.out.print(MSG_INPUT);
        valeurInput = Clavier.lireInt();
        if(valeurInput >= VALEUR_MIN && valeurInput <= VALEUR_MAX) {
            for (int i = 0; i < valeurInput+1; i++) {
                System.out.print(i+COL);
                for (int j = 0; j < valeurInput; j++) {

                }
            }
        }
    }
}
