package com.iu.s4.dao;

import java.util.List;

import com.iu.s4.model.BoardVO;
import com.iu.s4.util.Pager;

public interface BoardDAO {

	// list
	public List<BoardVO> boardList(Pager pager) throws Exception;
	// select
	public BoardVO boardSelect(int num) throws Exception; 
	// write
	public int boradWrite(BoardVO boardVO) throws Exception; 
	// update
	public int boardUpdate() throws Exception;
	// delete
	public int boardDelete() throws Exception;
	// count
	public int boardCount(Pager pager) throws Exception; 
}
