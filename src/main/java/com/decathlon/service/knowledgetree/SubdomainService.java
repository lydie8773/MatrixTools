package com.decathlon.service.knowledgetree;

import com.decathlon.common.util.mapper.knowledgetree.SubdomainMapper;
import com.decathlon.persistence.model.knowledgetree.Domain;
import com.decathlon.persistence.model.knowledgetree.Subdomain;
import com.decathlon.persistence.repo.knowledgetree.DomainRepository;
import com.decathlon.persistence.repo.knowledgetree.SubdomainRepository;
import com.decathlon.web.model.knowledgetree.SubdomainUI;
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
public class SubdomainService {

    @Autowired
    private SubdomainRepository subdomainRepository;
    @Autowired
    private DomainRepository domainRepository;

    @PersistenceContext
    private EntityManager entityManager;

    private SubdomainMapper subdomainMapper = new SubdomainMapper();

    private Logger logger = Logger.getLogger(SubdomainService.class);

    //Add new subdomain
    @Transactional
    public SubdomainUI create(SubdomainUI uiBean){
        Subdomain newSubdomain = new Subdomain();

        if(uiBean.getDomainname() == null){
            newSubdomain.setDomain(null);
        }else {
            Domain domain = domainRepository.findByDomainid(uiBean.getDomainid());
            newSubdomain.setDomain(domain);
        }

        newSubdomain.setSubdomainname(uiBean.getSubdomainname());

        Subdomain saved = subdomainRepository.save(newSubdomain);
        logger.debug("Created subdomain : "+saved);

        return subdomainMapper.toUIBean(saved);
    }

    //update the name for this subdomain
    public SubdomainUI update(SubdomainUI uiBean){
        Subdomain existing = subdomainRepository.findBySubdomainid(uiBean.getSubdomainid());
        Subdomain saved = subdomainRepository.save(existing);
        return subdomainMapper.toUIBean(saved);
    }

    public Boolean delete(SubdomainUI uiBean){
        Subdomain existing = subdomainRepository.findBySubdomainname(uiBean.getSubdomainname());
        if(existing == null){
            return false;
        }
        subdomainRepository.delete(existing);
        return true;
    }

    //Get one subdomain by id
    public SubdomainUI findBySubdomainid(Long subdomainid){
        return subdomainMapper.toUIBean(subdomainRepository.findBySubdomainid(subdomainid));
    }

    //Retrieve list of subdomains
    public List<SubdomainUI> findAll(){
        return subdomainMapper.toUIBean(subdomainRepository.findAll());
    }

    //Retrieve all subdomains with filter
    public List<SubdomainUI> findAllBySearch(String search){
        String hql = "select s.subdomainid,s.subdomainname from subdomain s";
        String newHql;
        if (search!=null){
            newHql = hql+" where s.subdomainname like '%"+search+"%'"
                    +" order by s.subdomainname";
        }else {
            newHql = hql+ " order by s.subdomainname";
        }

        Query query = entityManager.createQuery(newHql);
        List<Object> objectList = query.getResultList();

        List<SubdomainUI> subdomains = new ArrayList<SubdomainUI>();
        SubdomainUI subdomain;
        Iterator<Object> itr = objectList.iterator();

        while (itr.hasNext()){
            Object[] obj = (Object[]) itr.next();
            subdomain = new SubdomainUI();

            subdomain = subdomainMapper.toUIBean(subdomainRepository.findBySubdomainid(new Long(String.valueOf(obj[0])).longValue()));
            subdomains.add(subdomain);
        }

        return  subdomains;
    }
}























