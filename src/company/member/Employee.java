package company.member;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Optional;
import java.util.Scanner;

import util.Account;

public class Employee extends Member implements Account {

 File storage = new File("src/company/member/data/Users.txt");

 private static ArrayList<Employee> employeeList = new ArrayList<>();

 public Employee() {
  super();
 }

 public Employee(String email, String password) {
  super(email, password);
 }

 private boolean infoExists(String contentToSearch, int position) {

  try (Scanner scan = new Scanner(storage)) {
   while (scan.hasNextLine()) {
    var memberInfo = scan.nextLine().split(",");
    Optional<String> contentOptional = Optional.of(contentToSearch);
    contentOptional.filter(content -> content.equals(memberInfo[position])).map(name -> {
     return true;
    });
    contentOptional.filter(content -> !content.equals(memberInfo[position])).map(name -> {
     return false;
    });
   }
  } catch (IOException e) {
   e.printStackTrace();
  }
  return false;
 }

 public static ArrayList<Employee> employeesList() {
  return employeeList;
 }

 @Override
 public boolean signIn(Member employee) {
  return false;

 }

 @Override
 public void register() {

 }

 @Override
 public boolean usernameExists(String memberName) {
  return infoExists(memberName, 0);
 }

 @Override
 public boolean emailExists(String email) {

  return infoExists(email, 1);
 }
}
