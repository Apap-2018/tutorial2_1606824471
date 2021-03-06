package com.example.demo.controller;

import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PageController {
	@RequestMapping("/viral")
	public String index() {
		return "viral";
	}
	
	@RequestMapping("/challenge")
	public String challenge(@RequestParam(value = "name") String name, Model model) {
		model.addAttribute("name", name);
		return "challenge";
	}
	
//	@RequestMapping("/challenge/{name}")
//	public String challengePath(@PathVariable String name, Model model) {
//		model.addAttribute("name", name);
//		return "challenge";
//	}
	
	@RequestMapping(value= {"/challenge","challenge/{name}"})
	public String challengePath(@PathVariable Optional<String> name, Model model) {
		if (name.isPresent()) {
			model.addAttribute("name", name.get());
		} else {
			model.addAttribute("name", "KB");
		}
		return "challenge";
	}
	
	@RequestMapping("/generator")
	public String viralGenerator(@RequestParam(value = "a", defaultValue="0") int a, 
								@RequestParam(value = "b", defaultValue="0") int b, 
								Model model) {
		
		String hmfinal = "";
		String hm = "";
		model.addAttribute("a", a);
		model.addAttribute("b", b);
		
		if ((a!=0 || a!=1) && (b!=0 || b!=1)) {
			hm="hm";
			for (int i=1; i<a; i++) {
				hm = hm+"m";
			}
			
			hmfinal = hm;
			for (int ii=1; ii<b; ii++) {
				hmfinal = hmfinal +" "+hm;
			}
		} else {
			hmfinal = "hm";
		}
		model.addAttribute("hm", hmfinal);
		return "viralgenerator";
	
	}
}
