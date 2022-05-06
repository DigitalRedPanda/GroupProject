package util.account.writer;

import java.io.File;

import company.member.Member;
import util.account.Account;

public class AccountWriter implements IAcountWriter {
 private File dataSource = new File("src\\company\\member\\data\\Users.txt");

 @Override
 public void write(Member accountName) {

 }

}
