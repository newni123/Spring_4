package com.iu.s4.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.iu.s4.model.NoticeFilesVO;

@Repository
public class NoticeFilesDAO {
	@Inject
	private SqlSession sqlSession;
	private static final String NAMESPACE = "noticeFilesMapper.";
	
	public int fileDelete(NoticeFilesVO noticeFilesVO) throws Exception{
		return sqlSession.delete(NAMESPACE+"fileDelete",noticeFilesVO);
	}
	public int fileWrite(NoticeFilesVO noticeFilesVO) throws Exception {
		return sqlSession.insert(NAMESPACE + "fileWrite", noticeFilesVO);
	}
	public List<NoticeFilesVO> fileList(int num) throws Exception {
		return sqlSession.selectList(NAMESPACE + "fileList", num);
	}
}
