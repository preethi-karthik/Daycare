/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.daycare.Model;

import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author preethi
 */
public class ChildProfile {

    private int childId;
    private String childFirstName;
    private String childLastName;
    private String childMiddleName;
    private String childGender;
    private int childAge;
    private String childDateOfBirth;
    private String BloodGroup;
    private ArrayList<String> Allergies;


    /**
     * @return the childId
     */
    public int getChildId() {
        return childId;
    }

    /**
     * @param childId the childId to set
     */
    public void setChildId(int childId) {
        this.childId = childId;
    }

    /**
     * @return the childFirstName
     */
    public String getChildFirstName() {
        return childFirstName;
    }

    /**
     * @param childFirstName the childFirstName to set
     */
    public void setChildFirstName(String childFirstName) {
        this.childFirstName = childFirstName;
    }

    /**
     * @return the childLastName
     */
    public String getChildLastName() {
        return childLastName;
    }

    /**
     * @param childLastName the childLastName to set
     */
    public void setChildLastName(String childLastName) {
        this.childLastName = childLastName;
    }

    /**
     * @return the childMiddleName
     */
    public String getChildMiddleName() {
        return childMiddleName;
    }

    /**
     * @param childMiddleName the childMiddleName to set
     */
    public void setChildMiddleName(String childMiddleName) {
        this.childMiddleName = childMiddleName;
    }

    /**
     * @return the childGender
     */
    public String getChildGender() {
        return childGender;
    }

    /**
     * @param childGender the childGender to set
     */
    public void setChildGender(String childGender) {
        this.childGender = childGender;
    }

    /**
     * @return the childAge
     */
    public int getChildAge() {
        return childAge;
    }

    /**
     * @param childAge the childAge to set
     */
    public void setChildAge(int childAge) {
        this.childAge = childAge;
    }

    /**
     * @return the childDateOfBirth
     */
    public String getChildDateOfBirth() {
        return childDateOfBirth;
    }

    /**
     * @param childDateOfBirth the childDateOfBirth to set
     */
    public void setChildDateOfBirth(String childDateOfBirth) {
        this.childDateOfBirth = childDateOfBirth;
    }

    /**
     * @return the BloodGroup
     */
    public String getBloodGroup() {
        return BloodGroup;
    }

    /**
     * @param BloodGroup the BloodGroup to set
     */
    public void setBloodGroup(String BloodGroup) {
        this.BloodGroup = BloodGroup;
    }

    /**
     * @return the Allergies
     */
    public ArrayList<String> getAllergies() {
        return Allergies;
    }

    /**
     * @param Allergies the Allergies to set
     */
    public void setAllergies(ArrayList<String> Allergies) {
        this.Allergies = Allergies;
    }

}
