public class TesterAnimal {
    public static boolean memeProprio(Animal a1, Animal a2){
        String ProprioA1 = a1.getProprietaire();
        String ProprioA2 = a2.getProprietaire();
        if(ProprioA1.equals(ProprioA2)){
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        Animal animal1 = new Animal();

        Animal animal2 = new Animal("Charlie", 2, "Cockapoo", "Will");

        Animal animal3 = new Animal("Data", 2, "Labrador noir", "Caroline");

        Animal animal4 = new Animal("Tuna", 2, "Labrador noir", "Caroline");

        System.out.println();
        animal1.afficher();

        System.out.println();
        animal2.afficher();

        System.out.println();
        animal3.afficher();

        System.out.println();
        animal4.afficher();

        System.out.println();
        System.out.println("Vrai ou faux: " + animal2.getNom() + " et " + animal3.getNom() + " ont le même proprio?");
        System.out.println(memeProprio(animal2, animal3));

        System.out.println();
        System.out.println("Vrai ou faux: " + animal3.getNom() + " et " + animal4.getNom() + " ont le même proprio?");
        System.out.println(memeProprio(animal3, animal4));
    }
}
