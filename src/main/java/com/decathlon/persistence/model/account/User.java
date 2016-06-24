package com.decathlon.persistence.model.account;

/**
 * This user could be loaded with login user.
 * if user has admin rights, they can add,update,modify or delete other users.
 * They also can add,update,modify or delete skills, subdomain or domain.
 * They have other rights as normal user
 *
 * if user has normal rights, they can endorse and note the score.
 * Created by dengyuanqin on 16/3/15.
 */

import com.decathlon.persistence.model.judge.Endorsement;
import com.decathlon.persistence.model.judge.Score;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

/**
 * Javabean for account, account for the login
 */

@Entity(name="user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long userid; //Primary key

    @Column(unique = true)
    private String loginname; //record the login name
    private String username; //record the login username
    private String password; //record the login password
    private String email; //record the email

    @Temporal(TemporalType.DATE)
    private Date createdDate; //generate the current create time
    @Temporal(TemporalType.DATE)
    private Date modifiedDate; //generate the current modified time

    @Column
    private int role; //1.admin; 2.normal account
    //1 user could have many score records for himself
    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Score> score;

    //this object records that user could have endorsement for others' secord records
    @OneToMany(mappedBy = "user_endorse", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Endorsement> endorsement;

    /*
    COLUMNS is for the filter champ on the web page
     */
    public static enum COLUMNS{
        USERNAME,EMAIL,LOGINNAME,PASSWORD,CREATEDDATE,MODIFIEDDATE,ROLE
    }

    //Constructor
    public User(){}

    public User(String loginname, String username, String password, String email, Date createdDate, Date modifiedDate, int role, Set<Score> score, Set<Endorsement> endorsement) {
        this.loginname = loginname;
        this.username = username;
        this.password = password;
        this.email = email;
        this.createdDate = createdDate;
        this.modifiedDate = modifiedDate;
        this.role = role;
        this.score = score;
        this.endorsement = endorsement;
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

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public Set<Score> getScore() {
        return score;
    }

    public void setScore(Set<Score> score) {
        this.score = score;
    }

    public Set<Endorsement> getEndorsement() {
        return endorsement;
    }

    public void setEndorsement(Set<Endorsement> endorsement) {
        this.endorsement = endorsement;
    }

    @Override
    public String toString() {
        return "User{" +
                "userid=" + userid +
                ", loginname='" + loginname + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", createdDate=" + createdDate +
                ", modifiedDate=" + modifiedDate +
                ", role=" + role +
                ", score=" + score +
                ", endorsement=" + endorsement +
                '}';
    }
}





















