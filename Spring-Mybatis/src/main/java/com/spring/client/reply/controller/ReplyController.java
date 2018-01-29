package com.spring.client.reply.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.spring.client.reply.service.ReplyService;
import com.spring.client.reply.vo.ReplyVO;

/****************************************
 * 참고 : @RestController (@Controller + @ResponesBody) 기존의 특정한 JSP와 같은 뷰를 만들어 내는
 * 것이 목적이 아닌 REST 방식의 데이터 처리를 위해서 사용하는 (데이터 자체를 반환) 어노테이션이다.
 ****************************************/

@RestController
@RequestMapping(value = "/replies")
public class ReplyController {
	Logger logger = Logger.getLogger(ReplyController.class);

	@Autowired
	private ReplyService replyService;

	/****************************************
	 * 댓글 글목록 구현하기
	 * 
	 * @return List<ReplyVO> 참고 : @PathVariable는 URI의 경로에서 원하는 데이터를 추출하는 용도의 어노테이션.
	 *         현재 요청 URL : http://localgost:8080/replies/all/게시판글번호.do 예전 요청 URL :
	 *         http://localgost:8080/replies/replyList.do?b_num=게시판글번호
	 ****************************************/
	@RequestMapping(value = "/all/{b_num}.do", method = RequestMethod.GET)
	public ResponseEntity<List<ReplyVO>> list(@PathVariable("b_num") Integer b_num) {

		ResponseEntity<List<ReplyVO>> entity = null;
		try {
			entity = new ResponseEntity<List<ReplyVO>>(replyService.replyList(b_num), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<List<ReplyVO>>(HttpStatus.BAD_REQUEST);
		}
		return entity;
	}

	/****************************************
	 * 댓글 글쓰기 구현하기
	 * 
	 * @return String 참고 : @RequestBody
	 ****************************************/
	@RequestMapping(value = "/replyInsert")
	public ResponseEntity<String> replyInsert(@RequestBody ReplyVO rvo) {
		logger.info("replyInsert 호출 성공");
		ResponseEntity<String> entity = null;
		int result;
		try {
			result = replyService.replyInsert(rvo);
			if (result == 1) {
				entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
			}
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		return entity;
	}
	/****************************************
	 * 댓글 비밀번호 확인 구현하기
	 * 
	 * @return String 참고 : @RequestBody
	 ****************************************/
	@RequestMapping(value="/pwdConfirm.do")
	public ResponseEntity<Integer> pwdConfirm(@ModelAttribute ReplyVO rvo){
		logger.info("pwdConfirm 호출 성공");
		ResponseEntity<Integer> entity = null;
		int result = 0;
		try {
			result = replyService.pwdConfirm(rvo);
			entity = new ResponseEntity<Integer>(result,HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<Integer>(result, HttpStatus.BAD_REQUEST);
		}
		return entity;
		
	}
	/****************************************
	 * 댓글 수정 구현하기
	 * @return 
	 * 참고 : REST 방식에서 UPDATE 작업은 PUT,PATCH방식을 이용해서 처리.
	 * 전체 데이터를 수정하는 경우에는 PUT을 이용하고,
	 * 일부의 데이터를 수정하는 경우에는 PATCH를 이용.
	 ****************************************/
	@RequestMapping(value="/{r_num}.do",method= {RequestMethod.PUT,RequestMethod.PATCH})
	public ResponseEntity<String> replyUpdate(@PathVariable("r_num") Integer r_num, @RequestBody ReplyVO rvo){
		logger.info("replyUpdate 호출 성공");
		ResponseEntity<String> entity = null;
		try {
			rvo.setR_num(r_num);
			replyService.replyUpdate(rvo);
			entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		return entity;
		
	}
	/****************************************
	 * 댓글 삭제 구현하기
	 * @return 
	 * 참고 : REST 방식에서 DELETE 작업은 DELETE방식을 이용해서 처리.
	 ****************************************/
	@RequestMapping(value="/{r_num}.do",method= RequestMethod.DELETE)
	public ResponseEntity<String> replyDelete(@PathVariable("r_num") Integer r_num){
		logger.info("replyDelete 호출 성공");
		ResponseEntity<String> entity = null;
		try {
			replyService.replyDelete(r_num);
			entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		return entity;
		
	}
}
