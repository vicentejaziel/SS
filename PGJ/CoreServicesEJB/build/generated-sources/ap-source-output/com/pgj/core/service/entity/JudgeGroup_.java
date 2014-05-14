package com.pgj.core.service.entity;

import com.pgj.core.service.entity.Judge;
import com.pgj.core.service.entity.Report;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2014-05-14T00:11:02")
@StaticMetamodel(JudgeGroup.class)
public class JudgeGroup_ { 

    public static volatile SingularAttribute<JudgeGroup, Integer> id;
    public static volatile ListAttribute<JudgeGroup, Judge> judgeList;
    public static volatile SingularAttribute<JudgeGroup, String> status;
    public static volatile SingularAttribute<JudgeGroup, String> description;
    public static volatile SingularAttribute<JudgeGroup, String> name;
    public static volatile ListAttribute<JudgeGroup, Report> reportList;
    public static volatile SingularAttribute<JudgeGroup, Date> lastUpdateDate;

}