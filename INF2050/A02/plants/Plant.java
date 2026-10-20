package plants;

/**
 * Common interface for all plants, no matter if carnivorous or ordinary plants. All plants must
 * provide methods for doing synthesis and drinking water.
 *
 * @author Maximilian Schiedermeier
 */
public interface Plant {

  /**
   * Offers a beam of sunlight to the plant, and returns the plant's thankful reply.
   *
   * @return plant's reaction to offered beam of sunlight.
   */
  String doPhotoSynthesis();

  /**
   * Offers a sip of water to the plant, and returns the plant's thankful reply.
   *
   * @return plant's reaction to the offered beam of water.
   */
  String drinkWater();
}
