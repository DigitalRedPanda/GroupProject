package util.account;

import java.util.Date;

public abstract class Account {

    private String username;

    private String email;

    private String password;

    private Date date;

    public Account() {

        date = new Date();

    }

    public Account(String email, String password) {
        this();

        this.email = email;

        this.password = password;

    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public Date getDate() {
        return date;
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

    public abstract void signIn();

    public abstract void register();

}
