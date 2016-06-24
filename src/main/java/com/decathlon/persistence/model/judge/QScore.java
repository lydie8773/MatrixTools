package com.decathlon.persistence.model.judge;

import com.decathlon.persistence.model.account.QUser;
import com.decathlon.persistence.model.knowledgetree.QSkill;
import com.mysema.query.types.PathMetadata;
import com.mysema.query.types.path.*;

import javax.annotation.Generated;

import static com.mysema.query.types.PathMetadataFactory.forVariable;

/**
 * Created by DengYuanqin on 3/23/2016.
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QScore extends EntityPathBase<Score> {
    private static final PathInits INITS = PathInits.DIRECT;
    public static  final  QScore score = new QScore("score"); //Generate table

    /*
     *Generate columns
     */
    public final NumberPath<Long> scoreid = createNumber("scoreid", Long.class);
    public final StringPath scorename = createString("scorename");

    public final QSkill skill;
    public final QUser user;

    public final SetPath<Endorsement,QEndorsement> endorsement = this.<Endorsement,QEndorsement>createSet("endorsement",Endorsement.class,QEndorsement.class);

    public QScore(String variable) {
        this(Score.class, forVariable(variable), INITS);
    }

    public QScore(PathMetadata<?> metadata) {
        this(metadata, metadata.isRoot()?INITS:PathInits.DEFAULT);
    }

    public QScore(PathMetadata<?> metadata, PathInits inits) {
        this(Score.class, metadata, inits);
    }

    public QScore(Class<? extends Score> type,PathMetadata<?> metadata,PathInits inits){
        super(type,metadata,inits);
        this.skill=inits.isInitialized("skill")?new QSkill(forProperty("skill")):null;
        this.user=inits.isInitialized("user")?new QUser(forProperty("user")):null;
    }
}
