package com.mimman.board.controller;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.mimman.board.service.BoardService;

@Controller
public class ListController {
	private BoardService boardService;
	
	public void setBoardService(BoardService boardService) {
		this.boardService = boardService;
	}
	@RequestMapping("/list.board")
	public ModelAndView pageHandler(){
		ModelAndView mav = new ModelAndView("/board/list.jsp");
		try {
			List list = boardService.getList();
			mav.addObject("list",list);
			System.out.println("데이터 크기:"+list.size());
		} 
		catch (SQLException e) {
			System.out.println("ListController:pageHandler():"+e);
		}
		return mav;
	}
}
