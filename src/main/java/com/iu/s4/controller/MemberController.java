package com.iu.s4.controller;

import java.util.Date;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.iu.s4.model.MemberVO;
import com.iu.s4.service.MemberServiceImpl;

@Controller
@RequestMapping("/member/**")
public class MemberController {
	@Inject
	private MemberServiceImpl memberServiceImpl;

	@RequestMapping(value="emailCheck",method = RequestMethod.POST)
	public void emailCheck(MemberVO memberVO,Model model) throws Exception{
		memberVO = memberServiceImpl.emailCheck(memberVO);
		String result = "nonepass";
		if(memberVO == null) {
			result = "pass";
		}
		model.addAttribute("result",result);
	}
		
	
	@RequestMapping(value = "member_Check_Test", method = RequestMethod.POST)
	public void memberCheckId2(MemberVO memberVO, Model model) throws Exception {
		memberVO = memberServiceImpl.memberCheckId(memberVO);
		String result = "nonepass";
		if (memberVO == null) {
			result = "pass";
			
		}
		model.addAttribute("result", result);
	}
	
	@RequestMapping(value = "memberDelete")
	public ModelAndView memberDelete(MemberVO memberVO, HttpSession session) throws Exception {
		memberVO = (MemberVO) session.getAttribute("member");
		
		
		ModelAndView mv = new ModelAndView();
		if (memberServiceImpl.memberDelete(memberVO) > 0) {
			mv.setViewName("redirect:../");
			session.invalidate(); // 유지시간을 0으로 변경
		} else {
			mv.addObject("msg", "탈퇴 실패");
			mv.addObject("path", "../");
			mv.setViewName("common/common_result");
		}
		return mv;
	}

	@RequestMapping(value = "memberMypage", method = RequestMethod.POST)
	public ModelAndView memberUpdate(MemberVO memberVO) throws Exception {
		ModelAndView mv = new ModelAndView();
		if (memberServiceImpl.memberUpdate(memberVO) > 0) {
			mv.setViewName("redirect:../");
		} else {
			mv.addObject("msg", "수정 실패");
			mv.addObject("path", "../");
			mv.setViewName("common/common_result");
		}
		return mv;
	}

	@RequestMapping(value = "memberMypage", method = RequestMethod.GET)
	public ModelAndView memberUpdate(MemberVO memberVO, HttpSession session) throws Exception {
		ModelAndView mv = new ModelAndView();
		memberVO = (MemberVO) session.getAttribute("member");
		memberVO = memberServiceImpl.memberSelect(memberVO);
		String birth = memberVO.getBirth();
		mv.addObject("memberVO", memberVO);
		return mv;
	}

	@RequestMapping(value = "memberLogout", method = RequestMethod.GET)
	public String memberLogout(HttpSession session) throws Exception {
		// session.removeAttribute("member");
		session.invalidate(); // 유지시간을 0으로 변경
		return "redirect:../";
	}

	@RequestMapping(value = "memberCheckId", method = RequestMethod.GET)
	public void memberCheckId(MemberVO memberVO, Model model) throws Exception {
		MemberVO checkVO = memberServiceImpl.memberCheckId(memberVO);
		String result = "중복된 아이디";
		if (checkVO == null) {
			result = "사용가능한 아이디";
		}
		model.addAttribute("memberVO", memberVO);
		model.addAttribute("result", result);

	}



	@RequestMapping(value = "memberLogin", method = RequestMethod.POST)
	public ModelAndView memberLogin(MemberVO memberVO, HttpSession session) throws Exception {
		memberVO = memberServiceImpl.memberLogin(memberVO);
		ModelAndView mv = new ModelAndView();
		String msg = "아이디나 비밀번호가 일치하기 않습니다.";
		String path = "memberLogin";
		if (memberVO != null) {
			session.setAttribute("member", memberVO);
			msg = "로그인";
			path = "../";
		}
		mv.addObject("path", path);
		mv.addObject("msg", msg);
		mv.setViewName("common/common_result");
		return mv;

	}

	@RequestMapping(value = "memberLogin", method = RequestMethod.GET)
	public void memberLogin() throws Exception {

	}

	@RequestMapping(value = "memberJoin", method = RequestMethod.POST)
	public ModelAndView memberJoin(MemberVO memberVO, HttpSession session, HttpServletRequest request)
			throws Exception {
		System.out.println(session.getServletContext().getRealPath("resources/upload"));
		System.out.println(request.getSession().getServletContext().getRealPath(("resources/upload")));
		ModelAndView mv = new ModelAndView();
		int result = memberServiceImpl.memberJoin(memberVO, session);
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