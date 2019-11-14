package com.iu.s4.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.iu.s4.dao.BoardQnaDAO;
import com.iu.s4.model.BoardQnaVO;
import com.iu.s4.model.BoardVO;
import com.iu.s4.util.Pager;

@Service
public class BoardQnaService implements BoardService {
	@Inject
	private BoardQnaDAO boardQnaDAO;

	public int boardReply(BoardVO boardVO) throws Exception {
		BoardQnaVO parent = (BoardQnaVO) boardQnaDAO.boardSelect(boardVO);
		int result = boardQnaDAO.boardReplyUpdate(parent);
		parent.setTitle(boardVO.getTitle());
		parent.setWriter(boardVO.getWriter());
		parent.setContents(boardVO.getContents());
		parent.setStep(parent.getStep() + 1);
		parent.setDepth(parent.getDepth() + 1);
		return boardQnaDAO.boardReply(parent);

	}

	@Override
	public List<BoardVO> boardList(Pager pager) throws Exception {
		pager.makeRow();
		pager.makePage(boardQnaDAO.boardCount(pager));
		return boardQnaDAO.boardList(pager);
	}

	@Override
	public BoardVO boardSelect(BoardVO boardVO) throws Exception {
		// TODO Auto-generated method stub
		return boardQnaDAO.boardSelect(boardVO);
	}

	@Override
	public int boardWrite(BoardVO boardVO) throws Exception {
		// TODO Auto-generated method stub
		return boardQnaDAO.boardWrite(boardVO);
	}

	@Override
	public int boardUpdate(BoardVO boardVO) throws Exception {
		// TODO Auto-generated method stub
		return boardQnaDAO.boardUpdate(boardVO);
	}

	@Override
	public int boardDelete(BoardVO boardVO) throws Exception {
		// TODO Auto-generated method stub
		return boardQnaDAO.boardDelete(boardVO);
	}

}
