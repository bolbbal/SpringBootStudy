package com.hanulso.util;

public class PageVo {
	
	private int startPage;
	private int endPage;
	private boolean prev, next;
	private int total; 
	private Criteria cri; //pageNum, amount, type, keyword
	private int realEnd;
	
	public PageVo(Criteria cri, int total) {
		
		this.cri = cri;
		this.total = total;
		this.endPage = (int) Math.ceil(cri.getPageNum()/10.0) * 5;
		this.startPage = endPage - 4;
		
		this.realEnd = (int) (Math.ceil((total*1.0) / cri.getAmount()));
		
		if(realEnd < this.endPage) {
			endPage = realEnd;
		}
		
		this.prev = this.startPage > 1;
		
		this.next = this.endPage < realEnd;
	}

	public int getRealEnd() {
		return realEnd;
	}

	public void setRealEnd(int realEnd) {
		this.realEnd = realEnd;
	}

	public int getStartPage() {
		return startPage;
	}

	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}

	public int getEndPage() {
		return endPage;
	}

	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}

	public boolean isPrev() {
		return prev;
	}

	public void setPrev(boolean prev) {
		this.prev = prev;
	}

	public boolean isNext() {
		return next;
	}

	public void setNext(boolean next) {
		this.next = next;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public Criteria getCri() {
		return cri;
	}

	public void setCri(Criteria cri) {
		this.cri = cri;
	}
	
	
	
}
