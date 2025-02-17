package com.gn.board.service;

import static com.gn.common.sql.JDBCTemplate.close;
import static com.gn.common.sql.JDBCTemplate.getConnection;
import static com.gn.common.sql.JDBCTemplate.rollback;
import static com.gn.common.sql.JDBCTemplate.commit;
import java.sql.Connection;

import com.gn.board.dao.BoardDao;
import com.gn.board.vo.Attach;
import com.gn.board.vo.Board;
public class BoardService {
	
	public int createBoard(Board b, Attach a) {
		Connection conn = getConnection();
		int result = 0; 
		try {
			conn.setAutoCommit(false);
			int boardNo = new BoardDao().insertBoard(b,conn);
			a.setBoardNo(boardNo);
			int attachNo = new BoardDao().insertAttach(a,conn);
			
			if(boardNo != 0 && attachNo != 0) {
				result = 1; 
				commit(conn);
			} else {
				rollback(conn);
			}
		}catch(Exception e) {
			rollback(conn);
			e.printStackTrace();
		}
		close(conn);
		return result;
	}
}
