package siguraso.flusher.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestDeckOfCards {

  private DeckOfCards deck;

  @BeforeEach
  void init() {
    deck = new DeckOfCards();
  }

  @Test
  void testDeckOfCardsGetters() {
    try {
      assertEquals(52, deck.getDeckOfCards().size());
      deck.dealHand(5);
      assertEquals(5, deck.getCurrentHand().length);
    } catch (Exception e) {
      fail("The test failed, as the class threw an exception");
    }
  }

  @Test
  void testDealHand() {
    try {
      String[] hand = deck.dealHand(5);
      assertEquals(5, hand.length);
    } catch (Exception e) {
      fail("The test failed, as the class threw an exception");
    }
  }

  @Test
  void testUniqueCardsInHand() {
    try {
      String[] hand = deck.dealHand(5);
      for (int i = 0; i < hand.length; i++) {
        for (int j = i + 1; j < hand.length; j++) {
          assertNotEquals(hand[i], hand[j]);
        }
      }
    } catch (Exception e) {
      fail("The test failed, as the class threw an exception");
    }
  }


}