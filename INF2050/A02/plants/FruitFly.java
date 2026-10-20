package plants;

public class FruitFly implements Fly{
    @Override
    public String getName() {
        return "Fruity";
    }

    @Override
    public String makeAnnoyingSound() {
        return "Bziiiiiiiiiiiiiiiii";
    }
}
