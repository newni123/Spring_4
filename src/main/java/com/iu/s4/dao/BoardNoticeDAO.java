package com.iu.s4.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.iu.s4.model.BoardVO;
import com.iu.s4.util.Pager;

@Repository
public class BoardNoticeDAO implements BoardDAO{
	@Inject
	private SqlSession sqlSession;
	private final static String NAMESPACE = "noticeMapper.";
	@Override
	public List<BoardVO> boardList(Pager pager) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectList(NAMESPACE+"boardList",pager);
	}
	@Override
	public BoardVO boardSelect(int num) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public int boradWrite(BoardVO boardVO) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public int boardUpdate() throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public int boardDelete() throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public int boardCount(Pager pager) throws Exception {
		return sqlSession.selectOne(NAMESPACE+"boardCount",pager);
	}


}
