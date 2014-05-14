/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pgj.core.service.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author pepgonalez
 */
@Entity
@Table(name = "report")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Report.findAll", query = "SELECT r FROM Report r"),
    @NamedQuery(name = "Report.findById", query = "SELECT r FROM Report r WHERE r.id = :id"),
    @NamedQuery(name = "Report.findByDate", query = "SELECT r FROM Report r WHERE r.date = :date"),
    @NamedQuery(name = "Report.findByTime", query = "SELECT r FROM Report r WHERE r.time = :time"),
    @NamedQuery(name = "Report.findByNoJudges", query = "SELECT r FROM Report r WHERE r.noJudges = :noJudges"),
    @NamedQuery(name = "Report.findByAgency", query = "SELECT r FROM Report r WHERE r.agency = :agency"),
    @NamedQuery(name = "Report.findByAmp", query = "SELECT r FROM Report r WHERE r.amp = :amp"),
    @NamedQuery(name = "Report.findByReportRelation", query = "SELECT r FROM Report r WHERE r.reportRelation = :reportRelation"),
    @NamedQuery(name = "Report.findByAvNumber", query = "SELECT r FROM Report r WHERE r.avNumber = :avNumber"),
    @NamedQuery(name = "Report.findByIsRelevant", query = "SELECT r FROM Report r WHERE r.isRelevant = :isRelevant"),
    @NamedQuery(name = "Report.findByEvidenceContent", query = "SELECT r FROM Report r WHERE r.evidenceContent = :evidenceContent"),
    @NamedQuery(name = "Report.findBySecundarySceneNo", query = "SELECT r FROM Report r WHERE r.secundarySceneNo = :secundarySceneNo"),
    @NamedQuery(name = "Report.findByIsSuspects", query = "SELECT r FROM Report r WHERE r.isSuspects = :isSuspects"),
    @NamedQuery(name = "Report.findByStatus", query = "SELECT r FROM Report r WHERE r.status = :status"),
    @NamedQuery(name = "Report.findByLastUpdateDate", query = "SELECT r FROM Report r WHERE r.lastUpdateDate = :lastUpdateDate")})
