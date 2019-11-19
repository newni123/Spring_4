package com.iu.s4;

import static org.junit.Assert.*;

import javax.inject.Inject;

import org.junit.Test;

import com.iu.s4.dao.MemberDAOImpl;
import com.iu.s4.model.MemberVO;

public class MemberDAOTest extends TestAbstractCase{
	@Inject
	private MemberDAOImpl memberDAOImpl;
	//@Test
	public void memberDAOtest() throws Exception {
		MemberVO memberVO = new MemberVO();
		memberVO.setId("test1");
		memberVO.setPw("test1");
		memberVO.setName("test1");
		memberVO.setEmail("test1@e.com");
		memberVO.setBirth("2000-01-01");
		memberVO.setGender("F");
		int result = memberDAOImpl.memberJoin(memberVO);
		assertEquals(1, result);
	}
	@Test
	public void memberTest() throws Exception{
		MemberVO memberVO = new MemberVO();
		MemberVO memberVO2 = new MemberVO();
		memberVO.setId("admin");
		memberVO.setPw("admin");
		memberVO2 = memberDAOImpl.memberLogin(memberVO);
		assertNotNull(memberVO2);
	}

}
