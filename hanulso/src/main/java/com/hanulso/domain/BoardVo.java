package com.hanulso.domain;

import java.time.LocalDate;
import java.util.List;

import lombok.Data;

@Data
public class BoardVo {

	private long bno;
	private String title;
	private String content;
	private String writer;
	private LocalDate regdate;
	private LocalDate updatedate;

	private List<BoardAttachVo> attachList;
	private PresidentVo president;
}
