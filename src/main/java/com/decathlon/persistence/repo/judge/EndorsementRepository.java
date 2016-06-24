package com.decathlon.persistence.repo.judge;

import com.decathlon.persistence.model.account.User;
import com.decathlon.persistence.model.judge.Endorsement;
import com.decathlon.persistence.model.judge.Score;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

import java.util.List;

/**
 * Created by DengYuanqin on 3/24/2016.
 */
public interface EndorsementRepository extends JpaRepository<Endorsement, Long>,QueryDslPredicateExecutor<Endorsement>{
    public Endorsement findByEndorseid(Long endorseid);
    public Endorsement findByEndorsename(String endorsename);

    public List<Endorsement> findByUser(User user);
    public Page<Endorsement> findByUser(Pageable pageable, User user);

    public List<Endorsement> findByScore(Score score);
    public Page<Endorsement> findByScore(Pageable pageable, Score score);
}
