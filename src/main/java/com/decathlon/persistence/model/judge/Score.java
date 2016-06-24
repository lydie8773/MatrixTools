package com.decathlon.persistence.model.judge;

import com.decathlon.persistence.model.account.User;
import com.decathlon.persistence.model.knowledgetree.Skill;

import javax.persistence.*;
import java.util.Set;

/**
 * This class is to record the score of every user who has skill on it
 * Created by DengYuanqin on 3/22/2016.
 */
@Entity(name = "score")
public class Score {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long scoreid; //Primary key

    @Column(nullable = false)
    private String scorename; //score number

    //Many scores <-> 1 skill
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    private Skill skill;
    //Many scores <-> 1 user
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    private User user;
    //1 score <-> many endorsements
    @OneToMany(mappedBy = "endorsement", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Endorsement> endorsement;

    public static enum COLUMNS{
        SCORENAME
    }

    /*
     *Constructor
     */
    public Score() {
    }
    public Score(String scorename, Skill skill, User user, Set<Endorsement> endorsement) {
        this.scorename = scorename;
        this.skill = skill;
        this.user = user;
        this.endorsement = endorsement;
    }

    //Getter and Setter
    public Long getScoreid() {
        return scoreid;
    }

    public void setScoreid(Long scoreid) {
        this.scoreid = scoreid;
    }

    public String getScorename() {
        return scorename;
    }

    public void setScorename(String scorename) {
        this.scorename = scorename;
    }

    public Skill getSkill() {
        return skill;
    }

    public void setSkill(Skill skill) {
        this.skill = skill;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Set<Endorsement> getEndorsement() {
        return endorsement;
    }

    public void setEndorsement(Set<Endorsement> endorsement) {
        this.endorsement = endorsement;
    }

    @Override
    public String toString() {
        return "Score{" +
                "scoreid=" + scoreid +
                ", scorename='" + scorename + '\'' +
                ", skill=" + skill +
                ", user=" + user +
                ", endorsement=" + endorsement +
                '}';
    }
}
