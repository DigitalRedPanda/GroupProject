package util.account;

import java.util.function.Predicate;

public class InformationValidator {

 // Don't modify this
 public static Predicate<String> validateEmail = email -> {
  return email.matches("^[^@][\\w[^@]]+(@[a-z]+\\.)(com|net|(edu|co)\\.[a-z]{2})(\\s)*$");
 };

 public static Predicate<String> validatePassowrd = password -> {
  return password.matches("((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$%^&*()_+-=<>?{}\\[\\]]).{9,15})[\\s]*$");
 };

}
