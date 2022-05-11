package util.account.reader;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Optional;
import java.util.Scanner;

import util.account.Account;

public class AccountReader implements IAccountReader<Account> {

 private File storagePath = new File("src\\company\\member\\data\\Users.txt");

 @Override
 public boolean isStored(Account account) throws FileNotFoundException {
  LinkedList<String> accountInfo = new LinkedList<>();
  try (Scanner scan = new Scanner(storagePath)) {
   while (scan.hasNextLine()) {
    accountInfo = (LinkedList<String>) Arrays.asList(scan.nextLine().split(", "));
    if (account.getUsername().equals(accountInfo.get(0)))
     return true;
    else
     return false;
   }
  }
  return false;

 }

}
