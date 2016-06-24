package com.decathlon.web.model.knowledgetree;

/**
 * Created by DengYuanqin on 3/23/2016.
 */
public class DomainUI {
    private Long domainid;
    private String domainname;

    public DomainUI() {
    }

    public DomainUI(Long domainid, String domainname) {
        this.domainid = domainid;
        this.domainname = domainname;
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
        return "DomainUI{" +
                "domainid=" + domainid +
                ", domainname='" + domainname + '\'' +
                '}';
    }
}
