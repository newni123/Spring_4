package com.iu.s4.service;

import java.sql.SQLException;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.iu.s4.dao.BoardNoticeDAO;
import com.iu.s4.dao.NoticeFilesDAO;
import com.iu.s4.model.BoardVO;
import com.iu.s4.model.NoticeFilesVO;
import com.iu.s4.util.FileSaver;
import com.iu.s4.util.Pager;

@Service
public class BoardNoticeService implements BoardService {
	@Inject
	private BoardNoticeDAO boardNoticeDAO;
	@Inject
	private FileSaver fileSaver;
	@Inject
	private NoticeFilesDAO noticeFilesDAO;
	// @Inject private HttpSession session;
	private Object fileName;

	public boolean summerFileDelete(String file, HttpSession session) throws Exception {
		String realPath = session.getServletContext().getRealPath("resources/upload/summerFile");
		return fileSaver.fileDelete(realPath, file);

	}

	public String summerFile(MultipartFile file, HttpSession session) throws Exception {
		String realPath = session.getServletContext().getRealPath("resources/upload/summerFile");
		return fileSaver.save(realPath, file);
	}

	public NoticeFilesVO fileSelect(NoticeFilesVO noticeFilesVO) throws Exception {
		return noticeFilesDAO.filesSelect(noticeFilesVO);
	}

	@Override
	public List<BoardVO> boardList(Pager pager) throws Exception {
		pager.makeRow();
		pager.makePage(boardNoticeDAO.boardCount(pager));
		return boardNoticeDAO.boardList(pager);
	}

	public int fileDelete(NoticeFilesVO noticeFilesVO) throws Exception {
		return noticeFilesDAO.fileDelete(noticeFilesVO);
	}

	@Override
	public BoardVO boardSelect(BoardVO boardVO) throws Exception {
		// TODO Auto-generated method stub
		// boardVO = boardNoticeDAO.boardSelect(boardVO);
		// BoardNoticeVO boardNoticeVO = (BoardNoticeVO)boardVO;
		// List<NoticeFilesVO> noticeFilesVOs =
		// noticeFilesDAO.fileList(boardVO.getNum());
		// boardNoticeVO.setFiles(noticeFilesVOs);
		return boardNoticeDAO.boardSelect(boardVO);
	}

	@Override
	public int boardWrite(BoardVO boardVO, MultipartFile[] file, HttpSession session) throws Exception {
		String realPath = session.getServletContext().getRealPath("resources/upload/notice");
		NoticeFilesVO noticeFilesVO = new NoticeFilesVO();
		int result = boardNoticeDAO.boardWrite(boardVO);
		noticeFilesVO.setNum(boardVO.getNum());
		for (MultipartFile multipartFile : file) {
			if (multipartFile.getOriginalFilename() != "") { // Add File 누르고 실제로 파일을 올렸을때만
				String fileName = fileSaver.save2(realPath, multipartFile);
				noticeFilesVO.setFname(fileName);
				noticeFilesVO.setOname(multipartFile.getOriginalFilename());
				noticeFilesDAO.fileWrite(noticeFilesVO);
				if (result < 1) {
					throw new SQLException();
				}
			}
		}
		return result;
	}

	@Override
	public int boardUpdate(BoardVO boardVO, MultipartFile[] file, HttpSession session) throws Exception {
		// TODO Auto-generated method stub
		String realPath = session.getServletContext().getRealPath("resources/upload/notice");
		NoticeFilesVO noticeFilesVO = new NoticeFilesVO();
		int result = boardNoticeDAO.boardUpdate(boardVO);
		noticeFilesVO.setNum(boardVO.getNum());
		for (MultipartFile multipartFile : file) {
			if (multipartFile.getOriginalFilename() != "") {
				String fileName = fileSaver.save3(realPath, multipartFile);
				noticeFilesVO.setFname(fileName);
				noticeFilesVO.setOname(multipartFile.getOriginalFilename());
				noticeFilesDAO.fileWrite(noticeFilesVO); // update해도 어차피 테이블에 새로 추가하는거니까 그냥 fileWrite씀
			}
			if (result < 1) {
				throw new SQLException();
			}
		}
		return result;
	}

	@Override
	public int boardDelete(BoardVO boardVO) throws Exception {
		// TODO Auto-generated method stub
		return boardNoticeDAO.boardDelete(boardVO);
	}

}
