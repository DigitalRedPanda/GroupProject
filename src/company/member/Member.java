package company.member;

import java.util.Date;

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

}
