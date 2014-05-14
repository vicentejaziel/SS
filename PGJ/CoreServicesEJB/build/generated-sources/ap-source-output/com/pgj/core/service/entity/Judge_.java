package com.pgj.core.service.entity;

import com.pgj.core.service.entity.JudgeGroup;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2014-05-14T00:11:02")
@StaticMetamodel(Judge.class)
public class Judge_ { 

    public static volatile SingularAttribute<Judge, Integer> id;
    public static volatile SingularAttribute<Judge, String> status;
    public static volatile SingularAttribute<Judge, String> name;
    public static volatile SingularAttribute<Judge, JudgeGroup> judgeGroupId;
    public static volatile SingularAttribute<Judge, Date> lastUpdateDate;

}