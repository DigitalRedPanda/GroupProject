package company.member;

import java.util.ArrayList;

import util.account.Account;

public class Employee extends Member implements Account {

 private static ArrayList<Employee> employeeList = new ArrayList<>();

 public Employee() {
  super();
 }

 public Employee(String email, String password) {
  super(email, password);
 }

 public static ArrayList<Employee> employeesList() {
  return employeeList;
 }

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
