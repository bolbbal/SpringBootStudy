package com.hanulso.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.hanulso.domain.BoardAttachVo;
import com.hanulso.domain.PresidentVo;

@Mapper
public interface BoardAttachMapper {

	public void insert(BoardAttachVo attach);

	public List<BoardAttachVo> findByBno(Long bno);

	public PresidentVo getPresident(Long bno);

}
