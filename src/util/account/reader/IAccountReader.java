package util.account.reader;

import java.io.FileNotFoundException;

import util.account.Account;

public interface IAccountReader {
 // these methods are abstract methods that will be implemented inside
 // AccountReader

 boolean isStored(String account) throws FileNotFoundException;

}
