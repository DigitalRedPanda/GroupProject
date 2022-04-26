package util.gui;

import java.awt.Color;
import java.io.IOException;
import java.util.Optional;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Predicate;

import company.member.Member;
import javafx.application.Application;
//import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.Border;
import javafx.scene.layout.VBox;
//import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Screen;
import javafx.stage.Stage;
//import javafx.stage.StageStyle;

public class GUI extends Application {
  boolean Indicator = false;
  Label emailCorrectionIndicator;
  BiConsumer<Predicate<String>, TextField> contentValidator = (validator, textField) -> {
    var contentOptional = Optional.ofNullable(textField.getText());
    contentOptional.filter(content -> !validator.test(content) && !Indicator).map(content -> {
      System.out.println(validator.test(content));
      Indicator = true;
      textField.setStyle("-fx-border-color: red;");
      return content;
    });
    contentOptional.filter(content -> validator.test(content) && Indicator).map(content -> {
      System.out.println(validator.test(content));
      Indicator = false;
      textField.setStyle("-fx-border-color: none");
      return content;
    });
  };

  @Override
  public void start(Stage primaryStage) {

    // Application.setUserAgentStylesheet(Application.STYLESHEET_MODENA);
    // I chose this pane type because it acommodates a good stacking support for
    // nodes
    var loginLayout = new VBox(5);
    // currentScene = primaryStage.getScene();
    // Email is typed here
    var emailField = new TextField();
    // Password is typed here
    var passwordField = new PasswordField();
    // A prompt text is a transparent text that was previously written to guide
    // users by its content
    emailField.setPromptText("Enter your email");
    passwordField.setPromptText("Enter your password");
    // This button will initiate the validation procedure that validates his
    // registeration
    var loginButton = new Button();
    // This button will contain the action of switching to the second scene
    var registerButton = new Button();
    // Set the button's content to be "Login"
    loginButton.setText("Login");
    // Set the button's content to be "Aren't you registered"
    registerButton.setText("Aren't you registered?");
    var loginScene = new ModifiedScene(loginLayout, new Text("Login"), new TextField[] {
        emailField, passwordField }, loginButton, registerButton);
    // Creating a pane that comprises registeration necessities
    var regiserLayout = new VBox(5);
    // The typed-username is stored in the text file to greet the user after
    // successfully signing in
    var usernameField = new TextField();
    // This field will be processed in order to avoid wrongly-typed emails
    var emailRegisterField = new TextField();
    // This field will have a simple
    var passwordForCheckingField = new PasswordField();
    // This button will contain the username that will be showed with the greeting
    // scene when the user completely sign in
    usernameField.setPromptText("Enter your username");
    emailRegisterField.setPromptText("Enter your email");
    passwordForCheckingField.setPromptText("Enter your password");
    emailRegisterField.setOnKeyTyped(event -> {
      contentValidator.accept(Member.validateEmail, emailRegisterField);
    });
    passwordForCheckingField.setOnKeyTyped(event -> {
      contentValidator.accept(Member.validatePassowrd, passwordForCheckingField);
    });
    // This button will initiate the input processing to assure a correct input has
    // been typed
    var registerNowButton = new Button();
    // This button is responsible for switching back to the first scene
    var loginSceneButton = new Button();
    // Set this button's content to be "Register"
    registerNowButton.setText("Register");
    // Set this button's content to be "Are you already registered?"
    loginSceneButton.setText("Are you already registered?");
    // This second scene includes the following: VBox, Text, TextField[], First
    // button, Second Button
    var registerScene = new ModifiedScene(regiserLayout, new Text("Register"),
        new TextField[] { usernameField, emailRegisterField, passwordForCheckingField }, registerNowButton,
        loginSceneButton);

    registerButton.setOnAction(event -> {
      primaryStage.setScene(registerScene);
    });
    loginSceneButton.setOnAction(event -> {
      primaryStage.setScene(loginScene);
    });
    registerNowButton.setOnAction(event -> {

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
