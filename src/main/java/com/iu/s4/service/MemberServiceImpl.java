package com.iu.s4.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.iu.s4.dao.MemberDAOImpl;
import com.iu.s4.model.MemberVO;
@Service
public class MemberServiceImpl implements MemberService {
	@Inject
	private MemberDAOImpl memberDAOImpl;
	
	public MemberVO emailCheck(MemberVO memberVO) throws Exception{
		return memberDAOImpl.emailCheck(memberVO);
		
	}
	
	@Override
	public int memberJoin(MemberVO memberVO) throws Exception {
		// TODO Auto-generated method stub
		return memberDAOImpl.memberJoin(memberVO);
	}

	@Override
	public MemberVO memberLogin(MemberVO memberVO) throws Exception {
		// TODO Auto-generated method stub
		return memberDAOImpl.memberLogin(memberVO);
	}

	@Override
	public int memberUpdate(MemberVO memberVO) throws Exception {
		// TODO Auto-generated method stub
		return memberDAOImpl.memberUpdate(memberVO);
	}

	@Override
	public int memberDelete(MemberVO memberVO) throws Exception {
		// TODO Auto-generated method stub
		return memberDAOImpl.memberDelete(memberVO);
	}

	@Override
	public int memberPointUpdate(MemberVO memberVO) throws Exception {
		// TODO Auto-generated method stub
		return memberDAOImpl.memberPointUpdate(memberVO);
	}

	@Override
	public MemberVO memberCheckId(MemberVO memberVO) throws Exception {
		// TODO Auto-generated method stub
		return memberDAOImpl.memberCheckId(memberVO);
	}

	@Override
	public MemberVO memberSelect(MemberVO memberVO) throws Exception {
		// TODO Auto-generated method stub
		return memberDAOImpl.memberSelect(memberVO);
	}

}
