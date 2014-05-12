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
@Table(name = "report_scenes")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ReportScenes.findAll", query = "SELECT r FROM ReportScenes r"),
    @NamedQuery(name = "ReportScenes.findById", query = "SELECT r FROM ReportScenes r WHERE r.id = :id"),
    @NamedQuery(name = "ReportScenes.findBySceneDescription", query = "SELECT r FROM ReportScenes r WHERE r.sceneDescription = :sceneDescription"),
    @NamedQuery(name = "ReportScenes.findByStatus", query = "SELECT r FROM ReportScenes r WHERE r.status = :status"),
    @NamedQuery(name = "ReportScenes.findByLastUpdateDate", query = "SELECT r FROM ReportScenes r WHERE r.lastUpdateDate = :lastUpdateDate")})
public class ReportScenes implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 250)
    @Column(name = "scene_description")
    private String sceneDescription;
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
    @JoinColumn(name = "report_id", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Report reportId;

    public ReportScenes() {
    }

    public ReportScenes(Integer id) {
        this.id = id;
    }

    public ReportScenes(Integer id, String sceneDescription, String status, Date lastUpdateDate) {
        this.id = id;
        this.sceneDescription = sceneDescription;
        this.status = status;
        this.lastUpdateDate = lastUpdateDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSceneDescription() {
        return sceneDescription;
    }

    public void setSceneDescription(String sceneDescription) {
        this.sceneDescription = sceneDescription;
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
        if (!(object instanceof ReportScenes)) {
            return false;
        }
        ReportScenes other = (ReportScenes) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.pgj.core.service.entity.ReportScenes[ id=" + id + " ]";
    }
    
}
