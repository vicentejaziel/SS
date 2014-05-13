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
public class DependenceDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;
    private String name;
    private String streetAndNo;
    private String suburb;
    private String postalCode;
    private String betweenSt;
    private String latitude;
    private String longitude;
    private String cuadrant;
    private String status;
    private Date lastUpdateDate;
    private TownDTO town;

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
     * @return the streetAndNo
     */
    public String getStreetAndNo() {
        return streetAndNo;
    }

    /**
     * @param streetAndNo the streetAndNo to set
     */
    public void setStreetAndNo(String streetAndNo) {
        this.streetAndNo = streetAndNo;
    }

    /**
     * @return the suburb
     */
    public String getSuburb() {
        return suburb;
    }

    /**
     * @param suburb the suburb to set
     */
    public void setSuburb(String suburb) {
        this.suburb = suburb;
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
     * @return the longitude
     */
    public String getLongitude() {
        return longitude;
    }

    /**
     * @param longitude the longitude to set
     */
    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    /**
     * @return the cuadrant
     */
    public String getCuadrant() {
        return cuadrant;
    }

    /**
     * @param cuadrant the cuadrant to set
     */
    public void setCuadrant(String cuadrant) {
        this.cuadrant = cuadrant;
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
     * @return the town
     */
    public TownDTO getTown() {
        return town;
    }

    /**
     * @param town the town to set
     */
    public void setTown(TownDTO town) {
        this.town = town;
    }
}
