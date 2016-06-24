package com.decathlon.persistence.model.knowledgetree;

import com.decathlon.persistence.model.judge.QScore;
import com.decathlon.persistence.model.judge.Score;
import com.mysema.query.types.PathMetadata;
import com.mysema.query.types.path.*;

import javax.annotation.Generated;

import static com.mysema.query.types.PathMetadataFactory.forVariable;

/**
 * QSkill is a class of Querydsl query type for Skill
 * Created by dengyuanqin on 16/3/22.
 */

@Generated("com.mysema.query.codegen.EntitySerializer")
public class QSkill extends EntityPathBase<Skill>{
    private static final PathInits INITS = PathInits.DIRECT;

    private static final QSkill skill = new QSkill("skill"); //Generate table skill

    //Generate columns
    private final NumberPath<Long> skillid = createNumber("skillid", Long.class);
    private final StringPath skillname = createString("skillname");

    private final QSubdomain subdomain;
    private final SetPath<Score, QScore> score = this.<Score, QScore>createSet("score", Score.class, QScore.class);

    public QSkill(String variable){
        this(Skill.class, forVariable(variable), INITS);
    }

    public QSkill(PathMetadata<?> metadata){
        this(metadata, metadata.isRoot()?INITS:PathInits.DEFAULT);
    }

    public QSkill(PathMetadata<?> metadata, PathInits inits){
        this(Skill.class, metadata, inits);
    }

    public QSkill(Class<? extends Skill> type, PathMetadata<?> metadata, PathInits inits){
        super(type, metadata, inits);
        this.subdomain = inits.isInitialized("subdomain")?new QSubdomain(forProperty("subdomain")):null;
    }
}








