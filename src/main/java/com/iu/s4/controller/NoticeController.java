package com.iu.s4.controller;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.iu.s4.model.BoardNoticeVO;
import com.iu.s4.model.BoardVO;
import com.iu.s4.model.NoticeFilesVO;
import com.iu.s4.service.BoardNoticeService;
import com.iu.s4.util.Pager;

@Controller
@RequestMapping("/notice/**")
public class NoticeController {

	@Inject
	private BoardNoticeService boardNoticeService;

	@RequestMapping(value="summerFileDelete",method=RequestMethod.POST)
	public ModelAndView summerFileDelete(String file,HttpSession session) throws Exception{
		boolean check = boardNoticeService.summerFileDelete(file, session);
		String result = "delete Fail";
		if(check ) {
			result = "delete success";
		
		}
		ModelAndView mv = new ModelAndView();
		mv.addObject("common/common_ajaxResult");
		mv.setViewName("summerFileDelete");
		
		return mv;
	}
	
	
	@RequestMapping(value="summerFile", method=RequestMethod.POST)
	public ModelAndView summerFile(MultipartFile file,HttpSession session) throws Exception {
		String fileName = boardNoticeService.summerFile(file, session);
		ModelAndView mv = new ModelAndView();
		System.out.println(session.getServletContext().getRealPath("resources/upload/summerFile"));
		mv.setViewName("common/common_ajaxResult");
		mv.addObject("result",fileName);
		return mv;
	}

	@GetMapping(value = "fileDown")
	public ModelAndView fileDown(NoticeFilesVO noticeFilesVO) throws Exception {
		noticeFilesVO = boardNoticeService.fileSelect(noticeFilesVO);
		ModelAndView mv = new ModelAndView();
		mv.addObject("file", noticeFilesVO);
		mv.setViewName("fileDown");
		mv.addObject("board", "notice");
		return mv;
	}

	@PostMapping(value = "fileDelete")
	public ModelAndView fileDelete(NoticeFilesVO noticeFilesVO) throws Exception {
		ModelAndView mv = new ModelAndView();
		System.out.println(noticeFilesVO.getFname());
		int result = boardNoticeService.fileDelete(noticeFilesVO);
		mv.setViewName("common/common_ajaxResult");
		mv.addObject("result", result);
		return mv;
	}

	@RequestMapping(value = "noticeSelect")
	public ModelAndView boardSelect(BoardVO boardVO) throws Exception {
		ModelAndView mv = new ModelAndView();
		boardVO = boardNoticeService.boardSelect(boardVO);
		boardVO.setContents(boardVO.getContents().replace("\r\n", "<br>")); // 엔터 인식 시키기
		mv.addObject("vo", boardVO);
		mv.addObject("board", "notice");
		mv.setViewName("board/boardSelect");
		return mv;
	}

	@RequestMapping(value = "noticeList")
	public ModelAndView boardList(Pager pager) throws Exception {
		List<BoardVO> boardVOs = boardNoticeService.boardList(pager);
		ModelAndView mv = new ModelAndView();
		mv.addObject("list", boardVOs);
		mv.addObject("pager", pager);
		mv.addObject("board", "notice");
		mv.setViewName("board/boardList");
		return mv;
	}

	@RequestMapping(value = "noticeWrite", method = RequestMethod.POST)
	public ModelAndView boardWrite2(BoardVO boardVO, MultipartFile[] file, HttpSession session) throws Exception {
		for (int i = 0; i < file.length; i++)
			file[i].getOriginalFilename();
		ModelAndView mv = new ModelAndView();
		System.out.println(session.getServletContext().getRealPath("resources/upload/notice"));
		System.out.println("boardVO : " + boardVO);
		System.out.println("file : " + file);
		System.out.println("session : " + session);
		int result = boardNoticeService.boardWrite(boardVO, file, session);
		String msg = "작성 실패";
		if (result > 0) {
			mv.setViewName("redirect:./noticeList");
		} else {
			mv.addObject("msg", msg);
			mv.addObject("path", "./noticeList");
			mv.setViewName("common/common_result");
		}
		mv.addObject("board", "notice");
		return mv;

	}

	@RequestMapping(value = "noticeWrite", method = RequestMethod.GET)
	public ModelAndView boardWrite(BoardVO boardVO) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("board", "notice");
		mv.setViewName("board/boardWrite");
		return mv;
	}

	@RequestMapping(value = "noticeDelete")
	public ModelAndView boardDelete(BoardVO boardVO) throws Exception {
		ModelAndView mv = new ModelAndView();
		if (boardNoticeService.boardDelete(boardVO) > 0) {
			mv.setViewName("redirect:./noticeList");
		} else {
			mv.addObject("msg", "삭제 실패");
			mv.addObject("path", "./noticeList");
			mv.setViewName("common/common_result");
		}
		mv.addObject("board", "notice");
		return mv;
	}

	@RequestMapping(value = "noticeUpdate", method = RequestMethod.POST)
	public ModelAndView boardUpdate2(BoardVO boardVO, MultipartFile[] file, HttpSession session) throws Exception {
		ModelAndView mv = new ModelAndView();
		System.out.println("boardVO : " + boardVO);
		System.out.println("file : " + file);
		System.out.println("session : " + session);
		int result = boardNoticeService.boardUpdate(boardVO, file, session);
		if (result > 0) {
			mv.setViewName("redirect:./noticeList");
		} else {
			mv.addObject("msg", "수정 실패");
			mv.addObject("path", "./noticeList");
			mv.setViewName("common/common_result");
		}
		mv.addObject("board", "notice");
		return mv;
	}

	@RequestMapping(value = "noticeUpdate", method = RequestMethod.GET)
	public ModelAndView boardUpdate(BoardVO boardVO) throws Exception {
		ModelAndView mv = new ModelAndView();
		boardVO = boardNoticeService.boardSelect(boardVO);
		if (boardVO != null) {
			BoardNoticeVO boardNoticeVO = (BoardNoticeVO) boardVO;
			int size = boardNoticeVO.getFiles().size();
			mv.addObject("size", size);
			mv.addObject("vo", boardVO);
			mv.addObject("board", "notice");
			mv.setViewName("board/boardUpdate");
		}
		return mv;
	}

}
