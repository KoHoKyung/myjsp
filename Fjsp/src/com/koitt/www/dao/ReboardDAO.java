package com.koitt.www.dao;


import java.sql.*;
import java.util.*;
import com.koitt.www.util.*;
import com.koitt.www.sql.ReboardSQL;
import com.koitt.www.vo.ReboardVO;

import DB.DBCP;

/**
 * 	이 클래스는 댓글 데이터베이스 작업 전담 처리 클래스
 * @author 고호경
 * @since 2019.12.03
 * @version v.1.0
 * @see
 * 			변경이력
 * 	
 * 				2019.12.03		-		클래스제작, 게시글 가져오기 함수제작		담당자	:	고호경
 *
 */


public class ReboardDAO {
	DBCP db = null;
	Connection con = null;
	Statement stmt = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	ReboardSQL SQL = null;
	public ReboardDAO() {
		db = new DBCP();
		SQL = new ReboardSQL();
	}
	
	// 댓글 테이블에 모든 데이터를 가져오는 함수
	public ArrayList<ReboardVO> reboardAlllist(int startCont, int endCont){
		ArrayList<ReboardVO> list = new ArrayList<ReboardVO>();

		// 할일
		// 1. 커넥션 얻어오고
			con = db.getCon();
		// 2. 질의명령 가져오고
			String sql = SQL.getSQL(SQL.SEL_ALL);
		// 3.Statement 가져오고
			pstmt = db.getPSTMT(con, sql);
		// 4. 질의명령 보내고 결과 받고
			try {
				pstmt.setInt(1, startCont);
				pstmt.setInt(2, endCont);
				rs = pstmt.executeQuery();
				while (rs.next()) {
					ReboardVO vo = new ReboardVO();
					vo.setRbno(rs.getInt("rb_no"));
					vo.setId(rs.getString("m_id"));
					vo.setAvatar(rs.getString("avt"));
					vo.setBody(rs.getString("rb_body"));
					vo.setRbDate(rs.getDate("rb_date"));
					vo.setRbTime(rs.getTime("rb_date"));
					vo.setUpno(rs.getInt("rb_upno"));
					vo.setLvl(rs.getInt("lvl"));
					list.add(vo);
				}
				// 5. 데이터 뽑아서 VO에 담고
				// 6. VO를 list에 담아서 담고
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				db.close(rs);
				db.close(pstmt);
				db.close(con);
			}
		// 7. 리스트 내보내기
		
		return list;
	}
	
	// 총 게시물 수 가져오는 전담 처리함수
	public int getTotal() {
		// 할일
		int cnt = 0;
		// 1. 커넥션 얻고
		con = db.getCon();
		// 2. 질의명령 가져오고
		String sql = SQL.getSQL(SQL.SEL_CNT);
		// 3. stmt 얻어오고 
		stmt = db.getSTMT(con);
		// 4. 질의명령 보내고 결과 받고
			try {
				rs = stmt.executeQuery(sql);
				rs.next();
				cnt = rs.getInt("cnt");
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				db.close(rs);
				db.close(stmt);
				db.close(con);
			}
		// 5. 결과 내보내고
		
		return cnt; 
	}
}
