package com.hanulso.controller;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.Principal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.hanulso.domain.BoardAttachVo;
import com.hanulso.domain.BoardVo;
import com.hanulso.domain.CommentVo;
import com.hanulso.service.BoardService;
import com.hanulso.util.Criteria;
import com.hanulso.util.FileUpload;
import com.hanulso.util.PageVo;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/port")
@RequiredArgsConstructor
public class BoardController {

	private final BoardService service;
	private final FileUpload fileUpload;

	@GetMapping("/write.do")
	// @PreAuthorize("hasRole('ADMIN') or hasRole('USER')")
	@PreAuthorize("isAuthenticated()")
	public String writeBoardForm() {
		return "/portfolio/write";
	}

	@PostMapping("/save.do")
	public String saveBoard(BoardVo board,
			@RequestParam("president") MultipartFile president,
			@RequestParam("uploadFile") MultipartFile[] uploadFile) {

		if (uploadFile != null || uploadFile[0].getSize() != 0) {
			List<BoardAttachVo> list = fileUpload.uploadFiles(president,
					uploadFile);

			board.setAttachList(list);
		}

		service.register(board);
		return "redirect:/port/list.do";
	}

	// @GetMapping("/list.do")
	// public String listBoard(Model model) {
	// List<BoardVo> list = service.getList();
	// Integer count = service.getBoardCount();
	//
	// model.addAttribute("list", list);
	// model.addAttribute("count", count);
	//
	// return "/portfolio/list";
	// }

	// 받은 값을 사용하지 않고 넘겨주는 용도로만 쓸 때는 매개변수로 (@ModelAttribute("속성명") 변수타입 변수명) 을 쓸
	// 수
	// 있다.

	@GetMapping("/list.do")
	public String listBoard(Criteria cri, Model model) {

		List<BoardVo> list = null;
		Integer count = 0;

		if (cri.getPageNum() == null) {
			cri.setPageNum(1);
		}
		if (cri.getAmount() == null) {
			cri.setAmount(5);
		}

		if (cri.getType() == null) {

			list = service.getList(cri);
			count = service.getBoardCount();

		} else if (cri.getType() != null) {

			list = service.getListPaging(cri);
			count = service.getBoardCountPaging(cri);
		}

		model.addAttribute("page", new PageVo(cri, count));
		model.addAttribute("list", list);
		model.addAttribute("count", count);

		return "/portfolio/list";
	}

	@GetMapping("/view.do")
	public String viewBoard(Long bno, Model model,
			Principal principal/* 로그인 정보 */) {

		BoardVo board = service.getDetail(bno);
		BoardVo next = service.getNext(bno);
		BoardVo prev = service.getPrev(bno);
		int comment_count = service.countComment(bno);

		model.addAttribute("view", board);
		model.addAttribute("next", next);
		model.addAttribute("prev", prev);
		model.addAttribute("commentCount", comment_count);

		if (principal != null) {
			model.addAttribute("username", principal.getName());
		}

		return "/portfolio/view";
	}

	@GetMapping("/modify.do")
	public String modifyView(Long bno, Model model) {

		model.addAttribute("board", service.getDetail(bno));

		return "/portfolio/modify";
	}

	@PostMapping("/modify.do")
	public String modifyBoard(BoardVo board,
			@RequestParam("president") MultipartFile president,
			@RequestParam("uploadFile") MultipartFile[] uploadFile) {

		if (!president.isEmpty() && !uploadFile[0].isEmpty()) {

			List<BoardAttachVo> dlist = service.findByBno(board.getBno());

			removeFile(dlist);

			List<BoardAttachVo> list = fileUpload.uploadFiles(president,
					uploadFile);

			board.setAttachList(list);
		}

		service.updateBoard(board);

		return "redirect:/port/list.do";
	}

	public void removeFile(List<BoardAttachVo> list) {
		if (list == null || list.size() == 0) {
			return;
		}
		list.forEach(attach -> {
			try {
				System.out.println("삭제");
				Path filename = Paths
						.get("C:\\upload\\" + attach.getUploadfile());
				System.out.println(filename);
				Files.deleteIfExists(filename);
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
	}

	@GetMapping("/delete.do")
	public String deleteBoard(Long bno, RedirectAttributes rttr) { // RedirectAttributes
																	// : 일회성 속성
																	// 지정

		List<BoardAttachVo> list = service.findByBno(bno);
		removeFile(list);

		if (service.deleteBoard(bno) == true) {

			rttr.addFlashAttribute("msg", "삭제완료");
			return "redirect:/port/list.do";

		} else {
			rttr.addFlashAttribute("msg", "삭제실패");
			return "redirect:/port/list.do";
		}
	}

	@PostMapping("/commentSave.do")
	public String commentSave(CommentVo comment) {
		service.insertComment(comment);

		return "redirect:/port/view.do?bno=" + comment.getBoard_bno();

	}

	@PostMapping("/commentModify.do")
	public String commentModify(@ModelAttribute CommentVo comment) {
		service.updateComment(comment);

		return "redirect:/port/view.do?bno=" + comment.getBoard_bno();
	}

	@PostMapping("/commentDelete.do")
	@ResponseBody
	public Map<String, Object> commentDelete(@RequestParam Long reply_bno, @RequestParam Long board_bno) {
	    service.deleteComment(reply_bno); // 댓글 삭제 처리
	    System.out.println(1);
	    Map<String, Object> response = new HashMap<>();
	    response.put("status", "success");
	    response.put("redirectUrl", "/port/view.do?bno=" + board_bno);
	    return response; // JSON 형태로 응답
	}


}
