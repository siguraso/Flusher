package siguraso.flusher.model;

public class HandChecker {

  public HandChecker() {
  }

  public boolean checkFlush(String[] hand) {
    // create a deep, temporary copy of the hand
    char suit = hand[0].charAt(0);
    int sameSuitCount = 0;

    for (String card : hand) {
      if (card.charAt(0) == suit) {
        sameSuitCount++;
      }
    }

    return sameSuitCount == hand.length;
  }

  public int checkSum(String[] hand) {
    int sum = 0;
    for (String card : hand) {
      sum += Integer.parseInt(card.substring(1));
    }
    return sum;
  }

  public String heartsInHand(String[] hand) {
    StringBuilder hearts = new StringBuilder();
    for (String card : hand) {
      if (card.charAt(0) == '♥') {
        hearts.append(card).append(" ");
      }
    }
    return hearts.toString();
  }


}
