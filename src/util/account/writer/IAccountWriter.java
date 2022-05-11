package util.account.writer;

import util.account.Account;

public interface IAccountWriter<T extends Account> {

 void write(T accountName);

}
