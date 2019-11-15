package com.koitt.www.dao;

import java.sql.*;
import java.util.ArrayList;

import com.koitt.www.sql.FileBoardSQL;
import com.koitt.www.vo.FileboardVO;

import DB.*;

/**
 * 
 * 		이 클래스는 파일업로드게시판에 관련된
 * 		데이터베이스 작업을 전담할 클래스
 * 
 * @author 고호경
 * @since 2019.11.15
 * @version v.1.0
 * @see DB.DBCP, com.koitt.www.sql.FileBoardSQL
 * 
 * 		변경이력
 * 			2019.11.15	-	FileBoardDao 클래스 작성	-	담당자	:	고호경
 * 			2019.11.15	-	getFBList()	작성		-	담당자	:	고호경
 *
 */
public class FileBoardADao {
	DBCP db = null;
	Connection con = null;
	Statement stmt = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	FileBoardSQL fbSQL;
	FileboardVO fVo;
	public  FileBoardADao() {
		db = new DBCP();
		fbSQL = new FileBoardSQL();
	}
	
	// 파일 업로드게시판 리스트 가져오기 전담 처리함수
	public ArrayList<FileboardVO> getFBList() {
		ArrayList<FileboardVO> list = new ArrayList<FileboardVO>();
		// 커넥션 얻어오고
		con = db.getCon();
		String sql = fbSQL.getSql(fbSQL.SEL_ALL);
		// 질의 명령 가져오고
		stmt = db.getSTMT(con);
		
		try {
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				fVo = new FileboardVO();
				fVo.setFb_no(rs.getInt("bno"));
				fVo.setFb_id(rs.getString("writer"));
				fVo.setWdate(rs.getDate("wdate"));
				fVo.setWtime(rs.getTime("wdate"));
				fVo.setFb_title(rs.getString("title"));
				list.add(fVo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			db.close(rs);
			db.close(stmt);
			db.close(con);
		}
		
		
		return list;
	}
	public int getwrite(String sid, String fn, String fb) {
		int cnt = 0;
		con = db.getCon();
		String sql = fbSQL.getSql(fbSQL.EDIT_CONTENT);
		
		pstmt = db.getPSTMT(con, sql);
		
		try {
			pstmt.setString(1, sid);
			pstmt.setString(2, fn);
			pstmt.setString(3, fb);
			cnt = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			db.close(pstmt);
			db.close(con);
		}
		
		return cnt;
	}
	public ArrayList<FileboardVO> getfBody(String sid) {
		ArrayList<FileboardVO> list = new ArrayList<FileboardVO>();
		// 커넥션 얻어오고
		con = db.getCon();
		String sql = fbSQL.getSql(fbSQL.SEL_BOARD);
		// 질의 명령 가져오고
		pstmt = db.getPSTMT(con, sql);
		
		try {
			pstmt.setString(1, sid);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				fVo = new FileboardVO();
				fVo.setFb_no(rs.getInt("bno"));
				fVo.setFb_id(rs.getString("writer"));
				fVo.setWdate(rs.getDate("wdate"));
				fVo.setWtime(rs.getTime("wdate"));
				fVo.setFb_title(rs.getString("title"));
				fVo.setFb_body(rs.getString("body"));
				list.add(fVo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			db.close(rs);
			db.close(stmt);
			db.close(con);
		}
		
		
		return list;
	}
}
