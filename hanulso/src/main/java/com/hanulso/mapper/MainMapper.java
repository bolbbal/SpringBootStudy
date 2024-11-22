package com.hanulso.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.hanulso.domain.BoardAttachVo;
import com.hanulso.domain.BoardVo;

@Mapper
public interface MainMapper {

	public List<BoardVo> getList();

	public List<BoardAttachVo> findByBno(Long bno);

}
