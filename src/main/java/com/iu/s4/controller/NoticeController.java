package com.iu.s4.controller;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.iu.s4.model.BoardVO;
import com.iu.s4.service.BoardNoticeService;
import com.iu.s4.util.Pager;

@Controller
@RequestMapping("/board/**")
public class NoticeController {

	@Inject
	private BoardNoticeService boardNoticeService;

	@RequestMapping(value = "boardList")
	public ModelAndView boardList(Pager pager) throws Exception {
		List<BoardVO> boardVOs = boardNoticeService.boardList(pager);
		ModelAndView mv = new ModelAndView();
		mv.addObject("list", boardVOs);
		mv.addObject("pager", pager);
		mv.addObject("board", "notice");
		mv.setViewName("board/boardList");
		return mv;
	}
	@RequestMapping(value = "boardWrite", method = RequestMethod.POST)
	public void boardWrite2(BoardVO boardVO, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String msg = "작성 실패";
		if (boardNoticeService.boardWrite(boardVO) > 0)
			msg = "작성 완료";
		request.setAttribute("msg", msg);
		request.setAttribute("path", "./boardList");
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/common/common_result.jsp");
		view.forward(request, response);
	}
	@RequestMapping(value = "boardWrite", method = RequestMethod.GET)
	public ModelAndView boardWrite() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("board/boardWrite");
		mv.addObject("board","notice");
		return mv;
	}

}
