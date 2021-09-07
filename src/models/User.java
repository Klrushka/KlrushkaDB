package models;

import java.sql.Date;

public class User {
    private int id;
    private String firstname;
    private String secondname;
    private String username;
    private String gender;
    private Date birthday;
    private String mail;
    private  String password;
    private boolean login = false;


    public User(int id, String firstname, String secondname, String username, String gender, Date birthday, String mail, String password) {
        this.id = id;
        this.firstname = firstname;
        this.secondname = secondname;
        this.username = username;
        this.gender = gender;
        this.birthday = birthday;
        this.mail = mail;
        this.password = password;
    }

    @Override
    public String toString() {
        return "#" + id + ": " + firstname + " " + secondname + " (" + username + ") " +
                "Gender: " + gender + " Birthday: " + birthday;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isLogin() {
        return login;
    }

    public void setLogin(boolean login) {
        this.login = login;
    }
}
