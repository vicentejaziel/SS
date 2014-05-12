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
 * @author pepgonalez
 */
public class JudgeDTO implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    
    private Integer id;
    
    private String name;
    
    private String status;
    
    private Date lastUpdateDate;
   
    private Integer judgeGroupId;
    
    public JudgeDTO(){
        
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
     * @return the judgeGroupId
     */
    public Integer getJudgeGroupId() {
        return judgeGroupId;
    }

    /**
     * @param judgeGroupId the judgeGroupId to set
     */
    public void setJudgeGroupId(Integer judgeGroupId) {
        this.judgeGroupId = judgeGroupId;
    }


    
}
