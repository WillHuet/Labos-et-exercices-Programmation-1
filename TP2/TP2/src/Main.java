//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
void main() {

    String cle;
    System.out.println("Rentrez une clé de cryptage");
    cle = Clavier.lireString();
    Methodes.validerCle(cle);
}
