package util.gui;

import java.io.IOException;
import java.util.Optional;
import java.util.function.Consumer;

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
  public void start(Stage primaryStage) throws IOException {

    // Application.setUserAgentStylesheet(Application.STYLESHEET_MODENA);
    // I chose this pane type because it acommodates a good stacking support for
    // nodes
    VBox loginLayout = new VBox(5);
    // currentScene = primaryStage.getScene();
    // Email is typed here
    TextField emailField = new TextField();
    // Password is typed here
    PasswordField passwordField = new PasswordField();
    // A prompt text is a transparent text that was previously written to guide
    // users by its content
    emailField.setPromptText("Enter your email");
    passwordField.setPromptText("Enter your password");
    // This button will initiate the validation procedure that validates his
    // registeration
    Button loginButton = new Button();
    Button registerButton = new Button();
    loginButton.setText("Login");
    registerButton.setText("Aren't you registered?");
    Scene loginScene = new ModifiedScene(loginLayout, new Text("Login"), new TextField[] {
        emailField, passwordField }, loginButton, registerButton);
    // Creating a pane that comprises registeration necessities
    VBox regiserLayout = new VBox(5);
    // The typed-username is stored in the text file to greet the user after
    // successfully signing in
    TextField usernameField = new TextField();
    // This field will be processed in order to avoid wrongly-typed emails
    TextField emailRegisterField = new TextField();
    // This field will have a simple
    PasswordField passwordForCheckingField = new PasswordField();
    // This button will contain the username that will be showed with the greeting
    // scene when the user completely sign in
    usernameField.setPromptText("Enter your username");
    emailRegisterField.setPromptText("Enter your email");
    passwordForCheckingField.setPromptText("Enter your password");
    // This button will initiate the input processing to assure a correct input has
    // been typed
    Button registerNowButton = new Button();
    // This button is responsible for switching back to the first scene
    Button loginSceneButton = new Button();
    // Set button's content to be "Register"
    registerNowButton.setText("Register");
    // Set button's content to be "Are you already registered?"
    loginSceneButton.setText("Are you already registered?");
    // This second scene includes the following: VBox, Text, TextField[], First
    // button, Second Button

    Scene registerScene = new ModifiedScene(regiserLayout, new Text("Register"),
        new TextField[] { usernameField, emailRegisterField, passwordForCheckingField }, registerNowButton,
        loginSceneButton);
    /*
     * Consumer<Scene> handleConsumer = scene -> {
     * /*
     * Optional.of(scene).filter(currentScene ->
     * currentScene.equals(loginScene)).map(currentScene -> {
     * primaryStage.setScene(registerScene);
     * primaryStage.show();
     * return currentScene;
     * }).filter(currentScene ->
     * currentScene.equals(registerScene)).map(currentScene -> {
     * primaryStage.setScene(loginScene);
     * primaryStage.show();
     * return currentScene;
     * });
     * 
     * if (scene == loginScene) {
     * primaryStage.setScene(registerScene);
     * primaryStage.show();
     * } else {
     * primaryStage.setScene(loginScene);
     * primaryStage.show();
     * }
     * };
     */
    registerButton.setOnAction(event -> {
      // handleConsumer.accept(registerScene);
      primaryStage.setScene(registerScene);
      primaryStage.show();
    });
    loginSceneButton.setOnAction(event -> {
      // handleConsumer.accept(loginScene);
      primaryStage.setScene(loginScene);
      primaryStage.show();
    });

    // loginScene.setFill(Color.valueOf("#142850"));
    // primaryStage.initStyle(StageStyle.UTILITY);
    // Adding the application icon
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
