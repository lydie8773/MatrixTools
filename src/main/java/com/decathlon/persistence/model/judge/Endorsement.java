package com.decathlon.persistence.model.judge;

import com.decathlon.persistence.model.account.User;

import javax.persistence.*;

/**
 * This class is for User who can endorse somebody else's skills.
 * for the value of endorsename:
 * the rule is: 1 (Endorse), 2 (disagree)
 * Created by DengYuanqing on 3/22/2016.
 */
@Entity(name = "endorsement")
public class Endorsement {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long endorseid; //Primary key

    @Column(nullable = false)
    private int endoresename;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    private User user;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    private Score score;

    public static enum COLUMNS{
        ENDORESENAME
    }

    /*
     *Constructor
     */
    public Endorsement() {
    }

    public Endorsement(int endoresename, User user, Score score) {
        this.endoresename = endoresename;
        this.user = user;
        this.score = score;
    }


    //Getter and Setter
    public Long getEndorseid() {
        return endorseid;
    }

    public void setEndorseid(Long endorseid) {
        this.endorseid = endorseid;
    }

    public int getEndoresename() {
        return endoresename;
    }

    public void setEndoresename(int endoresename) {
        this.endoresename = endoresename;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Score getScore() {
        return score;
    }

    public void setScore(Score score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "Endorsement{" +
                "endorseid=" + endorseid +
                ", endoresename=" + endoresename +
                ", user=" + user +
                ", score=" + score +
                '}';
    }
}
