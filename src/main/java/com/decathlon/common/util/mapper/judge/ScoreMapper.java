package com.decathlon.common.util.mapper.judge;

import com.decathlon.persistence.model.account.User;
import com.decathlon.persistence.model.judge.Score;
import com.decathlon.persistence.model.knowledgetree.Domain;
import com.decathlon.persistence.model.knowledgetree.Skill;
import com.decathlon.persistence.model.knowledgetree.Subdomain;
import com.decathlon.web.model.judge.ScoreUI;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by DengYuanqin on 3/24/2016.
 */
public class ScoreMapper {

    public ScoreUI toUIBean(Score data){
        ScoreUI ui = new ScoreUI();
        if(data!=null){
            ui.setScoreid(data.getScoreid());
            ui.setScorename(data.getScorename());

            ui.setUserid(data.getUser().getUserid());
            ui.setLoginname(data.getUser().getLoginname());
            ui.setUsername(data.getUser().getUsername());
            ui.setPassword(data.getUser().getPassword());
            ui.setEmail(data.getUser().getEmail());
            ui.setRole(data.getUser().getRole());

            ui.setSkillid(data.getSkill().getSkillid());
            ui.setSkillname(data.getSkill().getSkillname());

            ui.setSubdomainid(data.getSkill().getSubdomain().getSubdomainid());
            ui.getSubdomainname(data.getSkill().getSubdomain().getSubdomainname());

            ui.getDomainid(data.getSkill().getSubdomain().getDomain().getDomainid());
            ui.getDomainname(data.getSkill().getSubdomain().getDomain().getDomainname());
        }
        return ui;
    }

    public List<ScoreUI> toUIBean(List<Score> data){
        List<ScoreUI> ui = new ArrayList<ScoreUI>();
        for (Score s:data){
            ui.add(toUIBean(s));
        }
        return ui;
    }

    //Retrieve data by page
    public Page<ScoreUI> toUIBean(Page<Score> data, Pageable pageable) {
        return new PageImpl<ScoreUI>(toUIBean(data.getContent()));
    }

    public Score toPersistenceBean(ScoreUI ui){
        Score data = new Score();
        if(ui!=null){
            data.setScoreid(ui.getScoreid());
            data.setScorename(ui.getScorename());

            User user = new User();
            user.setUserid(ui.getUserid());
            user.setLoginname(ui.getLoginname());
            user.setUsername(ui.getUsername());
            user.setPassword(ui.getPassword());
            user.setEmail(ui.getEmail());
            user.setRole(ui.getRole());
            data.setUser(user);

            Domain domain = new Domain();
            domain.setDomainid(ui.getDomainid(data.getSkill().getSubdomain().getDomain().getDomainid()));
            domain.setDomainname(ui.getDomainname(data.getSkill().getSubdomain().getDomain().getDomainname()));

            Subdomain subdomain = new Subdomain();
            subdomain.setSubdomainid(ui.getSubdomainid());
            subdomain.setSubdomainname(ui.getSubdomainname(data.getSkill().getSubdomain().getSubdomainname()));
            subdomain.setDomain(domain);

            Skill skill = new Skill();
            skill.setSkillid(ui.getSkillid());
            skill.setSkillname(ui.getSkillname());
            skill.setSubdomain(subdomain);
            data.setSkill(skill);
        }
        return data;
    }

    List<Score> toPersistenceBean(List<ScoreUI> ui){
        List<Score> data = new ArrayList<Score>();
        for (ScoreUI s:ui){
            data.add(toPersistenceBean(s));
        }
        return data;
    }

}
