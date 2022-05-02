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
