package com.hanulso.controller;

import java.util.ArrayList;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.hanulso.domain.SampleDto;

import jakarta.servlet.annotation.MultipartConfig;
import lombok.extern.log4j.Log4j2;

@Controller
@Log4j2
@RequestMapping("/sample/*")
public class SampleController {

	//localhost:8099/sample/basic
	@RequestMapping("/basic")
	public void basic() {
		log.info("basic");
	}
	
	//localhost:8099/sample/ex01?name=aaa&age=11
	@GetMapping("/ex01")
	public void getEx01(SampleDto dto) {
		System.out.println(dto.getName());
		System.out.println(dto.getAge());
	}
	
	@GetMapping("/ex02")
	public String getEx02(@RequestParam("name") String name, @RequestParam("age") int age) {
		System.out.println(name);
		System.out.println(age);
		
		return null;
	}
	
	//list
	//localhost:8099/sample/ex03?ids=111&ids=222&ids=333
	@GetMapping("/ex03")
	public String getEx03(@RequestParam("ids") ArrayList<String> ids) {
		
		for (String id : ids) {
			System.out.println(id);
		}
		
		return "redirect:/";
	}
	
	@GetMapping("/ex04")
	public String getEx04(SampleDto dto) {
		log.info(dto.getName());
		log.info(dto.getAge());
		log.info(dto.getRegdate());
		
		return "redirect:/";
		
	}
	
	//jsp 
	//request.setAttribute("list", list);
	//request.getRequestDispater(path).forward(request, response);
	
	//String Boot
	//Model
	@GetMapping("/ex05")
	public void getEx05(SampleDto  dto, int page, Model model) {
		
		model.addAttribute("dto", dto);
		model.addAttribute("page", page);
		
		//return "/sample/ex05";
	}
	
	//json
	@GetMapping("/ex06")
	public @ResponseBody SampleDto getEx06() {
		
		SampleDto dto = new SampleDto();
		
		dto.setName("우민규");
		dto.setAge(27);
		
		return dto;
	}
	
	//json타입 이라는 헤더 메시지와 200 ok 라는 상태코드 전송
	@GetMapping("/ex07")
	public ResponseEntity<String> getEx07() {
		
		String msg = "{\"name\":\"우민규\"}";
		HttpHeaders header = new HttpHeaders();
		header.add("Content-type", "application/json;charset=utf-8");
		
		return new ResponseEntity<>(msg, header, HttpStatus.OK);
	}
	
	//file
	@GetMapping("/upload")
	public String getUploadForm() {
		return "/sample/upload";
	}
	
	@PostMapping("/ex08")
	public void getEx08(ArrayList<MultipartFile> files) {
		files.forEach(file -> { //lamda
			System.out.println("name : " + file.getOriginalFilename());
			System.out.println("size : " + file.getSize());
		});
	}
}
