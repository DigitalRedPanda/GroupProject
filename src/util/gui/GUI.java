package util.gui;

import javafx.animation.TranslateTransition;

import javafx.application.Application;

import javafx.geometry.Insets;

import javafx.scene.Scene;

import javafx.scene.image.Image;

import javafx.scene.layout.BorderPane;

import javafx.scene.layout.Pane;

import javafx.scene.layout.VBox;

import javafx.scene.paint.Color;

import javafx.scene.text.Text;

import javafx.stage.Stage;

import javafx.stage.StageStyle;

public class GUI extends Application {

 @Override
 public void start(Stage primaryStage) throws Exception {

  TranslateTransition translate = new TranslateTransition();

  BorderPane border = new BorderPane();

  VBox loginLayout = new VBox(50);

  border.getChildren().add(loginLayout);

  Scene scene = new Scene(border, 600, 600);

  border.setCenter(loginLayout);

  Text txt1 = new Text("Username");

  txt1.setStyle("-fx-fill: #03cafc; -fx-font: 30 Cursive");

  loginLayout.setPadding(new Insets(10, 0, 10, 0));

  loginLayout.getChildren().add(txt1);

  Image icon = new Image(
    "file:src\\util\\gui\\icon\\Company.png");

  scene.setFill(Color.rgb(20, 40, 80));

  primaryStage.initStyle(StageStyle.DECORATED);

  primaryStage.getIcons().add(icon);

  primaryStage.setScene(scene);

  primaryStage.setTitle("Registration");

  primaryStage.setMinWidth(500);

  primaryStage.show();

 }

 public static void main(String[] args) {

  launch();

 }
}
