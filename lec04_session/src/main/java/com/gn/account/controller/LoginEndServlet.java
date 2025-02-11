package com.gn.account.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/loginEnd")
public class LoginEndServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;  

    public LoginEndServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String accountId = request.getParameter("account_id");
		String accountPw = request.getParameter("account_pw");
		String rememberId = request.getParameter("remember_id");
		
		System.out.println("아이디 : "+accountId
				+"\n비밀번호 : "+accountPw
				+"\n아이디 저장 유무 : "+rememberId);
		
		// 1. 아이디, 비밀번호 일치하는 데이터 있는지 확인
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Account account = null;
		try {
			// SELECT 
			// 기준 아이디와 비밀번호 일치(LIKE X)
			// 전체 정보 조회 -> account 객체에 담기
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			
		}
		if(account != null) {
			// 2-1. O
			// 		-> 사용자의 정보(번호,아이디,비밀번호,이름) 담고 있는 객체 Session에 저장
			// 		-> 아이디 정보 저장 O : Cookie에 아이디 저장
			//      -> 홈화면 이동 : 로그인한 사용자 정보 노출
			System.out.println(account);
		}else {
			// 2-2. X
			// 		-> 로그인 페이지 다시 요청
			System.out.println("로그인 실패");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		doGet(request, response);
	}

}
