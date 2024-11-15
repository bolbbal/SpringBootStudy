package com.hanulso.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.hanulso.domain.BoardVo;

@Mapper
public interface BoardMapper {
	
	public Integer insertSelectKey(BoardVo board);
	
	public List<BoardVo> getList();
	public Integer getBoardCount();
	
	public BoardVo getDetail(Long bno);
	public BoardVo getNext(Long bno);
	public BoardVo getPrev(Long bno);
	
	public Integer deleteBoard(Long bno);
}
