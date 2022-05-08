package util.account.writer;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

import company.member.Member;

public class AccountWriter implements IAcountWriter {
 private File dataSource = new File("src\\company\\member\\data\\Users.txt");

 @Override
 public void write(Member accountName) {
  try (var writer = new PrintWriter(dataSource)) {
   writer.write("%s, %s, %s".formatted(accountName.getUsername(), accountName.getEmail(), accountName.getPassword()));
  } catch (FileNotFoundException e) {
   e.printStackTrace();
  }

 }

}
