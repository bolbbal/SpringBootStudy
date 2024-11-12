package com.hanulso.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hanulso.domain.SampleDto;

@Controller
@RequestMapping("/sample/*")
public class SampleController {

	@RequestMapping("/basic")
	public void basic() {
		System.out.println("basic method call");
	}
	
	@GetMapping("/getCount")
	public void getBasic() {
		System.out.println("getMapping call");
	}
	
	@GetMapping("/ex01")
	public void getEx01(SampleDto dto) {
		System.out.println(dto.getName());
		System.out.println(dto.getAge());
	}
}
