package com.hanulso.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.hanulso.domain.BoardAttachVo;

@Mapper
public interface BoardAttachMapper {

	public void insert(BoardAttachVo attach);

	public List<BoardAttachVo> findByBno(Long bno);

	public void deleteAll(Long bno);
}
