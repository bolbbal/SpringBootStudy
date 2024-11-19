package com.hanulso.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.hanulso.domain.BoardVo;
import com.hanulso.service.BoardService;
import com.hanulso.util.Criteria;
import com.hanulso.util.PageVo;

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
	
//	@GetMapping("/list.do")
//	public String listBoard(Model model) {
//		List<BoardVo> list = service.getList();
//		Integer count = service.getBoardCount();
//		
//		model.addAttribute("list", list);
//		model.addAttribute("count", count);
//		
//		return "/portfolio/list";
//	}
	
	@GetMapping("/list.do")
	public String listBoard(Criteria cri, Model model) {
		
		List<BoardVo> list = service.getListPaging(cri);
		Integer count = 0;
		
		if(cri.getPageNum() == null) {			
			cri.setPageNum(1);
		}
		if(cri.getAmount() == null) {
			cri.setAmount(10);
		}
		
		
		if(cri.getType() != null) {
			
			count = service.getBoardCountPaging(cri);
			
		} else if (cri.getType() == null) {
			
			count = service.getBoardCount();
		}
		
		model.addAttribute("page", new PageVo(cri, count));
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
	
	@GetMapping("/modify.do")
	public String modifyView(Long bno, Model model) {
		
		model.addAttribute("board", service.getDetail(bno));
		
		return "/portfolio/modify";
	}
	
	@PostMapping("/modify.do")
	public String modifyBoard(BoardVo board) {
		
		service.updateBoard(board);
		
		return "redirect:/port/list.do";
	}
	
	@GetMapping("/delete.do")
	public String deleteBoard(Long bno, RedirectAttributes rttr) { //RedirectAttributes : 일회성 속성 지정
		
		if(service.deleteBoard(bno) == true) {
			
			rttr.addFlashAttribute("msg", "삭제완료");
			return "redirect:/port/list.do";
			
		} else {
			rttr.addFlashAttribute("msg", "삭제실패");
			return "redirect:/port/list.do";
		}
	}
	
}
