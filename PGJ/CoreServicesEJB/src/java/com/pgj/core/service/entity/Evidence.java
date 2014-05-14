/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pgj.core.service.entity;

import com.pgj.core.service.dto.EvidenceDTO;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
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
 * @author jgonzalez
 */
@Entity
@Table(name = "evidence")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Evidence.findAll", query = "SELECT e FROM Evidence e"),
    @NamedQuery(name = "Evidence.findById", query = "SELECT e FROM Evidence e WHERE e.id = :id"),
    @NamedQuery(name = "Evidence.findByName", query = "SELECT e FROM Evidence e WHERE e.name = :name"),
    @NamedQuery(name = "Evidence.findByDescription", query = "SELECT e FROM Evidence e WHERE e.description = :description"),
    @NamedQuery(name = "Evidence.findByCreationDate", query = "SELECT e FROM Evidence e WHERE e.creationDate = :creationDate"),
    @NamedQuery(name = "Evidence.findByIsProcesed", query = "SELECT e FROM Evidence e WHERE e.isProcesed = :isProcesed"),
    @NamedQuery(name = "Evidence.findByResult", query = "SELECT e FROM Evidence e WHERE e.result = :result"),
    @NamedQuery(name = "Evidence.findByStatus", query = "SELECT e FROM Evidence e WHERE e.status = :status"),
    @NamedQuery(name = "Evidence.findByLastUpdateDate", query = "SELECT e FROM Evidence e WHERE e.lastUpdateDate = :lastUpdateDate")})
public class Evidence implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 500)
    @Column(name = "description")
    private String description;
    @Basic(optional = false)
    @NotNull
    @Column(name = "creation_date")
    private int creationDate;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "is_procesed")
    private String isProcesed;
    @Size(max = 500)
    @Column(name = "result")
    private String result;
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
    @JoinColumn(name = "lab_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Lab labId;
    @JoinColumn(name = "report_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Report reportId;

    public Evidence() {
    }

    public Evidence(Integer id) {
        this.id = id;
    }

    public Evidence(Integer id, String name, String description, int creationDate, String isProcesed, String status, Date lastUpdateDate) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.creationDate = creationDate;
        this.isProcesed = isProcesed;
        this.status = status;
        this.lastUpdateDate = lastUpdateDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(int creationDate) {
        this.creationDate = creationDate;
    }

    public String getIsProcesed() {
        return isProcesed;
    }

    public void setIsProcesed(String isProcesed) {
        this.isProcesed = isProcesed;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
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

    public Lab getLabId() {
        return labId;
    }

    public void setLabId(Lab labId) {
        this.labId = labId;
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
        if (!(object instanceof Evidence)) {
            return false;
        }
        Evidence other = (Evidence) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }
    
    public EvidenceDTO getDTOFromInstance(){
        EvidenceDTO dto = new EvidenceDTO();
        dto.setId(this.id);
        dto.setReportId(this.reportId.getId());
        dto.setLab(this.labId.getDTOFromInstance());
        dto.setCreationDate(this.creationDate);
        dto.setName(this.name);
        dto.setDescription(this.description);
        dto.setIsProcesed(this.isProcesed);
        dto.setStatus(this.status);
        dto.setLastUpdateDate(this.lastUpdateDate);
        return dto;
    }

    @Override
    public String toString() {
        return "com.pgj.core.service.entity.Evidence[ id=" + id + " ]";
    }
    
}
