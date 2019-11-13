package com.iu.s4;

import static org.junit.Assert.*;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

public class SqlSessionTest extends TestAbstractCase{
	@Inject
	private SqlSession sqlSession;
	
	@Test
	public void sqlTest() {
		assertNotNull(sqlSession.getConnection());
	}

}
