package com.gn.member.service;

import java.sql.Connection;

import com.gn.member.dao.MemberDao;
import com.gn.member.vo.Member;
import static com.gn.common.sql.JDBCTemplate.close;
import static com.gn.common.sql.JDBCTemplate.getConnection;


public class MemberService {
	
	public Member selectMemberOne(int no) {
		Connection conn = getConnection();
		Member m = new MemberDao().selectMemberOne(no,conn);
		close(conn);
		return m;
	}
	
	public int updateMember(Member m) {
		Connection conn = getConnection();
		int result = new MemberDao().updateMember(m,conn);
		close(conn);
		return result; 
	}
	
	public Member loginMember(String id, String pw) {
		Connection conn = getConnection(); 
		Member m = new MemberDao().loginMember(id,pw,conn);
		close(conn);
		return m;
	}
	// createMember 메소드
	// Member를 매개변수로 받아서
	// Connection 객체 생성
	// MemberDao에게 Connection과 Member 전달
	// int 반환
	public int createMember(Member m) {
		Connection conn = getConnection();
		int result = new MemberDao().createMember(m,conn);
		close(conn);
		return result;
	}

}
