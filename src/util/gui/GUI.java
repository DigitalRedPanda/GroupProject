package util.gui;

import javafx.application.Application;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Screen;
import javafx.stage.Stage;
import util.account.validator.InformationValidator;

public class GUI extends Application {
  @Override
  public void start(Stage primaryStage) {
    // Application.setUserAgentStylesheet(Application.STYLESHEET_MODENA);
    // I chose this pane type because it acommodates a good stacking support for
    // nodes
    var loginLayout = new VBox(5);
    loginLayout.setBackground(Background.EMPTY);
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
    var registerLayout = new VBox(5);
    registerLayout.setBackground(Background.EMPTY);
    // The typed-username is stored in the text file to greet the user after
    // successfully signing in
    var usernameField = new TextField();
    // This field will be processed in order to avoid wrongly-typed emails
    var emailRegisterField = new TextField();
    // This field will have a password regex which notifies the user about the
    // required minimums for the password components
    var passwordForCheckingField = new PasswordField();
    // This button will contain the username that will be showed with the greeting
    // scene when the user completely sign in
    usernameField.setPromptText("Enter your username");
    emailRegisterField.setPromptText("Enter your email");
    passwordForCheckingField.setPromptText("Enter your password");
    usernameField.setOnKeyTyped(event -> {
      InformationValidator.validateUser.accept(usernameField);
    });
    emailRegisterField.setOnKeyTyped(event -> {
      InformationValidator.validateEmail.accept(emailRegisterField);
    });
    passwordForCheckingField.setOnKeyTyped(event -> {
      InformationValidator.validatePassowrd.accept(passwordForCheckingField);
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
    var registerScene = new ModifiedScene(registerLayout, new Text("Register"),
        new TextField[] { usernameField, emailRegisterField, passwordForCheckingField }, registerNowButton,
        loginSceneButton);

    registerButton.setOnMouseClicked(event -> {
      primaryStage.setScene(registerScene);
    });
    loginSceneButton.setOnMouseClicked(event -> {
      primaryStage.setScene(loginScene);
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
