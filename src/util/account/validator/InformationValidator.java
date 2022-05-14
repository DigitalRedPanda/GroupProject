package util.account.validator;

import java.io.FileNotFoundException;
import java.io.Writer;
import java.util.Optional;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import javafx.scene.control.TextField;
import util.account.Account;
import util.account.reader.AccountReader;
import util.account.reader.IAccountReader;
import util.account.writer.AccountWriter;
import util.account.writer.IAccountWriter;

public class InformationValidator {
  // This indicator determines whether textfield content is wrong once or not to
  // avert redundancy.
  private static boolean Indicator = false;
  private static IAccountReader reader = new AccountReader();
  private static IAccountWriter<Account> writer = new AccountWriter();
  private static boolean usernameIndicator = false;
  // I wrote this script to lessen the lines of code and added and indicator to
  // prevent excessive utilization.
  private static BiConsumer<TextField, Boolean> validateInput = (textField, validatingFactor) -> {
    var buttonContent = Optional.ofNullable(textField.getText());
    buttonContent.filter(text -> validatingFactor && !Indicator).map(text -> {
      // System.out.println(validateEmail.test(text) + " " +
      // validatePassowrd.test(text) + text);
      Indicator = true;
      textField.setStyle("-fx-border-color: none;");
      return null;
    });
    buttonContent.filter(text -> !validatingFactor && Indicator).map(text -> {
      // System.out.println(validateEmail.test(text) + " " +
      // validatePassowrd.test(text) + text);
      Indicator = false;
      textField.setStyle("-fx-border-color: red;");
      return null;
    });
  };

  // These two methods utilize validateInput since they have similar procedures I
  // abbreviated the algorithim in one method
  public static Consumer<TextField> validateEmail = email -> {
    validateInput.accept(email,
        email.getText().matches("^[^@][\\w[^@]]+(@[a-z]+\\.)(com|net|(edu|co)\\.[a-z]{2})(\\s)*$"));
  };

  public static Consumer<TextField> validatePassowrd = password -> {
    // This method validates passwords if they contain at least one digit and a
    // capitalized letter along with at least one symbol
    validateInput.accept(password,
        password.getText().matches("((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[\\W]).{9,})[\\s]*$"));
  };

  public static Consumer<TextField> validateUser = usernameField -> {

    var usernameOptional = Optional.ofNullable(usernameField.getText());
    usernameOptional.filter(usernameTyped -> {
      try {
        return reader.isStored(usernameTyped) && !usernameIndicator;
      } catch (FileNotFoundException e) {
        e.printStackTrace();
      }
      return false;
    }).map(username -> {
      usernameField.setStyle("-fx-border-color: red;");
      usernameIndicator = true;
      return username;
    });
    usernameOptional.filter(usernameTyped -> {
      try {
        return reader.isStored(usernameTyped) && usernameIndicator;
      } catch (FileNotFoundException e) {
        e.printStackTrace();
      }
      return false;
    }).map(username -> {
      usernameField.setStyle("-fx-border-color: none;");
      usernameIndicator = false;
      return username;
    });

  };
}
