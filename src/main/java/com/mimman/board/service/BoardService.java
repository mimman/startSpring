package com.mimman.board.service;

import java.sql.SQLException;
import java.util.List;

import com.mimman.board.repository.BoardDto;

public interface BoardService {
	//전체 글 가져오기
	public List getList() throws SQLException;
	
	//특정 글 가져오기
	public BoardDto findBySeq(int seq) throws SQLException;
	
	//글 저장하기
	public void write(BoardDto dto) throws SQLException;
	
	//글 수정하기
	public void update(BoardDto dto) throws SQLException;
	//글 삭제하기
	public void delete(int seq) throws SQLException;
}
