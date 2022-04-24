package util.gui;

import javafx.application.Application;
//import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.VBox;
//import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Screen;
import javafx.stage.Stage;
//import javafx.stage.StageStyle;

public class GUI extends Application {

  @Override
  public void start(Stage primaryStage) throws Exception {
    // Application.setUserAgentStylesheet(Application.STYLESHEET_MODENA);
    // I chose this pane because it commodates a good stacking support for nodes
    VBox loginLayout = new VBox(5);
    // Email is typed here
    TextField emailField = new TextField();
    // Password
    PasswordField passwordField = new PasswordField();
    // A prompt text is a transparent text previously written to guide users by
    // its content
    emailField.setPromptText("Enter email");
    passwordField.setPromptText("Enter password");
    Button loginButton = new Button();
    Button registerButton = new Button();
    loginButton.setText("Login");
    registerButton.setText("Aren't you registered?");
    Scene loginScene = new ModifiedScene(loginLayout, new Text("Login"), new TextField[] {
        emailField, passwordField }, loginButton, registerButton);
    VBox regiserLayout = new VBox(5);
    // loginScene.setFill(Color.valueOf("#142850"));
    // primaryStage.initStyle(StageStyle.UTILITY);
    primaryStage.getIcons().add(new Image(
        "file:src\\util\\gui\\icon\\Company.png"));
    primaryStage.setScene(loginScene);
    primaryStage.setTitle("Digi inc.");
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
