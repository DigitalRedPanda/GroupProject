package util.gui;

import java.util.Arrays;
import java.util.function.BiConsumer;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

public class ModifiedScene extends Scene {

 public ModifiedScene(VBox pane, Text text, TextField[] textFields) {
  super(pane, 800, 600);
  // Application.setUserAgentStylesheet("#142850");
  pane.getChildren().add(text);
  improvePaneContent.accept(pane, textFields);
  pane.setAlignment(Pos.CENTER);
  text.setStyle("-fx-fill: #F5F5E9; -fx-font: 30 \"Courier New\"; -fx-font-weight: bold");
  text.setStroke(Color.GRAY);
 }

 BiConsumer<VBox, TextField[]> improvePaneContent = (pane, textFields) -> {
  Arrays.stream(textFields).forEach((textField) -> {
   textField.setFocusTraversable(false);
   textField.setMaxHeight(60);
   textField.setMaxWidth(200);
  });
  pane.getChildren().addAll(textFields);
 };

}
