import java.util.Scanner;

import static java.lang.Math.round;

public class ConversionMontant {
    public static void main(String[] args) {
        final double VALEUR_1C = 0.01;
        final double VALEUR_5C = 0.05;
        final double VALEUR_10C = 0.10;
        final double VALEUR_25C = 0.25;
        final String MSG_PREMIER_NBR = "Conversion d'argent Canadian Tire! Rentrez le nombre de billets que vous avez pour chaque type de billet!";
        final String MSG_ERREUR_NBR = "Un des chiffres inscrits était négatif! Réessayez avec des chiffres plus grand que 0";
        final String MSG_1C = "Combien de 1C possédez-vous? : ";
        final String MSG_5C = "Combien de 5C possédez-vous? : ";
        final String MSG_10C = "Combien de 10C possédez-vous? : ";
        final String MSG_25C = "Combien de 25C possédez-vous? : ";

        int nbr1cInput;
        int nbr5cInput;
        int nbr10cInput;
        int nbr25cInput;
        double valeurTotale = 0;

        System.out.println(MSG_PREMIER_NBR);
        System.out.print(MSG_1C);
        nbr1cInput = Clavier.lireInt();
        System.out.print(MSG_5C);
        nbr5cInput = Clavier.lireInt();
        System.out.print(MSG_10C);
        nbr10cInput = Clavier.lireInt();
        System.out.print(MSG_25C);
        nbr25cInput = Clavier.lireInt();
        System.out.println();


        if (nbr1cInput < 0 || nbr5cInput < 0 || nbr10cInput < 0 || nbr25cInput < 0){
            while(nbr1cInput < 0 || nbr5cInput < 0 || nbr10cInput < 0 || nbr25cInput < 0){
                System.out.println(MSG_ERREUR_NBR);
                System.out.print(MSG_1C);
                nbr1cInput = Clavier.lireInt();
                System.out.print(MSG_5C);
                nbr5cInput = Clavier.lireInt();
                System.out.print(MSG_10C);
                nbr10cInput = Clavier.lireInt();
                System.out.print(MSG_25C);
                nbr25cInput = Clavier.lireInt();
            }
        }

        for (int i = 1; i <= nbr1cInput; i++) {
            valeurTotale += VALEUR_1C;
        }
        for (int i = 1; i <= nbr5cInput; i++) {
            valeurTotale += VALEUR_5C;
        }
        for (int i = 1; i <= nbr10cInput; i++) {
            valeurTotale += VALEUR_10C;
        }
        for (int i = 1; i <= nbr25cInput; i++) {
            valeurTotale += VALEUR_25C;
        }

        System.out.printf("Value: %.2f\n", valeurTotale);
    }
}
