package com.web.store.controller;

import java.text.SimpleDateFormat;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	@RequestMapping("/welcome")
	public String welcome(Model model) {
		model.addAttribute("title", "Welcome to KarpyShopping!");
		model.addAttribute("subtitle", "身寸ˋ惹");
		return "welcome";
	}

	@RequestMapping("/")
	public String index() {
		return "index";
	}

	@RequestMapping("/ch01/serverTime")
	public String serverTime(Model model) {
		model.addAttribute("now",
				new SimpleDateFormat("yyyy年MM月dd日HH時mm分ss秒SSS毫秒").format(new java.util.Date()) + ", Spring MVC版");
		return "ch01/serverTime";
	}

}
