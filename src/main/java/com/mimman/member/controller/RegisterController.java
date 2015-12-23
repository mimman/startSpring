package com.mimman.member.controller;

import java.sql.SQLException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.mimman.member.repository.RegisterRequest;
import com.mimman.member.service.MemberServiceImpl;


@Controller
public class RegisterController {
	private MemberServiceImpl memberServiceImpl;
	
	
	public void setMemberServiceImpl(MemberServiceImpl memberServiceImpl) {
		this.memberServiceImpl = memberServiceImpl;
	}
	@RequestMapping("/register.member")
	public String handleStep1(){
		
		return "step1";
	}
	@RequestMapping("/step2")
	public String handleStep2(@RequestParam(value="agree", defaultValue="false")Boolean agree) {
		if(!agree){
			return "step1";
		}
		else{
		return "step2";
		}
	}
	/*
	@RequestMapping("step3")
	public ModelAndView handleStep3(RegisterRequest reg){
		System.out.println(reg.getEmail());
		
		ModelAndView mav = new ModelAndView("step3");
		mav.addObject("name",reg.getName());
		return mav;
	}
	
	*/
	@RequestMapping(value="step3",method=RequestMethod.POST)
	public String handleStep3(@ModelAttribute("mem") RegisterRequest reg){
		try {
			System.out.println("step3 회원 추가 통과"+ reg.getEmail());
			memberServiceImpl.write(reg);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "step3";
	}
	
}
