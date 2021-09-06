package models;

import java.sql.Date;

public class People {
    private int id;
    private String firstname;
    private String secondname;
    private String username;
    private String gender;
    private Date birthday;

    public People(int id, String firstname, String secondname, String username, String gender, Date birthday) {
        this.id = id;
        this.firstname = firstname;
        this.secondname = secondname;
        this.username = username;
        this.gender = gender;
        this.birthday = birthday;
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

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getSecondname() {
        return secondname;
    }

    public void setSecondname(String secondname) {
        this.secondname = secondname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
}
