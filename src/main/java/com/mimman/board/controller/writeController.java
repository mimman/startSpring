package com.mimman.board.controller;

import java.sql.SQLException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mimman.board.repository.BoardDto;
import com.mimman.board.service.BoardService;

@Controller
public class writeController {
private BoardService boardService;
	
	public void setBoardService(BoardService boardService) {
		this.boardService = boardService;
	}
	
	@RequestMapping("write.board")
	public String pageHandler(){
		return "/board/write.jsp";
	}
	@RequestMapping(value="write.board", method=RequestMethod.POST)
	public String submitted(@ModelAttribute BoardDto dto){
	
		try {
			boardService.write(dto);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "redirect:list.board";
	}
}
