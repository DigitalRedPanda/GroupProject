package company.member;

import java.util.Date;

import java.util.function.Predicate;

import java.util.regex.Pattern;

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

    public abstract boolean isStored(String stored);

    // Don't modify this
    public static Predicate<String> validateEmail = email -> {
        return email.matches("^[^@][\\w[^@]]+(@[a-z]+\\.)(com|net|(edu|co)\\.[a-z]{2})(\\s)*$");
    };

}
