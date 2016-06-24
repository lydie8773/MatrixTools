package com.decathlon.web.model.knowledgetree;

/**
 * Created by DengYuanqing on 3/23/2016.
 */
public class SkillUI {

    private Long skillid;
    private String skillname;

    private Long subdomainid;
    private String subdomainname;

    private Long domainid;
    private String domainname;

    public SkillUI() {
    }

    public SkillUI(Long skillid, String skillname, Long subdomainid, String subdomainname, Long domainid, String domainname) {
        this.skillid = skillid;
        this.skillname = skillname;
        this.subdomainid = subdomainid;
        this.subdomainname = subdomainname;
        this.domainid = domainid;
        this.domainname = domainname;
    }

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

    @Override
    public String toString() {
        return "SkillUI{" +
                "skillid=" + skillid +
                ", skillname='" + skillname + '\'' +
                ", subdomainid=" + subdomainid +
                ", subdomainname='" + subdomainname + '\'' +
                ", domainid=" + domainid +
                ", domainname='" + domainname + '\'' +
                '}';
    }
}
