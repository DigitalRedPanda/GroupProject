package company.member;

import util.Account;

public class Employee extends Member implements Account {

 @Override
 public void signIn() {

 }

 @Override
 public void register() {

 }

 @Override
 public boolean isStored() {
  return false;
 }

}
