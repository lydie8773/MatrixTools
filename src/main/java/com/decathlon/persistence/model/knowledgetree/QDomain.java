package com.decathlon.persistence.model.knowledgetree;

import com.mysema.query.types.PathMetadata;
import com.mysema.query.types.path.*;

import javax.annotation.Generated;

import static com.mysema.query.types.PathMetadataFactory.forVariable;

/**
 * Created by dengyuanqin on 16/3/21.
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QDomain extends EntityPathBase<Domain>{
    private static final PathInits INITS = PathInits.DIRECT;

    public static  final QDomain domain = new QDomain("domain");

    public final NumberPath<Long> domainid = createNumber("domainid",Long.class);
    public final StringPath domainname = createString("domainname");
    public final SetPath<Subdomain, QSubdomain> subdomain = this.<Subdomain,QSubdomain>createSet("subdomain",Subdomain.class,QSubdomain.class);

    public QDomain(String variable){
        this(Domain.class, forVariable(variable), INITS);
    }

    public QDomain(PathMetadata<?> metadata){
        this(metadata, metadata.isRoot()?INITS:PathInits.DEFAULT);
    }

    public QDomain(PathMetadata<?> metadata, PathInits inits){
        this(Domain.class, metadata, inits);
    }

    public QDomain(Class<? extends Domain> domain, PathMetadata<?> metadata, PathInits inits){
        super(domain,metadata,inits);
    }
}
