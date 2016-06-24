package com.decathlon.service.knowledgetree;

import com.decathlon.common.util.mapper.knowledgetree.SkillMapper;
import com.decathlon.persistence.model.knowledgetree.Skill;
import com.decathlon.persistence.model.knowledgetree.Subdomain;
import com.decathlon.persistence.repo.knowledgetree.DomainRepository;
import com.decathlon.persistence.repo.knowledgetree.SkillRepository;
import com.decathlon.persistence.repo.knowledgetree.SubdomainRepository;
import com.decathlon.web.model.knowledgetree.SkillUI;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by dengyuanqin on 16/3/28.
 */
@Service
public class SkillService {

    @Autowired
    private SkillRepository skillRepository;
    @Autowired
    private SubdomainRepository subdomainRepository;
    @Autowired
    private DomainRepository domainRepository;

    @PersistenceContext
    private EntityManager entityManager;

    private SkillMapper skillMapper = new SkillMapper();

    private Logger logger = Logger.getLogger(SkillService.class);

    //add new skill
    @Transactional
    public SkillUI create(SkillUI uiBean){
        Skill newSkill = new Skill();
        newSkill.setSkillname(uiBean.getSkillname());
        Skill saved = skillRepository.save(newSkill);
        logger.debug("Created skill : "+saved);
        return skillMapper.toUIBean(saved);
    }

    //get one skill by its id
    public SkillUI findBySkillid(SkillUI uiBean){
        return skillMapper.toUIBean(skillRepository.findBySkillid(uiBean.getSkillid()));
    }

    //Retrieve all skills with filter
    public List<SkillUI> findAllByFilter(String search){
        String hql = "select s.skillid, s.skillname from skill s";
        String newHql;
        if(search != null){
            newHql = hql + " where s.skillname like '%"+search+"%'"
                        +" order by s.skillname";
        }else {
            newHql = hql+" order by s.skillname;";
        }

        Query query = entityManager.createQuery(newHql);
        List<Object> objectList = query.getResultList();

        List<SkillUI> skills = new ArrayList<SkillUI>();
        SkillUI skill;
        Iterator<Object> itr = objectList.iterator();

        while (itr.hasNext()){
            Object[] obj = (Object[]) itr.next();
            skill = new SkillUI();

            skill = skillMapper.toUIBean(skillRepository.findBySkillid(new Long(String.valueOf(obj[0])).longValue()));
            skills.add(skill);
        }

        return skills;
    }

    //get list of subdomains by domain
    public List<SkillUI> findAllByDomain(String domainid){
        return skillMapper.toUIBean(skillRepository.findBySubdomain(new Subdomain(new Long(domainid).longValue())));
    }

    //update the name of skill
    public SkillUI update (SkillUI uiBean) {
        Skill existing = skillRepository.findBySkillid(uiBean.getSkillid());
        existing.setSkillname(uiBean.getSkillname());
        Skill saved = skillRepository.save(existing);
        logger.debug("update skill : "+saved);
        return  skillMapper.toUIBean(saved);
    }

    //delete one skill
    public Boolean delete(SkillUI uiBean){
        Skill existing = skillRepository.findBySkillname(uiBean.getSkillname());
        if(existing == null){
            return false;
        }
        skillRepository.delete(existing);
        return true;
    }
}




















