package com.decathlon.persistence.model.account;

import com.decathlon.persistence.model.judge.Endorsement;
import com.decathlon.persistence.model.judge.QEndorsement;
import com.decathlon.persistence.model.judge.QScore;
import com.decathlon.persistence.model.judge.Score;
import com.mysema.query.types.PathMetadata;
import com.mysema.query.types.path.*;

import javax.annotation.Generated;
import java.util.Date;

import static com.mysema.query.types.PathMetadataFactory.forVariable;

/**
 * QUser defines a general statically typed syntax for querying on top of persisted knowledgetree model data.
 * Querydsl for JPA/Hibernate is an alternative to both JPQL and Criteria queries
 * Created by DengYuanqin on 3/23/2016.
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QUser extends EntityPathBase<User>{
    private static final PathInits INITS = PathInits.DIRECT;
    //Generate table user
    public static final QUser user = new QUser("user");
    /*
     * Generate the columns of table User
     */
    public final NumberPath<Long> userid = createNumber("userid", Long.class);
    public final StringPath username = createString("username");
    public final StringPath password = createString("password");
    public final StringPath loginname = createString("loginname");
    public final StringPath email = createString("email");
    public final NumberPath<Integer> role = createNumber("role",Integer.class);
    public final DateTimePath<Date> createdDate = createDateTime(
            "createdDate", Date.class);
    public final DateTimePath<Date> modifiedDate = createDateTime(
            "modifiedDate", Date.class);

    public final SetPath<Score, QScore> score = this.<Score,QScore>createSet("score",Score.class,QScore.class);
    public final SetPath<Endorsement,QEndorsement> endorsement = this.<Endorsement,QEndorsement>createSet("endorsement",Endorsement.class,QEndorsement.class);

    public QUser(String variable){
        this(User.class, forVariable(variable), INITS);
    }

    public QUser(PathMetadata<?> metadata){
        this(metadata,metadata.isRoot()?INITS:PathInits.DEFAULT);
    }

    public QUser(PathMetadata<?> metadata, PathInits inits){
        this(User.class,metadata,inits);
    }

    public QUser(Class<? extends User> type, PathMetadata<?> metadata, PathInits inits){
        super(type,metadata,inits);
    }
}

