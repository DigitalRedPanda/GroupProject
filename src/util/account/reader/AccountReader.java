package util.account.reader;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

public class AccountReader implements IAccountReader {

  private File storagePath = new File("src\\company\\member\\data\\Users.txt");

  @Override
  public boolean isStored(String accountName) throws FileNotFoundException {
    LinkedList<String> accountInfo = new LinkedList<>();
    try (Scanner scan = new Scanner(storagePath)) {
      while (scan.hasNextLine()) {
        accountInfo = (LinkedList<String>) Arrays.asList(scan.nextLine().split(", "));
        if (accountInfo.get(0).equals(accountName))
          return true;
        else
          return false;
      }
    }
    return false;

  }

}
