package com.mimman.board.controller;

import java.sql.SQLException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.mimman.board.repository.BoardDto;
import com.mimman.board.service.BoardService;

@Controller
public class updateController {
	private BoardService boardService;
	
	public void setBoardService(BoardService boardService) {
		this.boardService = boardService;
	}
	
	@RequestMapping("/update.board")
	public ModelAndView pageHandler(int b_seq) throws SQLException{
		ModelAndView mav = new ModelAndView("/board/update.jsp");
		mav.addObject("b_seq",b_seq);
		return mav;
	}
	
	@RequestMapping(value="/update.board", method=RequestMethod.POST)
	public ModelAndView pageHandler2(@ModelAttribute BoardDto dto) {
		ModelAndView mav = new ModelAndView("redirect:list.board");
	
		try {
			System.out.println(dto.getB_seq());
			boardService.update(dto);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return mav;
	}
}
