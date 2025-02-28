package siguraso.flusher.model;

import java.util.ArrayList;
import java.util.Random;
import java.util.stream.IntStream;

public class DeckOfCards {

  // suits in unicode characters
  private final char[] suits = {'♥', '♦', '♣', '♠'};
  private String[] currentHand;

  ArrayList<String> cards = new ArrayList<>();

  public DeckOfCards() {
    IntStream.range(1, 14).boxed().forEach(i -> {
      for (char suit : suits) {
        cards.add(String.valueOf(suit) + i);
      }
    });
  }

  public ArrayList<String> getDeckOfCards() {
    return cards;
  }

  public String[] dealHand(int cardsInHand) {
    String[] hand = new String[cardsInHand];
    Random rand = new Random();
    // create a temporary list to remove cards from

    ArrayList<String> tempCards = new ArrayList<>(cards);

    for (int i = 0; i < cardsInHand; i++) {
      int cardIndex = rand.nextInt(tempCards.size());
      hand[i] = tempCards.get(cardIndex);
      tempCards.remove(cardIndex);
    }

    currentHand = hand;
    return currentHand;
  }

  public String[] getCurrentHand() {
    return currentHand;
  }
}
