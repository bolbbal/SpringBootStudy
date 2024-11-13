package com.hanulso.controller.copy;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.extern.log4j.Log4j2;

@Controller
@Log4j2
public class MainController {

	@GetMapping({"/", "/main.do"})
	public String main() {
		log.info("index로 이동");
		return "index";
	}
}
