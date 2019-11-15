package com.iu.s4.service;

import com.iu.s4.model.MemberVO;

public interface MemberService {
	// Id Check
	public MemberVO memberCheckId(MemberVO memberVO) throws Exception;
	
	// Join
	public int memberJoin(MemberVO memberVO) throws Exception;

	// Login
	public MemberVO memberLogin(MemberVO memberVO) throws Exception;

	// Update
	public int memberUpdate(MemberVO memberVO) throws Exception;

	// Delete
	public int memberDelete(MemberVO memberVO) throws Exception;

	// Point Update
	public int memberPointUpdate(MemberVO memberVO) throws Exception;

}
