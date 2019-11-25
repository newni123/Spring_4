package com.iu.s4.controller;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.iu.s4.model.BoardVO;
import com.iu.s4.service.BoardQnaService;
import com.iu.s4.util.Pager;

@Controller
@RequestMapping("/qna/**")
public class QnaController {

	@Inject
	private BoardQnaService boardQnaService;

	@RequestMapping(value = "qnaSelect")
	public ModelAndView boardSelect(BoardVO boardVO) throws Exception {
		ModelAndView mv = new ModelAndView();
		boardVO = boardQnaService.boardSelect(boardVO);
		// boardVO.setContents(boardVO.getContents().replace("\r\n", "<br>"));
		mv.addObject("vo", boardVO);
		mv.addObject("board", "qna");
		mv.setViewName("board/boardSelect");
		return mv;
	}

	@RequestMapping("qnaList")
	public ModelAndView qnaList(Pager pager) throws Exception {
		List<BoardVO> qnaVOs = boardQnaService.boardList(pager);
		ModelAndView mv = new ModelAndView();
		mv.addObject("list", qnaVOs);
		mv.addObject("pager", pager);
		mv.addObject("board", "qna");
		mv.setViewName("board/boardList");
		return mv;
	}

	@RequestMapping(value = "qnaReply", method = RequestMethod.POST)
	public ModelAndView qnaReply(BoardVO boardVO) throws Exception {
		ModelAndView mv = new ModelAndView();
		String msg = "작성 실패";
		if (boardQnaService.boardReply(boardVO) > 0) {
			mv.setViewName("redirect:./qnaList");
		} else {
			mv.addObject("msg", msg);
			mv.addObject("path", "./qnaList");
			mv.setViewName("common/common_result");
		}
		mv.addObject("board", "qna");
		return mv;

	}

	@RequestMapping(value = "qnaReply", method = RequestMethod.GET)
	public ModelAndView qnaReply2(BoardVO boardVO) throws Exception {
		ModelAndView mv = new ModelAndView();
		mv.addObject(" -", boardVO);
		mv.addObject("board", "qna");
		mv.setViewName("board/boardReply");
		return mv;

	}

	@RequestMapping(value = "qnaWrite", method = RequestMethod.POST)
	public ModelAndView qnaWrite2(BoardVO boardVO, MultipartFile[] file, HttpSession session,
			HttpServletRequest request) throws Exception {
		ModelAndView mv = new ModelAndView();
		int result = boardQnaService.boardWrite(boardVO, file, session);
		System.out.println(session.getServletContext().getRealPath("resources/upload/qna"));
		String msg = "작성 실패";
		if (result > 0) {
			mv.setViewName("redirect:./qnaList");
		} else {
			mv.addObject("msg", msg);
			mv.addObject("path", "./qnaList");
			mv.setViewName("common/common_result");
		}
		mv.addObject("board", "qna");
		return mv;
	}

	@RequestMapping(value = "qnaWrite", method = RequestMethod.GET)
	public ModelAndView qnaWrite() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("board", "qna");
		mv.setViewName("board/boardWrite");
		return mv;
	}

	@RequestMapping(value = "qnaDelete")
	public ModelAndView boardDelete(BoardVO boardVO) throws Exception {
		ModelAndView mv = new ModelAndView();
		if (boardQnaService.boardDelete(boardVO) > 0) {
			mv.setViewName("redirect:./qnaList");
		} else {
			mv.addObject("msg", "삭제 실패");
			mv.addObject("path", "./qnaList");
			mv.setViewName("common/common_result");
		}
		mv.addObject("board", "qna");
		return mv;
	}

	@RequestMapping(value = "qnaUpdate", method = RequestMethod.POST)
	public ModelAndView boardUpdate2(BoardVO boardVO, MultipartFile[] file, HttpSession session) throws Exception {
		ModelAndView mv = new ModelAndView();
		int result = boardQnaService.boardUpdate(boardVO, file, session);
		if (result > 0) {
			mv.setViewName("redirect:./qnaList");
		} else {
			mv.addObject("msg", "수정 실패");
			mv.addObject("path", "./qnaList");
			mv.setViewName("common/common_result");
		}
		mv.addObject("board", "qna");
		return mv;
	}

	@RequestMapping(value = "qnaUpdate", method = RequestMethod.GET)
	public ModelAndView boardUpdate(BoardVO boardVO) throws Exception {
		ModelAndView mv = new ModelAndView();
		boardVO = boardQnaService.boardSelect(boardVO);
		mv.addObject("vo", boardVO);
		mv.addObject("board", "qna");
		mv.setViewName("board/boardUpdate");
		return mv;
	}

}
