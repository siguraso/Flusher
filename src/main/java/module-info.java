module siguraso.flusher.flusher {
  requires javafx.controls;
  requires javafx.graphics;

  opens siguraso.flusher.flusher to javafx.graphics;
  exports siguraso.flusher.flusher;
  exports siguraso.flusher;
  opens siguraso.flusher to javafx.graphics;
}