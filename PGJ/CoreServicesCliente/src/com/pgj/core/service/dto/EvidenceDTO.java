/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pgj.core.service.dto;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author jgonzalez
 */
public class EvidenceDTO implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    private Integer id;

    private String name;
    private String description;
    private int creationDate;
    private String isProcesed;
    private String result;
    private String status;
    private Date lastUpdateDate;
    private LabDTO lab;
    private Integer reportId;
    
    private boolean isProc;
    
    public EvidenceDTO(){
        
    }

    /**
     * @return the id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return the creationDate
     */
    public int getCreationDate() {
        return creationDate;
    }

    /**
     * @param creationDate the creationDate to set
     */
    public void setCreationDate(int creationDate) {
        this.creationDate = creationDate;
    }

    /**
     * @return the isProcesed
     */
    public String getIsProcesed() {
        return isProcesed;
    }

    /**
     * @param isProcesed the isProcesed to set
     */
    public void setIsProcesed(String isProcesed) {
        this.isProcesed = isProcesed;
    }

    /**
     * @return the result
     */
    public String getResult() {
        return result;
    }

    /**
     * @param result the result to set
     */
    public void setResult(String result) {
        this.result = result;
    }

    /**
     * @return the status
     */
    public String getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * @return the lastUpdateDate
     */
    public Date getLastUpdateDate() {
        return lastUpdateDate;
    }

    /**
     * @param lastUpdateDate the lastUpdateDate to set
     */
    public void setLastUpdateDate(Date lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
    }

    /**
     * @return the labId
     */
    public LabDTO getLab() {
        return lab;
    }

    /**
     * @param labId the labId to set
     */
    public void setLab(LabDTO lab) {
        this.lab = lab;
    }

    /**
     * @return the reportId
     */
    public Integer getReportId() {
        return reportId;
    }

    /**
     * @param reportId the reportId to set
     */
    public void setReportId(Integer reportId) {
        this.reportId = reportId;
    }

    /**
     * @return the isProc
     */
    public boolean isIsProc() {
        return isProc;
    }

    /**
     * @param isProc the isProc to set
     */
    public void setIsProc(boolean isProc) {
        this.isProc = isProc;
    }
    
}
