package com.decathlon.persistence.repo.knowledgetree;

import com.decathlon.persistence.model.knowledgetree.Skill;
import com.decathlon.persistence.model.knowledgetree.Subdomain;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

import java.util.List;

/**
 * Created by DengYuanqin on 3/24/2016.
 */
public interface SkillRepository extends JpaRepository<Skill,Long>, QueryDslPredicateExecutor<Skill>{
    public Skill findBySkillid(Long skillid);
    public Skill findBySkillname(String skillname);

    public List<Skill> findBySubdomain(Subdomain subdomain);
    public Page<Skill> findBySubdomain(Pageable pageable, Subdomain subdomain);

}
