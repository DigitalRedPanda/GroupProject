package util.gui;

import java.util.Arrays;
import java.util.function.BiConsumer;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
// import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.control.Button;

public class ModifiedScene extends Scene {

 public ModifiedScene(VBox pane, Text text, TextField[] textFields,
   Button initiatorButton, Button switchingButton) {
  super(pane, 800, 600);
  // Application.setUserAgentStylesheet("#142850");
  pane.getChildren().add(text);
  improvePaneContent.accept(pane, textFields);
  pane.getChildren().addAll(switchingButton, initiatorButton);
  pane.setAlignment(Pos.CENTER);
  text.setStyle("-fx-fill: #F5F5E9; -fx-font: 50 \"Courier New\"; -fx-font-weight: bold; -fx-stroke: grey");
  // text.setStroke(Color.GRAY);
  initiatorButton.setStyle("-fx-color: #4e4b44; -fx-font: 15 \"Monaco\"; ");
  // switchingButton.setStyle("-fx-border: none; -fx-decoration: underline;");
 }

 BiConsumer<VBox, TextField[]> improvePaneContent = (pane, textFields) -> {
  Arrays.stream(textFields).forEach((textField) -> {
   // textField.setFocusTraversable(false);
   textField.setMaxHeight(120);
   textField.setMaxWidth(300);
  });
  pane.getChildren().addAll(textFields);
 };

}
