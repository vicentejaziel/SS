/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pgj.core.service.entity;

import com.pgj.core.service.dto.TownDTO;
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
@Table(name = "town")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Town.findAll", query = "SELECT t FROM Town t"),
    @NamedQuery(name = "Town.findById", query = "SELECT t FROM Town t WHERE t.id = :id"),
    @NamedQuery(name = "Town.findByName", query = "SELECT t FROM Town t WHERE t.name = :name"),
    @NamedQuery(name = "Town.findByStatus", query = "SELECT t FROM Town t WHERE t.status = :status"),
    @NamedQuery(name = "Town.findByLastUpdateDate", query = "SELECT t FROM Town t WHERE t.lastUpdateDate = :lastUpdateDate")})
public class Town implements Serializable {
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "townId", fetch = FetchType.LAZY)
    private List<Dependence> dependenceList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "townId", fetch = FetchType.LAZY)
    private List<Diligence> diligenceList;

    public Town() {
    }

    public Town(Integer id) {
        this.id = id;
    }

    public Town(Integer id, String name, String status, Date lastUpdateDate) {
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
    public List<Dependence> getDependenceList() {
        return dependenceList;
    }

    public void setDependenceList(List<Dependence> dependenceList) {
        this.dependenceList = dependenceList;
    }

    @XmlTransient
    public List<Diligence> getDiligenceList() {
        return diligenceList;
    }

    public void setDiligenceList(List<Diligence> diligenceList) {
        this.diligenceList = diligenceList;
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
        if (!(object instanceof Town)) {
            return false;
        }
        Town other = (Town) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }
    
    public TownDTO getDTOFromInstance(){
        TownDTO dto = new TownDTO();
        dto.setId(this.id);
        dto.setName(this.name);
        dto.setStatus(this.status);
        dto.setLastUpdateDate(this.lastUpdateDate);
        return dto;
    }

    @Override
    public String toString() {
        return "com.pgj.core.service.entity.Town[ id=" + id + " ]";
    }
    
}
