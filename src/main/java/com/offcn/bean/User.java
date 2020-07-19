package com.offcn.bean;

import java.util.Date;

public class User {

    private int id;
    private String userName;
    private String password;
    private String email;
    private String name;
    private String sex;
    private Date birthday;


    public User(String userName, String password, String email, String name, String sex, Date birthday) {
        this.userName = userName;
        this.password = password;
        this.email = email;
        this.name = name;
        this.sex = sex;
        this.birthday = birthday;
    }

    public User(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
}
