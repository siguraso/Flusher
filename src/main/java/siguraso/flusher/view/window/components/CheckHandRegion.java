package siguraso.flusher.view.window.components;

import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import siguraso.flusher.model.HandChecker;

public class CheckHandRegion implements WindowComponent {

  private final HandChecker handChecker = new HandChecker();
  private final VBox checkHandRegion = new VBox();
  private final VBox sumBox = new VBox();
  private final VBox heartsBox = new VBox();
  private final VBox fiveFlushBox = new VBox();
  private final VBox queenOfSpadesBox = new VBox();

  public CheckHandRegion() {
  }

  public void init() {
    Label sumOfHand = new Label("Sum of hand: ");
    sumOfHand.getStyleClass().add("check_hand_label");
    Label handSum = new Label("-");
    handSum.getStyleClass().add("check_hand_value");
    sumBox.setAlignment(javafx.geometry.Pos.CENTER);
    sumBox.getChildren().addAll(sumOfHand, handSum);

    Label heartsInHand = new Label("Hearts in hand: ");
    heartsInHand.getStyleClass().add("check_hand_label");
    Label handHearts = new Label("-");
    handHearts.getStyleClass().add("check_hand_value");
    heartsBox.setAlignment(javafx.geometry.Pos.CENTER);
    heartsBox.getChildren().addAll(heartsInHand, handHearts);

    Label hasQueenOfSpades = new Label("Has Queen of spades (♠12): ");
    hasQueenOfSpades.getStyleClass().add("check_hand_label");
    Label queenOfSpades = new Label("-");
    queenOfSpades.getStyleClass().add("check_hand_value");
    queenOfSpadesBox.setAlignment(javafx.geometry.Pos.CENTER);
    queenOfSpadesBox.getChildren().addAll(hasQueenOfSpades, queenOfSpades);

    Label checkFiveFlush = new Label("Has flush: ");
    checkFiveFlush.getStyleClass().add("check_hand_label");
    Label fiveFlush = new Label("-");
    fiveFlush.getStyleClass().add("check_hand_value");
    fiveFlushBox.setAlignment(javafx.geometry.Pos.CENTER);
    fiveFlushBox.getChildren().addAll(checkFiveFlush, fiveFlush);

    checkHandRegion.getChildren().addAll(sumBox, heartsBox, queenOfSpadesBox, fiveFlushBox);
    checkHandRegion.setAlignment(javafx.geometry.Pos.CENTER);
    checkHandRegion.setSpacing(140);
    checkHandRegion.setMinWidth(400);
    checkHandRegion.getStyleClass().add("check_hand_region");
  }

  public void updateRegion(String[] hand) {
    // update sum

    int sum = handChecker.checkSum(hand);
    Label handSum = (Label) sumBox.getChildren().get(1);
    handSum.setText(Integer.toString(sum));

    // update hearts in hand

    String hearts = handChecker.heartsInHand(hand);
    Label handHearts = (Label) heartsBox.getChildren().get(1);
    if (hearts.isEmpty()) {
      handHearts.setText("-");
    } else {
      handHearts.setText(hearts);
    }

    // update queen of spades

    boolean hasQueenOfSpades = false;
    for (String card : hand) {
      if (card.equals("♠12")) {
        hasQueenOfSpades = true;
        break;
      }
    }
    Label queenOfSpades = (Label) queenOfSpadesBox.getChildren().get(1);
    queenOfSpades.setText(hasQueenOfSpades ? "Yes" : "No");

    // update five flush

    boolean hasFiveFlush = handChecker.checkFlush(hand);
    Label fiveFlush = (Label) fiveFlushBox.getChildren().get(1);
    fiveFlush.setText(hasFiveFlush ? "Yes" : "No");
  }

  public Node getComponent() {
    return checkHandRegion;
  }

}
