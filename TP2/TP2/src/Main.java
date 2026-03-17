//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
void main() {

    String test;
    String msgSollicitation = "Rentrez une clé : ";
    String msgErreur = "Erreur, veuillez réessayer... : ";
    test = Methodes.validerCle(msgSollicitation, msgErreur);

    System.out.println(test);

}
