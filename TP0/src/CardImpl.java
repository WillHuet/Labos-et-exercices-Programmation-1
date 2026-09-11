/**
 * This class implements the Card interface, and provides a correct
 * implementation of all required methods (including the toString method).
 */
public class CardImpl implements Card {
    private int cardValue = 0;

    public CardImpl(int cardValue){
        this.cardValue = cardValue;
    }
    @Override
    public CardType getType() {
        switch (cardValue){
            case -2, -1:
                return CardType.NUMERIC_NEGATIVE;
            case 0:
                return CardType.NUMERIC_NEUTRAL;
            case 1, 2, 3, 4:
                return CardType.NUMERIC_POSITIVE_LIGHT;
            case 5, 6, 7, 8:
                return CardType.NUMERIC_POSITIVE_MODERATE;
            case 9, 10, 11, 12:
                return CardType.NUMERIC_POSITIVE_HEAVY;
            default:
                throw new RuntimeException();
        }
    }

    @Override
    public int getValue() {
        return this.cardValue;
    }

    @Override
    public String toString(){
        return String.valueOf(this.cardValue);
    }
}
