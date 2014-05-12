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
@Table(name = "crime_subcategory")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CrimeSubcategory.findAll", query = "SELECT c FROM CrimeSubcategory c"),
    @NamedQuery(name = "CrimeSubcategory.findById", query = "SELECT c FROM CrimeSubcategory c WHERE c.id = :id"),
    @NamedQuery(name = "CrimeSubcategory.findByName", query = "SELECT c FROM CrimeSubcategory c WHERE c.name = :name"),
    @NamedQuery(name = "CrimeSubcategory.findByStatus", query = "SELECT c FROM CrimeSubcategory c WHERE c.status = :status"),
    @NamedQuery(name = "CrimeSubcategory.findByLastUpdateDate", query = "SELECT c FROM CrimeSubcategory c WHERE c.lastUpdateDate = :lastUpdateDate")})
public class CrimeSubcategory implements Serializable {
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "crimeSubcategoryId", fetch = FetchType.LAZY)
    private List<Report> reportList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "crimeCategoryId", fetch = FetchType.LAZY)
    private List<CrimeSubcategory> crimeSubcategoryList;
    @JoinColumn(name = "crime_category_id", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private CrimeSubcategory crimeCategoryId;

    public CrimeSubcategory() {
    }

    public CrimeSubcategory(Integer id) {
        this.id = id;
    }

    public CrimeSubcategory(Integer id, String name, String status, Date lastUpdateDate) {
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

    @XmlTransient
    public List<Report> getReportList() {
        return reportList;
    }

    public void setReportList(List<Report> reportList) {
        this.reportList = reportList;
    }

    @XmlTransient
    public List<CrimeSubcategory> getCrimeSubcategoryList() {
        return crimeSubcategoryList;
    }

    public void setCrimeSubcategoryList(List<CrimeSubcategory> crimeSubcategoryList) {
        this.crimeSubcategoryList = crimeSubcategoryList;
    }

    public CrimeSubcategory getCrimeCategoryId() {
        return crimeCategoryId;
    }

    public void setCrimeCategoryId(CrimeSubcategory crimeCategoryId) {
        this.crimeCategoryId = crimeCategoryId;
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
        if (!(object instanceof CrimeSubcategory)) {
            return false;
        }
        CrimeSubcategory other = (CrimeSubcategory) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.pgj.core.service.entity.CrimeSubcategory[ id=" + id + " ]";
    }
    
}
