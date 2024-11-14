package com.hanulso.board;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.hanulso.domain.BoardVo;
import com.hanulso.mapper.BoardMapper;

@SpringBootTest
public class BoardTest {

	@Autowired
	private BoardMapper mapper;
	
	@Test
	public void insertTest() {
		
		BoardVo board = new BoardVo();
		
		board.setTitle("우민규");
		board.setContent("같은 악성 페까를 친구로 두는게 맞을까요?");
		board.setWriter("ㅇㅇ(223.62)");
		
		mapper.insertSelectKey(board);
		System.out.println(board);
	}
}
