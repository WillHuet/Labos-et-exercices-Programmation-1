//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
void main() {
    int[] tableauResultat = new int[36000000];
    int compteur1 = 0;
    int compteur2 = 0;
    int compteur3 = 0;
    int compteur4 = 0;
    int compteur5 = 0;
    int compteur6 = 0;

    for (int i = 0; i < tableauResultat.length; i++) {
        tableauResultat[i] = Dé.lancerDe();
    }
    for (int number :  tableauResultat) {
        switch (number) {
            case 1:
                compteur1++;
                break;
            case 2:
                compteur2++;
                break;
            case 3:
                compteur3++;
                break;
            case 4:
                compteur4++;
                break;
            case 5:
                compteur5++;
                break;
            case 6:
                compteur6++;
                break;
        }
    }
    System.out.println("Nbr de 1 : " + compteur1);
    System.out.println("Nbr de 2 : " + compteur2);
    System.out.println("Nbr de 3 : " + compteur3);
    System.out.println("Nbr de 4 : " + compteur4);
    System.out.println("Nbr de 5 : " + compteur5);
    System.out.println("Nbr de 6 : " + compteur6);
}
