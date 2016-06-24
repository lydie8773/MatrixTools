package com.decathlon.persistence.repo.account;

import com.decathlon.persistence.model.account.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

import java.util.List;

/**
 * Created by DengYuanqin on 3/24/2016.
 */
public interface UserRepository extends JpaRepository<User,Integer>, QueryDslPredicateExecutor<User>{
    public User findByUserid(Long userid);
    public User findByUsername(String username);
}
