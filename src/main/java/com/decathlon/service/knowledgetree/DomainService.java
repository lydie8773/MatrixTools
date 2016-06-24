package com.decathlon.service.knowledgetree;

import com.decathlon.common.util.mapper.knowledgetree.DomainMapper;
import com.decathlon.persistence.model.knowledgetree.Domain;
import com.decathlon.persistence.repo.knowledgetree.DomainRepository;
import com.decathlon.web.model.knowledgetree.DomainUI;
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
public class DomainService {

    @Autowired
    private DomainRepository domainRepository;

    @PersistenceContext//Expresses a dependency on a container-managed {@link EntityManager} and its associated persistence context.
    private EntityManager entityManager;

    //object mapper is for the exchange between Web ui and database
    private DomainMapper domainMapper = new DomainMapper();

    private Logger logger = Logger.getLogger(DomainService.class);

    //get one domain by domainname
    public DomainUI findByDomainname(DomainUI uiBean){
        return domainMapper.toUIBean(domainRepository.findByDomainname(uiBean.getDomainname()));
    }

    //get one domain by domainid
    public DomainUI findByDomainid(Long domainid){
        Domain domain = domainRepository.findByDomainid(domainid);
        return domainMapper.toUIBean(domain);
    }

    //get all domains by filter
    public List<DomainUI> findAllSearchByPage(String search){
        String hql = "select d.domainid, d.domainname from domain d";
        String newHql;
        if (search != null){
            newHql = hql+" where d.domainname like '%"+search+"%'"
                    +" order by d.domainname";
        }else {
            newHql = hql + " order by d.domainname";
        }

        Query query = entityManager.createQuery(newHql);
        List<Object> objectList = query.getResultList();

        List<DomainUI> domains = new ArrayList<DomainUI>();
        DomainUI domain;
        Iterator<Object> itr = objectList.iterator();

        while (itr.hasNext()){
            Object[] obj = (Object[]) itr.next();
            domain = new DomainUI();

            domain = domainMapper.toUIBean(domainRepository.findByDomainid(new Long(String.valueOf(obj[0])).longValue()));
            domains.add(domain);
        }
        return domains;
    }


    //create one new domain
    @Transactional
    public DomainUI create(DomainUI uiBean){
        Domain newDomain = new Domain();
        newDomain.setDomainname(uiBean.getDomainname());
        Domain saved = domainRepository.save(newDomain);
        logger.debug("Created domain : "+saved);
        return domainMapper.toUIBean(saved);
    }



    //Just update the name for this domain
    public DomainUI update(DomainUI uiBean){
        Domain existing = domainRepository.findByDomainid(uiBean.getDomainid());

        existing.setDomainname(uiBean.getDomainname());

        Domain saved = domainRepository.save(existing);
        logger.debug("update domain : "+saved);

        return domainMapper.toUIBean(saved);
    }

    //delete domain
    public Boolean delete (DomainUI uiBean){
        Domain existing = domainRepository.findByDomainname(uiBean.getDomainname());
        if (existing == null){
            return false;
        }
        domainRepository.delete(existing);
        return true;
    }
}














