package util.account.validator;

import java.util.Optional;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Predicate;

import javafx.scene.control.TextField;

public class InformationValidator {
  // This indicator determines whether textfield content is wrong once or not to
  // avert redundancy
  private static boolean Indicator = false;
  // I wrote this script to lessen the lines of code and added and indicator to
  // prevent excessive utilization
  private static BiConsumer<TextField, Boolean> validateInput = (textField, validatingFactor) -> {
    var buttonContent = Optional.ofNullable(textField.getText());
    buttonContent.filter(text -> validatingFactor /* && !Indicator */).map(text -> {
      // System.out.println(validateEmail.test(text) + " " +
      // validatePassowrd.test(text) + text);
      Indicator = true;
      textField.setStyle("-fx-border-color: none");
      return null;
    });
    buttonContent.filter(text -> !validatingFactor /* && Indicator */).map(text -> {
      // System.out.println(validateEmail.test(text) + " " +
      // validatePassowrd.test(text) + text);
      Indicator = false;
      textField.setStyle("-fx-border-color: red");
      return null;
    });
  };

  // Don't modify this
  public static Consumer<TextField> validateEmail = email -> {
    validateInput.accept(email,
        email.getText().matches("^[^@][\\w[^@]]+(@[a-z]+\\.)(com|net|(edu|co)\\.[a-z]{2})(\\s)*$"));
  };

  public static Consumer<TextField> validatePassowrd = password -> {
    validateInput.accept(password,
        password.getText().matches("((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$%^&*()_+-=<>?{}\\[\\]]).{9,15})[\\s]*$"));
  };

  public static Consumer<TextField> validateUser = username -> {

  };

}
