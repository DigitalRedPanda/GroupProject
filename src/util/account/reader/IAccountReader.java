package util.account.reader;

import util.account.Account;

public interface IAccountReader<T extends Account> {
 // these methods are abstract methods that will be implemented inside
 // AccountReader
 void read(Account account);

 boolean isStored(Account account);

}
