package com.pgj.core.service.entity;

import com.pgj.core.service.entity.Report;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2014-05-14T00:11:02")
@StaticMetamodel(CallTypeEO.class)
public class CallTypeEO_ { 

    public static volatile SingularAttribute<CallTypeEO, Integer> id;
    public static volatile SingularAttribute<CallTypeEO, String> status;
    public static volatile SingularAttribute<CallTypeEO, String> name;
    public static volatile ListAttribute<CallTypeEO, Report> reportList;
    public static volatile SingularAttribute<CallTypeEO, Date> lastUpdateDate;

}