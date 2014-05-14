/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pgj.core.web.facade;

import com.pgj.core.service.dto.CallTypeDTO;
import com.pgj.core.service.dto.DependenceDTO;
import com.pgj.core.service.dto.JudgeGroupDTO;
import com.pgj.core.service.dto.LabDTO;
import com.pgj.core.service.dto.TownDTO;
import com.pgj.core.service.ejb.ProcessServiceEJBRemote;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author pepgonalez
 */
public class ReportBeanFacade implements ProcessServiceEJBRemote {

    ProcessServiceEJBRemote processEJB;

    public ReportBeanFacade() {

        try {
            Context c = new InitialContext();
            processEJB = (ProcessServiceEJBRemote) c.lookup(ProcessServiceEJBRemote.MAPPED_NAME);
                    
        } catch (NamingException ex) {
            Logger.getLogger(ReportBeanFacade.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public List<JudgeGroupDTO> findAllJudgeGroup() {
        return this.processEJB.findAllJudgeGroup();
    }

    @Override
    public List<CallTypeDTO> getAllCallTypes() {
        return this.processEJB.getAllCallTypes();
    }

    @Override
    public List<TownDTO> getTownList() {
        return this.processEJB.getTownList();
    }

    @Override
    public List<DependenceDTO> getDependenceList() {
        return this.processEJB.getDependenceList();
    }

    @Override
    public List<LabDTO> getLabList() {
        return this.processEJB.getLabList();
    }

}
