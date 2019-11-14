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
		return sqlSession.selectList(NAMESPACE+"noticeList",pager);
	}
	@Override
	public BoardVO boardSelect(BoardVO boardVO) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(NAMESPACE+"noticeSelect",boardVO);
	}
	@Override
	public int boardWrite(BoardVO boardVO) throws Exception {
		return sqlSession.insert(NAMESPACE+"noticeWrite",boardVO);
	}
	@Override
	public int boardUpdate(BoardVO boardVO) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.update(NAMESPACE+"noticeUpdate",boardVO);
	}
	@Override
	public int boardDelete(BoardVO boardVO) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.delete(NAMESPACE+"noticeDelete",boardVO);
	}
	@Override
	public int boardCount(Pager pager) throws Exception {
		return sqlSession.selectOne(NAMESPACE+"noticeCount",pager);
	}


}
