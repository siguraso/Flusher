module siguraso.flusher.flusher {
  requires javafx.controls;
  requires javafx.graphics;

  opens siguraso.flusher to javafx.graphics;
  exports siguraso.flusher;
}