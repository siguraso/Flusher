package siguraso.flusher.view.window.components;

import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Rectangle;

public class CardView implements WindowComponent {

  private final HBox cardView = new HBox();

  public CardView() {
  }

  private VBox createCard(String cardString) {
    VBox card = new VBox();
    card.setMinWidth(130);
    card.setMinHeight(200);
    card.setMaxHeight(200);

    Label cardLabel = new Label(cardString);

    if (cardString.charAt(0) == '♥' || cardString.charAt(0) == '♦') {
      card.getStyleClass().add("card_red");
      cardLabel.getStyleClass().add("card_label_red");
    } else {
      card.getStyleClass().add("card_blk");
      cardLabel.getStyleClass().add("card_label_blk");
    }

    card.getChildren().add(cardLabel);

    card.setAlignment(javafx.geometry.Pos.CENTER);

    return card;
  }

  public void updateCards(String[] hand) {
    cardView.getChildren().clear();

    for (String card : hand) {
      cardView.getChildren().add(createCard(card));
    }
  }

  @Override
  public void init() {
    cardView.setSpacing(30);
    cardView.setMaxHeight(400);
    cardView.setMinHeight(400);
    cardView.setMinWidth(900);
    cardView.setMaxWidth(900);
    cardView.setAlignment(javafx.geometry.Pos.CENTER);
    cardView.setPadding(new javafx.geometry.Insets(20, 20, 20, 20));

    cardView.getStyleClass().add("card_view");

  }

  @Override
  public Node getComponent() {
    return cardView;
  }

}
