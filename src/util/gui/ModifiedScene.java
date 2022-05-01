package util.gui;

import java.util.Arrays;
import java.util.function.BiConsumer;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
// import javafx.scene.paint.Color;
import javafx.scene.text.Text;

public class ModifiedScene extends Scene {

  public ModifiedScene(VBox pane, Text text, TextField[] textFields,
      Button initiatorButton, Button switchingButton) {
    super(pane, 800, 600, Color.valueOf("#142850"));
    // Application.setUserAgentStylesheet("#142850");
    this.getStylesheets().add(this.getClass().getResource("InterfaceStyle.css").toExternalForm());
    pane.getChildren().add(text);
    improvePaneContent.accept(pane, textFields);
    pane.getChildren().addAll(switchingButton, initiatorButton);
    pane.setAlignment(Pos.CENTER);
    text.setId("Header");
    initiatorButton.setId("ProcessInitiator");
    switchingButton.setId("Switcher");
    // This method that contains a lambda is liable for switching between scenes
  }

  BiConsumer<VBox, TextField[]> improvePaneContent = (pane, textFields) -> {
    Arrays.stream(textFields).forEach((textField) -> {
      // textField.setFocusTraversable(false);
      textField.setId("Info");
    });
    pane.getChildren().addAll(textFields);
  };

}
