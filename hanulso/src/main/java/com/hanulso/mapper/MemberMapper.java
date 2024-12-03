package com.hanulso.mapper;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberMapper {

	public int countByUsername(final String username);

}
