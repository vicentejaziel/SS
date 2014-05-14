package com.pgj.core.service.entity;

import com.pgj.core.service.entity.Crime;
import com.pgj.core.service.entity.Report;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2014-05-14T00:11:02")
@StaticMetamodel(CrimeCategory.class)
public class CrimeCategory_ { 

    public static volatile SingularAttribute<CrimeCategory, Integer> id;
    public static volatile SingularAttribute<CrimeCategory, Crime> crimeId;
    public static volatile SingularAttribute<CrimeCategory, String> status;
    public static volatile SingularAttribute<CrimeCategory, String> name;
    public static volatile ListAttribute<CrimeCategory, Report> reportList;
    public static volatile SingularAttribute<CrimeCategory, Date> lastUpdateDate;

}