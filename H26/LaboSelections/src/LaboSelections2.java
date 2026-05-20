public class LaboSelections2 {
    void main() {
        final char LETTRE_A = 'A';
        final char LETTRE_B = 'B';
        final char LETTRE_Q = 'Q';

        final String MSG_INPUT = "Entrez un nombre entier : ";
        final String MSG_ENONCE = "Le nombre ";
        final String MSG_ERROR_INPUT = "Nombre refusé";

        int inputNombre;
        int compteurChiffre = 0;

        System.out.print(MSG_INPUT);
        inputNombre = Clavier.lireInt();

        if(inputNombre >= 0){
            if(inputNombre % 2 ==0){
                System.out.println(MSG_ENONCE + "est pair.");
            } else {
                System.out.println(MSG_ENONCE + "est impair");
            }
            if(inputNombre % 10 ==0){
                System.out.println(MSG_ENONCE + "est un multiple de 10.");
            }
            while(inputNombre != 0){
                inputNombre = inputNombre / 10;
                compteurChiffre++;
            }
            System.out.println(MSG_ENONCE + "contient " + compteurChiffre + " chiffre(s)");
        } else {
            System.out.println(MSG_ERROR_INPUT);
        }
    }
}