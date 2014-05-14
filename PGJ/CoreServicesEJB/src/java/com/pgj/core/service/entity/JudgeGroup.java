/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pgj.core.service.entity;

import com.pgj.core.service.dto.JudgeDTO;
import com.pgj.core.service.dto.JudgeGroupDTO;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;
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
@Table(name = "judge_group")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "JudgeGroup.findAll", query = "SELECT j FROM JudgeGroup j"),
    @NamedQuery(name = "JudgeGroup.findById", query = "SELECT j FROM JudgeGroup j WHERE j.id = :id"),
    @NamedQuery(name = "JudgeGroup.findByName", query = "SELECT j FROM JudgeGroup j WHERE j.name = :name"),
    @NamedQuery(name = "JudgeGroup.findByDescription", query = "SELECT j FROM JudgeGroup j WHERE j.description = :description"),
    @NamedQuery(name = "JudgeGroup.findByStatus", query = "SELECT j FROM JudgeGroup j WHERE j.status = :status"),
    @NamedQuery(name = "JudgeGroup.findByLastUpdateDate", query = "SELECT j FROM JudgeGroup j WHERE j.lastUpdateDate = :lastUpdateDate")})
public class JudgeGroup implements Serializable {
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "judgeGroupId")
    private List<Report> reportList;

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
    @Size(max = 250)
    @Column(name = "description")
    private String description;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "judgeGroupId", fetch = FetchType.LAZY)
    private List<Judge> judgeList;

    public JudgeGroup() {
    }

    public JudgeGroup(Integer id) {
        this.id = id;
    }

    public JudgeGroup(Integer id, String name, String status, Date lastUpdateDate) {
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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
    public List<Judge> getJudgeList() {
        return judgeList;
    }

    public void setJudgeList(List<Judge> judgeList) {
        this.judgeList = judgeList;
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
        if (!(object instanceof JudgeGroup)) {
            return false;
        }
        JudgeGroup other = (JudgeGroup) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    public JudgeGroupDTO getInstanceFromEO() {
        JudgeGroupDTO dto = new JudgeGroupDTO();
        dto.setId(this.id);
        dto.setName(this.name);
        dto.setDescription(this.description);
        dto.setStatus(this.status);
        dto.setLastUpdateDate(new Timestamp(this.lastUpdateDate.getTime()));

        List<JudgeDTO> judgeList = new ArrayList<JudgeDTO>();
        for (Judge e : this.judgeList) {
            judgeList.add(e.getInstanceFromEO());
        }
        dto.setJudgeList(judgeList);

        return dto;

    }

    @Override
    public String toString() {
        return "com.pgj.core.service.entity.JudgeGroup[ id=" + id + " ]";
    }

    @XmlTransient
    public List<Report> getReportList() {
        return reportList;
    }

    public void setReportList(List<Report> reportList) {
        this.reportList = reportList;
    }

}
