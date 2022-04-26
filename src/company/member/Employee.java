package company.member;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import util.Account;

public class Employee extends Member implements Account {

 File storage = new File("src/company/member/data/Users.txt");

 @Override
 public boolean signIn(Member employee) {
  return false;

 }

 @Override
 public void register() {

 }

 @Override
 public boolean isStored(String info) {
  try (Scanner scan = new Scanner(storage)) {
   while (scan.hasNextLine()) {

   }
  } catch (IOException e) {
   e.printStackTrace();
  }
  return false;
 }

}
