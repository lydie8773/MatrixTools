package com.decathlon.persistence.repo.knowledgetree;

import com.decathlon.persistence.model.knowledgetree.Domain;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

import java.util.List;

/**
 * Created by DengYuanqin on 3/24/2016.
 */
public interface DomainRepository extends JpaRepository<Domain,Long>,QueryDslPredicateExecutor<Domain>{
    public Domain findByDomainid(Long domainid);
    public Domain findByDomainname(String domainname);
}
