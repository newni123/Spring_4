package com.iu.s4.controller;


import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.iu.s4.model.MemberVO;
import com.iu.s4.service.MemberServiceImpl;

@Controller
@RequestMapping("/member/**")
public class MemberController {
	@Inject
	private MemberServiceImpl memberServiceImpl;

	@RequestMapping(value="memberLogin",method=RequestMethod.POST)
	public void memberLogin(MemberVO memberVO) throws Exception{
		
	}
	
	@RequestMapping(value="memberLogin",method=RequestMethod.GET)
	public void memberLogin() throws Exception{
		
	}
	
	@RequestMapping(value = "memberJoin", method = RequestMethod.POST)
	public ModelAndView memberJoin(MemberVO memberVO, String year, String month, String date) throws Exception {
		memberVO.setBirth(year+"-"+month+"-"+date);
		ModelAndView mv = new ModelAndView();
		int result = memberServiceImpl.memberJoin(memberVO);
		if (result > 0)
			mv.setViewName("redirect:../");
		else {
			mv.addObject("msg", "회원가입 완료");
			mv.addObject("path", "../");
			mv.setViewName("common/common_result");
		}
		return mv;

	}

	@RequestMapping(value = "memberJoin", method = RequestMethod.GET)
	public void memberJoin() throws Exception {

	}
}
