package company.member;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.Optional;
import java.util.Scanner;
import java.util.function.Predicate;

public abstract class Member {

    private String email;

    private String password;

    private Date date;

    public Member() {

        date = new Date();

    }

    public Member(String email, String password) {

        this();

        this.email = email;

        this.password = password;

    }

    boolean infoExists(String contentToSearch, int position) {

        try (Scanner scan = new Scanner(new File("src/company/member/data/Users.txt"))) {
            while (scan.hasNextLine()) {
                var memberInfo = scan.nextLine().split(", ");
                Optional<String> contentOptional = Optional.of(contentToSearch);
                contentOptional.filter(content -> content.equals(memberInfo[position])).map(name -> {
                    return true;
                });
                contentOptional.filter(content -> !content.equals(memberInfo[position])).map(name -> {
                    return false;
                });
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public abstract boolean usernameExists(String memberName);

    public abstract boolean emailExists(String email);
}
