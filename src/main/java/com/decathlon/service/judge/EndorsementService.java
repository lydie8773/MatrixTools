package com.decathlon.service.judge;

import com.decathlon.common.util.extjs.FilterRequest;
import com.decathlon.common.util.mapper.judge.EndorsementMapper;
import com.decathlon.persistence.model.account.User;
import com.decathlon.persistence.model.judge.Endorsement;
import com.decathlon.persistence.model.judge.QEndorsement;
import com.decathlon.persistence.repo.account.UserRepository;
import com.decathlon.persistence.repo.judge.EndorsementRepository;
import com.decathlon.web.model.judge.EndorsementUI;
import com.mysema.query.types.Predicate;
import com.mysema.query.types.expr.BooleanExpression;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by dengyuanqin on 16/3/28.
 */

@Service
public class EndorsementService {
    @Autowired
    private EndorsementRepository endorsementRepository;
    @Autowired
    private UserRepository userRepository;

    //Get log from every action of this service
    private Logger logger = Logger.getLogger(EndorsementService.class);

    @PersistenceContext
    private EntityManager entityManager;

    private EndorsementMapper endorsementMapper = new EndorsementMapper();

    //add endorsement
    @Transactional
    public EndorsementUI create(EndorsementUI uiBean){
        Endorsement newEndorsement = endorsementMapper.toPersistenceBean(uiBean);
        Endorsement saved = endorsementRepository.save(newEndorsement);
        logger.debug("Created endorsement : "+saved);
        return endorsementMapper.toUIBean(saved);
    }

    //According userid, retrive all the endorsement
    public List<EndorsementUI> findAllByUseid(Long userid){
        User user = userRepository.findByUserid(userid);
        return endorsementMapper.toUIBean(endorsementRepository.findByUser(user));
    }

    /*
    Retrieving all the clients from database by page
     */
    public Page<EndorsementUI> findAllPage(Pageable pageable, List<FilterRequest> filters){
        Predicate predicate = toPredicate(filters);
        return endorsementMapper.toUIBean(endorsementRepository.findAll(predicate,pageable),pageable);
    }

    public Predicate toPredicate(final List<FilterRequest> filters){
        logger.info("Entering predicates : "+filters);
        QEndorsement endorsement = QEndorsement.endorsement;
        BooleanExpression result = null;
        try {
            for (FilterRequest filter:filters){
                Endorsement.COLUMNS column = Endorsement.COLUMNS.ENDORESENAME.valueOf(filter.getProperty().toUpperCase());
                BooleanExpression expression = null;
                switch (column){
                    case ENDORESENAME:
                        if(filter.getValue()!=null&&!"".equals(filter.getValue())){
                            expression = endorsement.endorsename.like("%"+filter.getValue()+"%");
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
        logger.info("Result predicate : "+(result!=null?result.toString():""));
        logger.info("Exitng predicates");
        return result;
    }
}
