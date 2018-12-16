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
    
}
