package br.com.camtwo.spring.jspjpa.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

	@RequestMapping("/")
	String home() {
		return "index";
	}
	
}
