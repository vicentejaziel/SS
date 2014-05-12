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
@Table(name = "crime_category")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CrimeCategory.findAll", query = "SELECT c FROM CrimeCategory c"),
    @NamedQuery(name = "CrimeCategory.findById", query = "SELECT c FROM CrimeCategory c WHERE c.id = :id"),
    @NamedQuery(name = "CrimeCategory.findByName", query = "SELECT c FROM CrimeCategory c WHERE c.name = :name"),
    @NamedQuery(name = "CrimeCategory.findByStatus", query = "SELECT c FROM CrimeCategory c WHERE c.status = :status"),
    @NamedQuery(name = "CrimeCategory.findByLastUpdateDate", query = "SELECT c FROM CrimeCategory c WHERE c.lastUpdateDate = :lastUpdateDate")})
public class CrimeCategory implements Serializable {
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
    @Size(min = 1, max = 1)
    @Column(name = "status")
    private String status;
    @Basic(optional = false)
    @NotNull
    @Column(name = "last_update_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastUpdateDate;
    @JoinColumn(name = "crime_id", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Crime crimeId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "crimeCategoryId", fetch = FetchType.LAZY)
    private List<Report> reportList;

    public CrimeCategory() {
    }

    public CrimeCategory(Integer id) {
        this.id = id;
    }

    public CrimeCategory(Integer id, String name, String status, Date lastUpdateDate) {
        this.id = id;
        this.name = name;
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

    public Crime getCrimeId() {
        return crimeId;
    }

    public void setCrimeId(Crime crimeId) {
        this.crimeId = crimeId;
    }

    @XmlTransient
    public List<Report> getReportList() {
        return reportList;
    }

    public void setReportList(List<Report> reportList) {
        this.reportList = reportList;
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
        if (!(object instanceof CrimeCategory)) {
            return false;
        }
        CrimeCategory other = (CrimeCategory) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.pgj.core.service.entity.CrimeCategory[ id=" + id + " ]";
    }
    
}
