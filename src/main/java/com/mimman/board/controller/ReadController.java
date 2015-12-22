package com.mimman.board.controller;

import java.sql.SQLException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.mimman.board.repository.BoardDto;
import com.mimman.board.service.BoardService;

@Controller
public class ReadController {
	private BoardService boardService;
	
	public void setBoardService(BoardService boardService) {
		this.boardService = boardService;
	}
	
	@RequestMapping("/read.board")
	public ModelAndView pageHandler(int b_seq) throws SQLException{
		ModelAndView mav = new ModelAndView("/board/read.jsp");
		BoardDto dto = boardService.findBySeq(b_seq);
		mav.addObject("dto",dto);
		return mav;
	}
}
