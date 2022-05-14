package util.account.writer;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

import util.account.Account;
import util.account.reader.AccountReader;
import util.account.reader.IAccountReader;

public class AccountWriter implements IAccountWriter<Account> {
  private File dataSource = new File("src\\company\\member\\data\\Users.txt");
  private IAccountReader accountReader = new AccountReader();

  @Override
  public void write(Account account) throws FileNotFoundException {
    try (var writer = new PrintWriter(dataSource)) {
      if (accountReader.isStored(account.getUsername()))
        return;
      else
        writer.write(
            "%s, %s, %s".formatted(account.getUsername(), account.getEmail(), account.getPassword()));
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
