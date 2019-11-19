package com.iu.s4.service;

import java.io.File;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;

import com.iu.s4.dao.BoardNoticeDAO;
import com.iu.s4.model.BoardVO;
import com.iu.s4.util.FileSaver;
import com.iu.s4.util.Pager;
@Service
public class BoardNoticeService implements BoardService {
	@Inject
	private BoardNoticeDAO boardNoticeDAO;
	
	@Override
	public List<BoardVO> boardList(Pager pager) throws Exception {
		pager.makeRow();
		pager.makePage(boardNoticeDAO.boardCount(pager));
		return boardNoticeDAO.boardList(pager);
	}

	@Override
	public BoardVO boardSelect(BoardVO boardVO) throws Exception {
		// TODO Auto-generated method stub
		return boardNoticeDAO.boardSelect(boardVO);
	}

	@Override
	public int boardWrite(BoardVO boardVO, HttpSession session) throws Exception {
		String realPath = session.getServletContext().getRealPath("resources/upload/board");
		System.out.println(realPath);
		File file = new File(realPath);
		if(!file.exists()) {
			file.mkdirs();
		}
		FileSaver fs = new FileSaver();
		String fileName = fs.save2(realPath, boardVO.getFile());
		System.out.println(fileName);
		boardVO.setFileName(fileName);
		boardVO.setOriginalName(boardVO.getFile().getOriginalFilename());
		
		System.out.println("testfn:"+boardVO.getFileName());
		System.out.println("testf:"+boardVO.getFile());
		System.out.println("teston:"+boardVO.getOriginalName());
		return boardNoticeDAO.boardWrite(boardVO);
	}

	@Override
	public int boardUpdate(BoardVO boardVO) throws Exception {
		// TODO Auto-generated method stub
		return boardNoticeDAO.boardUpdate(boardVO);
	}

	@Override
	public int boardDelete(BoardVO boardVO) throws Exception {
		// TODO Auto-generated method stub
		return boardNoticeDAO.boardDelete(boardVO);
	}
	

}
