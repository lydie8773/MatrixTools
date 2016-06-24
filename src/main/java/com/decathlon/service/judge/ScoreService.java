package com.decathlon.service.judge;

import com.decathlon.common.util.extjs.FilterRequest;
import com.decathlon.common.util.mapper.judge.ScoreMapper;
import com.decathlon.persistence.model.judge.QScore;
import com.decathlon.persistence.model.judge.Score;
import com.decathlon.persistence.repo.judge.ScoreRepository;
import com.decathlon.web.model.judge.ScoreUI;
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
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Interface used to interact with the persistence context.
 *
 * <p> An <code>EntityManager</code> instance is associated with
 * a persistence context. A persistence context is a set of entity
 * instances in which for any persistent entity identity there is
 * a unique entity instance. Within the persistence context, the
 * entity instances and their lifecycle are managed.
 * The <code>EntityManager</code> API is used
 * to create and remove persistent entity instances, to find entities
 * by their primary key, and to query over entities.
 *
 * <p> The set of entities that can be managed by a given
 * <code>EntityManager</code> instance is defined by a persistence
 * unit. A persistence unit defines the set of all classes that are
 * related or grouped by the application, and which must be
 * colocated in their mapping to a single database.
 */


/**
 * Why transactional here? The reason is the following. The save(...) method
 * of the repository proxy is a transactional one. As you have a
 * JpaTransactionManager configured the lifecycle of the Hibernate Session
 * is bound to the transaction. This results in the Session (and
 * transaction) being closed when the call returns from save(...) in the
 * testcase. Thus the entity is not attached to the Session anymore which
 * causes the exception I see later on.
 *
 * The Exception I had:
 * org.springframework.dao.InvalidDataAccessApiUsageException: detached
 * entity passed to persist
 */


/**
 * Created by DengYuanqin on 3/24/2016.
 */
@Service
public class ScoreService {
    @Autowired
    private ScoreRepository scoreRepository;

    //Interface used to interact with the persistence context.
    @PersistenceContext
    private EntityManager entityManager;
    private ScoreMapper scoreMapper = new ScoreMapper();
    private Logger logger = Logger.getLogger(ScoreService.class);


    @Transactional
    public ScoreUI create(ScoreUI uiBean){
        Score newScore = scoreMapper.toPersistenceBean(uiBean);
        Score saved = scoreRepository.save(newScore);
        logger.debug("Created scores : "+saved);
        return scoreMapper.toUIBean(saved);
    }

    public Page<ScoreUI> findAllPage(Pageable pageable, List<FilterRequest> filters){
        Predicate predicate = toPredicate(filters);
        return scoreMapper.toUIBean(scoreRepository.findAll(predicate,pageable),pageable);
    }

    public ScoreUI find(ScoreUI uiBean){
        return scoreMapper.toUIBean(scoreRepository.findByScorename(uiBean.getScorename()));
    }

    /*
    Retrieve all scores from database by page.
     */
    /*public List<ScoreUI> findAllScoreByPage(int start, int limit, String search){
        String hql = "select s.scoreid, s.scorename from score s";
        String newHql;
        if(search!=null){
            newHql=hql+" where s.scorename like '%"+search+"%'";
        }else {
            newHql = hql;
        }

        Query query = entityManager.createQuery(newHql);
        query.setFirstResult(start);
        query.setMaxResults(limit);
        List<Object> objectList=query.getResultList();

        List<ScoreUI> scores = new ArrayList<ScoreUI>();
        ScoreUI score;
        Iterator<Object> itr = objectList.iterator();

        while(itr.hasNext()){
            Object[] obj=(Object[])itr.next();
            score = new ScoreUI();

            score = scoreMapper.toUIBean(scoreRepository.findByScoreid(new Long(String.valueOf(obj[0])).longValue()));
            scores.add(score);
        }
        return scores;
    }*/

    /*
    Retrieve a score according its id
     */
    public ScoreUI findByScorename(String scorename){
        return scoreMapper.toUIBean(scoreRepository.findByScorename(scorename));
    }

    public Predicate toPredicate(final List<FilterRequest> filters){
        logger.info("Entering predicates : "+filters);
        QScore score = QScore.score;
        BooleanExpression result = null;
        try {
            for (FilterRequest filter:filters){
                Score.COLUMNS column= Score.COLUMNS.valueOf(filter.getProperty().toUpperCase());
                BooleanExpression expression =null;
                switch (column){
                    case SCORENAME:
                        if(filter.getValue()!=null&&!"".equals(filter.getValue())){
                            expression=score.scorename.like("%"+filter.getValue()+"%");
                        }
                        break;
                }
                if (expression!=null){
                    if (result!=null){
                        result=result.and(expression);
                    }else {
                        result = expression;
                    }
                }
            }
        }catch (Exception e){
            logger.error(e);
        }
        logger.info("Result predicate : "+(result!=null?result.toString():""));
        logger.info("Exiting predicates");
        return result;
    }
}
