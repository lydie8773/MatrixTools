package com.decathlon.persistence.repo.knowledgetree;

import com.decathlon.persistence.model.knowledgetree.Domain;
import com.decathlon.persistence.model.knowledgetree.Subdomain;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

import java.util.List;

/**
 * Created by DengYuanqin on 3/24/2016.
 */
public interface SubdomainRepository extends JpaRepository<Subdomain,Long>,QueryDslPredicateExecutor<Subdomain>{
    public Subdomain findBySubdomainid(Long subdomainid);
    public Subdomain findBySubdomainname(String subdomainname);

    public List<Subdomain> findByDomain(Domain domain);
    public Page<Subdomain> findByDomain(Pageable pageable, Domain domain);
}
