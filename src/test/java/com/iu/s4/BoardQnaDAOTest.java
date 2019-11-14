package com.iu.s4;

import static org.junit.Assert.*;

import javax.inject.Inject;

import org.junit.Test;

import com.iu.s4.dao.BoardQnaDAO;
import com.iu.s4.model.BoardQnaVO;
import com.iu.s4.model.BoardVO;

public class BoardQnaDAOTest {
	@Inject
	private BoardQnaDAO boardQnaDAO;
	//@Test
	public void qnaUpdate() throws Exception {
		BoardVO boardVO = new BoardVO();
		boardVO.setNum(234);
		boardVO.setTitle("Test");
		boardVO.setContents("Contents");
		boardVO.setWriter("Writer");
		int result = boardQnaDAO.boardUpdate(boardVO);
		assertEquals(1, result);
	}
	@Test
	public void qnaReply() throws Exception{
		BoardQnaVO boardQnaVO = new BoardQnaVO();
		boardQnaVO.setTitle("Test");
		boardQnaVO.setContents("Contents");
		boardQnaVO.setWriter("Writer");
		int result = boardQnaDAO.boardReply(boardQnaVO);
		assertEquals(1, result);
	}

}
