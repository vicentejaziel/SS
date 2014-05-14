package com.pgj.core.service.entity;

import com.pgj.core.service.entity.Diligence;
import com.pgj.core.service.entity.Town;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2014-05-14T00:11:02")
@StaticMetamodel(Dependence.class)
public class Dependence_ { 

    public static volatile SingularAttribute<Dependence, Integer> id;
    public static volatile ListAttribute<Dependence, Diligence> diligenceList;
    public static volatile SingularAttribute<Dependence, String> postalCode;
    public static volatile SingularAttribute<Dependence, String> suburb;
    public static volatile SingularAttribute<Dependence, String> status;
    public static volatile SingularAttribute<Dependence, String> cuadrant;
    public static volatile SingularAttribute<Dependence, String> name;
    public static volatile SingularAttribute<Dependence, Town> townId;
    public static volatile SingularAttribute<Dependence, String> betweenSt;
    public static volatile SingularAttribute<Dependence, String> longitude;
    public static volatile SingularAttribute<Dependence, String> streetAndNo;
    public static volatile SingularAttribute<Dependence, String> latitude;
    public static volatile SingularAttribute<Dependence, Date> lastUpdateDate;

}