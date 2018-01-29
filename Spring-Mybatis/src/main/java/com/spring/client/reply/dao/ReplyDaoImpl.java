package com.spring.client.reply.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.client.reply.vo.ReplyVO;

@Repository
public class ReplyDaoImpl implements ReplyDao {

	@Autowired
	private SqlSession session;
	
	//글목록 구현
	@Override
	public List<ReplyVO> replyList(Integer b_num) {
		return session.selectList("replyList",b_num);
	}
	//글입력 구현
	@Override
	public int replyInsert(ReplyVO rvo) {
		return session.insert("replyInsert");
	}
	//비밀번호 구현
	@Override
	public int pwdConfirm(ReplyVO rvo) {
		return (Integer) session.selectOne("pwdConfirm");
	}
	//글수정 구현
	@Override
	public int replyUpdate(ReplyVO rvo) {
		return session.update("replyUpdate");
	}
	//글삭제 구현
	@Override
	public int replyDelete(int r_num) {
		return session.delete("replyDelete",r_num);
	}
 
}
