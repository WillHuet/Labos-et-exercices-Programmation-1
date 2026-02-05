public class LaboSelections3 {
    void main() {
        final String MSG_INPUT = "Entrez un nombre entier positif : ";
        final String MSG_INPUT_2 = "Entrez un nombre positif : ";
        final String MSG_DIVISIBLE_PAR_5 = "Les 3 plus grands multiples de 5 sont : ";
        final String MSG_SOMME = "La somme est : ";
        final String MSG_PRODUIT = "Le produit est : ";

        int inputNombre;
        int inputNombre2;

        System.out.print(MSG_INPUT);
        inputNombre = Clavier.lireInt();

        if(inputNombre %5 == 0 && inputNombre >= 15){
            System.out.println(MSG_DIVISIBLE_PAR_5);
            for (int i = 2; i >= 0; i--){
                System.out.print(inputNombre - (5*i) + " ");
            }
        } else {
            System.out.print(MSG_INPUT_2);
            inputNombre2 = Clavier.lireInt();
            if(inputNombre %2 == 0 || inputNombre2 %2 ==0){
                System.out.println(MSG_SOMME + (inputNombre+inputNombre2));
            } else {
                System.out.println(MSG_PRODUIT + (inputNombre*inputNombre2));
            }
        }
    }
}