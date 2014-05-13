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
import com.pgj.core.service.entity.CallTypeEO;
import com.pgj.core.service.entity.Dependence;
import com.pgj.core.service.entity.JudgeGroup;
import com.pgj.core.service.entity.Town;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author pepgonalez
 */
@Stateless(name = ProcessServiceEJBRemote.NAME, mappedName = ProcessServiceEJBRemote.MAPPED_NAME)
@Remote(ProcessServiceEJBRemote.class)
public class ProcessServiceEJB implements ProcessServiceEJBRemote {

    @PersistenceContext(name = "CoreServicesEJBPU")
    private EntityManager em;
    
    @Override
    public List<JudgeGroupDTO> findAllJudgeGroup() {
        System.out.println("Inicio de proceso de obtencion de grupo");
        
        List<JudgeGroupDTO> finalList = new ArrayList<>();    
        List<JudgeGroup> resList = em.createNamedQuery("JudgeGroup.findAll")
                .getResultList();
 
        for (JudgeGroup e : resList){
            finalList.add(e.getInstanceFromEO());
        } 
        System.out.println("Fin de la operacion, total de elementos encontrados: " + finalList.size());
        return finalList;
    }

    @Override
    public List<CallTypeDTO> getAllCallTypes() {
        List<CallTypeEO> list = em.createNamedQuery("CallTypeEO.findAll").getResultList();
        List<CallTypeDTO> resList = new ArrayList<>();
        for(CallTypeEO element : list){
            resList.add(element.getDTOFromInstance());
        }
        return resList;
    }

    @Override
    public List<TownDTO> getTownList() {
        List<Town> townList = em.createNamedQuery("Town.findAll").getResultList();
        List<TownDTO> resList = new ArrayList<>();
        for(Town element : townList){
            resList.add(element.getDTOFromInstance());
        }
        return resList;
    }

    @Override
    public List<DependenceDTO> getDependenceList() {
        List<DependenceDTO> resList = new ArrayList<>();
        List<Dependence> dependenceList = em.createNamedQuery("Dependence.findAll").getResultList();
        
        for (Dependence element : dependenceList){
            resList.add(element.getDTOFromInstance());
        }
        
        return resList;
    }
    
}
