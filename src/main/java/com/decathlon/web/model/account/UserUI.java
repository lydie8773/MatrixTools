package com.decathlon.web.model.account;

/**
 * This class is for the objects on Web page
 * Created by DengYuanqin on 3/23/2016.
 */
public class UserUI {

    private Long userid;
    private String loginname;
    private String username;
    private String password;
    private String email;
    private int role;

    private String createdDate;
    private String modifiedDate;

    //constructor
    public UserUI() {
    }

    public UserUI(Long userid, String loginname, String username, String password, String email, int role, String createdDate, String modifiedDate) {
        this.userid = userid;
        this.loginname = loginname;
        this.username = username;
        this.password = password;
        this.email = email;
        this.role = role;
        this.createdDate = createdDate;
        this.modifiedDate = modifiedDate;
    }

    //Getter and Setter
    public Long getUserid() {
        return userid;
    }

    public void setUserid(Long userid) {
        this.userid = userid;
    }

    public String getLoginname() {
        return loginname;
    }

    public void setLoginname(String loginname) {
        this.loginname = loginname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    public String getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(String modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    @Override
    public String toString() {
        return "UserUI{" +
                "userid=" + userid +
                ", loginname='" + loginname + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", role=" + role +
                ", createdDate='" + createdDate + '\'' +
                ", modifiedDate='" + modifiedDate + '\'' +
                '}';
    }
}