public class Report implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "transport_unit")
    private String transportUnit;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "reportId")
    private List<Evidence> evidenceList;
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "date")
    @Temporal(TemporalType.DATE)
    private Date date;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "time")
    private String time;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "event_time")
    private String eventTime;
    @Basic(optional = false)
    @NotNull
    @Column(name = "no_judges")
    private int noJudges;
    @Size(max = 30)
    @Column(name = "agency")
    private String agency;
    @Size(max = 30)
    @Column(name = "AMP")
    private String amp;
    @Size(max = 10)
    @Column(name = "report_relation")
    private String reportRelation;
    @Size(max = 10)
    @Column(name = "av_number")
    private String avNumber;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "is_relevant")
    private String isRelevant;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "evidence_content")
    private String evidenceContent;
    @Basic(optional = false)
    @NotNull
    @Column(name = "secundary_scene_no")
    private int secundarySceneNo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "is_suspects")
    private String isSuspects;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "status")
    private String status;
    @Basic(optional = false)
    @NotNull
    @Column(name = "last_update_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastUpdateDate;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "reportId", fetch = FetchType.LAZY)
    private List<ReportJudges> reportJudgesList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "reportId", fetch = FetchType.LAZY)
    private List<ReportScenes> reportScenesList;
    @JoinColumn(name = "crime_subcategory_id", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private CrimeSubcategory crimeSubcategoryId;
    @JoinColumn(name = "crime_category_id", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private CrimeCategory crimeCategoryId;
    @JoinColumn(name = "crime_id", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Crime crimeId;
    @JoinColumn(name = "diligence_id", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Diligence diligenceId;
    @JoinColumn(name = "judge_group_id", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private JudgeGroup judgeGroupId;
    @JoinColumn(name = "call_type_id", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private CallTypeEO callTypeId;

    public Report() {
    }

    public Report(Integer id) {
        this.id = id;
    }

    public Report(Integer id, Date date, String time, String eventTime, int noJudges, String isRelevant, String evidenceContent, int secundarySceneNo, String isSuspects, String status, Date lastUpdateDate) {
        this.id = id;
        this.date = date;
        this.time = time;
        this.eventTime = eventTime;
        this.noJudges = noJudges;
        this.isRelevant = isRelevant;
        this.evidenceContent = evidenceContent;
        this.secundarySceneNo = secundarySceneNo;
        this.isSuspects = isSuspects;
        this.status = status;
        this.lastUpdateDate = lastUpdateDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
    
    public String getEventTime(){
        return eventTime;
    }
    
    public void setEventTime(String eventTime){
        this.eventTime = eventTime;
    }

    public int getNoJudges() {
        return noJudges;
    }

    public void setNoJudges(int noJudges) {
        this.noJudges = noJudges;
    }

    public String getAgency() {
        return agency;
    }

    public void setAgency(String agency) {
        this.agency = agency;
    }

    public String getAmp() {
        return amp;
    }

    public void setAmp(String amp) {
        this.amp = amp;
    }

    public String getReportRelation() {
        return reportRelation;
    }

    public void setReportRelation(String reportRelation) {
        this.reportRelation = reportRelation;
    }

    public String getAvNumber() {
        return avNumber;
    }

    public void setAvNumber(String avNumber) {
        this.avNumber = avNumber;
    }

    public String getIsRelevant() {
        return isRelevant;
    }

    public void setIsRelevant(String isRelevant) {
        this.isRelevant = isRelevant;
    }

    public String getEvidenceContent() {
        return evidenceContent;
    }

    public void setEvidenceContent(String evidenceContent) {
        this.evidenceContent = evidenceContent;
    }

    public int getSecundarySceneNo() {
        return secundarySceneNo;
    }

    public void setSecundarySceneNo(int secundarySceneNo) {
        this.secundarySceneNo = secundarySceneNo;
    }

    public String getIsSuspects() {
        return isSuspects;
    }

    public void setIsSuspects(String isSuspects) {
        this.isSuspects = isSuspects;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getLastUpdateDate() {
        return lastUpdateDate;
    }

    public void setLastUpdateDate(Date lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
    }

    @XmlTransient
    public List<ReportJudges> getReportJudgesList() {
        return reportJudgesList;
    }

    public void setReportJudgesList(List<ReportJudges> reportJudgesList) {
        this.reportJudgesList = reportJudgesList;
    }

    @XmlTransient
    public List<ReportScenes> getReportScenesList() {
        return reportScenesList;
    }

    public void setReportScenesList(List<ReportScenes> reportScenesList) {
        this.reportScenesList = reportScenesList;
    }

    public CrimeSubcategory getCrimeSubcategoryId() {
        return crimeSubcategoryId;
    }

    public void setCrimeSubcategoryId(CrimeSubcategory crimeSubcategoryId) {
        this.crimeSubcategoryId = crimeSubcategoryId;
    }

    public CrimeCategory getCrimeCategoryId() {
        return crimeCategoryId;
    }

    public void setCrimeCategoryId(CrimeCategory crimeCategoryId) {
        this.crimeCategoryId = crimeCategoryId;
    }

    public Crime getCrimeId() {
        return crimeId;
    }

    public void setCrimeId(Crime crimeId) {
        this.crimeId = crimeId;
    }

    public Diligence getDiligenceId() {
        return diligenceId;
    }

    public void setDiligenceId(Diligence diligenceId) {
        this.diligenceId = diligenceId;
    }

    public JudgeGroup getJudgeGroupId() {
        return judgeGroupId;
    }

    public void setJudgeGroupId(JudgeGroup judgeGroupId) {
        this.judgeGroupId = judgeGroupId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Report)) {
            return false;
        }
        Report other = (Report) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.pgj.core.service.entity.Report[ id=" + id + " ]";
    }

    public String getTransportUnit() {
        return transportUnit;
    }

    public void setTransportUnit(String transportUnit) {
        this.transportUnit = transportUnit;
    }

    @XmlTransient
    public List<Evidence> getEvidenceList() {
        return evidenceList;
    }

    public void setEvidenceList(List<Evidence> evidenceList) {
        this.evidenceList = evidenceList;
    }
    
}
