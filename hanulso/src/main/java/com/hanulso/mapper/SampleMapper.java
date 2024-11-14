package com.hanulso.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper //sql과 그에 대한 처리 지정
public interface SampleMapper {
	
	@Select("select sysdate from dual")
	public String getTime1();
	
	public String getTime2();
}
