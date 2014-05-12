package com.pgj.core.service.entity;

import com.pgj.core.service.entity.Dependence;
import com.pgj.core.service.entity.Diligence;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2014-05-11T22:11:07")
@StaticMetamodel(Town.class)
public class Town_ { 

    public static volatile SingularAttribute<Town, Integer> id;
    public static volatile ListAttribute<Town, Diligence> diligenceList;
    public static volatile SingularAttribute<Town, String> status;
    public static volatile SingularAttribute<Town, String> name;
    public static volatile ListAttribute<Town, Dependence> dependenceList;
    public static volatile SingularAttribute<Town, Date> lastUpdateDate;

}