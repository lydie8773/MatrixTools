package com.decathlon.web.model.knowledgetree;

/**
 * Created by DengYuanqing on 3/23/2016.
 */
public class SubdomainUI {
    private Long subdomainid;
    private String subdomainname;

    //Through object subdomain, get domain information
    private Long domainid;
    private String domainname;

    public SubdomainUI() {
    }

    public SubdomainUI(Long subdomainid, String subdomainname, Long domainid, String domainname) {
        this.subdomainid = subdomainid;
        this.subdomainname = subdomainname;
        this.domainid = domainid;
        this.domainname = domainname;
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
        return "SubdomainUI{" +
                "subdomainid=" + subdomainid +
                ", subdomainname='" + subdomainname + '\'' +
                ", domainid=" + domainid +
                ", domainname='" + domainname + '\'' +
                '}';
    }
}
