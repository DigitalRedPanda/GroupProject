package util.account.writer;

import java.io.FileNotFoundException;

import util.account.Account;

public interface IAccountWriter<T extends Account> {

 void write(T accountName) throws FileNotFoundException;

}
