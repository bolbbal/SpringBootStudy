package com.hanulso.domain;

import java.util.Date;
import java.util.List;

import lombok.Data;

@Data
public class BoardVo {
	
	private long bno;
	private String title;
	private String content;
	private String writer;
	private Date regdate;
	private Date updatedate;
	
	private List<BoardAttachVo> attachList;
}
