package com.decathlon.service.account;

import com.decathlon.common.util.extjs.FilterRequest;
import com.decathlon.common.util.mapper.account.UserMapper;
import com.decathlon.persistence.model.account.QUser;
import com.decathlon.persistence.model.account.User;
import com.decathlon.persistence.repo.account.UserRepository;
import com.decathlon.web.model.account.UserUI;
import com.mysema.query.types.Predicate;
import com.mysema.query.types.expr.BooleanExpression;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * Created by DengYuanqin on 3/24/2016.
 */
@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    private Logger logger = Logger.getLogger(UserService.class);

    private UserMapper userMapper = new UserMapper();

    public UserUI create(UserUI uiBean){
        User newUser = userMapper.toPersistenceBean(uiBean);
        User saved = userRepository.save(newUser);
        logger.debug("Created Account : "+saved);
        return userMapper.toUIBean(saved);
    }

    public User find(User user){
        return  user;
    }

    //Retrieve all users from database
    public List<UserUI> findAll(){
        return userMapper.toUIBean(userRepository.findAll());
    }

    public Page<UserUI> findAll(Pageable pageable, List<FilterRequest> filters){
        Predicate predicate = toPredicate(filters);
        return userMapper.toUIBean(userRepository.findAll(predicate,pageable),pageable);
    }

    public UserUI findByUsername(String username){
        return userMapper.toUIBean(userRepository.findByUsername(username));
    }

    public UserUI update(UserUI uiBean){
        User existingUser = userRepository.findByUsername(uiBean.getUsername());
        if (existingUser==null){
            return  null;
        }
        existingUser.setLoginname(uiBean.getLoginname());
        existingUser.setUsername(uiBean.getUsername());
        existingUser.setPassword(uiBean.getPassword());
        existingUser.setEmail(uiBean.getEmail());
        existingUser.setRole(uiBean.getRole());

        User saved = null;

        try {
            saved = userRepository.save(existingUser);
        }catch (Exception e){
            logger.error(e);
        }
        return userMapper.toUIBean(saved);
    }

    public Boolean delete(UserUI user){
        User existingUser = userRepository.findByUsername(user.getUsername());
        if(existingUser == null){
            return false;
        }
        userRepository.delete(existingUser);
        return true;
    }

    private Predicate toPredicate(final List<FilterRequest> filters){
        logger.info("Entering predicates : "+filters);
        QUser user = QUser.user;
        BooleanExpression result = null;
        try {
            for (FilterRequest filter:filters){
                User.COLUMNS column = User.COLUMNS.valueOf(filter.getProperty().toUpperCase());
                BooleanExpression expression = null;

                switch (column){
                    case USERNAME:
                        if(filter.getValue()!=null&&!"".equals(filter.getValue())){
                            expression = user.username.like("%"+filter.getValue()+"&");
                        }
                        break;
                }
                if (expression!=null){
                    if (result!=null){
                        result=result.and(expression);
                    }else {
                        result=expression;
                    }
                }
            }
        }catch (Exception e){
            logger.error(e);
        }
        logger.info("Result Predicate : "+(result!=null?result.toString():""));
        logger.info("Exiting predicates");
        return  result;
    }
}
