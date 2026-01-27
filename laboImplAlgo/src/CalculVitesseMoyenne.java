import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CalculVitesseMoyenne {
    void main() {
        String MSG_ACCUEIL = "Ce programme calcule la vitesse moyenne pour un trajet effectue en plusieurs tronçons.";
        String MSG_NBR_KILO = "Entrez le nombre de kilometre(s) pour ce tronçon:";
        String MSG_VITESSE = "Entrez la vitesse (Km/h) pour ce tronçon:";
        String MSG_AUTRE_TRONCON = "Voulez-vous comptabiliser un autre tronçon? (o/n): ";
        String MSG_FINAL = "La vitesse moyenne est de: ";

        String MSG_ERREUR_KILO_NEGATIF = "ERREUR. Le nombre de kilomètre(s) doit être supérieur ou égal a 0.";
        String MSG_ERREUR_VITESSE_NEGATIVE = "ERREUR. La vitesse doit etre superieure ou egale a 0.";
        String MSG_ERREUR_OUI_NON = "ERREUR. Veuillez répondre par 'o' (oui) ou par 'n' (non)!: ";

        int nbrTroncon = 1;
        List<Integer> numKilos = new ArrayList<>();
        List<Integer> numVitesse = new ArrayList<>();
        List<Double> numTemps = new ArrayList<>();
        int[] tableauKilos = {0};
        int[] tableauVitesse = {0};
        int kiloTotal = 0;
        double tempsTotal = 0;
        double vitesseMoyenne = 0;
        char validation = 'o';
        char continuer = 'o';
        char arreter = 'n';

        Scanner scanner = new Scanner(System.in);

        System.out.println(MSG_ACCUEIL);
        System.out.println();

        while(validation != 'n'){
            for (int i = 0; i < nbrTroncon; i++){
                System.out.println("----------");
                System.out.println("TRONÇON #" + nbrTroncon);
                System.out.println("----------");
                System.out.println(MSG_NBR_KILO);
                int nbrKilos = scanner.nextInt();
                if (nbrKilos < 0){
                    while(nbrKilos < 0){
                        System.out.println(MSG_ERREUR_KILO_NEGATIF);
                        nbrKilos = scanner.nextInt();
                        System.out.println();
                    }
                }
                //tableauKilos[i] = nbrKilos;
                numKilos.add(nbrKilos);
                System.out.println();
                System.out.println(MSG_VITESSE);
                int vitesse = scanner.nextInt();
                if (vitesse < 0){
                    while(vitesse < 0){
                        System.out.println(MSG_ERREUR_VITESSE_NEGATIVE);
                        vitesse = scanner.nextInt();
                        System.out.println();
                    }
                }
                //tableauVitesse[i] = vitesse;
                numVitesse.add(vitesse);
                System.out.println();
                System.out.println(MSG_AUTRE_TRONCON);
                validation = scanner.next().charAt(0);
                if (validation != continuer && validation != arreter){
                    while (validation != continuer && validation != arreter){
                        System.out.println(MSG_ERREUR_OUI_NON);
                        validation = scanner.next().charAt(0);
                        System.out.println();
                    }
                }
                if(validation == continuer){
                    nbrTroncon++;
                }
            }
        }

        for (int i = 0; i < numKilos.size(); i++){
            kiloTotal += numKilos.get(i);
            tempsTotal += (double) numKilos.get(i) / numVitesse.get(i);
        }


//        for (int num : numKilos){
//            kiloTotal += num;
//
//        }

//        for (int num : numVitesse){
//            vitesseTotal += num;
//        }

        vitesseMoyenne = kiloTotal / tempsTotal;
        String formattedValue = String.format("%.2f", vitesseMoyenne);
        System.out.println();
        System.out.println(MSG_FINAL + formattedValue + " km/h");
    }
}
