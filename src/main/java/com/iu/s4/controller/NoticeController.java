package com.iu.s4.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.iu.s4.model.BoardVO;
import com.iu.s4.service.BoardNoticeService;
import com.iu.s4.util.Pager;

@Controller
@RequestMapping("/board/**")
public class NoticeController {
	
	@Inject
	private BoardNoticeService boardNoticeService;
	
	@RequestMapping("boardList")
	public ModelAndView boardList(Pager pager) throws Exception{
		List<BoardVO> boardVOs = boardNoticeService.boardList(pager);
		ModelAndView mv = new ModelAndView();
		mv.addObject("list",boardVOs);
		mv.addObject("pager",pager);
		mv.setViewName("board/boardList");
		return mv;
	}
}
