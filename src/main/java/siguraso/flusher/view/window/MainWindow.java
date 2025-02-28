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
  private final Label handsDealtLabel = new Label("Hands dealt: 0");
  private int handsDealtCounter = 0;
  private final BorderPane root = new BorderPane();
  private boolean freakyModeActive = false;
  private final Button newHandButton = new Button("New hand");
  private final Button checkHandButton = new Button("Check hand");


  public MainWindow(Stage primaryStage) {
    this.window = primaryStage;
  }

  private void toggleFreakyMode() {
    freakyModeActive = !freakyModeActive;
  }

  private boolean isFreakyModeActive() {
    return freakyModeActive;
  }

  private void updateHandsDealtCounter() {
    handsDealtCounter++;
    handsDealtLabel.setText("Hands dealt: " + handsDealtCounter);

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
    handsDealtLabel.getStyleClass().add("hands_dealt_label");
    CardView cardView = new CardView();
    cardView.init();

    newHandButton.setMinHeight(50);
    newHandButton.setMinWidth(200);
    newHandButton.setOnAction(actionEvent -> {
      cardView.updateCards(deckOfCards.dealHand(5));
      updateHandsDealtCounter();
    });

    CheckHandRegion checkHandRegion = new CheckHandRegion();
    checkHandRegion.init();

    checkHandButton.setMinHeight(50);
    checkHandButton.setMinWidth(200);
    checkHandButton.setOnAction(
        actionEvent -> checkHandRegion.updateRegion(deckOfCards.getCurrentHand()));

    HBox buttonBox = new HBox();
    buttonBox.getChildren().addAll(newHandButton, checkHandButton);
    buttonBox.setAlignment(javafx.geometry.Pos.CENTER);
    buttonBox.setSpacing(40);

    dealCardRegion.getChildren()
        .addAll(header, cardView.getComponent(), buttonBox,
            handsDealtLabel);
    dealCardRegion.getStyleClass().add("deal_card_region");
    dealCardRegion.setAlignment(javafx.geometry.Pos.CENTER);
    dealCardRegion.setSpacing(20);
    dealCardRegion.setMinWidth(1000);

    // these unicodde characters spell "freaky" in a fancy font
    Button freakyModeButton = getFreakyButton(header);

    root.setRight(checkHandRegion.getComponent());
    root.setCenter(dealCardRegion);
    root.getStyleClass().add("main_window");

    StackPane allElements = new StackPane();
    allElements.getChildren().add(root);
    freakyModeButton.getStyleClass().add("freaky_mode_button");

    allElements.getChildren().add(freakyModeButton);

    Scene scene = new Scene(allElements);
    scene.getStylesheets().add("file:src/main/resources/style/Style.css");

    window.setTitle("flusher.");
    window.setScene(scene);
    window.setResizable(false);
    window.setWidth(1800);
    window.setHeight(900);
  }

  private Button getFreakyButton(Label header) {
    // this button stays hidden until the user hovers over it, where it appears.
    Button freakyModeButton = new Button(
        "Toggle  \uD835\uDCEF\uD835\uDCFB\uD835\uDCEE\uD835\uDCEA\uD835\uDCF4\uD835\uDD02  mode");
    freakyModeButton.setOnAction(actionEvent -> {
      toggleFreakyMode();
      if (isFreakyModeActive()) {
        // when freaky mode is active, change the header and the window title
        header.setText(
            "\uD835\uDCEF\uD835\uDCFB\uD835\uDCEE\uD835\uDCEA\uD835\uDCF4\uD835\uDD02  flusher. 😩");
        window.setTitle("freaky flusher. >:)");
        newHandButton.setText("Flush me zaddy 😩");
        checkHandButton.setText("Check on my hand daddy 😩");
      } else {
        header.setText("flusher.");
        window.setTitle("flusher.");
        newHandButton.setText("New hand");
        checkHandButton.setText("Check hand");
      }
    });
    return freakyModeButton;
  }
}
