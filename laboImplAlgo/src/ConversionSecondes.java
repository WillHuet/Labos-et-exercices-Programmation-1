import java.util.Scanner;

public class ConversionSecondes {
    public static void main(String[] args) {

        final int NBR_SECONDES_JOUR = 86400;
        final int NBR_SECONDES_HEURE = 3600;
        final int NBR_SECONDES_MINUTE = 60;
        final String MSG_PREMIER_NBR = "Entrez un nombre de secondes! Nous allons convertir le tout en jours, heures, minutes et secondes:";
        final String MSG_NOUVEAU_NBR = "Entrez un nouveau nombre de secondes! Nous allons convertir le tout en jours, heures, minutes et secondes:";
        final String MSG_ERREUR_NBR = "Nombre de secondes rentré est négatif ou nul! Réessayez avec un nombre plus grand que 0";

        int nbrSecondesInput;
        int nbrSecondes;
        int secondes;
        int minutes;
        int heures;
        int jours;

        Scanner scanner = new Scanner(System.in);

        System.out.println(MSG_PREMIER_NBR);
        nbrSecondesInput = scanner.nextInt();

        while(nbrSecondesInput != 0){
            nbrSecondes = nbrSecondesInput;
            secondes = 0;
            minutes = 0;
            heures = 0;
            jours = 0;
            if (nbrSecondes > 0){
                while(nbrSecondes > 0){
                    if(nbrSecondes >= NBR_SECONDES_JOUR){
                        jours++;
                        nbrSecondes = nbrSecondes - NBR_SECONDES_JOUR;
                    }
                    else if(nbrSecondes >= NBR_SECONDES_HEURE){
                        heures++;
                        nbrSecondes = nbrSecondes - NBR_SECONDES_HEURE;
                    }
                    else if(nbrSecondes >= NBR_SECONDES_MINUTE){
                        minutes++;
                        nbrSecondes = nbrSecondes - NBR_SECONDES_MINUTE;
                    }
                    else{
                        secondes = nbrSecondes;
                        nbrSecondes = 0;
                    }
                }
                System.out.println("("+ jours +","+ heures +","+ minutes +","+ secondes +")");
                System.out.println();
                System.out.println(MSG_NOUVEAU_NBR);
                nbrSecondesInput = scanner.nextInt();

            }
            else {
                while(nbrSecondesInput < 0){
                    System.out.println(MSG_ERREUR_NBR);
                    nbrSecondesInput = scanner.nextInt();
                }
            }
        }

        //for (int i = 1; i <= 5; i++) {
        //IO.println("i = " + i);
        //}
    }

}
