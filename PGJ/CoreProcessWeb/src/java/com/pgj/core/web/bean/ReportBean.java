/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pgj.core.web.bean;

import com.pgj.commons.utils.Constants;
import com.pgj.core.service.dto.CallTypeDTO;
import com.pgj.core.service.dto.DependenceDTO;
import com.pgj.core.service.dto.JudgeDTO;
import com.pgj.core.service.dto.JudgeGroupDTO;
import com.pgj.core.service.dto.TownDTO;
import com.pgj.core.web.facade.ReportBeanFacade;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author pepgonalez
 */
@ManagedBean(name = "ReportBean")
@ViewScoped
public class ReportBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private BigDecimal reportId;
    private Date date;
    private String time;
    private String eventTime;
    private String transportUnit;

    //Tipo de llamada
    private Integer callType;
    private List<CallTypeDTO> callTypeList = new ArrayList<>();

    //GRUPO DE PERITOS SELECCIONADO
    private Integer grupo = 0;
    private List<JudgeGroupDTO> judgeGroupList = new ArrayList<>();

    //NUMERO DE PERITOS
    private Integer noJugdes = 0;
    private List<Integer> noJudgesList = new ArrayList<>();

    //LISTADO DE PERITOS
    private List<JudgeDTO> judgeList = new ArrayList<>();
    private JudgeDTO[] listOfJudges;

    // VALORES DE DILIGENCIA
    private List<DependenceDTO> dependenceList = new ArrayList<>();
    private Integer diligenceDep;

    private Integer townId;
    private List<TownDTO> townList = new ArrayList<>();

    private String streetNo;
    private String colony;
    private String postalCode;
    private String betweenSt;
    private String longitud;
    private String latitude;
    private String cuad;
    
    
    //VALORES DE CRIMEN
    private Integer crimeId;
    private Integer crimeCategoryId;
    private Integer cimeSubCategoryId;
    
    private String agency;
    private String amp;
    private String idRel;
    private String avNo;
    private boolean isRelevant;
    private boolean isEvidence;
    private boolean isSuspects;

    private final transient ReportBeanFacade facade;

    public ReportBean() {

        facade = new ReportBeanFacade();

        //Carga de Catalogos
        this.judgeGroupList = facade.findAllJudgeGroup();
        this.callTypeList = facade.getAllCallTypes();
        this.dependenceList = facade.getDependenceList();
        this.townList = facade.getTownList();
        this.noJudgesList = Constants.getNoList();

        //Asignacion de dependencia
        this.diligenceDep = this.dependenceList.get(0).getId();

    }

    public void updateGroup() {
        System.out.println("metodo update Gruop");
        System.out.println("grupo seleccionado: " + this.grupo);
        System.out.println("grupo seleccionado: " + this.noJugdes);
        System.out.println("Fin de metodo update group");
        if (this.grupo > 0) {
            for (JudgeGroupDTO element : this.judgeGroupList) {
                if (element.getId().intValue() == this.grupo) {
                    this.judgeList = element.getJudgeList();
                }
            }
        } else {
            this.judgeList = new ArrayList<>();
        }
    }

    public void updateNoJudges() {
        System.out.println("metodo update No Judges");
        System.out.println("grupo seleccionado: " + this.grupo);
        System.out.println("grupo seleccionado: " + this.noJugdes);
        System.out.println("Fin de metodo update No judges");
        if (this.noJugdes > 0) {
            this.listOfJudges = new JudgeDTO[this.noJugdes];
        }
    }

    public void updateDiligence() {
        System.out.println("Metodo update diligence");
        System.out.println("DiligenceDep: " + this.diligenceDep);
        DependenceDTO currentDep = null;
        for (DependenceDTO e : this.dependenceList) {
            if (this.diligenceDep == e.getId().intValue()) {
                System.out.println("Dependencia encontrada...");
                currentDep = e;
                break;
            }
        }
        if (currentDep != null) {
            System.out.println("Copiando valores...");
            this.streetNo = currentDep.getStreetAndNo();
            this.colony = currentDep.getSuburb();
            if (currentDep.getTown() != null){
                this.townId = currentDep.getTown().getId();
            }else{
                this.townId = -1;
            }
            this.postalCode = currentDep.getPostalCode();
            this.betweenSt = currentDep.getBetweenSt();
            this.latitude = currentDep.getLatitude();
            this.longitud = currentDep.getLongitude();
            this.cuad = currentDep.getCuadrant();
        }
    }

    /**
     * @return the reportId
     */
    public BigDecimal getReportId() {
        return reportId;
    }

    /**
     * @param reportId the reportId to set
     */
    public void setReportId(BigDecimal reportId) {
        this.reportId = reportId;
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
     * @return the noJugdes
     */
    public int getNoJugdes() {
        return noJugdes;
    }

    /**
     * @param noJugdes the noJugdes to set
     */
    public void setNoJugdes(int noJugdes) {
        this.noJugdes = noJugdes;
    }

    /**
     * @return the streetNo
     */
    public String getStreetNo() {
        return streetNo;
    }

    /**
     * @param streetNo the streetNo to set
     */
    public void setStreetNo(String streetNo) {
        this.streetNo = streetNo;
    }

    /**
     * @return the colony
     */
    public String getColony() {
        return colony;
    }

    /**
     * @param colony the colony to set
     */
    public void setColony(String colony) {
        this.colony = colony;
    }

    /**
     * @return the postalCode
     */
    public String getPostalCode() {
        return postalCode;
    }

    /**
     * @param postalCode the postalCode to set
     */
    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    /**
     * @return the betweenSt
     */
    public String getBetweenSt() {
        return betweenSt;
    }

    /**
     * @param betweenSt the betweenSt to set
     */
    public void setBetweenSt(String betweenSt) {
        this.betweenSt = betweenSt;
    }

    /**
     * @return the longitud
     */
    public String getLongitud() {
        return longitud;
    }

    /**
     * @param longitud the longitud to set
     */
    public void setLongitud(String longitud) {
        this.longitud = longitud;
    }

    /**
     * @return the latitude
     */
    public String getLatitude() {
        return latitude;
    }

    /**
     * @param latitude the latitude to set
     */
    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    /**
     * @return the cuad
     */
    public String getCuad() {
        return cuad;
    }

    /**
     * @param cuad the cuad to set
     */
    public void setCuad(String cuad) {
        this.cuad = cuad;
    }

    /**
     * @return the judgeGroupList
     */
    public List<JudgeGroupDTO> getJudgeGroupList() {
        return judgeGroupList;
    }

    /**
     * @param judgeGroupList the judgeGroupList to set
     */
    public void setJudgeGroupList(List<JudgeGroupDTO> judgeGroupList) {
        this.judgeGroupList = judgeGroupList;
    }

    /**
     * @return the noJudgesList
     */
    public List<Integer> getNoJudgesList() {
        return noJudgesList;
    }

    /**
     * @param noJudgesList the noJudgesList to set
     */
    public void setNoJudgesList(List<Integer> noJudgesList) {
        this.noJudgesList = noJudgesList;
    }

    /**
     * @return the grupo
     */
    public Integer getGrupo() {
        return grupo;
    }

    /**
     * @param grupo the grupo to set
     */
    public void setGrupo(Integer grupo) {
        this.grupo = grupo;
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
     * @return the callType
     */
    public Integer getCallType() {
        return callType;
    }

    /**
     * @param callType the callType to set
     */
    public void setCallType(Integer callType) {
        this.callType = callType;
    }

    /**
     * @return the callTypeList
     */
    public List<CallTypeDTO> getCallTypeList() {
        return callTypeList;
    }

    /**
     * @param callTypeList the callTypeList to set
     */
    public void setCallTypeList(List<CallTypeDTO> callTypeList) {
        this.callTypeList = callTypeList;
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
     * @return the dependenceList
     */
    public List<DependenceDTO> getDependenceList() {
        return dependenceList;
    }

    /**
     * @param dependenceList the dependenceList to set
     */
    public void setDependenceList(List<DependenceDTO> dependenceList) {
        this.dependenceList = dependenceList;
    }

    /**
     * @return the townId
     */
    public Integer getTownId() {
        return townId;
    }

    /**
     * @param townId the townId to set
     */
    public void setTownId(Integer townId) {
        this.townId = townId;
    }

    /**
     * @return the townList
     */
    public List<TownDTO> getTownList() {
        return townList;
    }

    /**
     * @param townList the townList to set
     */
    public void setTownList(List<TownDTO> townList) {
        this.townList = townList;
    }

    /**
     * @return the diligenceDep
     */
    public Integer getDiligenceDep() {
        return diligenceDep;
    }

    /**
     * @param diligenceDep the diligenceDep to set
     */
    public void setDiligenceDep(Integer diligenceDep) {
        this.diligenceDep = diligenceDep;
    }

    /**
     * @return the crimeId
     */
    public Integer getCrimeId() {
        return crimeId;
    }

    /**
     * @param crimeId the crimeId to set
     */
    public void setCrimeId(Integer crimeId) {
        this.crimeId = crimeId;
    }

    /**
     * @return the crimeCategoryId
     */
    public Integer getCrimeCategoryId() {
        return crimeCategoryId;
    }

    /**
     * @param crimeCategoryId the crimeCategoryId to set
     */
    public void setCrimeCategoryId(Integer crimeCategoryId) {
        this.crimeCategoryId = crimeCategoryId;
    }

    /**
     * @return the cimeSubCategoryId
     */
    public Integer getCimeSubCategoryId() {
        return cimeSubCategoryId;
    }

    /**
     * @param cimeSubCategoryId the cimeSubCategoryId to set
     */
    public void setCimeSubCategoryId(Integer cimeSubCategoryId) {
        this.cimeSubCategoryId = cimeSubCategoryId;
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
     * @return the idRel
     */
    public String getIdRel() {
        return idRel;
    }

    /**
     * @param idRel the idRel to set
     */
    public void setIdRel(String idRel) {
        this.idRel = idRel;
    }

    /**
     * @return the avNo
     */
    public String getAvNo() {
        return avNo;
    }

    /**
     * @param avNo the avNo to set
     */
    public void setAvNo(String avNo) {
        this.avNo = avNo;
    }

    /**
     * @return the isRelevant
     */
    public boolean isIsRelevant() {
        return isRelevant;
    }

    /**
     * @param isRelevant the isRelevant to set
     */
    public void setIsRelevant(boolean isRelevant) {
        this.isRelevant = isRelevant;
    }

    /**
     * @return the isEvidence
     */
    public boolean isIsEvidence() {
        return isEvidence;
    }

    /**
     * @param isEvidence the isEvidence to set
     */
    public void setIsEvidence(boolean isEvidence) {
        this.isEvidence = isEvidence;
    }

    /**
     * @return the isSuspects
     */
    public boolean isIsSuspects() {
        return isSuspects;
    }

    /**
     * @param isSuspects the isSuspects to set
     */
    public void setIsSuspects(boolean isSuspects) {
        this.isSuspects = isSuspects;
    }
}
