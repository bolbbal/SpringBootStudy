package com.hanulso.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.hanulso.domain.BoardAttachVo;

@Mapper
public interface BoardAttachMapper {
	
	public void insert(BoardAttachVo attach);
}
