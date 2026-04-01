//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
void main() {
    CarteAJouer c1 = new CarteAJouer();
    CarteAJouer c2 = new CarteAJouer(4, "trefle");
    CarteAJouer c3 = new CarteAJouer(1, "trèfle");
    CarteAJouer c4 = new CarteAJouer(13, "coeur");

    c1.afficher();
    System.out.println();

    c2.afficher();
    System.out.println();

    c3.afficher();
    System.out.println();

    c4.afficher();


}
