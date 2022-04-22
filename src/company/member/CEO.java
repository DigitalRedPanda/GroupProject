package company.member;

import util.Account;

public class CEO extends Member implements Account {

 public CEO() {

  super();

 }

 @Override
 public boolean isStored() {
  return false;
 }

 @Override
 public void signIn() {
 }

 @Override
 public void register() {
 }

}
