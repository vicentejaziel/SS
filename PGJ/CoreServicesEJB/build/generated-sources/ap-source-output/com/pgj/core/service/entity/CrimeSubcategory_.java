package com.pgj.core.service.entity;

import com.pgj.core.service.entity.CrimeSubcategory;
import com.pgj.core.service.entity.Report;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2014-05-11T22:11:07")
@StaticMetamodel(CrimeSubcategory.class)
public class CrimeSubcategory_ { 

    public static volatile SingularAttribute<CrimeSubcategory, Integer> id;
    public static volatile SingularAttribute<CrimeSubcategory, String> status;
    public static volatile SingularAttribute<CrimeSubcategory, String> name;
    public static volatile ListAttribute<CrimeSubcategory, CrimeSubcategory> crimeSubcategoryList;
    public static volatile SingularAttribute<CrimeSubcategory, CrimeSubcategory> crimeCategoryId;
    public static volatile ListAttribute<CrimeSubcategory, Report> reportList;
    public static volatile SingularAttribute<CrimeSubcategory, Date> lastUpdateDate;

}