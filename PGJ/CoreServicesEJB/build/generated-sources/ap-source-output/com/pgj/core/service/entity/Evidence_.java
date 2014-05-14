package com.pgj.core.service.entity;

import com.pgj.core.service.entity.Lab;
import com.pgj.core.service.entity.Report;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2014-05-14T00:11:02")
@StaticMetamodel(Evidence.class)
public class Evidence_ { 

    public static volatile SingularAttribute<Evidence, Integer> id;
    public static volatile SingularAttribute<Evidence, Integer> creationDate;
    public static volatile SingularAttribute<Evidence, String> result;
    public static volatile SingularAttribute<Evidence, String> status;
    public static volatile SingularAttribute<Evidence, String> description;
    public static volatile SingularAttribute<Evidence, String> name;
    public static volatile SingularAttribute<Evidence, String> isProcesed;
    public static volatile SingularAttribute<Evidence, Lab> labId;
    public static volatile SingularAttribute<Evidence, Report> reportId;
    public static volatile SingularAttribute<Evidence, Date> lastUpdateDate;

}