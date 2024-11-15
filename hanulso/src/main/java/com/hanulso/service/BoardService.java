package com.hanulso.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hanulso.domain.BoardVo;
import com.hanulso.mapper.BoardMapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BoardService {

	private final BoardMapper mapper;
	
	@Transactional
	public void register(BoardVo board) {
		mapper.insertSelectKey(board);
	}
	
	@Transactional
	public List<BoardVo> getList() {
		return mapper.getList();
	}
	
	@Transactional
	public Integer getBoardCount() {
		return mapper.getBoardCount();
	}
	
	@Transactional
	public BoardVo getDetail(Long bno) {
		return mapper.getDetail(bno);
	}
	
	@Transactional
	public BoardVo getNext(Long bno) {
		return mapper.getNext(bno);
	}
	
	@Transactional
	public BoardVo getPrev(Long bno) {
		return mapper.getPrev(bno);
	}
	
	@Transactional
	public void deleteBoard(Long bno) {
		mapper.deleteBoard(bno);
	}
	
}
