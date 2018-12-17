/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.daycare.Interface;

import com.daycare.Model.Daycare;

import java.util.List;

/**
 *
 * @author preethi
 */
public interface FindDaycareRepositoryInterface {

    public List<Daycare> getSearchResult(String state, String City, int userRating, String StartDate, String EndDate);
    public List<Daycare> getSearchResult(String state, String City, int userRating);
}
