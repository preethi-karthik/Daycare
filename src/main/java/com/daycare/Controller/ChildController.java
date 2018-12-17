/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.daycare.Controller;

import com.daycare.Interface.ChildProfileRepositoryInterface;
import com.daycare.Model.ChildProfile;
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
@RequestMapping("/ChildProfile")
public class ChildController {

    ChildProfileRepositoryInterface childProfileRepositoryInterface;

    @Autowired  
	public ChildController(ChildProfileRepositoryInterface p)
	{
		 this.childProfileRepositoryInterface = p ;
	}

    @RequestMapping(method = RequestMethod.GET, params = {"childid"})
    public @ResponseBody
    ChildProfile getChildId(@RequestParam("childid") int childid) {
        return childProfileRepositoryInterface.getchildid(childid);

    }

}
