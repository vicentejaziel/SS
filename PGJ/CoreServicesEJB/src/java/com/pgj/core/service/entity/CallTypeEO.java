/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pgj.core.service.entity;

import com.pgj.core.service.dto.CallTypeDTO;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "call_type")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CallTypeEO.findAll", query = "SELECT c FROM CallTypeEO c"),
    @NamedQuery(name = "CallTypeEO.findById", query = "SELECT c FROM CallTypeEO c WHERE c.id = :id"),
    @NamedQuery(name = "CallTypeEO.findByName", query = "SELECT c FROM CallTypeEO c WHERE c.name = :name"),
    @NamedQuery(name = "CallTypeEO.findByStatus", query = "SELECT c FROM CallTypeEO c WHERE c.status = :status"),
    @NamedQuery(name = "CallTypeEO.findByLastUpdateDate", query = "SELECT c FROM CallTypeEO c WHERE c.lastUpdateDate = :lastUpdateDate")})
public class CallTypeEO implements Serializable {
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

    public CallTypeEO() {
    }

    public CallTypeEO(Integer id) {
        this.id = id;
    }

    public CallTypeEO(Integer id, String name, String status, Date lastUpdateDate) {
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CallTypeEO)) {
            return false;
        }
        CallTypeEO other = (CallTypeEO) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }
    
    
    public CallTypeDTO getDTOFromInstance(){
        CallTypeDTO e = new CallTypeDTO();
        e.setId(this.id);
        e.setName(this.name);
        e.setStatus(this.getStatus());
        e.setLastUpdateDate(this.lastUpdateDate);
        return e;
    }

    @Override
    public String toString() {
        return "com.pgj.core.service.ejb.CallTypeEO[ id=" + id + " ]";
    }
    
}
