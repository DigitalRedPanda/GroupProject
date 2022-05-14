package company.member;

import java.util.ArrayList;

import util.account.Account;

public class Employee extends Account {

 // private static ArrayList<String> employeeList = new ArrayList<>();

 public Employee() {
  super();
  // employeeList.add(this.getUsername());
 }

 public Employee(String email, String password) {
  super(email, password);
  // employeeList.add(this.getUsername());
 }

 /*
  * public static ArrayList<String> getEmployeesList() {
  * return employeeList;
  * }
  */

 @Override
 public void register() {
  // TODO implementing an algorithim that registers the Employee via a writing
  // method that stores their information
 }

 @Override
 public void signIn() {
  // TODO implementing an algorithim that signs the employees in and checks
  // through a reading method that confirms their existance
 }
}
