package com.decathlon.common.util.mapper.judge;

import com.decathlon.persistence.model.account.User;
import com.decathlon.persistence.model.judge.Endorsement;
import com.decathlon.persistence.model.judge.Score;
import com.decathlon.persistence.model.knowledgetree.Domain;
import com.decathlon.persistence.model.knowledgetree.Skill;
import com.decathlon.persistence.model.knowledgetree.Subdomain;
import com.decathlon.web.model.judge.EndorsementUI;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by DengYuanqin on 3/23/2016.
 */
public class EndorsementMapper {
    //Get all the information of endorsement
    public EndorsementUI toUIBean(Endorsement data){
        EndorsementUI ui = new EndorsementUI();
        if(data!=null){
            ui.setEndorseid(data.getEndorseid());
            ui.setEndorsename(data.getEndoresename());

            ui.setScoreid(data.getScore().getScoreid());
            ui.setScorename(data.getScore().getScorename());

            ui.setUserid(data.getUser().getUserid());
            ui.setLoginname(data.getUser().getLoginname());
            ui.setUsername(data.getUser().getUsername());
            ui.setPassword(data.getUser().getPassword());
            ui.setEmail(data.getUser().getEmail());
            ui.setRole(data.getUser().getRole());
            //ui.setCreatedDate(data.getUser().getCreatedDate());
            //ui.setModifiedDate(data.getUser().getModifiedDate());

            ui.setSkillid(data.getScore().getSkill().getSkillid());
            ui.setSkillname(data.getScore().getSkill().getSkillname());

            ui.setSubdomainid(data.getScore().getSkill().getSubdomain().getSubdomainid());
            ui.getSubdomainname(data.getScore().getSkill().getSubdomain().getSubdomainname());

            ui.getDomainid(data.getScore().getSkill().getSubdomain().getDomain().getDomainid());
            ui.getDomainname(data.getScore().getSkill().getSubdomain().getDomain().getDomainname());
        }
        return ui;
    }

    //List to collect the UI web page endorsements
    public List<EndorsementUI> toUIBean(List<Endorsement> data){
        List<EndorsementUI> ui = new ArrayList<EndorsementUI>();
        for (Endorsement e:data){
            ui.add(toUIBean(e));
        }
        return ui;
    }

    //Page to collect the UI web page endorsements
    public Page<EndorsementUI> toUIBean(Page<Endorsement> data, Pageable pageable) {
        return new PageImpl<EndorsementUI>(toUIBean(data.getContent()));
    }

    //Receive the endorsement from web page,
    public Endorsement toPersistenceBean(EndorsementUI ui){
        Endorsement data = new Endorsement();
        if(ui!=null){
            data.setEndorseid(ui.getEndorseid());

            User user = new User();
            user.setUserid(ui.getUserid());
            user.setLoginname(ui.getLoginname());
            user.setUsername(ui.getUsername());
            user.setPassword(ui.getPassword());
            user.setEmail(ui.getEmail());
            user.setRole(ui.getRole());
            data.setUser(user);

            Domain domain = new Domain();
            domain.setDomainid(ui.getDomainid(data.getScore().getSkill().getSubdomain().getDomain().getDomainid()));
            domain.setDomainname(ui.getDomainname(data.getScore().getSkill().getSubdomain().getDomain().getDomainname()));

            Subdomain subdomain = new Subdomain();
            subdomain.setSubdomainid(ui.getSubdomainid());
            subdomain.setSubdomainname(ui.getSubdomainname(data.getScore().getSkill().getSubdomain().getSubdomainname()));
            subdomain.setDomain(domain);

            Skill skill = new Skill();
            skill.setSkillid(ui.getSkillid());
            skill.setSkillname(ui.getSkillname());
            skill.setSubdomain(subdomain);

            Score score = new Score();
            score.setScoreid(ui.getScoreid());
            score.setScorename(ui.getScorename());
            score.setSkill(skill);
            data.setScore(score);
        }
        return data;
    }

    public List<Endorsement> toPersistenceBean(List<EndorsementUI> ui){
        List<Endorsement> data = new ArrayList<Endorsement>();
        for (EndorsementUI e:ui){
            data.add(toPersistenceBean(e));
        }
        return data;
    }


}
