package com.decathlon.persistence.model.knowledgetree;

import javax.persistence.*;
import java.util.Set;

/**
 * javabean for table subdomain
 * Created by DengYuanqing on 3/22/2016.
 */
@Entity(name = "subdomain")

public class Subdomain {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long subdomainid; //primary key in subdomain table
    private String subdomainname; //name value in subdomain table

    //Object domain has the many to one relationship for subdomain.
    //one domain could have many subdomains.
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    private Domain domain;

    // many skills <-> 1 subdomain
    @OneToMany(mappedBy = "subdomain", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Skill> skill;


    //Columns name for class
    public static enum COLUMNS{
        SUBDOMAINNAME
    }

    //Constructor
    public Subdomain() {
    }

    public Subdomain(Long subdomainid) {
        this.subdomainid = subdomainid;
    }

    public Subdomain(String subdomainname, Domain domain, Set<Skill> skill) {
        this.subdomainname = subdomainname;
        this.domain = domain;
        this.skill = skill;
    }

    //Getter and Setter
    public Long getSubdomainid() {
        return subdomainid;
    }

    public void setSubdomainid(Long subdomainid) {
        this.subdomainid = subdomainid;
    }

    public String getSubdomainname() {
        return subdomainname;
    }

    public void setSubdomainname(String subdomainname) {
        this.subdomainname = subdomainname;
    }

    public Domain getDomain() {
        return domain;
    }

    public void setDomain(Domain domain) {
        this.domain = domain;
    }

    public Set<Skill> getSkill() {
        return skill;
    }

    public void setSkill(Set<Skill> skill) {
        this.skill = skill;
    }

    @Override
    public String toString() {
        return "Subdomain{" +
                "subdomainid=" + subdomainid +
                ", subdomainname='" + subdomainname + '\'' +
                ", domain=" + domain +
                ", skill=" + skill +
                '}';
    }
}
