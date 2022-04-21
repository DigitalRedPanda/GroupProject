package util.gui;

import javafx.application.Application;

import javafx.scene.Scene;

import javafx.scene.image.Image;

import javafx.scene.layout.StackPane;

import javafx.scene.paint.Color;

import javafx.stage.Stage;

public class GUI extends Application {

 @Override
 public void start(Stage arg0) throws Exception {

  StackPane pane = new StackPane();

  Scene scene = new Scene(pane, 600, 600, Color.VIOLET);

  Image icon = new Image(
    "file:src\\util\\gui\\icon\\Company.png");

  arg0.getIcons().add(icon);

  arg0.setTitle("Registration");

  arg0.show();

 }

 public static void main(String[] args) {

  launch();

 }
}
