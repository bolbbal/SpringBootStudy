package com.hanulso.sample;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.hanulso.mapper.SampleMapper;

@SpringBootTest
public class SampleTest {

	@Autowired
	private SampleMapper mapper; //자동주입
	
	@Test
	public void testGetTime1() {
		System.out.println(mapper.getTime1());
	}
	
	@Test
	public void testGetTime2() {
		System.out.println(mapper.getTime2());
	}
	
}
