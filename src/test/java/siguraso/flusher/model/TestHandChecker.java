package siguraso.flusher.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestHandChecker {

  private HandChecker handChecker;

  @BeforeEach
  void init() {
    handChecker = new HandChecker();
  }

  @Test
  void testCheckFlush() {
    try {
      String[] hand = {"♥2", "♥3", "♥4", "♥5", "♥6"};
      assertTrue(handChecker.checkFlush(hand));
    } catch (Exception e) {
      fail("The test failed, as the class threw an exception");
    }
  }

  @Test
  void testCheckSum() {
    try {
      String[] hand = {"♥2", "♦3", "♣4", "♠5", "♥6"};
      assertEquals(20, handChecker.checkSum(hand));
      assertNotEquals(21, handChecker.checkSum(hand));

    } catch (Exception e) {
      fail("The test failed, as the class threw an exception");
    }
  }

  @Test
  void testHeartsInHand() {
    try {
      String[] hand = {"♥2", "♦3", "♣4", "♠5", "♥6"};
      assertEquals("♥2 ♥6 ", handChecker.heartsInHand(hand));
      String[] hand2 = {"♦2", "♦3", "♣4", "♠5", "♦6"};
      assertTrue(handChecker.heartsInHand(hand2).isEmpty());
    } catch (Exception e) {
      fail("The test failed, as the class threw an exception");
    }
  }


}