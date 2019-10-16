package com.review.wiki;

public class ReviewsVO {
	private String seq;
    private String contents;
    
    
	public ReviewsVO(String seq, String contents) {
		super();
		this.seq = seq;
		this.contents = contents;
	}
	
	public String getSeq() {
		return seq;
	}
	public void setSeq(String seq) {
		this.seq = seq;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
    
    
}
