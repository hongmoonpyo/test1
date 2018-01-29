package com.spring.client.board.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.client.board.vo.BoardVO;

@Repository
public class BoardDaoImpl implements BoardDao {
	@Autowired
	private SqlSession session;

	// 글목록 구현
	@Override
	public List<BoardVO> boardList(BoardVO bvo) {
		/*return session.selectList("boardList", bvo);*/
		return session.selectList("boardList");
	}

	// 전체 레코드 건수 구현
	@Override
	public int boardListCnt(BoardVO bvo) {
		return (Integer) session.selectOne("boardListCnt");
	}

	// 글상세 구현
	@Override
	public BoardVO boardDetail(BoardVO bvo) {
		return (BoardVO) session.selectOne("boardDetail", bvo);
	}

	// 글입력 구현
	@Override
	public int boardInsert(BoardVO bvo) {
		return session.insert("boardInsert", bvo);
	}

	// 비밀번호 확인 구현
	@Override
	public int pwdConfirm(BoardVO bvo) {
		return (Integer) session.selectOne("pwdConfirm", bvo);
	}

	// 글수정 구현
	@Override
	public int boardUpdate(BoardVO bvo) {
		return session.update("boardUpdate", bvo);
	}

	// 글삭제 구현
	@Override
	public int boardDelete(int b_num) {
		return session.delete("boardDelete", b_num);
	}

}
