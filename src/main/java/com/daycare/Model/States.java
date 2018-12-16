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
public class States {
    
        
    private int stateid;
    private String Abbr;
    private String State ;
    

    /**
     * @return the stateid
     */
    public int getStateid() {
        return stateid;
    }

    /**
     * @param stateid the stateid to set
     */
    public void setStateid(int stateid) {
        this.stateid = stateid;
    }

    /**
     * @return the Abbr
     */
    public String getAbbr() {
        return Abbr;
    }

    /**
     * @param Abbr the Abbr to set
     */
    public void setAbbr(String Abbr) {
        this.Abbr = Abbr;
    }

    /**
     * @return the State
     */
    public String getState() {
        return State;
    }

    /**
     * @param State the State to set
     */
    public void setState(String State) {
        this.State = State;
    }

    
}
