package com.decathlon.persistence.model.knowledgetree;

import com.mysema.query.types.PathMetadata;
import com.mysema.query.types.path.*;

import javax.annotation.Generated;

import static com.mysema.query.types.PathMetadataFactory.forVariable;

/**
 * Created by DengYuanqin on 3/22/2016.
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QSubdomain extends EntityPathBase<Subdomain> {
    private static final PathInits INITS = PathInits.DIRECT;

    public static final QSubdomain subdomain = new QSubdomain("subdomain");//Generate table subdomain

    public final NumberPath<Long> subdomainid = createNumber("subdomainid", Long.class);
    public final StringPath subdomainname = createString("subdomainname");

    public final QDomain domain;
    public final SetPath<Skill,QSkill> skill = this.<Skill,QSkill> createSet("skill",Skill.class,QSkill.class);

    public QSubdomain(String variable) {
        this(Subdomain.class, forVariable(variable),INITS);
    }

    public QSubdomain(PathMetadata<?> metadata) {
        this(metadata,metadata.isRoot()?INITS:PathInits.DEFAULT);
    }

    public QSubdomain(PathMetadata<?> metadata, PathInits inits){
        this(Subdomain.class, metadata, inits);
    }

    public QSubdomain(Class<? extends Subdomain> subdomain, PathMetadata<?> metadata, PathInits inits){
        super(subdomain,metadata,inits);
        this.domain = inits.isInitialized("domain") ? new QDomain(forProperty("domain"),inits.get("domain")):null;
    }
}
