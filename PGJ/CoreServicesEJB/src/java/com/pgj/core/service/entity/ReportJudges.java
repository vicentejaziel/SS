/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pgj.core.service.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author pepgonalez
 */
@Entity
@Table(name = "report_judges")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ReportJudges.findAll", query = "SELECT r FROM ReportJudges r"),
    @NamedQuery(name = "ReportJudges.findById", query = "SELECT r FROM ReportJudges r WHERE r.id = :id"),
    @NamedQuery(name = "ReportJudges.findByStatus", query = "SELECT r FROM ReportJudges r WHERE r.status = :status"),
    @NamedQuery(name = "ReportJudges.findByLastUpdateDate", query = "SELECT r FROM ReportJudges r WHERE r.lastUpdateDate = :lastUpdateDate")})
public class ReportJudges implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
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
    @JoinColumn(name = "judge_id", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Judge judgeId;
    @JoinColumn(name = "report_id", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Report reportId;

    public ReportJudges() {
    }

    public ReportJudges(Integer id) {
        this.id = id;
    }

    public ReportJudges(Integer id, String status, Date lastUpdateDate) {
        this.id = id;
        this.status = status;
        this.lastUpdateDate = lastUpdateDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Judge getJudgeId() {
        return judgeId;
    }

    public void setJudgeId(Judge judgeId) {
        this.judgeId = judgeId;
    }

    public Report getReportId() {
        return reportId;
    }

    public void setReportId(Report reportId) {
        this.reportId = reportId;
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
        if (!(object instanceof ReportJudges)) {
            return false;
        }
        ReportJudges other = (ReportJudges) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.pgj.core.service.entity.ReportJudges[ id=" + id + " ]";
    }
    
}
