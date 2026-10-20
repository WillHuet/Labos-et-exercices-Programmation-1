package plants;

/**
 * Interface for plants that eat flies.
 */
public interface CarnivorousPlant extends Plant {

  /**
   * Let the carnivorous plant eat a fly.
   *
   * @return the plants answer to being fed with a fly.
   */
  String eatFly(Fly fly);
}
