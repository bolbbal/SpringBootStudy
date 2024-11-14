package com.hanulso.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.hanulso.domain.BoardVo;

@Mapper
public interface BoardMapper {
	
	public Integer insertSelectKey(BoardVo board);
}
