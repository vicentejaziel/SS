/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pgj.core.service.entity;

import com.pgj.core.service.dto.JudgeDTO;
import java.io.Serializable;
import java.sql.Timestamp;
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
@Table(name = "judge")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Judge.findAll", query = "SELECT j FROM Judge j"),
    @NamedQuery(name = "Judge.findById", query = "SELECT j FROM Judge j WHERE j.id = :id"),
    @NamedQuery(name = "Judge.findByName", query = "SELECT j FROM Judge j WHERE j.name = :name"),
    @NamedQuery(name = "Judge.findByStatus", query = "SELECT j FROM Judge j WHERE j.status = :status"),
    @NamedQuery(name = "Judge.findByLastUpdateDate", query = "SELECT j FROM Judge j WHERE j.lastUpdateDate = :lastUpdateDate")})
public class Judge implements Serializable {
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
    @JoinColumn(name = "judge_group_id", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private JudgeGroup judgeGroupId;

    public Judge() {
    }

    public Judge(Integer id) {
        this.id = id;
    }

    public Judge(Integer id, String name, String status, Date lastUpdateDate) {
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
        if (!(object instanceof Judge)) {
            return false;
        }
        Judge other = (Judge) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    public JudgeDTO getInstanceFromEO(){
        JudgeDTO dto = new JudgeDTO();
        dto.setId(this.id);
        dto.setName(this.name);
        dto.setStatus(this.status);
        dto.setLastUpdateDate(new Timestamp(this.lastUpdateDate.getTime()));
        dto.setJudgeGroupId(this.judgeGroupId.getId());
        return dto;
    }
    
    
    @Override
    public String toString() {
        return "com.pgj.core.service.entity.Judge[ id=" + id + " ]";
    }
    
}
