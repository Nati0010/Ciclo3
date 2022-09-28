package com.misiontic.celuplanet.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;
import com.misiontic.celuplanet.models.cellphoneDTOrequest;
import com.misiontic.celuplanet.services.interfaces.IcellphoneService;

@Controller



public class cellphonesController {
	
	@Autowired
	private IcellphoneService cellphoneService;
	
	@GetMapping({
		"/celulares"
	})
	
	public String celulares(Model model){
		model.addAttribute("celulares", cellphoneService.getCells());
		return "celulares";
	}
	
	@GetMapping({
		"/",
		""
	})
	
	public String home(){
		return "index";
	}
	
	@GetMapping({
		"/create-cellphone"
	})
	public String createCellponeView() {
		return "create-cellphone";
	}
	
	@PostMapping({
		"/api/create-cellphone"
		
	})
	public RedirectView createCellphoneDB(@ModelAttribute cellphoneDTOrequest cell ) {
		try {
			cellphoneService.saveCellphone(cell);
		} catch (Exception e) {
			System.out.println(e);
			return new RedirectView("/");
		}
		return new RedirectView("/");
	}
}
