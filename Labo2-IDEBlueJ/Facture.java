public class Facture {
    public static void main (String [] args) {
        String nom1;
        String nom2;
        String nom3;
        double prix1;
        double prix2;
        double prix3;
        System.out.println("Ce programme affiche la facture d'une "
                + "commande de 3 items.\n");
        System.out.print("Entrez le nom de l'item 1 : ");
        nom1 = Clavier.lireString();
        System.out.print("Entrez le prix de l'item " + nom1 + " : ");
        prix1 = Clavier.lireDouble();
        System.out.print("\nEntrez le nom de l'item 2 : ");
        nom2 = Clavier.lireString();
        System.out.print("Entrez le prix de l'item " + nom2 + " : ");
        prix2 = Clavier.lireDouble();
        System.out.print("\nEntrez le nom de l'item 3 : ");
        nom3 = Clavier.lireString();
        System.out.print("Entrez le prix de l'item " + nom3 + " : ");
        prix3 = Clavier.lireDouble();
        System.out.println("\n--------\nFACTURE\n--------");
        System.out.printf("%-45S%10.2f $\n", nom1, prix1);
        System.out.printf("%-45S%10.2f $\n", nom2, prix2);
        System.out.printf("%-45S%10.2f $\n", nom3, prix3);
        System.out.printf("\n%-45S%10.2f $\n", "TOTAL", prix1
                + prix2 + prix3);
        System.out.println("\nFin normale du programme");
    }
}