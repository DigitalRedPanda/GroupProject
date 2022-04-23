package util.gui;

import java.util.Arrays;
import java.util.Optional;
import java.util.function.BiConsumer;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class ModifiedScene extends Scene {

 public ModifiedScene(VBox pane, Text text, TextField[] textFields) {
  super(pane, 800, 600, Color.valueOf("#142850"));
  pane.setAlignment(Pos.CENTER);

  /*
   * txtf1.setPromptText("Enter email");
   * PasswordField txtf2 = new PasswordField();
   * txtf2.setPromptText("Enter passowrd");
   * Text txt1 = new Text("Login");
   * txt1.setStyle("-fx-fill: #F5F5E9; -fx-font: 30 \"Courier New\";");
   * txt1.setStroke(Color.GRAY);
   */

 }

 BiConsumer<VBox, TextField[]> improvePaneContent = (pane, textFields) -> {
  Arrays.stream(textFields).forEach((textField) -> {
   Optional.of(textField).filter(textf -> textf instanceof PasswordField).map(textf -> {

    return textField;
   }).filter(textf -> textf instanceof PasswordField == false).map();
   textField.setMaxHeight(60);
   textField.setMaxWidth(200);
  });
  pane.getChildren().addAll(textFields);
 };

}
