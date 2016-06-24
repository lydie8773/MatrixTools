package com.decathlon.common.util.mapper.knowledgetree;

import com.decathlon.persistence.model.knowledgetree.Domain;
import com.decathlon.web.model.knowledgetree.DomainUI;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by DengYuanqin on 3/24/2016.
 */
public class DomainMapper {

    public DomainUI toUIBean(Domain data){
        DomainUI ui = new DomainUI();
        if(data!=null){
            ui.setDomainid(data.getDomainid());
            ui.setDomainname(data.getDomainname());
        }
        return ui;
    }

    public List<DomainUI> toUIBean(List<Domain> data){
        List<DomainUI> ui = new ArrayList<DomainUI>();
        for (Domain d:data){
            ui.add(toUIBean(d));
        }
        return ui;
    }

    public Domain toPersistenceBean(DomainUI ui){
        Domain data = new Domain();
        if(ui!=null){
            data.setDomainid(ui.getDomainid());
            data.setDomainname(ui.getDomainname());
        }
        return data;
    }

    public List<Domain> toPersistenceBean(List<DomainUI> ui){
        List<Domain> data= new ArrayList<Domain>();
        for (DomainUI d:ui){
            data.add(toPersistenceBean(d));
        }
        return data;
    }
}
