package com.hanulso.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.hanulso.domain.BoardVo;
import com.hanulso.service.BoardService;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/port")
@RequiredArgsConstructor
public class BoardController {

	private final BoardService service;
	
	@GetMapping("/write.do")
	public String writeBoardForm() {
		return "/portfolio/write";
	}
	
	@PostMapping("/save.do")
	public String saveBoard(BoardVo board) {
		service.register(board);
		return "redirect:/port/list.do";
	}
	
	@GetMapping("/list.do")
	public String listBoard(Model model) {
		List<BoardVo> list = service.getList();
		Integer count = service.getBoardCount();
		
		model.addAttribute("list", list);
		model.addAttribute("count", count);
		
		return "/portfolio/list";
	}
	
	@GetMapping("/view.do")
	public String viewBoard(Long bno, Model model) {
		
		BoardVo board = service.getDetail(bno);
		BoardVo next = service.getNext(bno);
		BoardVo prev = service.getPrev(bno);
		
		model.addAttribute("view", board);
		model.addAttribute("next", next);
		model.addAttribute("prev", prev);

		return "/portfolio/view";
	}
	
	@GetMapping("/delete.do")
	public String deleteBoard(Long bno) {
		
		service.deleteBoard(bno);
		
		return "redirect:/port/list.do";
	}
	
}
