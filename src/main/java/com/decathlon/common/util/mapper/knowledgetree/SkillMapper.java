package com.decathlon.common.util.mapper.knowledgetree;

import com.decathlon.persistence.model.knowledgetree.Domain;
import com.decathlon.persistence.model.knowledgetree.Skill;
import com.decathlon.persistence.model.knowledgetree.Subdomain;
import com.decathlon.web.model.knowledgetree.SkillUI;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by DengYuanqin on 3/24/2016.
 */
public class SkillMapper {

    public SkillUI toUIBean(Skill data){
        SkillUI ui = new SkillUI();
        if(data != null){
            ui.setSkillid(data.getSkillid());
            ui.setSkillname(data.getSkillname());

            ui.setSubdomainid(data.getSubdomain().getSubdomainid());
            ui.setSubdomainname(data.getSubdomain().getSubdomainname());

            ui.setDomainid(data.getSubdomain().getDomain().getDomainid());
            ui.setDomainname(data.getSubdomain().getDomain().getDomainname());
        }
        return ui;
    }

    public List<SkillUI> toUIBean(List<Skill> data){
        List<SkillUI> ui = new ArrayList<SkillUI>();
        for (Skill s:data){
            ui.add(toUIBean(s));
        }
        return ui;
    }

    public Skill toPersistenceBean(SkillUI ui){
        Skill data = new Skill();
        if(ui!=null){
            data.setSkillid(ui.getSkillid());
            data.setSkillname(ui.getSkillname());

            Domain domain = new Domain();
            domain.setDomainid(ui.getDomainid());
            domain.setDomainname(ui.getDomainname());

            Subdomain subdomain = new Subdomain();
            subdomain.setSubdomainid(ui.getSubdomainid());
            subdomain.setSubdomainname(ui.getSubdomainname());
            subdomain.setDomain(domain);
            data.setSubdomain(subdomain);
        }
        return data;
    }

    public List<Skill> toPersistenceBean(List<SkillUI> ui){
        List<Skill> data = new ArrayList<Skill>();
        for (SkillUI s:ui){
            data.add(toPersistenceBean(s));
        }
        return data;
    }
}
