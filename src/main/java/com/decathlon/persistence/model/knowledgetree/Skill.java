package com.decathlon.persistence.model.knowledgetree;

import com.decathlon.persistence.model.judge.Score;

import javax.persistence.*;
import java.util.Set;

/**
 * Every subdomain has own skills, this skill would be defined more detail by every responsible of domain
 * Created by DengYuanqing on 3/22/2016.
 */
@Entity(name = "skill")
public class Skill {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) //primary key could generate automatically
    private Long skillid; //Primary key
    @Column(nullable = false)
    private String skillname; //Skill name

    /*
     * 1 subdomain <-> many skills
     */
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    private Subdomain subdomain;

    /*
     *many scores <-> 1 skill
     */
    @OneToMany(mappedBy = "skill", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Score> score;

    /*
     *Constructor
     */
    public Skill() {
    }

    public Skill(String skillname, Subdomain subdomain, Set<Score> score) {
        this.skillname = skillname;
        this.subdomain = subdomain;
        this.score = score;
    }

    /*
     *Getter and setter
     * @return
     */
    public Long getSkillid() {
        return skillid;
    }

    public void setSkillid(Long skillid) {
        this.skillid = skillid;
    }

    public String getSkillname() {
        return skillname;
    }

    public void setSkillname(String skillname) {
        this.skillname = skillname;
    }

    public Subdomain getSubdomain() {
        return subdomain;
    }

    public void setSubdomain(Subdomain subdomain) {
        this.subdomain = subdomain;
    }

    public Set<Score> getScore() {
        return score;
    }

    public void setScore(Set<Score> score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "Skill{" +
                "skillid=" + skillid +
                ", skillname='" + skillname + '\'' +
                ", subdomain=" + subdomain +
                ", score=" + score +
                '}';
    }
}
