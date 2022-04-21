package util.gui;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;

import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class GUI extends Application {

 @Override
 public void start(Stage primaryStage) throws Exception {

  Pane root = new StackPane();

  Pane loginLayout = new VBox(50);

  root.getChildren().add(loginLayout);

  Scene scene = new Scene(root, 600, 600);

  Image icon = new Image(
    "file:src\\util\\gui\\icon\\Company.png");

  scene.setFill(Color.rgb(20, 40, 80));

  primaryStage.initStyle(StageStyle.DECORATED);

  primaryStage.getIcons().add(icon);

  primaryStage.setScene(scene);

  primaryStage.setTitle("Registration");

  primaryStage.show();

 }

 public static void main(String[] args) {

  launch();

 }
}
