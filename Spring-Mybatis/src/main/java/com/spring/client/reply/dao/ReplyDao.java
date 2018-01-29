package com.spring.client.reply.dao;

import java.util.List;

import com.spring.client.reply.vo.ReplyVO;

public interface ReplyDao {
	public List<ReplyVO> replyList(Integer b_num);
	public int replyInsert(ReplyVO rvo);
	public int pwdConfirm(ReplyVO rvo);
	public int replyUpdate(ReplyVO rvo);
	public int replyDelete(int r_num);
}
