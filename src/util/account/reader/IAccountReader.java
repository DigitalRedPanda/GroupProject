package util.account.reader;

import util.account.Account;

public interface IAccountReader<T extends Account> {

 void read(Account account);

 boolean isStored(Account account);

}
