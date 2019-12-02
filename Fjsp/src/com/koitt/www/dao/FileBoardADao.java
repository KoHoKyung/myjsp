package com.koitt.www.dao;

import java.sql.*;
import java.util.ArrayList;

import com.koitt.www.sql.FileBoardSQL;
import com.koitt.www.vo.FileInfoVO;
import com.koitt.www.vo.FileboardVO;
import com.koitt.www.vo.MemberVO;

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

	
	public ArrayList<FileboardVO> getFBList(int startRow, int endRow) {
		ArrayList<FileboardVO> list = new ArrayList<FileboardVO>();
		// 커넥션 얻어오고
		con = db.getCon();
		String sql = fbSQL.getSql(fbSQL.SEL_ALL);
		
		System.out.println("getFBList(int startRow, int endRow) : \n" + sql);
		
		// 질의 명령 가져오고
		pstmt = db.getPSTMT(con, sql);
				
		try {
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				fVo = new FileboardVO();
				fVo.setFb_rn(rs.getInt("no"));
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
			db.close(pstmt);
			db.close(con);
		}
		
		
		return list;
	}
	
	public ArrayList<FileboardVO> getFBSI(int startRow, int endRow, String st) {
		ArrayList<FileboardVO> list = new ArrayList<FileboardVO>();
		// 커넥션 얻어오고
		con = db.getCon();
		String sql = fbSQL.getSql(fbSQL.SEL_SEARCHI);
		// 질의 명령 가져오고
		
		System.out.println("getFBSI(int startRow, int endRow, String st) : \n" + sql);
		
		pstmt = db.getPSTMT(con, sql);
		
		try {
			pstmt.setString(1, "%"+st+"%");
			pstmt.setInt(2, startRow);
			pstmt.setInt(3, endRow);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				fVo = new FileboardVO();
				fVo.setFb_rn(rs.getInt("rn"));
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
			db.close(pstmt);
			db.close(con);
		}
		
		
		return list;
	}
	
	public ArrayList<FileboardVO> getFBST(int startRow, int endRow, String st) {
		ArrayList<FileboardVO> list = new ArrayList<FileboardVO>();
		// 커넥션 얻어오고
		con = db.getCon();
		String sql = fbSQL.getSql(fbSQL.SEL_SEARCHT);
		// 질의 명령 가져오고
		pstmt = db.getPSTMT(con, sql);
		
		try {
			pstmt.setString(1, "%"+st+"%");
			pstmt.setInt(2, startRow);
			pstmt.setInt(3, endRow);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				fVo = new FileboardVO();
				fVo.setFb_rn(rs.getInt("rn"));
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
			db.close(pstmt);
			db.close(con);
		}
		
		
		return list;
	}
	public ArrayList<FileboardVO> getFBSB(int startRow, int endRow, String st) {
		ArrayList<FileboardVO> list = new ArrayList<FileboardVO>();
		// 커넥션 얻어오고
		con = db.getCon();
		String sql = fbSQL.getSql(fbSQL.SEL_SEARCHT);
		// 질의 명령 가져오고
		pstmt = db.getPSTMT(con, sql);
		
		try {
			pstmt.setString(1, "%"+st+"%");
			pstmt.setInt(2, startRow);
			pstmt.setInt(3, endRow);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				fVo = new FileboardVO();
				fVo.setFb_rn(rs.getInt("rn"));
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
			db.close(pstmt);
			db.close(con);
		}
		
		
		return list;
	}
	public ArrayList<FileboardVO> getFBSA( int startRow, int endRow, String st) {
		ArrayList<FileboardVO> list = new ArrayList<FileboardVO>();
		// 커넥션 얻어오고
		con = db.getCon();
		String sql = fbSQL.getSql(fbSQL.SEL_SEARCHA);
		// 질의 명령 가져오고
		pstmt = db.getPSTMT(con, sql);
		try {
			pstmt.setString(1, "%"+st+"%");
			pstmt.setString(2, "%"+st+"%");
			pstmt.setInt(3, startRow);
			pstmt.setInt(4, endRow);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				fVo = new FileboardVO();
				fVo.setFb_rn(rs.getInt("rn"));
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
			db.close(pstmt);
			db.close(con);
		}
		
		
		return list;
	}
	
	public int getMAXPAGE() {

		// 커넥션 얻어오고
		con = db.getCon();
		String sql = fbSQL.getSql(fbSQL.SEL_MAXPAGE);
		// 질의 명령 가져오고
		stmt = db.getSTMT(con);
		int cnt = 0;
		try {
			rs = stmt.executeQuery(sql);
			rs.next();
			cnt = rs.getInt("max");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			db.close(rs);
			db.close(stmt);
			db.close(con);
		}
		
		
		return cnt;
	}
	
	public int getMAXPAGEBT(String st) {
		
		// 커넥션 얻어오고
		con = db.getCon();
		String sql = fbSQL.getSql(fbSQL.SEL_MAXPAGEBT);
		// 질의 명령 가져오고
		pstmt = db.getPSTMT(con, sql);
		
		int cnt = 0;
		try {
			pstmt.setString(1, "%"+st+"%");
			rs = pstmt.executeQuery();
			rs.next();
			cnt = rs.getInt("max");
			System.out.println(cnt);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			db.close(rs);
			db.close(pstmt);
			db.close(con);
		}
		
		
		return cnt;
	}
	
	public int getMAXPAGEBI(String st) {
		
		// 커넥션 얻어오고
		con = db.getCon();
		String sql = fbSQL.getSql(fbSQL.SEL_MAXPAGEBI);
		// 질의 명령 가져오고
		pstmt = db.getPSTMT(con, sql);
		
		int cnt = 0;
		try {
			pstmt.setString(1, "%"+st+"%");
			rs = pstmt.executeQuery();
			rs.next();
			cnt = rs.getInt("max");
			System.out.println(cnt);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			db.close(rs);
			db.close(pstmt);
			db.close(con);
		}
		
		
		return cnt;
	}
	public int getMAXPAGEBB(String st) {
		
		// 커넥션 얻어오고
		con = db.getCon();
		String sql = fbSQL.getSql(fbSQL.SEL_MAXPAGEBB);
		// 질의 명령 가져오고
		pstmt = db.getPSTMT(con, sql);
		
		int cnt = 0;
		try {
			pstmt.setString(1, "%"+st+"%");
			rs = pstmt.executeQuery();
			rs.next();
			cnt = rs.getInt("max");
			System.out.println(cnt);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			db.close(rs);
			db.close(pstmt);
			db.close(con);
		}
		
		
		return cnt;
	}
	public int getMAXPAGEBA(String st) {
		
		// 커넥션 얻어오고
		con = db.getCon();
		String sql = fbSQL.getSql(fbSQL.SEL_MAXPAGEBA);
		// 질의 명령 가져오고
		pstmt = db.getPSTMT(con, sql);
		
		int cnt = 0;
		try {
			pstmt.setString(1, "%"+st+"%");
			pstmt.setString(2, "%"+st+"%");
			rs = pstmt.executeQuery();
			rs.next();
			cnt = rs.getInt("max");
			System.out.println(cnt);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			db.close(rs);
			db.close(pstmt);
			db.close(con);
		}
		
		
		return cnt;
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
			db.close(pstmt);
			db.close(con);
		}
		
		
		return list;
	}
	
	public int boardReset(String fbb, String mno) {
		int cnt = 0;
		// 할일
		// 1.커넥션 얻어오고
		con = db.getCon();
		// 2. 질의명령 얻어오고
		String sql =fbSQL.getSql(fbSQL.EDIT_RESET);
	
		pstmt = db.getPSTMT(con, sql);
		// 4. 질의 명령 완성하고
			try {
				pstmt.setString(1, fbb);
				pstmt.setString(2, mno);
				cnt = pstmt.executeUpdate();
				System.out.println(cnt);
				// 5. 질의명령 보내고 결과 받고
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				db.close(pstmt);
				db.close(con);
			}

		// 6. 결과 내보내기
		return cnt;
	}
	public int boardDelete(String fbno) {
		int cnt = 0;
		// 할일
		// 1.커넥션 얻어오고
		con = db.getCon();
		// 2. 질의명령 얻어오고
		String sql =fbSQL.getSql(fbSQL.EDIT_DELETE);
		
		pstmt = db.getPSTMT(con, sql);
		// 4. 질의 명령 완성하고
		try {
			pstmt.setString(1, fbno);
			cnt = pstmt.executeUpdate();
			System.out.println(cnt);
			// 5. 질의명령 보내고 결과 받고
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.close(pstmt);
			db.close(con);
		}
		
		// 6. 결과 내보내기
		return cnt;
	}
	public int addFileInfo(FileInfoVO fvo) {
		int cnt = 0;
		con = db.getCon();
		String sql = fbSQL.getSql(fbSQL.ADD_FILEINFO);
		pstmt = db.getPSTMT(con, sql);
		try {
			pstmt.setInt(1, fvo.getBno());
			pstmt.setString(2, fvo.getOriname());
			pstmt.setString(3, fvo.getSavename());
			pstmt.setString(4, fvo.getDir());
			pstmt.setLong(5, fvo.getLen());
			
			cnt = pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		} finally {
			db.close(pstmt);
			db.close(con);
		}
		
		return cnt;
	}


}
