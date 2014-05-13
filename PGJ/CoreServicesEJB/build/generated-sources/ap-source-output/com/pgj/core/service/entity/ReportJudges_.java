package com.pgj.core.service.entity;

import com.pgj.core.service.entity.Judge;
import com.pgj.core.service.entity.Report;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2014-05-12T14:15:29")
@StaticMetamodel(ReportJudges.class)
public class ReportJudges_ { 

    public static volatile SingularAttribute<ReportJudges, Integer> id;
    public static volatile SingularAttribute<ReportJudges, String> status;
    public static volatile SingularAttribute<ReportJudges, Judge> judgeId;
    public static volatile SingularAttribute<ReportJudges, Report> reportId;
    public static volatile SingularAttribute<ReportJudges, Date> lastUpdateDate;

}