/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.daycare.Controller;

import com.daycare.Interface.FindDaycareRepositoryInterface;
import com.daycare.Model.Daycare;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author preethi
 */
@Controller
@RequestMapping("/FindDaycare")
public class FindDaycareController {
     FindDaycareRepositoryInterface FindDaycareRepositoryInterface ;
     @Autowired
	public FindDaycareController(FindDaycareRepositoryInterface FindDaycareRepositoryInterface)
	{
		 this.FindDaycareRepositoryInterface = FindDaycareRepositoryInterface ;
	}
    
    
    @RequestMapping(method = RequestMethod.GET,params = { "state","City","userRating","StartDate","EndDate" } )	
    public  @ResponseBody List<Daycare> getSearchResult (@RequestParam("state") String state , @RequestParam("City") String City ,
            @RequestParam("userRating") int userRating,@RequestParam("StartDate") String StartDate,@RequestParam("EndDate") String EndDate)
	{
		return FindDaycareRepositoryInterface.getSearchResult(state,City,userRating,StartDate,EndDate) ;
		
	}
}
