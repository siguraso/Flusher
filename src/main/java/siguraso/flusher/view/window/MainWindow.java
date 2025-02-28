package siguraso.flusher.view.window;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import siguraso.flusher.model.DeckOfCards;
import siguraso.flusher.view.window.components.CardView;
import siguraso.flusher.view.window.components.CheckHandRegion;

public class MainWindow implements Window {

  private final Stage window;
  private final DeckOfCards deckOfCards = new DeckOfCards();
  private final VBox dealCardRegion = new VBox();
  private final BorderPane root = new BorderPane();


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
    Label header = new Label("flusher.");
    header.getStyleClass().add("header");
    CardView cardView = new CardView();
    cardView.init();

    Button newHand = new Button("Draw new hand");
    newHand.setMinHeight(50);
    newHand.setMinWidth(200);
    newHand.setOnAction(actionEvent -> {
      cardView.updateCards(deckOfCards.dealHand(5));
    });

    CheckHandRegion checkHandRegion = new CheckHandRegion();
    checkHandRegion.init();

    Button checkHand = new Button("Check hand");
    checkHand.setMinHeight(50);
    checkHand.setMinWidth(200);
    checkHand.setOnAction(actionEvent -> {
      checkHandRegion.updateRegion(deckOfCards.getCurrentHand());
    });

    HBox buttonBox = new HBox();
    buttonBox.getChildren().addAll(newHand, checkHand);
    buttonBox.setAlignment(javafx.geometry.Pos.CENTER);
    buttonBox.setSpacing(40);

    dealCardRegion.getChildren()
        .addAll(header, cardView.getComponent(), buttonBox, checkHandRegion.getComponent());
    dealCardRegion.getStyleClass().add("deal_card_region");
    dealCardRegion.setAlignment(javafx.geometry.Pos.CENTER);
    dealCardRegion.setSpacing(20);
    dealCardRegion.setMinWidth(1000);

    root.setRight(checkHandRegion.getComponent());
    root.setCenter(dealCardRegion);
    root.getStyleClass().add("main_window");

    Scene scene = new Scene(root);
    scene.getStylesheets().add("file:src/main/resources/style/Style.css");

    window.setTitle("Flusher");
    window.setScene(scene);
    window.setResizable(false);
    window.setWidth(1800);
    window.setHeight(900);
  }
}
