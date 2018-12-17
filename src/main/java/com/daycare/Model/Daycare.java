/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.daycare.Model;

/**
 *
 * @author preethi
 */
public class Daycare {

    /**
     * @return the Address
     */
    public String getAddress() {
        return Address;
    }

    /**
     * @param Address the Address to set
     */
    public void setAddress(String Address) {
        this.Address = Address;
    }

    /**
     * @return the zipcode
     */
    public String getZipcode() {
        return zipcode;
    }

    /**
     * @param zipcode the zipcode to set
     */
    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    /**
     * @return the availableSeats
     */
    public int getAvailableSeats() {
        return availableSeats;
    }

    /**
     * @param availableSeats the availableSeats to set
     */
    public void setAvailableSeats(int availableSeats) {
        this.availableSeats = availableSeats;
    }

    /**
     * @return the costperday
     */
    public Float getCostperday() {
        return costperday;
    }

    /**
     * @param costperday the costperday to set
     */
    public void setCostperday(Float costperday) {
        this.costperday = costperday;
    }

    /**
     * @return the Date
     */
    public String getDate() {
        return Date;
    }

    /**
     * @param Date the Date to set
     */
    public void setDate(String Date) {
        this.Date = Date;
    }

    /**
     * @return the daycareId
     */
    public int getDaycareId() {
        return daycareId;
    }

    /**
     * @param daycareId the daycareId to set
     */
    public void setDaycareId(int daycareId) {
        this.daycareId = daycareId;
    }

    /**
     * @return the daycareName
     */
    public String getDaycareName() {
        return daycareName;
    }

    /**
     * @param daycareName the daycareName to set
     */
    public void setDaycareName(String daycareName) {
        this.daycareName = daycareName;
    }
    
    private int daycareId;
    private String daycareName;
    private String Address;
    private String zipcode;
    private int availableSeats;
    private Float costperday;
    private String Date ; 
    
}
