package com.pgj.core.service.entity;

import com.pgj.core.service.entity.CrimeCategory;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2014-05-11T22:11:07")
@StaticMetamodel(Crime.class)
public class Crime_ { 

    public static volatile SingularAttribute<Crime, Integer> id;
    public static volatile SingularAttribute<Crime, String> status;
    public static volatile SingularAttribute<Crime, String> name;
    public static volatile ListAttribute<Crime, CrimeCategory> crimeCategoryList;
    public static volatile SingularAttribute<Crime, Date> lastUpdateDate;

}