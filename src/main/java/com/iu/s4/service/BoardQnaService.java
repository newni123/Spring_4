package com.iu.s4.service;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.iu.s4.dao.BoardQnaDAO;
import com.iu.s4.dao.QnaFilesDAO;
import com.iu.s4.model.BoardQnaVO;
import com.iu.s4.model.BoardVO;
import com.iu.s4.model.QnaFilesVO;
import com.iu.s4.util.FileSaver;
import com.iu.s4.util.Pager;

@Service
public class BoardQnaService implements BoardService {
	@Inject
	private BoardQnaDAO boardQnaDAO;
	@Inject
	private FileSaver fileSaver;
	@Inject
	private QnaFilesDAO qnaFilesDAO;

	public int boardReply(BoardVO boardVO) throws Exception {
		int result = boardQnaDAO.boardReplyUpdate(boardVO);
		/*int result = boardQnaDAO.boardReplyUpdate(parent);
		parent.setTitle(boardVO.getTitle());
		parent.setWriter(boardVO.getWriter());
		parent.setContents(boardVO.getContents());
		parent.setStep(parent.getStep() + 1);
		parent.setDepth(parent.getDepth() + 1);*/
		return boardQnaDAO.boardReply(boardVO);

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
		/*boardVO = boardQnaDAO.boardSelect(boardVO);
		BoardQnaVO boardQnaVO = (BoardQnaVO)boardVO;
		List<QnaFilesVO> qnaFilesVOs = qnaFilesDAO.fileList(boardVO.getNum());
		boardQnaVO.setFiles(qnaFilesVOs);*/
		return boardQnaDAO.boardSelect(boardVO);
	}

	@Override
	public int boardWrite(BoardVO boardVO,MultipartFile[] file,HttpSession session) throws Exception {
		// TODO Auto-generated method stub
		String realPath = session.getServletContext().getRealPath("resources/upload/qna");
		QnaFilesVO qnaFilesVO = new QnaFilesVO();
		int result = boardQnaDAO.boardWrite(boardVO); // 작성될 글의 num을 받아와 files테이블에 넣기 위함
		qnaFilesVO.setNum(boardVO.getNum());
		for(MultipartFile multipartFile: file) {
			String fileName = fileSaver.save(realPath, multipartFile);
			qnaFilesVO.setFname(fileName);
			qnaFilesVO.setOname(multipartFile.getOriginalFilename());
			qnaFilesDAO.fileWrite(qnaFilesVO);
		}
		return result;
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
