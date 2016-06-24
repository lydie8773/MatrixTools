package com.decathlon.persistence.model.knowledgetree;

import javax.persistence.*;
import java.util.Set;

/**
 * This class is to record our work domains
 * Created by dengyuanqin on 16/3/21.
 */

@Entity(name = "domain")
public class Domain {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long domainid; //Primary key

    @Column(unique = true)
    private String domainname; //Domain name

    //many subdomain <-> 1 domain
    @OneToMany(mappedBy = "domain", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Subdomain> subdomain;

    //enum COLUMNS is for the filter
    public static enum COLUMNS{
        DOMAINNAME
    }

    /*
     *Constructor
     */
    public Domain(){

    }
    public Domain(String domainname, Set<Subdomain> subdomain) {
        this.domainname = domainname;
        this.subdomain = subdomain;
    }

    //Getter and Setter
    public Long getDomainid() {
        return domainid;
    }

    public void setDomainid(Long domainid) {
        this.domainid = domainid;
    }

    public String getDomainname() {
        return domainname;
    }

    public void setDomainname(String domainname) {
        this.domainname = domainname;
    }

    public Set<Subdomain> getSubdomain() {
        return subdomain;
    }

    public void setSubdomain(Set<Subdomain> subdomain) {
        this.subdomain = subdomain;
    }

    @Override
    public String toString() {
        return "Domain{" +
                "domainid=" + domainid +
                ", domainname='" + domainname + '\'' +
                ", subdomain=" + subdomain +
                '}';
    }
}
