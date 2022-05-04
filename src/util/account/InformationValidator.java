package util.account;

import java.util.Optional;
import java.util.function.BiConsumer;
import java.util.function.Predicate;

import javafx.scene.control.TextField;

public class InformationValidator {
 boolean Indicator = false;
 BiConsumer<Predicate<String>, TextField> contentValidator = (validator, textField) -> {
  var contentOptional = Optional.ofNullable(textField.getText());
  contentOptional.filter(content -> !validator.test(content) && !Indicator).map(content -> {
   System.out.println(validator.test(content));
   Indicator = true;
   textField.setStyle("-fx-border-color: red");
   return content;
  });
  contentOptional.filter(content -> validator.test(content) && Indicator).map(content -> {
   System.out.println(validator.test(content));
   Indicator = false;
   textField.setStyle("-fx-border-color: none");
   return content;
  });
 };

 // Don't modify this
 public static Predicate<String> validateEmail = email -> {
  return email.matches("^[^@][\\w[^@]]+(@[a-z]+\\.)(com|net|(edu|co)\\.[a-z]{2})(\\s)*$");
 };

 public static Predicate<String> validatePassowrd = password -> {
  return password.matches("((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$%^&*()_+-=<>?{}\\[\\]]).{9,15})[\\s]*$");
 };

}
