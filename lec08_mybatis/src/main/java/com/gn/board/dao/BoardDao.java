package com.gn.board.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.gn.board.vo.Board;

public class BoardDao {
	
	public int deleteBoard(SqlSession session, int boardNo) {
		return session.delete("boardMapper.deleteBoard",boardNo);
	}
	
	public int updateBoard(SqlSession session, Board board) {
		return session.update("boardMapper.boardUpdate",board);
	}
	
	public Board selectBoardThree(SqlSession session,Board option) {
		return session.selectOne("boardMapper.boardThree",option);
	}
	
	public Board selectBoardTwo(SqlSession session,Map<String,String> paramMap) {
		return session.selectOne("boardMapper.boardTwo",paramMap);
	}
	
	public Board selectBoardOne(SqlSession session,int boardNo) {
		return session.selectOne("boardMapper.boardOne",boardNo);
	}
	
	public List<Board> selectBoardList(SqlSession session){
		// 매개변수 : mapper의 namespace.쿼리문의 id
		return session.selectList("boardMapper.boardList");
	}
}
