package com.pgj.core.service.entity;

import com.pgj.core.service.entity.Dependence;
import com.pgj.core.service.entity.Report;
import com.pgj.core.service.entity.Town;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2014-05-11T22:11:07")
@StaticMetamodel(Diligence.class)
public class Diligence_ { 

    public static volatile SingularAttribute<Diligence, String> status;
    public static volatile SingularAttribute<Diligence, String> cuadrant;
    public static volatile SingularAttribute<Diligence, Town> townId;
    public static volatile SingularAttribute<Diligence, String> streetAndNo;
    public static volatile ListAttribute<Diligence, Report> reportList;
    public static volatile SingularAttribute<Diligence, Date> lastUpdateDate;
    public static volatile SingularAttribute<Diligence, Integer> id;
    public static volatile SingularAttribute<Diligence, String> postalCode;
    public static volatile SingularAttribute<Diligence, String> suburb;
    public static volatile SingularAttribute<Diligence, String> name;
    public static volatile SingularAttribute<Diligence, Dependence> dependenceId;
    public static volatile SingularAttribute<Diligence, String> longitude;
    public static volatile SingularAttribute<Diligence, String> betweenSt;
    public static volatile SingularAttribute<Diligence, String> latitude;

}