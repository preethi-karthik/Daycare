/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.daycare.Controller;
import com.daycare.Interface.ProfileRepositoryInterface;
import com.daycare.Model.Profile;
import com.daycare.Repository.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author preethi
 */

@RequestMapping("/Profile")

public class ProfileController {
  
    
    ProfileRepositoryInterface profileRepositoryInterface ;
      @RequestMapping(method = RequestMethod.GET,params = { "RecipeId" } )
	 @ResponseBody
    public Profile getUserId (@RequestParam("userid") int userid )
	{
		return profileRepositoryInterface.getuserid(userid) ;
		
	}
    
}
