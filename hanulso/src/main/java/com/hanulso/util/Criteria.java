package com.hanulso.util;

public class Criteria {
	private Integer pageNum; //페이지 번호
	private Integer amount = 10; //1페이지에 출력할 레코드 개수
	private String type; //검색조건 title, content
	private String keyword; //검색 키워드
	
	public Criteria() {
		this(1);
	}
	
	public Criteria(Integer pageNum) {
		this.pageNum = pageNum;
	}
	
	public Criteria(Integer pageNum, int amount) {
		this.pageNum = pageNum;
		this.amount = amount;
	}
	
	public Integer getPageNum() {
		return pageNum;
	}
	public void setPageNum(Integer pageNum) {
		this.pageNum = pageNum;
	}
	public Integer getAmount() {
		return amount;
	}
	public void setAmount(Integer amount) {
		this.amount = amount;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
}
