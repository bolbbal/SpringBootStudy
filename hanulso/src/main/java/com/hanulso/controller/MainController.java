package com.hanulso.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.hanulso.service.MainService;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Controller
@Log4j2
@RequiredArgsConstructor
public class MainController {

	private final MainService service;

	@GetMapping({ "/", "/main.do" })
	public String main(Model model) {
		model.addAttribute("mainList", service.getMain());
		log.info("index로 이동");
		return "index";
	}
}
