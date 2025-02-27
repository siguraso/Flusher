package siguraso.flusher.model;

public class HandChecker {

  public HandChecker() {
  }

  public boolean checkFlush(String[] hand) {
    char suit = hand[0].charAt(0);
    for (String card : hand) {
      if (card.charAt(0) != suit) {
        return false;
      }
    }

    return true;
  }


}
