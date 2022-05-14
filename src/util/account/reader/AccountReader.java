package util.account.reader;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class AccountReader implements IAccountReader {

  private File storagePath = new File("src\\company\\member\\data\\Users.txt");

  @Override
  public boolean isStored(String accountName) throws FileNotFoundException {
    List<String> accountInfo = List.of();
    try (Scanner scan = new Scanner(storagePath)) {
      while (scan.hasNextLine()) {
        accountInfo = Arrays.asList(scan.nextLine().split(", "));
        if (accountInfo.get(0).equals(accountName)) {
          System.out.println(accountInfo.get(0) + true);
          return true;
        } else {
          System.out.println(accountInfo.get(0) + false);
          return false;
        }
      }
    }
    return false;

  }

}
