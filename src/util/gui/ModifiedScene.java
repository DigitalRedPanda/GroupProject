package util.gui;

import java.util.Arrays;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

public class ModifiedScene extends Scene {

  public ModifiedScene(VBox pane, Text text, TextField[] textFields,
      Button initiatorButton, Button switchingButton) {
    super(pane, 600, 500, Color.valueOf("#142850"));
    // Application.setUserAgentStylesheet("#142850");
    this.getStylesheets().add(this.getClass().getResource("InterfaceStyle.css").toExternalForm());
    pane.getChildren().add(text);
    Arrays.stream(textFields).forEach((textField) -> {
      textField.setId("Info");
      pane.getChildren().add(textField);
    });
    pane.getChildren().addAll(switchingButton, initiatorButton);
    pane.setAlignment(Pos.CENTER);
    text.setId("Header");
    initiatorButton.setId("ProcessInitiator");
    switchingButton.setId("Switcher");
    // This method that contains a lambda is liable for switching between scenes
  }

}
