package com.hanulso.domain;

import java.time.LocalDate;

import lombok.Data;

@Data
public class CommentVo {
	private Long reply_bno;
	private Long board_bno;
	private String username;
	private String content;
	private LocalDate regdate;
}
