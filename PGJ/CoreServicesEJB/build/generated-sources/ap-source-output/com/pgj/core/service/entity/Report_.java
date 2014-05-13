package com.pgj.core.service.entity;

import com.pgj.core.service.entity.CallTypeEO;
import com.pgj.core.service.entity.Crime;
import com.pgj.core.service.entity.CrimeCategory;
import com.pgj.core.service.entity.CrimeSubcategory;
import com.pgj.core.service.entity.Diligence;
import com.pgj.core.service.entity.JudgeGroup;
import com.pgj.core.service.entity.ReportJudges;
import com.pgj.core.service.entity.ReportScenes;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2014-05-12T14:15:29")
@StaticMetamodel(Report.class)
public class Report_ { 

    public static volatile SingularAttribute<Report, Crime> crimeId;
    public static volatile ListAttribute<Report, ReportScenes> reportScenesList;
    public static volatile ListAttribute<Report, ReportJudges> reportJudgesList;
    public static volatile SingularAttribute<Report, String> status;
    public static volatile SingularAttribute<Report, String> agency;
    public static volatile SingularAttribute<Report, Date> date;
    public static volatile SingularAttribute<Report, Diligence> diligenceId;
    public static volatile SingularAttribute<Report, Integer> secundarySceneNo;
    public static volatile SingularAttribute<Report, Date> lastUpdateDate;
    public static volatile SingularAttribute<Report, Integer> id;
    public static volatile SingularAttribute<Report, CallTypeEO> callTypeId;
    public static volatile SingularAttribute<Report, CrimeSubcategory> crimeSubcategoryId;
    public static volatile SingularAttribute<Report, String> isSuspects;
    public static volatile SingularAttribute<Report, String> time;
    public static volatile SingularAttribute<Report, String> avNumber;
    public static volatile SingularAttribute<Report, String> reportRelation;
    public static volatile SingularAttribute<Report, Integer> noJudges;
    public static volatile SingularAttribute<Report, JudgeGroup> judgeGroupId;
    public static volatile SingularAttribute<Report, String> evidenceContent;
    public static volatile SingularAttribute<Report, String> isRelevant;
    public static volatile SingularAttribute<Report, CrimeCategory> crimeCategoryId;
    public static volatile SingularAttribute<Report, String> eventTime;
    public static volatile SingularAttribute<Report, String> amp;

}