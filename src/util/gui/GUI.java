package util.gui;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.stream.Stream;

import javafx.animation.TranslateTransition;

import javafx.application.Application;

import javafx.geometry.Insets;

import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;

import javafx.scene.control.TextField;

import javafx.scene.image.Image;

import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

import javafx.scene.paint.Color;

import javafx.scene.text.Text;

import javafx.stage.Screen;

import javafx.stage.Stage;

import javafx.stage.StageStyle;

public class GUI extends Application {

  @Override
  public void start(Stage primaryStage) throws Exception {
    TranslateTransition translate = new TranslateTransition();
    VBox loginLayout = new VBox(5);
    Scene scene = new Scene(loginLayout, 600, 600/* , Color.valueOf("#142850") */);
    TextField txtf1 = new TextField();
    txtf1.setPromptText("Enter Username");
    TextField txtf2 = new TextField();
    txtf2.setPromptText("Enter passowrd");
    Text txt1 = new Text("Login");
    txt1.setStyle("-fx-fill: #F5F5E9; -fx-font: 30 \"Courier New\";");
    txt1.setStroke(Color.GRAY);
    loginLayout.getChildren().add(txt1);
    improvePaneContent.accept(loginLayout, new TextField[] { txtf1, txtf2 });
    scene.setFill(Color.valueOf("#142850"));
    loginLayout.setAlignment(Pos.CENTER);
    Image icon = new Image(
        "file:src\\util\\gui\\icon\\Company.png");
    primaryStage.initStyle(StageStyle.DECORATED);
    primaryStage.getIcons().add(icon);
    primaryStage.setScene(scene);
    primaryStage.setTitle("Login");
    primaryStage.setMinWidth(500);
    primaryStage.setMinHeight(600);
    primaryStage.setMaxHeight(Screen.getPrimary().getBounds().getHeight());
    primaryStage.setMaxWidth(Screen.getPrimary().getBounds().getWidth());
    primaryStage.show();
  }

  BiConsumer<Pane, TextField[]> improvePaneContent = (pane, textFields) -> {
    Arrays.stream(textFields).forEach((textField) -> {
      textField.setMaxHeight(60);
      textField.setMaxWidth(200);
    });
    pane.getChildren().addAll(textFields);
  };

  public static void main(String[] args) {
    launch();
  }
}
