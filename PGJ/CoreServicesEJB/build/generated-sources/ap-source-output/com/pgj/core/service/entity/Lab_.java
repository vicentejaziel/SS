package com.pgj.core.service.entity;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2014-05-11T22:11:07")
@StaticMetamodel(Lab.class)
public class Lab_ { 

    public static volatile SingularAttribute<Lab, Integer> id;
    public static volatile SingularAttribute<Lab, String> status;
    public static volatile SingularAttribute<Lab, String> description;
    public static volatile SingularAttribute<Lab, String> name;
    public static volatile SingularAttribute<Lab, String> labType;
    public static volatile SingularAttribute<Lab, Date> lastUpdateDate;

}