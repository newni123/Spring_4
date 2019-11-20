package com.iu.s4.controller;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.iu.s4.model.BoardVO;
import com.iu.s4.service.BoardNoticeService;
import com.iu.s4.util.Pager;

@Controller
@RequestMapping("/notice/**")
public class NoticeController {

	@Inject
	private BoardNoticeService boardNoticeService;

	@RequestMapping(value = "noticeSelect")
	public ModelAndView boardSelect(BoardVO boardVO) throws Exception {
		ModelAndView mv = new ModelAndView();
		boardVO = boardNoticeService.boardSelect(boardVO);
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
	public ModelAndView boardWrite2(BoardVO boardVO, MultipartFile[] file, HttpSession session,
			HttpServletRequest request) throws Exception {
		for(int i = 0; i < file.length;i++)
			file[i].getOriginalFilename();
		ModelAndView mv = new ModelAndView();
		System.out.println(session.getServletContext().getRealPath("resources/upload/notice"));
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
	public ModelAndView boardUpdate2(BoardVO boardVO) throws Exception {
		ModelAndView mv = new ModelAndView();
		if (boardNoticeService.boardUpdate(boardVO) > 0) {
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
		mv.addObject("vo", boardVO);
		mv.addObject("board", "notice");
		mv.setViewName("board/boardUpdate");
		return mv;
	}

}
