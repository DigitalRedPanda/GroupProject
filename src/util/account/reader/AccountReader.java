package util.account.reader;

import java.io.File;

import util.account.Account;

public class AccountReader<T extends Account> implements IAccountReader<Account> {

 private File storagePath = new File("src\\company\\member\\data\\Users.txt");

 @Override
 public void read(Account account) {
 }

 @Override
 public boolean isStored(Account account) {
  return false;
 }

}
