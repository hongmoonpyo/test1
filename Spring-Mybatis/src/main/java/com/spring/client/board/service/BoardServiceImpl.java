package com.spring.client.board.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.client.board.dao.BoardDao;
import com.spring.client.board.vo.BoardVO;

@Service
@Transactional
public class BoardServiceImpl implements BoardService {
	Logger logger = Logger.getLogger(BoardServiceImpl.class);

	@Autowired
	private BoardDao boardDao;

	// 글목록 구현
	@Override
	public List<BoardVO> boardList(BoardVO bvo) {
		List<BoardVO> myList = null;

		// 정렬에 대한 기본값 설정
		if (bvo.getOrder_by() == null) {
			bvo.setOrder_by("b_num");
		}
		if (bvo.getOrder_sc() == null) {
			bvo.setOrder_sc("DESC");
		}

		myList = boardDao.boardList(bvo);
		return myList;
	}

	// 전체 레코드 수 구현
	@Override
	public int boardListCnt(BoardVO bvo) {
		return boardDao.boardListCnt(bvo);
	}

	// 글입력 구현
	@Override
	public int boardInsert(BoardVO bvo) {
		int result = 0;
		try {
			result = boardDao.boardInsert(bvo);
		} catch (Exception e) {
			e.printStackTrace();
			result = 0;
		}

		return result;
	}

	// 글상세 구현
	@Override
	public BoardVO boardDetail(BoardVO bvo) {
		BoardVO detail = null;
		detail = boardDao.boardDetail(bvo);
		return detail;
	}

	// 비밀번호 확인 구현
	@Override
	public int pwdConfirm(BoardVO bvo) {
		int result = 0;
		result = boardDao.pwdConfirm(bvo);
		return result;
	}

	// 글수정 구현
	@Override
	public int boardUpdate(BoardVO bvo) {
		int result = 0;
		try {
			result = boardDao.boardUpdate(bvo);
		} catch (Exception e) {
			e.printStackTrace();
			result = 0;
		}

		return result;
	}

	// 글 삭제 구현
	@Override
	public int boardDelete(int b_num) {
		int result = 0;
		try {
			result = boardDao.boardDelete(b_num);
		} catch (Exception e) {
			e.printStackTrace();
			result = 0;
		}

		return result;
	}

}
