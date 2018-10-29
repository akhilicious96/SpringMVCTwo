package com.cg.springmvctwo.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.cg.springmvctwo.dto.Mobile;
import com.cg.springmvctwo.service.IMobileService;


@Controller
public class MobileSpring {
	
	@Autowired
	IMobileService mobileService;
	

	@RequestMapping(value = "/home")
	public String getAllMobile(@ModelAttribute("my") Mobile mob, Map<String, Object> model){
		
		List<String> myList = new ArrayList<>();
		myList.add("Android");
		myList.add("iPhone");
		myList.add("Windows");
		
		model.put("cato", myList);
		
		
		
		return "AddMobile";
	}
	
	@RequestMapping(value = "adddata", method = RequestMethod.POST)
	public String addMobileData(@Valid@ModelAttribute("my") Mobile mobile, BindingResult result, Map<String, Object> model){
		
		if(result.hasErrors()){
			
			List<String> myList = new ArrayList<>();
			myList.add("Android");
			myList.add("iPhone");
			myList.add("Windows");
			
			model.put("cato", myList);
			
			return "AddMobile";
		}
		mobileService.addMobile(mobile);		
		return "success";
	}
	
	@RequestMapping(value="showall", method = RequestMethod.GET)
	public ModelAndView showAlMobileData(){
		
		List<Mobile> allMobile = mobileService.showAll();
		return new ModelAndView("mobileshow", "data", allMobile);
		
	}
	
	
	@RequestMapping(value="searchmobile", method = RequestMethod.GET)
	public String searchData(@ModelAttribute("yy") Mobile mob){
		return "searchMobile";
		
	}
	
	@RequestMapping(value = "mobilesearch", method = RequestMethod.POST)
	public ModelAndView dataSearch(@ModelAttribute("yy") Mobile mob){
	
		Mobile mobSearch = mobileService.searchMobile(mob.getMobId());
		System.out.println(mobSearch);
		return new ModelAndView("showsearch", "temp",mobSearch);
		
	}
	
	@RequestMapping(value = "deleteMobile", method = RequestMethod.GET)
	public String deleteSearchMobileData(@ModelAttribute("dd") Mobile mob){
		
		return "delete";
	}
	
	@RequestMapping(value = "delete", method = RequestMethod.POST)
	public String deleteMobileData(@ModelAttribute("dd") Mobile mob){
		mobileService.deleteMobile(mob.getMobId());
		return "successdel";
	}
	
	@RequestMapping(value="updateMobile", method = RequestMethod.GET)
	public String updateMobile(@ModelAttribute("uu") Mobile mob){
		
		return "update";
	}
	
	@RequestMapping(value = "update", method = RequestMethod.POST)
	public String updateMobileData(@ModelAttribute("uu") Mobile mob){
		mobileService.updateMobile(mob.getMobId(), mob.getMobPrice());
		return "successupdate";
	}
}
