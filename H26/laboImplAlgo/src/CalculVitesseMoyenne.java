import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CalculVitesseMoyenne {
    public static void main(String[] args) {
        final String MSG_ACCUEIL = "Ce programme calcule la vitesse moyenne pour un trajet effectue en plusieurs tronçons.";
        final String MSG_NBR_KILO = "Entrez le nombre de kilometre(s) pour ce tronçon: ";
        final String MSG_VITESSE = "Entrez la vitesse (Km/h) pour ce tronçon: ";
        final String MSG_AUTRE_TRONCON = "Voulez-vous comptabiliser un autre tronçon? (o/n): ";
        final String MSG_FINAL = "La vitesse moyenne est de: ";

        final String MSG_ERREUR_KILO_NEGATIF = "ERREUR. Le nombre de kilomètre(s) doit être supérieur ou égal a 0 : ";
        final String MSG_ERREUR_VITESSE_NEGATIVE = "ERREUR. La vitesse doit être supérieure ou égale a 0 : ";
        final String MSG_ERREUR_OUI_NON = "ERREUR. Veuillez répondre par 'o' (oui) ou par 'n' (non)!: ";

        final char CARAC_CONTINUER = 'o';
        final char CARAC_ARRETER = 'n';

        List<Integer> numKilos = new ArrayList<>();
        List<Integer> numVitesse = new ArrayList<>();
        int nbrTroncon = 1;
        int kiloTotal = 0;
        double tempsTotal = 0;
        double vitesseMoyenne = 0;
        boolean validation = true;
        char validationInput;

        System.out.println(MSG_ACCUEIL);
        while(validation){
            for (int i = 0; i < nbrTroncon; i++){
                System.out.println();
                System.out.println("----------");
                System.out.println("TRONÇON #" + nbrTroncon);
                System.out.println("----------");
                System.out.print(MSG_NBR_KILO);
                int nbrKilos = Clavier.lireInt();
                if (nbrKilos < 0){
                    while(nbrKilos < 0){
                        System.out.print(MSG_ERREUR_KILO_NEGATIF);
                        nbrKilos = Clavier.lireInt();
                        System.out.println();
                    }
                }
                numKilos.add(nbrKilos);
                System.out.println();

                System.out.print(MSG_VITESSE);
                int vitesse = Clavier.lireInt();
                if (vitesse < 0){
                    while(vitesse < 0){
                        System.out.print(MSG_ERREUR_VITESSE_NEGATIVE);
                        vitesse = Clavier.lireInt();
                        System.out.println();
                    }
                }
                numVitesse.add(vitesse);
                System.out.println();

                System.out.print(MSG_AUTRE_TRONCON);
                validationInput = Clavier.lireChar();
                if (validationInput != CARAC_CONTINUER && validationInput != CARAC_ARRETER){
                    while (validationInput != CARAC_CONTINUER && validationInput != CARAC_ARRETER){
                        System.out.print(MSG_ERREUR_OUI_NON);
                        validationInput = Clavier.lireChar();
                        System.out.println();
                    }
                }

                if (validationInput == CARAC_CONTINUER){
                    nbrTroncon++;
                } else if (validationInput == CARAC_ARRETER){
                    validation = false;
                }
            }
        }

        for (int i = 0; i < numKilos.size(); i++){
            kiloTotal += numKilos.get(i);
            tempsTotal += (double) numKilos.get(i) / numVitesse.get(i);
        }

        vitesseMoyenne = kiloTotal / tempsTotal;
        System.out.println();
        System.out.printf(MSG_FINAL + "%.2f" + " km/h", vitesseMoyenne);
    }
}
