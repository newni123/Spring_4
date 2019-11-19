package com.iu.s4.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.iu.s4.model.BoardQnaVO;
import com.iu.s4.model.BoardVO;
import com.iu.s4.util.Pager;

@Repository
public class BoardQnaDAO implements BoardDAO{
	@Inject
	private SqlSession sqlSession;
	private static final String NAMESPACE = "qnaMapper.";
	
	public int boardReply(BoardVO boardVO) throws Exception{
		return sqlSession.insert(NAMESPACE+"boardReply",boardVO);
	}
	
	public int boardReplyUpdate(BoardQnaVO qnaVO) throws Exception{
		return sqlSession.update(NAMESPACE+"boardReplyUpdate",qnaVO);
	}
	@Override
	public List<BoardVO> boardList(Pager pager) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectList(NAMESPACE+"qnaList",pager);
	}
	@Override
	public BoardVO boardSelect(BoardVO boardVO) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(NAMESPACE+"qnaSelect",boardVO);
	}
	@Override
	public int boardWrite(BoardVO boardVO) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.insert(NAMESPACE+"qnaWrite",boardVO);
	}
	@Override
	public int boardUpdate(BoardVO boardVO) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.update(NAMESPACE+"qnaUpdate",boardVO);
	}
	@Override
	public int boardDelete(BoardVO boardVO) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.delete(NAMESPACE+"qnaDelete",boardVO);
	}
	@Override
	public int boardCount(Pager pager) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(NAMESPACE+"qnaCount",pager);
	} 
	
	
}
