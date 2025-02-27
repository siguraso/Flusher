package siguraso.flusher.view;

import javafx.application.Application;
import javafx.stage.Stage;
import siguraso.flusher.view.window.MainWindow;

public class UserInterface extends Application {

  @Override
  public void start(Stage primaryStage) {
    MainWindow mainWindow = new MainWindow(primaryStage);

    mainWindow.init();
    mainWindow.show();
  }

}
