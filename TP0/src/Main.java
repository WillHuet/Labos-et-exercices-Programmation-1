public class Main {

  /**
   * Launcher for Skyjo TP0.
   * The code below is to illustrate how CardImpl implementations are used. Student code will be
   * tested BEYOND the examples below.
   *
   * @param args none.
   */
  public static void main(String[] args) {

    // Example 1, card "-1"
    Card testCardMinus1 = new CardImpl(-1);
    System.out.println(testCardMinus1.getType());
    System.out.println(testCardMinus1);
    // Must print:
    //    NUMERIC_NEGATIVE
    //    -1

    // Example 2, card "12"
    Card testCard12 = new CardImpl(12);
    System.out.println(testCard12.getType());
    System.out.println(testCard12);
    // Must print:
    //    NUMERIC_POSITIVE_HEAVY
    //    12
  }
}
