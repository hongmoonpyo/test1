package com.spring.client.reply.vo;

public class ReplyVO {
	private int r_num =0;//댓글번호
	private int b_num =0;//게시판 글번호
	private String r_name="";//댓글 작성자
	private String r_content="";//댓글 내용
	private String r_date ="";//댓글 작성일
	private String	 r_pwd =""; //댓글 비밀번호
	public int getR_num() {
		return r_num;
	}
	public void setR_num(int r_num) {
		this.r_num = r_num;
	}
	public int getB_num() {
		return b_num;
	}
	public void setB_num(int b_num) {
		this.b_num = b_num;
	}
	public String getR_name() {
		return r_name;
	}
	public void setR_name(String r_name) {
		this.r_name = r_name;
	}
	public String getR_content() {
		return r_content;
	}
	public void setR_content(String r_content) {
		this.r_content = r_content;
	}
	public String getR_date() {
		return r_date;
	}
	public void setR_date(String r_date) {
		this.r_date = r_date;
	}
	public String getR_pwd() {
		return r_pwd;
	}
	public void setR_pwd(String r_pwd) {
		this.r_pwd = r_pwd;
	}
	
	
}
