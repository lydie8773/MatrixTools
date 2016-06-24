package com.decathlon.persistence.repo.judge;

import com.decathlon.persistence.model.account.User;
import com.decathlon.persistence.model.judge.Score;
import com.decathlon.persistence.model.knowledgetree.Skill;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

import java.util.List;

/**
 * Created by DengYuanqin on 3/24/2016.
 */
public interface ScoreRepository extends JpaRepository<Score, Long>, QueryDslPredicateExecutor<Score>{
    public Score findByScoreid(Long scoreid);
    public Score findByScorename(String scorename);

    public List<Score> findByUser(User user);
    public Page<Score> findByUser(Pageable pageable, User user);

    public List<Score> findBySkill(Skill skill);
    public Page<Score> findBySkill(Pageable pageable, Skill skill);
}
