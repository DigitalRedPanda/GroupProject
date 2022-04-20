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

    // Generated by java auto-completion
    public void setEmail(String email) {
        this.email = email;
    }

    // Generated by java auto-completion
    public void setPassword(String password) {
        this.password = password;
    }

    // Generated by java auto-completion
    public String getPassword() {
        return password;
    }

    // Generated by java auto-completion
    public String getEmail() {
        return email;
    }

    public

    // Don't modify this
    public static Predicate<String> validateEmail = email -> {
        return Pattern.compile("^[^@][\\w[^@]]+(@[a-z]+\\.)(com|net|(edu|co)\\.[a-z]{2})(/s)*$").matcher(email)
                .matches();
    };

}
