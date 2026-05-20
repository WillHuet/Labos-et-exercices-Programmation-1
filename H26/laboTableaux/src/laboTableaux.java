public class laboTableaux {
    int[] t11 = null;
    int[] t12 = {};
    int[] t13 = {5};
    int[] t14 = {1,1,1,1,1,1};
    int[] t15 = {4, 6, 2, 7, 1, 9, 12, 5, 2, 45, 23, 19, 0, 8};

    String [] t21 = null;
    String [] t22 = {};
    String [] t23 = {"pluie"};
    String [] t24 = {"lac", "mer", "riviere", "fleuve"};

    public void statistiques(int[] tableau){
        int nombreMin = 0;
        int nombreMax = 0;
        int moyenne = 0;
        if  (tableau != null){
            if(tableau.length > 0){
                for(int i = 0; i < tableau.length; i++){
                    if(i != 0){
                        if(tableau[i] < nombreMin){
                            nombreMin = tableau[i];
                        } else if (tableau[i] > nombreMax){
                            nombreMax = tableau[i];
                        }
                    } else {
                        nombreMin = tableau[0];
                        nombreMax =  tableau[0];
                    }
                    moyenne += tableau[i];
                }
                System.out.println("MIN : " + nombreMin);
                System.out.println("MAX : " + nombreMax);
                System.out.println("MOY : " + (double)(moyenne/tableau.length));
            } else {
                System.out.println("Aucune statistique");
            }
        } else {
            System.out.println("Aucune statistique");
        }
    }

    public void afficherTableau(String[] tableau){
        if  (tableau != null){
            switch (tableau.length){
                case 0:
                    System.out.println("[ ]");
                    break;
                case 1:
                    System.out.println("[ " + tableau[0] + " ]");
                    break;
                default:
                    System.out.print("[ ");
                    for (String s : tableau) {
                        System.out.print(s + ", ");
                    }
                    System.out.print(" ]");
            }
        } else {
            System.out.println("[ ]");
        }
    }

    public String[] remplirTableau(){
        int grandeurTableau = 0;
        System.out.println("Entrez un nombre entier > 0 : ");
        grandeurTableau = Clavier.lireInt();

        String[] tableau = new String[grandeurTableau];

        for (int i = 0; i < grandeurTableau; i++){
            System.out.println("Entrez une chaine de caractères : ");
            tableau[i] = Clavier.lireString();
        }
        return tableau;
    }

    public char[] extraireSousTab(char[] tab, int indiceDebut, int indiceFin){
        return null;
    }

    void main(String[] args) {
        afficherTableau(remplirTableau());
    }
}
