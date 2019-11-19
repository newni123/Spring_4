package com.iu.s4.service;

import javax.servlet.http.HttpSession;

import com.iu.s4.model.MemberVO;

public interface MemberService {
	
	public MemberVO memberSelect(MemberVO memberVO) throws Exception;
	
	// Id Check
	public MemberVO memberCheckId(MemberVO memberVO) throws Exception;
	
	// Join
	public int memberJoin(MemberVO memberVO,HttpSession session) throws Exception;
	// Login
	public MemberVO memberLogin(MemberVO memberVO) throws Exception;

	// Update
	public int memberUpdate(MemberVO memberVO) throws Exception;

	// Delete
	public int memberDelete(MemberVO memberVO) throws Exception;

	// Point Update
	public int memberPointUpdate(MemberVO memberVO) throws Exception;

}
