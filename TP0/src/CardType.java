/**
 * Enum for various types appearing in Skyjo (action).
 *
 * @author Maximilian Schiedermeier
 */
public enum CardType {

  /**
   * Represents cards with value below 0.
   */
  NUMERIC_NEGATIVE,

  /**
   * Represents cards with value equal 0.
   */
  NUMERIC_NEUTRAL,

  /**
   * Represents cards with mildly positive value, i.e. 1-4.
   */
  NUMERIC_POSITIVE_LIGHT,

  /**
   * Represents cards with moderately positive value, i.e. 5-8.
   */
  NUMERIC_POSITIVE_MODERATE,

  /**
   * Represents cards with heavily positive value, i.e. 9-12.
   */
  NUMERIC_POSITIVE_HEAVY,

  /**
   * Represents special cards.
   */
  SPECIAL
}
