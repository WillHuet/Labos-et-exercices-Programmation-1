package plants;

public class PitcherPlant implements CarnivorousPlant{
    @Override
    public String eatFly(Fly fly) {
        // Check which fly it is
        return fly.makeAnnoyingSound() + "... CHOMP!!!!   That was delicious! Yummy! Thank you!";
    }

    @Override
    public String doPhotoSynthesis() {
        return "Oh, sunbeams. I like sunbeams, but I like flies even more.";
    }

    @Override
    public String drinkWater() {
        return "Slurp... good water, but could use some extra nutrients.";
    }
}
