package com.hanulso.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.hanulso.domain.MemberVo;

@Mapper
public interface MemberMapper {

	public int countByUsername(final String username);

	public void insertMember(MemberVo member);

	public MemberVo loginCheck(String username);
}
