package util.account.reader;

import java.io.FileNotFoundException;

import util.account.Account;

public interface IAccountReader<T extends Account> {
 // these methods are abstract methods that will be implemented inside
 // AccountReader

 boolean isStored(Account account) throws FileNotFoundException;

}
