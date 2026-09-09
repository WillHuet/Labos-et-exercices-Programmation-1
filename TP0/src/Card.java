/**
 * Represents a Skyjo card. There a various types of cards, concerning values they represent and
 * their characteristic visualization. Cards must display neatly formatted when toString is
 * invoked, that is take up strictly two characters. Examples: "-2", " 2" (leading space), "12".
 * Cards have a type associated, based on their value. The ranges are: below 0: NUMERIC_NEGATIVE,
 * ==0: NUMERIC_NEUTRAL, 1-4: NUMERIC_POSITIVE_LIGHT, 5-8: NUMERIC_POSITIVE_MODERATE, 9-12:
 * NUMERIC_POSITIVE_HEAVY.
 *
 * @author Maximilian Schiedermeier
 */
public interface Card {

  /**
   * Getter for retrieving the type of given card object.
   *
   * @return CardType enum instance specifying the type.
   */
  CardType getType();

  /**
   * Getter for retrieving the numeric value, associated with the card object.
   *
   * @return value in range -2 to 12, associated with card object.
   */
  int getValue();

  /**
   * Getter for string version of card. Must print the card's value as two-character string. For
   * example: "-2", " 2" (mind the leading space character!), "12".
   */
  String toString();
}
