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
public class ReportDTO implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    private Integer id;
    private Date date;
    private String time;
    private CallTypeDTO callType = new CallTypeDTO();
    private String eventTime;
    private JudgeGroupDTO group = new JudgeGroupDTO();
    private int noJudges;
    private String transportUnit;
    private String agency;
    private String amp;
    private String reportRelation;
    private String avNumber;
    private String isRelevant;
    private String evidenceContent;
    private int secundarySceneNo;
    private String isSuspects;
    private String status;
    private Date lastUpdateDate;

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
     * @return the date
     */
    public Date getDate() {
        return date;
    }

    /**
     * @param date the date to set
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * @return the time
     */
    public String getTime() {
        return time;
    }

    /**
     * @param time the time to set
     */
    public void setTime(String time) {
        this.time = time;
    }

    /**
     * @return the callType
     */
    public CallTypeDTO getCallType() {
        return callType;
    }

    /**
     * @param callType the callType to set
     */
    public void setCallType(CallTypeDTO callType) {
        this.callType = callType;
    }

    /**
     * @return the eventTime
     */
    public String getEventTime() {
        return eventTime;
    }

    /**
     * @param eventTime the eventTime to set
     */
    public void setEventTime(String eventTime) {
        this.eventTime = eventTime;
    }


    /**
     * @return the noJudges
     */
    public int getNoJudges() {
        return noJudges;
    }

    /**
     * @param noJudges the noJudges to set
     */
    public void setNoJudges(int noJudges) {
        this.noJudges = noJudges;
    }

    /**
     * @return the transportUnit
     */
    public String getTransportUnit() {
        return transportUnit;
    }

    /**
     * @param transportUnit the transportUnit to set
     */
    public void setTransportUnit(String transportUnit) {
        this.transportUnit = transportUnit;
    }

    /**
     * @return the agency
     */
    public String getAgency() {
        return agency;
    }

    /**
     * @param agency the agency to set
     */
    public void setAgency(String agency) {
        this.agency = agency;
    }

    /**
     * @return the amp
     */
    public String getAmp() {
        return amp;
    }

    /**
     * @param amp the amp to set
     */
    public void setAmp(String amp) {
        this.amp = amp;
    }

    /**
     * @return the reportRelation
     */
    public String getReportRelation() {
        return reportRelation;
    }

    /**
     * @param reportRelation the reportRelation to set
     */
    public void setReportRelation(String reportRelation) {
        this.reportRelation = reportRelation;
    }

    /**
     * @return the avNumber
     */
    public String getAvNumber() {
        return avNumber;
    }

    /**
     * @param avNumber the avNumber to set
     */
    public void setAvNumber(String avNumber) {
        this.avNumber = avNumber;
    }

    /**
     * @return the isRelevant
     */
    public String getIsRelevant() {
        return isRelevant;
    }

    /**
     * @param isRelevant the isRelevant to set
     */
    public void setIsRelevant(String isRelevant) {
        this.isRelevant = isRelevant;
    }

    /**
     * @return the evidenceContent
     */
    public String getEvidenceContent() {
        return evidenceContent;
    }

    /**
     * @param evidenceContent the evidenceContent to set
     */
    public void setEvidenceContent(String evidenceContent) {
        this.evidenceContent = evidenceContent;
    }

    /**
     * @return the secundarySceneNo
     */
    public int getSecundarySceneNo() {
        return secundarySceneNo;
    }

    /**
     * @param secundarySceneNo the secundarySceneNo to set
     */
    public void setSecundarySceneNo(int secundarySceneNo) {
        this.secundarySceneNo = secundarySceneNo;
    }

    /**
     * @return the isSuspects
     */
    public String getIsSuspects() {
        return isSuspects;
    }

    /**
     * @param isSuspects the isSuspects to set
     */
    public void setIsSuspects(String isSuspects) {
        this.isSuspects = isSuspects;
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
     * @return the group
     */
    public JudgeGroupDTO getGroup() {
        return group;
    }

    /**
     * @param group the group to set
     */
    public void setGroup(JudgeGroupDTO group) {
        this.group = group;
    }
    
    
}
