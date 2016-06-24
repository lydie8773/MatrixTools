package com.decathlon.web.model.judge;

/**
 * Created by DengYuanqin on 3/23/2016.
 */
public class EndorsementUI {

    private Long endorseid;
    private int endorsename;

    private Long scoreid;
    private String scorename;

    private Long userid;
    private String loginname;
    private String username;
    private String password;
    private String email;
    private int role;
    private String createdDate;
    private String modifiedDate;

    private Long skillid;
    private String skillname;

    private Long subdomainid;
    private String subdomainname;

    private Long domainid;
    private String domainname;

    public EndorsementUI() {
    }

    public EndorsementUI(Long endorseid, int endorsename, Long scoreid, String scorename, Long userid, String loginname, String username, String password, String email, int role, String createdDate, String modifiedDate, Long skillid, String skillname, Long subdomainid, String subdomainname, Long domainid, String domainname) {
        this.endorseid = endorseid;
        this.endorsename = endorsename;
        this.scoreid = scoreid;
        this.scorename = scorename;
        this.userid = userid;
        this.loginname = loginname;
        this.username = username;
        this.password = password;
        this.email = email;
        this.role = role;
        this.createdDate = createdDate;
        this.modifiedDate = modifiedDate;
        this.skillid = skillid;
        this.skillname = skillname;
        this.subdomainid = subdomainid;
        this.subdomainname = subdomainname;
        this.domainid = domainid;
        this.domainname = domainname;
    }

    public Long getEndorseid() {
        return endorseid;
    }

    public void setEndorseid(Long endorseid) {
        this.endorseid = endorseid;
    }

    public int getEndorsename() {
        return endorsename;
    }

    public void setEndorsename(int endorsename) {
        this.endorsename = endorsename;
    }

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

    public String getSubdomainname(String subdomainname) {
        return this.subdomainname;
    }

    public void setSubdomainname(String subdomainname) {
        this.subdomainname = subdomainname;
    }

    public Long getDomainid(Long domainid) {
        return this.domainid;
    }

    public void setDomainid(Long domainid) {
        this.domainid = domainid;
    }

    public String getDomainname(String domainname) {
        return this.domainname;
    }

    public void setDomainname(String domainname) {
        this.domainname = domainname;
    }

    @Override
    public String toString() {
        return "EndorsementUI{" +
                "endorseid=" + endorseid +
                ", endorsename='" + endorsename + '\'' +
                ", scoreid=" + scoreid +
                ", scorename='" + scorename + '\'' +
                ", userid=" + userid +
                ", loginname='" + loginname + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", role=" + role +
                ", createdDate='" + createdDate + '\'' +
                ", modifiedDate='" + modifiedDate + '\'' +
                ", skillid=" + skillid +
                ", skillname='" + skillname + '\'' +
                ", subdomainid=" + subdomainid +
                ", subdomainname='" + subdomainname + '\'' +
                ", domainid=" + domainid +
                ", domainname='" + domainname + '\'' +
                '}';
    }
}
