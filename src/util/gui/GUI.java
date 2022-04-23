package util.gui;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class GUI extends Application {

  @Override
  public void start(Stage primaryStage) throws Exception {
    // Application.setUserAgentStylesheet(Application.STYLESHEET_MODENA);
    VBox loginLayout = new VBox(5);
    TextField txtf1 = new TextField();
    txtf1.setPromptText("Enter email");
    PasswordField txtf2 = new PasswordField();
    txtf2.setPromptText("Enter password");
    Scene loginScene = new ModifiedScene(loginLayout, new Text("Login"), new TextField[] { txtf1, txtf2 });
    // loginScene.setFill(Color.valueOf("#142850"));
    Button login = new Button();
    login.setText("Login");
    login.setStyle("-fx-color: #4e4b44; -fx-font: 15 \"Monaco\"; ");
    loginLayout.getChildren().add(login);
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
