package com.hanulso.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hanulso.domain.BoardAttachVo;
import com.hanulso.domain.BoardVo;
import com.hanulso.mapper.BoardAttachMapper;
import com.hanulso.mapper.BoardMapper;
import com.hanulso.util.Criteria;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BoardService {

	private final BoardMapper mapper;
	private final BoardAttachMapper attachMapper;

	@Transactional
	public void register(BoardVo board) {

		mapper.insertSelectKey(board);

		if (board.getAttachList() == null || board.getAttachList().size() <= 0) {
			return;
		} else {
			board.getAttachList().forEach(attach -> {
				attach.setBno(board.getBno());
				attachMapper.insert(attach);
			});
		}

	}

	public List<BoardVo> getList(Criteria cri) {

		List<BoardVo> list = mapper.getList(cri);

		for (BoardVo board : list) {
			List<BoardAttachVo> attachList = attachMapper.findByBno(board.getBno());

			board.setAttachList(attachList);
		}

		return list;
	}

	public List<BoardVo> getListPaging(Criteria cri) {
		return mapper.getListPaging(cri);
	}

	public int getBoardCount() {
		return mapper.getBoardCount();
	}

	public int getBoardCountPaging(Criteria cri) {
		return mapper.getBoardCountPaging(cri);
	}

	public BoardVo getDetail(Long bno) {
		List<BoardAttachVo> list = attachMapper.findByBno(bno);

		BoardVo board = mapper.getDetail(bno);

		board.setAttachList(list);

		return board;
	}

	public BoardVo getNext(Long bno) {
		return mapper.getNext(bno);
	}

	public BoardVo getPrev(Long bno) {
		return mapper.getPrev(bno);
	}

	public void updateBoard(BoardVo board) {

		boolean result = mapper.updateBoard(board) >= 1;

		if (result && !(board.getAttachList() == null)) {

			attachMapper.deleteAll(board.getBno());

			board.getAttachList().forEach(attach -> {
				attach.setBno(board.getBno());
				attachMapper.insert(attach);
			});
		}
	}

	public boolean deleteBoard(Long bno) {

		boolean result = false;

		if (mapper.deleteBoard(bno) > 0) {
			result = true;
		}

		return result;
	}

	public List<BoardAttachVo> findByBno(Long bno) {
		return attachMapper.findByBno(bno);
	}

}
