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
@Table(name = "diligence")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Diligence.findAll", query = "SELECT d FROM Diligence d"),
    @NamedQuery(name = "Diligence.findById", query = "SELECT d FROM Diligence d WHERE d.id = :id"),
    @NamedQuery(name = "Diligence.findByName", query = "SELECT d FROM Diligence d WHERE d.name = :name"),
    @NamedQuery(name = "Diligence.findByStreetAndNo", query = "SELECT d FROM Diligence d WHERE d.streetAndNo = :streetAndNo"),
    @NamedQuery(name = "Diligence.findBySuburb", query = "SELECT d FROM Diligence d WHERE d.suburb = :suburb"),
    @NamedQuery(name = "Diligence.findByPostalCode", query = "SELECT d FROM Diligence d WHERE d.postalCode = :postalCode"),
    @NamedQuery(name = "Diligence.findByBetweenSt", query = "SELECT d FROM Diligence d WHERE d.betweenSt = :betweenSt"),
    @NamedQuery(name = "Diligence.findByLatitude", query = "SELECT d FROM Diligence d WHERE d.latitude = :latitude"),
    @NamedQuery(name = "Diligence.findByLongitude", query = "SELECT d FROM Diligence d WHERE d.longitude = :longitude"),
    @NamedQuery(name = "Diligence.findByCuadrant", query = "SELECT d FROM Diligence d WHERE d.cuadrant = :cuadrant"),
    @NamedQuery(name = "Diligence.findByStatus", query = "SELECT d FROM Diligence d WHERE d.status = :status"),
    @NamedQuery(name = "Diligence.findByLastUpdateDate", query = "SELECT d FROM Diligence d WHERE d.lastUpdateDate = :lastUpdateDate")})
public class Diligence implements Serializable {
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
    @Size(min = 1, max = 50)
    @Column(name = "street_and_no")
    private String streetAndNo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "suburb")
    private String suburb;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "postal_code")
    private String postalCode;
    @Size(max = 100)
    @Column(name = "between_st")
    private String betweenSt;
    @Size(max = 30)
    @Column(name = "latitude")
    private String latitude;
    @Size(max = 30)
    @Column(name = "longitude")
    private String longitude;
    @Size(max = 10)
    @Column(name = "cuadrant")
    private String cuadrant;
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
    @JoinColumn(name = "town_id", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Town townId;
    @JoinColumn(name = "dependence_id", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Dependence dependenceId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "diligenceId", fetch = FetchType.LAZY)
    private List<Report> reportList;

    public Diligence() {
    }

    public Diligence(Integer id) {
        this.id = id;
    }

    public Diligence(Integer id, String name, String streetAndNo, String suburb, String postalCode, String status, Date lastUpdateDate) {
        this.id = id;
        this.name = name;
        this.streetAndNo = streetAndNo;
        this.suburb = suburb;
        this.postalCode = postalCode;
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

    public String getStreetAndNo() {
        return streetAndNo;
    }

    public void setStreetAndNo(String streetAndNo) {
        this.streetAndNo = streetAndNo;
    }

    public String getSuburb() {
        return suburb;
    }

    public void setSuburb(String suburb) {
        this.suburb = suburb;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getBetweenSt() {
        return betweenSt;
    }

    public void setBetweenSt(String betweenSt) {
        this.betweenSt = betweenSt;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getCuadrant() {
        return cuadrant;
    }

    public void setCuadrant(String cuadrant) {
        this.cuadrant = cuadrant;
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

    public Town getTownId() {
        return townId;
    }

    public void setTownId(Town townId) {
        this.townId = townId;
    }

    public Dependence getDependenceId() {
        return dependenceId;
    }

    public void setDependenceId(Dependence dependenceId) {
        this.dependenceId = dependenceId;
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
        if (!(object instanceof Diligence)) {
            return false;
        }
        Diligence other = (Diligence) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.pgj.core.service.entity.Diligence[ id=" + id + " ]";
    }
    
}
