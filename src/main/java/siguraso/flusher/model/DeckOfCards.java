package siguraso.flusher.model;

import java.util.ArrayList;
import java.util.Random;
import java.util.stream.IntStream;

public class DeckOfCards {

  // suits in unicode characters
  private final char[] suits = {'♥', '♦', '♣', '♠'};

  ArrayList<String> cards = new ArrayList<>();

  public DeckOfCards() {
    IntStream.range(1, 53).boxed().forEach(i -> {
      for (char suit : suits) {
        cards.add(String.valueOf(suit) + i);
      }
    });
  }

  public ArrayList<String> getDeckOfCards() {
    return cards;
  }

  public String[] dealHand(int cards) {
    String[] hand = new String[cards];
    Random rand = new Random();
    // create a temporary list to remove cards from
    ArrayList<String> tempCards = this.cards;

    for (int i = 0; i < cards; i++) {
      int cardIndex = rand.nextInt(tempCards.size());
      hand[i] = tempCards.get(cardIndex);
      tempCards.remove(cardIndex);
    }

    return hand;
  }
}
