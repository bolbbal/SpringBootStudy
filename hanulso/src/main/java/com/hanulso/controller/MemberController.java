package com.hanulso.controller;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hanulso.domain.MemberVo;
import com.hanulso.service.MemberDetailService;
import com.hanulso.service.MemberService;
import com.hanulso.util.MailSenderRunner;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("/mem")
public class MemberController {

	private final MailSenderRunner mailSenderRunner;
	private final MemberService service;
	private final MemberDetailService detail;

	@GetMapping("/terms.do")
	public String memberForm() {
		return "/member/mailsend";
	}

	String checkIncode = "";

	@PostMapping("/mail.do")
	@ResponseBody
	public String mailSend(@RequestParam("email") String email) {

		checkIncode = mailSenderRunner.sendMail(email);

		return checkIncode;

	}

	@PostMapping("/sign.do")
	public String signForm(@RequestParam String authtication, HttpSession session) {

		if (checkIncode.equals(authtication)) {
			session.setAttribute("authenticated", true);
			return "redirect:/mem/member.do";
		} else {
			checkIncode = "";
			session.setAttribute("authenticated", false);
			return "redirect:/mem/terms.do";
		}
	}

	@GetMapping("/member.do")
	public String form(HttpSession session) {
		Boolean isAuthenticated = (Boolean) session.getAttribute("authenticated");
		if (isAuthenticated != null && isAuthenticated) {
			return "/member/member";
		} else
			return "redirect:/mem/terms.do";
	}

	@PostMapping("/idcheck.do")
	@ResponseBody
	public int usernameCheck(@RequestParam final String username) {

		return service.usernameCheck(username);
	}

	@PostMapping("/access.do")
	@ResponseBody
	public String signUp(MemberVo member) {

		service.insertMember(member);

		return "회원가입 완료";
	}
	
	@GetMapping("/login")
	public String loginForm() {
		return "/member/login";
	}
	
//	@PostMapping("/loginCheck.do") //jsp 방식
//	public String loginCheck(MemberVo insertMember, Model model, HttpServletRequest request) {
//		
//		MemberVo resultMember = service.loginCheck(insertMember.getUsername(), insertMember.getPassword());
//		
//		if(resultMember == null) {
//			return "redirect:/mem/login";
//		}
//		
//		HttpSession session = request.getSession();
//		session.setAttribute("member", resultMember);
//		
//		return "redirect:/";
//	}
	
//	@PostMapping("/loginCheck.do") //jsp 방식
//	public String loginCheck(MemberVo insertMember) {
//		
//		UserDetails user = detail.loadUserByUsername(insertMember.getUsername());
//		
//		
//		
//		return "redirect:/";
//	}
}
