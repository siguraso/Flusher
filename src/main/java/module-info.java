module siguraso.flusher.flusher {
  requires javafx.controls;
  requires javafx.graphics;

  opens siguraso.flusher.view to javafx.graphics;
  exports siguraso.flusher;
}