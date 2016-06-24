package com.decathlon.persistence.model.judge;

import com.decathlon.persistence.model.account.QUser;
import com.mysema.query.types.PathMetadata;
import com.mysema.query.types.path.EntityPathBase;
import com.mysema.query.types.path.NumberPath;
import com.mysema.query.types.path.PathInits;
import com.mysema.query.types.path.StringPath;

import javax.annotation.Generated;
import javax.persistence.Entity;

import static com.mysema.query.types.PathMetadataFactory.forVariable;

/**
 * Querydsl is for create database structure
 * Created by DengYuanqin on 3/23/2016.
 */

@Generated("com.mysema.query.codegen.EntitySerializer")
public class QEndorsement extends EntityPathBase<Endorsement> {
    private static final PathInits INITS = PathInits.DIRECT;
    public static  final QEndorsement endorsement = new QEndorsement("endorsement");

    //Generate columns
    public final NumberPath<Long> endorseid = createNumber("endorseid", Long.class);
    public final StringPath endorsename = createString("endorsename");

    public QUser user;
    public QScore score;

    public QEndorsement(String variable) {
        this(Endorsement.class, forVariable(variable), INITS);
    }

    public QEndorsement(PathMetadata<?> metadata){
        this(metadata, metadata.isRoot()?INITS:PathInits.DEFAULT);
    }

    public QEndorsement(PathMetadata<?> metadata, PathInits inits){
        this(Endorsement.class, metadata, inits);
    }

    public QEndorsement(Class<? extends Endorsement> type, PathMetadata<?> metadata, PathInits inits){
        super(type, metadata, inits);
        this.user = inits.isInitialized("user")?new QUser(forProperty("user")):null;
        this.score = inits.isInitialized("score")?new QScore(forProperty("score")):null;
    }
}
