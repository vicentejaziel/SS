/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pgj.core.web.vo;

import com.pgj.core.service.dto.DiligenceDTO;
import com.pgj.core.service.dto.JudgeDTO;
import com.pgj.core.service.dto.ReportDTO;
import java.io.Serializable;

/**
 *
 * @author jgonzalez
 */
public class FullReportVO implements Serializable {
    
    private static final long serialVersionUID = 1L;
   
    private ReportDTO header = new ReportDTO();
    private JudgeDTO[] listOfJudges;
    private DiligenceDTO diligence = new DiligenceDTO();
    
    public FullReportVO(){ 
    }

    /**
     * @return the header
     */
    public ReportDTO getHeader() {
        return header;
    }

    /**
     * @param header the header to set
     */
    public void setHeader(ReportDTO header) {
        this.header = header;
    }

    /**
     * @return the listOfJudges
     */
    public JudgeDTO[] getListOfJudges() {
        return listOfJudges;
    }

    /**
     * @param listOfJudges the listOfJudges to set
     */
    public void setListOfJudges(JudgeDTO[] listOfJudges) {
        this.listOfJudges = listOfJudges;
    }

    /**
     * @return the diligence
     */
    public DiligenceDTO getDiligence() {
        return diligence;
    }

    /**
     * @param diligence the diligence to set
     */
    public void setDiligence(DiligenceDTO diligence) {
        this.diligence = diligence;
    }


    
}
