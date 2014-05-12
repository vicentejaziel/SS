/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pgj.core.service.dto;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

/**
 *
 * @author pepgonalez
 */
public class JudgeGroupDTO implements Serializable {
    
    private static final long serialVersionUID = 1L;
   
    private Integer id;
    private String name;
    private String description;
    private String status;
    private Timestamp lastUpdateDate;
    private List<JudgeDTO> judgeList;
    
    public JudgeGroupDTO(){
        
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
    public Timestamp getLastUpdateDate() {
        return lastUpdateDate;
    }

    /**
     * @param lastUpdateDate the lastUpdateDate to set
     */
    public void setLastUpdateDate(Timestamp lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
    }

    /**
     * @return the judgeList
     */
    public List<JudgeDTO> getJudgeList() {
        return judgeList;
    }

    /**
     * @param judgeList the judgeList to set
     */
    public void setJudgeList(List<JudgeDTO> judgeList) {
        this.judgeList = judgeList;
    }
    
    
    
}
