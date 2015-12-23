package com.mimman.member.service;

import java.sql.SQLException;


import com.mimman.member.repository.RegisterRequest;


import mybatis.MemberManager;

public class MemberServiceImpl {
	public void write(RegisterRequest req) throws SQLException{
		System.out.println("memberimpl통과" + req.getEmail());
		MemberManager.MemberWrite(req);
	}
}
