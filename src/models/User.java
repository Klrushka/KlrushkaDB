package models;

import userhistory.History;

import java.sql.Date;

public class User {
    private int id;
    private String firstname;
    private String secondname;
    private String username;
    private String gender;
    private Date birthday;
    private String mail;
    private String password;
    private boolean isHaveHistory = false;
    private History history;
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


    public boolean isLogin() {
        return login;
    }

    public void setLogin(boolean login) {
        this.login = login;
    }

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public boolean isHaveHistory() {
        return isHaveHistory;
    }

    public void setHaveHistory(boolean haveHistory) {
        isHaveHistory = haveHistory;
    }

    public void setHistory(History history) {
        this.history = history;
    }

    public History getHistory() {
        return history;
    }
}
