package siguraso.flusher.view.window;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import siguraso.flusher.model.DeckOfCards;
import siguraso.flusher.view.window.components.CardView;

public class MainWindow implements Window {

  private final Stage window;
  private final DeckOfCards deckOfCards = new DeckOfCards();
  VBox root = new VBox();


  CardView cardView = new CardView(deckOfCards.dealHand(5));

  public MainWindow(Stage primaryStage) {
    this.window = primaryStage;
  }

  @Override
  public void show() {
    window.show();
  }

  @Override
  public void close() {
    window.close();
  }

  @Override
  public void init() {
    Label header = new Label("Please flush me daddy 😩");
    header.getStyleClass().add("header");

    root.getChildren().addAll(header, cardView.getComponent());
    root.setAlignment(javafx.geometry.Pos.CENTER);
    root.getStyleClass().add("root");
    root.setSpacing(20);

    Scene scene = new Scene(root);
    scene.getStylesheets().add("file:src/main/resources/style/Style.css");

    window.setTitle("Flusher");
    window.setScene(scene);
    window.setWidth(1200);
    window.setHeight(900);
  }
}
