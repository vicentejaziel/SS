/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pgj.core.web.bean;

import com.pgj.core.service.dto.EvidenceDTO;
import com.pgj.core.service.dto.LabDTO;
import com.pgj.core.web.facade.ReportBeanFacade;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 *
 * @author jgonzalez
 */
@ManagedBean(name = "EvBean")
@ViewScoped
public class EvBean implements Serializable {

    private static final Log logger = LogFactory.getLog(EvBean.class);
    
    private static final long serialVersionUID = 1L;
    
    private EvidenceDTO[] evidenceList;
    
    private List<EvidenceDTO> list = new ArrayList<EvidenceDTO>();
    
    private List<LabDTO> labList = new ArrayList<LabDTO>();
    
    public EvBean(){
        
        logger.debug("Registro debug");
        logger.info("Registro info");
        logger.error("Registro error");
        logger.fatal("Registro fatal");
        logger.warn("Registro warning");
        
        ReportBeanFacade facade = new ReportBeanFacade();
        labList = facade.getLabList();
        
        this.list.add(new EvidenceDTO());
    }
    
    
    public void addEvidence(){
        logger.info("Agregando Registro...");
//        List<EvidenceDTO> evList = new ArrayList<>();
//        evList.addAll(Arrays.asList(evidenceList));
//        evList.add(new EvidenceDTO());
//        this.evidenceList = evList.toArray(new EvidenceDTO[evList.size()]);
//        System.out.println("Elementos en lista: " + this.evidenceList.length);
        this.list.add(new EvidenceDTO());
        System.out.println("Elemento actuales: " + this.list.size());
    }
    

    /**
     * @return the evidenceList
     */
    public EvidenceDTO[] getEvidenceList() {
        return evidenceList;
    }

    /**
     * @param evidenceList the evidenceList to set
     */
    public void setEvidenceList(EvidenceDTO[] evidenceList) {
        this.evidenceList = evidenceList;
    }

    /**
     * @return the list
     */
    public List<EvidenceDTO> getList() {
        return list;
    }

    /**
     * @param list the list to set
     */
    public void setList(List<EvidenceDTO> list) {
        this.list = list;
    }

    /**
     * @return the labList
     */
    public List<LabDTO> getLabList() {
        return labList;
    }

    /**
     * @param labList the labList to set
     */
    public void setLabList(List<LabDTO> labList) {
        this.labList = labList;
    }
    
}
