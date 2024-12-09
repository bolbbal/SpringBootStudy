package com.hanulso.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.hanulso.domain.CommentVo;

@Mapper
public interface CommentMapper {
	public Integer insertComment(CommentVo comment);

	public List<CommentVo> getComment(Long board_bno);
}
