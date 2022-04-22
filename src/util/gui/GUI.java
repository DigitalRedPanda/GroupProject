package util.gui;

import javafx.animation.TranslateTransition;

import javafx.application.Application;

import javafx.geometry.Insets;

import javafx.geometry.Pos;

import javafx.scene.Scene;

import javafx.scene.control.TextField;

import javafx.scene.image.Image;

import javafx.scene.layout.BorderPane;

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

    // BorderPane border = new BorderPane();

    VBox loginLayout = new VBox(10);

    // border.getChildren().add(loginLayout);

    Scene scene = new Scene(loginLayout, 600, 600/* , Color.valueOf("#142850") */);

    scene.setFill(Color.valueOf("#142850"));

    Text txt1 = new Text("Username");

    // BorderPane.setAlignment(loginLayout, Pos.BASELINE_CENTER);

    txt1.setStyle("-fx-fill: #F5F5E9; -fx-font: 30 \"Courier New\";");

    txt1.setStroke(Color.GRAY);

    /*
     * TextField txtf1 = new TextField("Enter your name");
     * 
     * txtf1.setMaxWidth(150);
     */
    loginLayout.setPadding(new Insets(10, 0, 10, 0));

    loginLayout.getChildren().addAll(txt1/* , txtf1 */);

    loginLayout.setAlignment(Pos.CENTER);

    Image icon = new Image(
        "file:src\\util\\gui\\icon\\Company.png");

    primaryStage.initStyle(StageStyle.DECORATED);

    primaryStage.getIcons().add(icon);

    primaryStage.setScene(scene);

    primaryStage.setTitle("Registration");

    primaryStage.setMinWidth(500);

    primaryStage.setMinHeight(600);

    primaryStage.setMaxHeight(Screen.getPrimary().getBounds().getHeight());

    primaryStage.setMaxWidth(Screen.getPrimary().getBounds().getWidth());

    primaryStage.show();

  }

  public static void main(String[] args) {

    launch();

  }
}
