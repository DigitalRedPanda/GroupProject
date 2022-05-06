package util.account.validator;

import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Predicate;
import javafx.scene.control.TextField;

public class InformationValidator {
 // This indicator determines either textfield content is wrong once or not to
 // avert redundancy
 boolean Indicator = false;
 // I wrote this script to lessen the lines of code and added and indicator to
 // prevent excessive utilization
 public Consumer<TextField> validateInput = textField -> {
  var input = Optional.ofNullable(textField.getText());
  input.filter(text -> (validateEmail.test(text) ^ validatePassowrd.test(text)) && !Indicator).map(text -> {
   System.out.println(validateEmail.test(text) + " " + validatePassowrd.test(text) + text);
   Indicator = true;
   textField.setStyle("-fx-border-color: none");
   return text;
  });
  input.filter(text -> !(validateEmail.test(text) ^ validatePassowrd.test(text)) && Indicator).map(text -> {
   System.out.println(validateEmail.test(text) + " " + validatePassowrd.test(text) + text);
   Indicator = false;
   textField.setStyle("-fx-border-color: red");
   return text;
  });
 };

 // Don't modify this
 private static Predicate<String> validateEmail = email -> {
  return email.matches("^[^@][\\w[^@]]+(@[a-z]+\\.)(com|net|(edu|co)\\.[a-z]{2})(\\s)*$");
 };

 private static Predicate<String> validatePassowrd = password -> {
  return password.matches("((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$%^&*()_+-=<>?{}\\[\\]]).{9,15})[\\s]*$");
 };

}
