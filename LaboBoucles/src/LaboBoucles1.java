public class LaboBoucles1 {
    final static int FERMER_PROGRAM = -1;
    final static String MSG_INPUT = "Entrez un nombre (-1 pour terminer) : ";
    final static String MSG_SOMME = "La somme des nombres est ";
    void main() {
        int valeurInput=0;
        int somme = 0;

        while (valeurInput != FERMER_PROGRAM) {
            System.out.print(MSG_INPUT);
            valeurInput = Clavier.lireInt();
            if (valeurInput != FERMER_PROGRAM) {
                somme += valeurInput;
            }
        }
        System.out.println(MSG_SOMME + somme);
    }
}
