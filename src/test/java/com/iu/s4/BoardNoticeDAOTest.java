package com.iu.s4;

import static org.junit.Assert.*;

import javax.inject.Inject;

import org.junit.Test;

import com.iu.s4.dao.BoardNoticeDAO;
import com.iu.s4.model.BoardVO;

public class BoardNoticeDAOTest extends TestAbstractCase{
	
	@Inject
	private BoardNoticeDAO boardNoticeDAO;
	//@Test
	public void boardWriteTest() throws Exception{
		BoardVO boardVO = new BoardVO();
		boardVO.setTitle("test2");
		boardVO.setWriter("test2");
		boardVO.setContents("contents2");
		int result = boardNoticeDAO.boardWrite(boardVO);
		assertEquals(1, result);
	}
	//@Test
	public void boardSelectTest() throws Exception{
		BoardVO boardVO = new BoardVO();
		boardVO.setNum(500);
		BoardVO boardVO2 = boardNoticeDAO.boardSelect(boardVO);
		assertNotNull(boardVO2);
	}
	@Test
	public void DeleteTest() throws Exception{
		BoardVO boardVO = new BoardVO();
		boardVO.setNum(535);
		int result = boardNoticeDAO.boardDelete(boardVO);
		assertEquals(1, result);
	}
	@Test
	public void boardUpdateTest() throws Exception {
		BoardVO boardVO = new BoardVO();
		boardVO.setNum(533);
		boardVO.setTitle("Test");
		boardVO.setContents("Contents");
		boardVO.setWriter("Writer");
		int result = boardNoticeDAO.boardUpdate(boardVO);
		assertEquals(1, result);
	}

}
