/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.daycare.Controller;
import com.daycare.Model.Daycare;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping("/Daycare")
/**
 *
 * @author preethi
 */
public class DaycareController {
        @RequestMapping(method = RequestMethod.GET)
	public @ResponseBody ArrayList<Daycare> getAllCategories()
	{
		return new ArrayList<Daycare>();
		
	}
}
