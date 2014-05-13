/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pgj.core.service.ejb;

import com.pgj.core.service.dto.CallTypeDTO;
import com.pgj.core.service.dto.DependenceDTO;
import com.pgj.core.service.dto.JudgeGroupDTO;
import com.pgj.core.service.dto.TownDTO;
import java.util.List;

/**
 *
 * @author pepgonalez
 */
public interface ProcessServiceEJBRemote {
    
    public static final String NAME = "ProcessServiceEJB";
    public static final String MAPPED_NAME = "ProcessServiceEJB#com.pgj.core.service.ejb.ProcessServiceEJBRemote";
 

    List<JudgeGroupDTO> findAllJudgeGroup();
    
    List<CallTypeDTO> getAllCallTypes();
    
    List<TownDTO> getTownList();
    
    List<DependenceDTO> getDependenceList();
}
