package com.decathlon.common.util.mapper.knowledgetree;

import com.decathlon.persistence.model.knowledgetree.Domain;
import com.decathlon.persistence.model.knowledgetree.Subdomain;
import com.decathlon.web.model.knowledgetree.SubdomainUI;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by DengYuanqin on 3/24/2016.
 */
public class SubdomainMapper {
    public SubdomainUI toUIBean (Subdomain data){
        SubdomainUI ui = new SubdomainUI();
        if(data != null){
            ui.setSubdomainid(data.getSubdomainid());
            ui.setSubdomainname(data.getSubdomainname());

            ui.setDomainid(data.getDomain().getDomainid());
            ui.setDomainname(data.getDomain().getDomainname());
        }
        return ui;
    }

    public List<SubdomainUI> toUIBean (List<Subdomain> data){
        List<SubdomainUI> ui = new ArrayList<SubdomainUI>();
        for (Subdomain s:data){
            ui.add(toUIBean(s));
        }
        return ui;
    }

    public Subdomain toPersistenceBean (SubdomainUI ui){
        Subdomain data = new Subdomain();
        if(ui != null){
            data.setSubdomainid(ui.getSubdomainid());
            data.setSubdomainname(ui.getSubdomainname());

            Domain domain = new Domain();
            domain.setDomainid(ui.getDomainid());
            domain.setDomainname(ui.getDomainname());
            data.setDomain(domain);
        }
        return data;
    }

    public List<Subdomain> toPersistenceBean (List<SubdomainUI> ui){
        List<Subdomain> data = new ArrayList<Subdomain>();
        for (SubdomainUI s:ui){
            data.add(toPersistenceBean(s));
        }
        return data;
    }
}
