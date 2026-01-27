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
        int[] tableauKilos = {};
        int[] tableauVitesse = {};
        int kiloTotal = 0;
        int vitesseTotal = 0;
        int vitesseMoyenne = 0;
        char validation = 'o';

        Scanner scanner = new Scanner(System.in);

        System.out.println(MSG_ACCUEIL);
        System.out.println();

        while(validation != 'n'){
            for (int i = 1; i <= nbrTroncon; i++){
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
                tableauKilos[i] = nbrKilos;
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
                tableauVitesse[i] = vitesse;
                System.out.println();
                System.out.println(MSG_AUTRE_TRONCON);
                validation = scanner.next().charAt(0);
                if (validation == 'o' || validation == 'n'){
                    while (validation == 'o' || validation == 'n'){
                        System.out.println(MSG_ERREUR_OUI_NON);
                        validation = scanner.next().charAt(0);
                        System.out.println();
                    }
                }
            }
        }

        for (int num : tableauKilos){
            kiloTotal += tableauKilos[num];
            vitesseTotal += tableauVitesse[num];
        }

        vitesseMoyenne = kiloTotal / vitesseTotal;
        System.out.println();
        System.out.println(MSG_FINAL + vitesseMoyenne + " km/h");
    }
}
