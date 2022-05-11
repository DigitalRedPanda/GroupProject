package util.account.writer;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

import util.account.Account;
import util.account.reader.AccountReader;
import util.account.reader.IAccountReader;

public class AccountWriter implements IAccountWriter<Account> {
 private File dataSource = new File("src\\company\\member\\data\\Users.txt");
 private IAccountReader<Account> accountReader = new AccountReader();

 @Override
 public void write(Account accountName) {
  try (var writer = new PrintWriter(dataSource)) {
   if (accountReader.isStored(accountName))
    return;
   else
    writer.write("%s, %s, %s".formatted(accountName.getUsername(), accountName.getEmail(), accountName.getPassword()));

  } catch (FileNotFoundException e) {
   e.printStackTrace();
  }
 }

 /*
  * try (var writer = new PrintWriter(dataSource)) {
  * writer.write("%s, %s, %s".formatted(accountName.getUsername(),
  * accountName.getEmail(), accountName.getPassword()));
  * } catch (FileNotFoundException e) {
  * e.printStackTrace();
  * }
  * 
  * }
  */

}
