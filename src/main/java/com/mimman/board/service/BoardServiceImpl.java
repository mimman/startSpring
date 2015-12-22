package com.mimman.board.service;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import com.mimman.board.repository.BoardDto;

import mybatis.BoardManager;

public class BoardServiceImpl implements BoardService {
	private JdbcTemplate jdbcTemplate;

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public List getList() throws SQLException {
		/*
		String sql = "select * from tblSpringBoard order by b_seq desc";
		List<BoardDto> list = new ArrayList<BoardDto>();

		list = jdbcTemplate.query(sql, new RowMapperImpl());

		return list;
		*/
		return BoardManager.getList();
	}

	class RowMapperImpl implements RowMapper {

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

	}

	public BoardDto findBySeq(int b_seq) throws SQLException {
		/*
		String sql = "select * from tblSpringBoard where b_seq=" + seq;
		BoardDto dto = jdbcTemplate.queryForObject(sql, new RowMapperImpl());
		return dto;
		*/
		return BoardManager.findBySeq(b_seq);
	}

	public void write(BoardDto dto) throws SQLException {
		BoardManager.write(dto);

		
		/*
		String sql = "insert into tblSpringBoard(b_seq,b_title,b_content,b_writer,"
				+ "b_regdate,b_hitcount,b_password) values(seq_board.nextVal,?,?,?,sysdate,0,?)";

		// 파라미터를 넘겨줄 때 두가지 방법
		// 1. object[] 방식 간편하고 딱 한번밖에 파라미터를 쓸 수 밖에 없다
		// 2. PrepareStatementSetter 인터페이스 구현
		// jdbcTemplate.update(sql,new WriteParams(dto));

		Object[] values = new Object[] { dto.getB_title(), dto.getB_content(), dto.getB_writer(), dto.getB_password() };
		jdbcTemplate.update(sql, values);
		*/
	}
	
	/*
	 * class WriteParams implements PreparedStatementSetter{ private BoardDto
	 * dto;
	 * 
	 * public WriteParams(BoardDto dto){ this.dto = dto; }
	 * 
	 * public void setValues(PreparedStatement pstmt) throws SQLException {
	 * pstmt.setString(1, dto.getB_title()); pstmt.setString(2,
	 * dto.getB_content()); pstmt.setString(3, dto.getB_writer());
	 * pstmt.setString(4, dto.getB_password()); }
	 * 
	 * }
	 */

	public void update(BoardDto dto) throws SQLException {
		BoardManager.update(dto);
		/*
		String sql = "update tblSpringBoard set b_title=?, b_content=? " + "where b_seq=?";
		System.out.println("update" +"글번호"+ dto.getB_seq()+"제목"+dto.getB_title()+"내용"+dto.getB_content()+dto.getB_seq());
		
		Object[] val = new Object[] { dto.getB_title(), dto.getB_content(), dto.getB_seq() };
		System.out.println(sql);
		jdbcTemplate.update(sql, val);
		*/
		
		
	}

	public void delete(int b_seq) throws SQLException {
		BoardManager.delete(b_seq);
		/*
		String sql = "delete from tblSpringBoard where b_seq=?";

		Object[] val = new Object[] { seq };
		jdbcTemplate.update(sql, val);
		*/

	}

}
