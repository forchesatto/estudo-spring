package br.com.camtwo.spring.jspjpa.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class IndexController {

	@RequestMapping("/index")
	@ResponseBody
	String home() {
		return "index";
	}
	
}
