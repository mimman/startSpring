package com.mimman.board.controller;

import java.sql.SQLException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.mimman.board.repository.BoardDto;
import com.mimman.board.service.BoardService;

@Controller
public class deleteController {
private BoardService boardService;
	
	public void setBoardService(BoardService boardService) {
		this.boardService = boardService;
	}
	
	@RequestMapping("/delete.board")
	public ModelAndView pageHandler(int b_seq) throws SQLException{
		ModelAndView mav = new ModelAndView("redirect:list.board");
		boardService.delete(b_seq);
		return mav;
	}
}
