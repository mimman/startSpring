package com.mimman.board.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.mimman.board.repository.BoardDto;

public class BoardServiceImpl implements BoardService {
	private JdbcTemplate jdbcTemplate;
	
	
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public List getList() throws SQLException {
		String sql="select * from tblSpringBoard order by b_seq desc";
		List<BoardDto> list = new ArrayList<BoardDto>();
		RowMapper rowmap = new RowMapper(){

			public Object mapRow(ResultSet rs, int arg1) throws SQLException {
				BoardDto dto = new BoardDto();
				dto.setB_content(rs.getString("b_content"));
				dto.setB_hitcount(rs.getInt("b_hitcount"));
				dto.setB_password(rs.getString("b_password"));
				dto.setB_regdate(rs.getString("b_regdate"));
				dto.setB_seq(rs.getInt("b_seq"));
				dto.setB_title(rs.getString("b_title"));
				dto.setB_writer(rs.getString("b_writer"));
				
				return dto;
			}
	
		};
		
		list = jdbcTemplate.query(sql,rowmap);
		
		return list;
	}

	public BoardDto findBySeq() throws SQLException {
		
		return null;
	}

	public void write(BoardDto dto) throws SQLException {
		

	}

	public void update(BoardDto dto) throws SQLException {
		

	}

	public void delete(int seq) throws SQLException {
		

	}

}
