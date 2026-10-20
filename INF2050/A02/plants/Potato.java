package plants;

public class Potato implements Plant{
    @Override
    public String doPhotoSynthesis() {
        return "Oh sunbeams. I love warm sunbeams!";
    }

    @Override
    public String drinkWater() {
        return "Slurp... aah!";
    }
}
