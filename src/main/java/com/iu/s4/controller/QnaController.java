package com.iu.s4.controller;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.iu.s4.model.BoardQnaVO;
import com.iu.s4.model.BoardVO;
import com.iu.s4.service.BoardQnaService;
import com.iu.s4.util.Pager;

@Controller
@RequestMapping("/qna/**")
public class QnaController {

	@Inject
	private BoardQnaService boardQnaService;

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

	@RequestMapping(value = "qnaWrite", method = RequestMethod.POST)
	public int qnaWrite2(BoardVO boardVO, HttpServletRequest request, HttpServletResponse response) throws Exception {
		return boardQnaService.boardWrite(boardVO);
	}

	@RequestMapping(value = "qnaWrite", method = RequestMethod.GET)
	public ModelAndView qnaWrite() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("board/boardWrite");
		mv.addObject("board","qna");
		return mv;
	}

}
