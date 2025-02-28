package siguraso.flusher.model;

public class HandChecker {

  public HandChecker() {
  }

  public boolean checkFiveFlush(String[] hand) {
    // create a deep, temporary copy of the hand
    String[] tempCards = new String[5];
    for (int i = 0; i < hand.length; i++) {
      tempCards[i] = hand[i].substring(0, 1);
    }

    int redCount = 0;
    int blackCount = 0;

    for (String card : tempCards) {
      if (card.charAt(0) == '♥' || card.charAt(0) == '♦') {
        redCount++;
      } else {
        blackCount++;
      }
    }

    return redCount == 5 || blackCount == 5;
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
